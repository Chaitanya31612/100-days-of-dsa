package day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberofCoins {
    public int minCoinsRec(int coins[], int M, int V)
    {
        if(V <= 0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            if(coins[i] <= V) {
                int subAns = minCoinsRec(coins, M, V - coins[i]);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = 1 + subAns;
                }
            }
        }

        return ans;
    }

    // dp solution
    public int minCoins(int coins[], int M, int V)
    {
        int[] dp = new int[V + 1];
        dp[0] = 0;
        for(int i = 1; i <= V; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i = 1; i <= V; i++) {
            for(int j = 0; j < M; j++) {
                if(coins[j] <= i) {
                    int subAns = dp[i - coins[j]];
                    if(subAns != Integer.MAX_VALUE && subAns + 1 < dp[i]) {
                        dp[i] = subAns + 1;
                    }
                }
            }
        }

        if(dp[V] != Integer.MAX_VALUE)
            return dp[V];

        return -1;
    }

    public void findMinGreedy(int[] coins, int m, int v) {
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(coins);
        for(int i = m-1; i>=0; i--) {
            while(v >= coins[i]) {
                v -= coins[i];
                list.add(coins[i]);
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int v = sc.nextInt();
        int[] coins = new int[m];
        for(int i = 0; i < m; i++)
            coins[i] = sc.nextInt();

        new NumberofCoins().findMinGreedy(coins,m,v);
    }
}
