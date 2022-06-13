package day22_binarytreemisc;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if(list.size() == 0) {
            list.add(num);
        } else {
            // binary search for next index to append
            int s = 0, e = list.size() - 1;
            while(s <= e) {
                int mid = s + (e-s)/2;
                if(list.get(mid) == num) {
                    s = mid;
                    break;
                } else if(num < list.get(mid)) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            }

            list.add(s, num);
        }
    }

    public double findMedian() {
        double median;
        if((list.size()&1) == 1) {
            median = list.get(list.size()/2);
        } else {
            median = (list.get((list.size()/2)-1) + list.get(list.size()/2)) / 2.0;
        }
        return median;
    }
}
