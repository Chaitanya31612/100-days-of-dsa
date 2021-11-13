package day11;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        if(B > A.size()) return -1;

        // B < A.length
        int low=A.get(0), high=0, ans = -1;
        for(int i = 0;i<A.size();i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        while(low <= high) {
            int mid = (low + high) / 2;
            if(allocationPossible(A, mid, B)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean allocationPossible(ArrayList<Integer> A, int target, int K) {
        int allocatedStu = 0, pages = 0;

        for(int i = 0; i < A.size(); i++) {
            if(pages + A.get(i) > target) {
                allocatedStu++;
                pages = A.get(i);
                if(pages > target) return false;
            } else {
                pages += A.get(i);
            }
        }

        if(allocatedStu < K) return true;

        return false;
    }
}
