import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementToAddendMap = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; ++i) {
            int elem = nums[i];
            if (complementToAddendMap.containsKey(elem)) {
                return new int[] {complementToAddendMap.get(elem), i};
            }
            complementToAddendMap.put(target - elem, i);
        }
        throw new IllegalArgumentException("Unable to find target sum: " + target + " from input: " + Arrays.toString(nums));
    }
}
