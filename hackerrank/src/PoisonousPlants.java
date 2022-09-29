import java.util.List;
import java.util.Stack;

public class PoisonousPlants {
    private static int maxInRange(int[] arr, int start, int end) {
        int max = 0; // for our case 0 indicates a plant that will survive till eternity
        for (int i = start; i <= end; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int poisonousPlants(List<Integer> p, boolean debug) {
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[p.size()];
        stack.push(0);
        days[0] = 0; // left plant is never killed
        for (int i = 1; i < p.size(); ++i) {
            int cur = p.get(i);
            while(!stack.isEmpty() && p.get(stack.peek()) >= cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                days[i] = 0;
            }
            else {
                days[i] =  maxInRange(days, stack.peek()+1, i-1) + 1;
            }
            stack.push(i);
        }
        if (debug) {
            for (int i = 0; i < p.size(); ++i) {
                System.out.println("i: " + i + " " + p.get(i)+"(" + days[i] + ")");
            }
            System.out.println();
        }
        return maxInRange(days, 0, p.size()-1);
    }
    public static int poisonousPlants(List<Integer> p) {
        return poisonousPlants(p, false);
    }
}
