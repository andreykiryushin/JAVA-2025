package timus;

import java.io.*;
import java.util.*;

public class Zadanie1523 {
    static final int MOD = 1000000000;

    static class FenwickTree {
        int[] tree;

        FenwickTree(int size) {
            tree = new int[size + 1];
        }

        void update(int index, int value) {
            while (index < tree.length) {
                tree[index] = (tree[index] + value) % MOD;
                index += index & -index;
            }
        }

        int query(int index) {
            int res = 0;
            while (index > 0) {
                res = (res + tree[index]) % MOD;
                index -= index & -index;
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = 1;
        }

        for (int j = 2; j <= k; j++) {
            FenwickTree ft = new FenwickTree(n);
            for (int i = 0; i < n; i++) {
                dp[i][j] = ft.query(n - a[i]);
                ft.update(n - a[i] + 1, dp[i][j - 1]);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + dp[i][k]) % MOD;
        }

        System.out.println(result);
    }
}