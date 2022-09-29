import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TwoSumTest {

    @ParameterizedTest(name = "{index} => ts={0} nums={1} target={2} expected={3}")
    @MethodSource("twoSumTestDataProvider")
    public void test_valid(final TwoSum ts, final int[] nums, final int target, final int[] expected) throws IllegalArgumentException {
        int[] actual = ts.twoSum(nums, target);
        assertArrayEquals(expected, actual);
        System.out.println("Verified: " + Arrays.toString(nums) + " " + target + " " + Arrays.toString(expected));
    }

    private static Stream<Arguments> twoSumTestDataProvider() {
        final TwoSum ts = new TwoSum();
        return Stream.of(
                Arguments.of( ts, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(ts, new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(ts, new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}
