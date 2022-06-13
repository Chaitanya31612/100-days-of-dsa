package practice;

import java.util.Scanner;

public class MaxValueFromBinaryString {
    static int lcs(String s1, String s2){
        //	Write your code here.

        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        int ans = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    int val = 1 + prev[j-1];
                    cur[j] = val;
                    ans = Math.max(ans,val);
                }
                else
                    cur[j] = 0;
            }
            for(int k = 0; k < m+1; k++)
                prev[k] = cur[k];
        }

        return ans;

    }

    public static void main(String args[]) {

        String s1= "001010";
        String s2= "101001";

        System.out.println("The Length of Longest Common Substring is "+lcs(s1,s2));
    }
}