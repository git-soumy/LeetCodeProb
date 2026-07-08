class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefVal = new long[n + 1]; // concatenation value mod p
        int[] prefCnt = new int[n + 1];   // count of non-zero digits so far
        long[] prefSum = new long[n + 1]; // actual digit sum so far
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
                prefCnt[i + 1] = prefCnt[i] + 1;
                prefSum[i + 1] = prefSum[i] + d;
            } else {
                prefVal[i + 1] = prefVal[i];
                prefCnt[i + 1] = prefCnt[i];
                prefSum[i + 1] = prefSum[i];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];

            int cnt = prefCnt[r + 1] - prefCnt[l];
            long pow = pow10[cnt];

            long x = (prefVal[r + 1] - prefVal[l] * pow % MOD % MOD + MOD) % MOD;
            long sum = (prefSum[r + 1] - prefSum[l]) % MOD;

            ans[i] = (int) (x * sum % MOD);
        }
        return ans;
    }
}