package day26_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    public static int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        int m = 0;
        for(int i = 0; i < n; i++) {
            m = Math.max(m, arr[i].deadline);
        }
        int jobs = 0, profit = 0;
        int[] slots = new int[m + 1];
        Arrays.fill(slots, -1);

        for(int i = 0; i < n; i++) {
            for(int j = arr[i].deadline; j > 0; j--) {
                if(slots[j] == -1) {
                    jobs++;
                    profit += arr[i].profit;
                    slots[j] = i;
                    break;
                }
            }
        }

        return new int[]{jobs, profit};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            //function call
            int[] res = JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}