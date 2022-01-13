public class RecursionVideo {
    public static void print(int n) {
        if(n == 0) {
            return;
        }

        print(n - 1);
        System.out.println(n);
    }

    public static void printBackward(int n) {
        // base condition
        if(n == 0) return;

        // for print(4), print(3) will print (3 2 1) so we need to print 4 first
        System.out.println(n);
        printBackward(n - 1);
    }

    public static void sort(int[] arr) {
        // [4,2,1,5,3] -> 4 (1,2,3,5) then put 4 at it correct position

    }

    public static void main(String[] args) {
//        print(9);
        printBackward(9);
    }
}
