class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (used[c - 'a']) continue;

            while (st.length() > 0 &&
                   st.charAt(st.length() - 1) > c &&
                   last[st.charAt(st.length() - 1) - 'a'] > i) {

                used[st.charAt(st.length() - 1) - 'a'] = false;
                st.deleteCharAt(st.length() - 1);
            }

            st.append(c);
            used[c - 'a'] = true;
        }

        return st.toString();
    }
}