class Solution {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = countSetBits(i);

            if (isPrime(setBits)) {
                count++;
            }
        }

        return count;
    }

    private int countSetBits(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}