package day10;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequence {
    static class Job {
        int id, profit, deadline;
        Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    int[] JobScheduling(Job arr[], int n)
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
}
