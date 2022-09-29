import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTest {

    @ParameterizedTest(name = "{index} => obj={0} grid={1} expected={2}")
    @MethodSource("testDataProvider")
    public void test_valid_BFS(final NumberOfIslands obj, final char[][] grid, final int expected) {
        int actual = obj.numIslands(grid);
        assertEquals(expected, actual);
        System.out.println("Verified:\n" + prettyPrint2DArray(grid) + "to have " + expected + " islands using BFS");
    }

    @ParameterizedTest(name = "{index} => obj={0} grid={1} expected={2}")
    @MethodSource("testDataProvider")
    public void test_valid_DFS(final NumberOfIslands obj, final char[][] grid, final int expected) {
        int actual = obj.numIslandsDFS(grid);
        assertEquals(expected, actual);
        System.out.println("Verified:\n" + prettyPrint2DArray(grid) + "to have " + expected + " islands using DFS");
    }

    private static Stream<Arguments> testDataProvider() {
        final NumberOfIslands obj = new NumberOfIslands();
        return Stream.of(
                Arguments.of( obj,
                        new char[][]{
                                {'1','1','1','1','0'},
                                {'1','1','0','1','0'},
                                {'1','1','0','0','0'},
                                {'0','0','0','0','0'}
                        }, 1),

                Arguments.of(obj,
                        new char[][]{
                                {'1','1','0','0','0'},
                                {'1','1','0','0','0'},
                                {'0','0','1','0','0'},
                                {'0','0','0','1','1'}
                        }, 3),
                Arguments.of(obj,
                        new char[][]{
                                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
                        }, 1)
        );
    }

    private String prettyPrint2DArray(Object[] a) {
        return Arrays.deepToString(a)
                .replace("[[", "[\n\t[")
                .replace("], ", "]\n\t")
                .replace("]]", "]\n]\n");
    }
}
