import java.util.*;

public class SortByFrequency {

    static class Pair {
        int value;
        int freq;
        Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    public static ArrayList<Integer> sortByFreq(int[] arr, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!freq.containsKey(arr[i])) {
                freq.put(arr[i], 0);
            }
            freq.put(arr[i], freq.get(arr[i]) + 1);
        }

        ArrayList<Pair> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            list.add(p);
        }
        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.freq == o2.freq)
                    return o1.value - o2.value;
                return o2.freq - o1.freq;
            }
        };

        Collections.sort(list, c);
//        for(Pair p : list) {
//            System.out.println(p.value + " " + p.freq);
//        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Pair p : list) {
            while(p.freq-- > 0) {
                ans.add(p.value);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(sortByFreq(arr, n));
    }
}
