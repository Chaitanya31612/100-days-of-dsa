package day8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NMeeting {
    public static int maxMeetingsBrute(int start[], int end[], int n)
    {

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(end[j] > end[j+1]) {
                    int temp = start[j];
                    start[j] = start[j+1];
                    start[j+1] = temp;

                    temp = end[j];
                    end[j] = end[j+1];
                    end[j+1] = temp;
                }
            }
        }

        int count = 1, i = 0;
        for(int j = 1; j < n; j++) {
            if(start[j] > end[i]) {
                count++;
                i = j;
            }
        }

        return count;
    }

    static class Activity {
        int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        Activity[] arr = new Activity[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Activity(start[i], end[i]);
        }

        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end - o2.end;
            }
        });

        int count = 1, i = 0;
        for(int j = 1; j < n; j++) {
            if(arr[j].start > arr[i].end) {
                count++;
                i = j;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++)
            end[i] = sc.nextInt();

        System.out.println(maxMeetings(start,end,n));
    }
}

//Example
//6
//1 3 0 5 8 5
//2 4 6 7 9 9
//4