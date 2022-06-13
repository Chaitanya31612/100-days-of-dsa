package practice;

public class ContainerWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        if(n == 2) return Math.min(height[0], height[1]);
        int i = 0, j = n-1, max = j*Math.min(height[i], height[j]);
        while(i < j) {
            if(height[i] < height[j]) {
                while(i+1 < j && height[i+1] <= height[i]) i++;
                if(i+1 >= j) break;
                i++;
                max = Math.max(max, (j-i)*Math.min(height[i], height[j]));

            } else {
                while(i < j-1 && height[j-1] <= height[j]) j--;
                if(i >= j-1) break;
                j--;
                max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
