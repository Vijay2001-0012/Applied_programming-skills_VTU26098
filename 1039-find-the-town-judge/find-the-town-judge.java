class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] count = new int[n + 1];

        for (int[] relation : trust) {

            int a = relation[0];
            int b = relation[1];

            count[a]--;
            count[b]++;
        }

        for (int i = 1; i <= n; i++) {

            if (count[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}