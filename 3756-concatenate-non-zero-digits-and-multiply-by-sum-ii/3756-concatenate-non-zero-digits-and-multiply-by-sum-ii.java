class Solution {
    static final int MOD = 1_000_000_007;
    int n;
    long[] segVal;
    long[] segCnt;
    long[] pow10;
    int[] digits;
    long[] prefSum;

    public int[] sumAndMultiply(String s, int[][] queries) {
        n = s.length();
        digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';

        pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;

        prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + (digits[i] != 0 ? digits[i] : 0);
        }

        segVal = new long[4 * n];
        segCnt = new long[4 * n];
        build(1, 0, n - 1);

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            long[] res = query(1, 0, n - 1, l, r);
            long x = res[0];
            long sum = (prefSum[r + 1] - prefSum[l]) % MOD;
            ans[i] = (int) ((x % MOD) * sum % MOD);
        }
        return ans;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            int d = digits[l];
            if (d != 0) {
                segVal[node] = d;
                segCnt[node] = 1;
            } else {
                segVal[node] = 0;
                segCnt[node] = 0;
            }
            return;
        }
        int mid = (l + r) >>> 1;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        merge(node);
    }

    private void merge(int node) {
        int left = 2 * node, right = 2 * node + 1;
        segCnt[node] = segCnt[left] + segCnt[right];
        segVal[node] = (segVal[left] * pow10[(int) segCnt[right]] + segVal[right]) % MOD;
    }

    private long[] query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            return new long[]{0, 0};
        }
        if (ql <= l && r <= qr) {
            return new long[]{segVal[node], segCnt[node]};
        }
        int mid = (l + r) >>> 1;
        long[] leftRes = query(2 * node, l, mid, ql, qr);
        long[] rightRes = query(2 * node + 1, mid + 1, r, ql, qr);

        long cnt = leftRes[1] + rightRes[1];
        long val = (leftRes[0] * pow10[(int) rightRes[1]] + rightRes[0]) % MOD;
        return new long[]{val, cnt};
    }
}