
import java.util.*;

public class FractionalKnapsack {

    public static void main(String args[]) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int W = 50;
        int total = 0;
        double ratio[][] = new double[value.length][2];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // sort in ascending order we want in descending
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                capacity -= weight[idx];
                total += value[idx];
            } else {
                total += ratio[i][1] * capacity;
                capacity=0;
                break;
            }

        }
        System.out.println(total);

    }
}
