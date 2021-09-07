public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        int s = 1, e = 5, mid, target = 4;

        while(s <= e) {
//            mid = (s + e) / 2;
            mid = s + (e - s) / 2; // used for preventing overflow errors, not needed in python
            System.out.println(mid);

            if(mid == target) {
                System.out.println(mid);
                break;
            } else if(mid < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
    }
}
