class Solution {
    public int missingMultiple(int[] nums, int k) {

        int multiple = k;

        while (true) {

            boolean found = false;

            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return multiple;
            }

            multiple += k;
        }
    }
}