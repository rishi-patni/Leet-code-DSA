class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] cnt = new int[mx + 1];
        for (int x : nums) cnt[x]++;

        long[] gcdCnt = new long[mx + 1];

        for (int i = mx; i >= 1; i--) {
            long total = 0;
            for (int j = i; j <= mx; j += i) {
                total += cnt[j];
                gcdCnt[i] -= gcdCnt[j];
            }
            gcdCnt[i] += total * (total - 1) / 2;
        }

        for (int i = 2; i <= mx; i++) {
            gcdCnt[i] += gcdCnt[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(gcdCnt, queries[i]);
        }

        return ans;
    }

    private int upperBound(long[] arr, long target) {
        int l = 1, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}