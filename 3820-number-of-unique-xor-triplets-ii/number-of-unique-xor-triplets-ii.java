import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        Set<Integer> pairs = new HashSet<>();
        BitSet triplets = new BitSet();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        for (int pair : pairs) {
            for (int num : nums) {
                triplets.set(pair ^ num);
            }
        }

        return triplets.cardinality();
    }
}