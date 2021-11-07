package day8;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    static class ItemValue {
        int value, weight;
        Double cost;

        ItemValue(int v, int w) {
            this.value = v;
            this.weight = w;
            this.cost = (v / (double) w);
        }
    }
    static double fractionalKnapsack(int W, Item arr[], int n) {

        ItemValue[] newArr = new ItemValue[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = new ItemValue(arr[i].value, arr[i].weight);
        }

        Arrays.sort(newArr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        // for (ItemValue a : newArr) {
        // System.out.println(a.cost);
        // }
        double total = 0, rem = W;

        for (ItemValue i : newArr) {
            if (i.weight < rem) {
                total += i.value;
                rem -= i.weight;
            } else {
                total += rem * i.cost;
                break;
            }
        }

        return total;
    }
}
