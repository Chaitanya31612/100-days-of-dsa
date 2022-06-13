package day3_arrays;

import java.util.*;

// https://leetcode.com/problems/majority-element-ii/discuss/1534712/Java-easy-solution-with-explanation-oror-Moore's-voting-algorithm

public class MajorityElement2 {
    // first approach is to use hashmap for the purpose

    public static List<Integer> majorityElementBrute(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 3)) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    // moore's voting algorithm
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Integer num1 = null, num2 = null;
        int c1 = 0, c2 = 0;

        for (int el : nums) {
            if (num1 != null && el == num1)
                c1++;
            else if (num2 != null && el == num2)
                c2++;
            else if (c1 == 0) {
                num1 = el;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = el;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        int count = 0;
        for (int el : nums) {
            if (num1 != null && el == num1)
                count++;
        }
        if (count > nums.length / 3)
            list.add(num1);

        count = 0;
        for (int el : nums) {
            if (num2 != null && el == num2)
                count++;
        }
        if (count > nums.length / 3)
            list.add(num2);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(majorityElement(nums));
        sc.close();
    }
}
