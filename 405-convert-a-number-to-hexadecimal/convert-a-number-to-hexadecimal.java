class Solution {
    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        char[] hex = {
            '0','1','2','3','4','5','6','7',
            '8','9','a','b','c','d','e','f'
        };

        StringBuilder ans = new StringBuilder();

        while (num != 0) {
            ans.append(hex[num & 15]);
            num >>>= 4;
        }

        return ans.reverse().toString();
    }
}