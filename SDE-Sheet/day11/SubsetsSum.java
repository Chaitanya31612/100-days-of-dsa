package day11;

import java.util.ArrayList;

public class SubsetsSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        return subsetSumsUtil(arr, 0, N);
    }

    ArrayList<Integer> subsetSumsUtil(ArrayList<Integer> arr, int idx, int N){
        if(idx == N - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(arr.get(idx));
            return list;
        }
        ArrayList<Integer> list = subsetSumsUtil(arr, idx + 1, N);
        int size = list.size();
        for(int i = 0; i < size; i++) {
            list.add(list.get(i) + arr.get(idx));
        }

        return list;
    }
}
