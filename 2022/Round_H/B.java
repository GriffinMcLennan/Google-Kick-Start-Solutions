/*
 * Problem Link: https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb1b6/0000000000c47e79
 * Magic Well Of Lillies
 */

import java.util.*;

public class B {
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int cid = 1; cid <= T; cid++) {
            System.out.printf("Case #%d: ", cid);
            int L = scanner.nextInt();
            dp = new Integer[L + 1];
            System.out.printf("%d\n", dfs(0, L));
        }

        scanner.close();
    }

    private static int dfs(int have, int L) {
        if (have == L) {
            return 0;
        }
        else if (dp[have] != null) return dp[have];

        int basic = 1 + dfs(have + 1, L);

        if (have > 0) {
            int cost = 4;

            for (int total = have * 2; total <= L; total += have) {
                cost += 2;
                basic = Math.min(basic, cost + dfs(total, L));
            }    
        }

        return dp[have] = basic;
    }
}