import java.util.*;

public class IntersectionArray {

    public static int[] intersectNaive(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = 0, n2 = 0;

        while(n1 < nums1.length && n2 < nums2.length) {
            if(nums1[n1] < nums2[n2]) n1++;
            else if(nums2[n2] < nums1[n1]) n2++;
            else {
                ans.add(nums1[n1]);
                n1++; n2++;
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int num : nums1) {
            if(!map1.containsKey(num)) {
                map1.put(num, 1);
            } else {
                map1.put(num, map1.get(num) + 1);
            }
        }

        for(int num : nums2) {
            if(!map2.containsKey(num)) {
                map2.put(num, 1);
            } else {
                map2.put(num, map2.get(num) + 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                int k = Math.min(entry.getValue(), map2.get(entry.getKey()));
                for(int i = 0; i < k; i++) {
                    ans.add(entry.getKey());
                }
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

//        System.out.println(Arrays.toString(intersectNaive(arr1, arr2)));
        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }
}
