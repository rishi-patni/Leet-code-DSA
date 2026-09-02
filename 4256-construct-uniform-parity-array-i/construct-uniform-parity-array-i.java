class Solution {
    public boolean uniformArray(int[] nums1) {

        int odd = 0;
        int even = 0;

        for (int num : nums1) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        if (even == 0 || odd == 0) {
            return true;
        }

        return true;
    }
}