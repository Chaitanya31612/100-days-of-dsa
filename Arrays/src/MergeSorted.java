import java.util.ArrayList;

public class MergeSorted {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int[] currentIndex = new int[K];

        ArrayList<Integer> list = new ArrayList<>();
        while(list.size() != K * K) {
            int minVal = Integer.MAX_VALUE, minInd = -1;
            for(int i = 0; i < K; i++) {
                if(currentIndex[i] < K && arr[i][currentIndex[i]] < minVal) {
                    minVal = arr[i][currentIndex[i]];
                    minInd = i;
                }
            }
            list.add(arr[minInd][currentIndex[minInd]]);
            currentIndex[minInd] += 1;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};
        int K = 4;

        System.out.println(mergeKArrays(arr, K));
    }
}
