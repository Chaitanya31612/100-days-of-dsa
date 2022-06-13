package practice;

public class CountLatticeInsideCircle {

    // return number of lattice points inside atleast one circle with given center and radius
    public static int countLatticeInsideCircle(int x, int y, int r) {
        int count = 0;
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                if (i * i + j * j <= r * r) {
                    count++;
                }
            }
        }
        return count;
    }

    // common lattice points in two circles
    public static int commonLatticeInsideCircle(int x1, int y1, int r1, int x2, int y2, int r2) {
        int count = 0;
        for (int i = -r1; i <= r1; i++) {
            for (int j = -r1; j <= r1; j++) {
                if (i * i + j * j <= r1 * r1) {
                    if (x1 + i >= x2 - r2 && x1 + i <= x2 + r2 && y1 + j >= y2 - r2 && y1 + j <= y2 + r2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] circles = {{2,2,2}, {3,4,1}};
        int ans = 0;
        for (int[] circle : circles) {
            ans += countLatticeInsideCircle(circle[0], circle[1], circle[2]);
            System.out.println(ans);
        }

        System.out.println(commonLatticeInsideCircle(2,2,2,3,4,1));
        System.out.println(ans);
    }
}
