import java.util.*;

public class NumberOfIslands {
    /**
     * <p>The markIsland function below starts from the start vertex and marks all neighbouring
     * land vertices (grid[x][y]== 1) as visited using BFS. It continues to do so until there is no land vertex reachable
     * from start vertex and its neighbours and their neighbours and so on</p>
     * <p>Important thing to remember here is that we need to first mark the vertex as visited by adding it to the visited
     * Set and then add it to BFS queue else we end repeating the islands we visit resulting in duplicate computations</p>
     * See: <a href="https://leetcode.com/problems/number-of-islands/discuss/2025998/BFS-Time-Limit-Exceeded-(TLE)-Explanation">
     *     Explanation</a>
     */
    private void markIsland(Vertex start, Vertex min, Vertex max, Set<Vertex> visited, char[][] grid) {
        Queue<Vertex> q = new LinkedList<>();
        // first mark the vertex as visited
        visited.add(start);
        q.offer(start);
        while (!q.isEmpty()) {
            Vertex vertex = q.poll();
            visited.add(vertex);
            List<Vertex> neighbours = vertex.getNeighbours().stream()
                    .filter(n -> n.isWithin(min, max) && !visited.contains(n) && grid[n.getX()][n.getY()] == '1')
                    .toList();
            for (Vertex n: neighbours) {
                visited.add(n);
                q.offer(n);
            }
        }
    }

    private void markIslandDFS(Vertex start, Vertex min, Vertex max, Set<Vertex> visited, char[][] grid) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex counted = stack.pop();
            visited.add(counted);
            counted.getNeighbours().stream()
                    .filter(n -> !visited.contains(n) && n.isWithin(min, max) && grid[n.getX()][n.getY()] == '1')
                    .forEach(stack::push);
        }
    }

    public int numIslands(char[][] grid) {
        final int r = grid.length;
        final int c = grid[0].length;
        final Vertex min = new Vertex(0, 0);
        final Vertex max = new Vertex(r, c);

        Set<Vertex> visited = new HashSet<>(r*c);

        int numIslands = 0;
        for(int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                char ch = grid[i][j];
                Vertex v = new Vertex(i, j);
                if (!visited.contains(v) && ch == '1') {
                    markIsland(v, min, max, visited, grid);
                    ++numIslands;
                }
            }
        }
        return numIslands;
    }

    public int numIslandsDFS(char[][] grid) {
        final int r = grid.length;
        final int c = grid[0].length;
        final Vertex min = new Vertex(0, 0);
        final Vertex max = new Vertex(r, c);

        Set<Vertex> visited = new HashSet<>(r*c);

        int numIslands = 0;
        for(int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                char ch = grid[i][j];
                Vertex v = new Vertex(i, j);
                if (!visited.contains(v) && ch == '1') {
                    markIslandDFS(v, min, max, visited, grid);
                    ++numIslands;
                }
            }
        }
        return numIslands;
    }
}

class Vertex {
    private final int x;
    private final int y;

    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Vertex> getNeighbours() {
        final Vertex north = new Vertex(this.getX() - 1, this.getY());
        final Vertex south = new Vertex(this.getX() + 1, this.getY());
        final Vertex east = new Vertex(this.getX(), this.getY() + 1);
        final Vertex west = new Vertex(this.getX(), this.getY() - 1);
        return List.of(north, south, east, west);
    }

    public boolean isWithin(Vertex min, Vertex max) {
        return this.getX() >= min.getX() && this.getY() >= min.getY()
                && this.getX() < max.getX() && this.getY() < max.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return x == vertex.x && y == vertex.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}