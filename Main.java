import java.io.*;
import java.util.*;

public class Main {
    static class Pearl {
        int w, c; // weight, cost
        Pearl(int w, int c) {
            this.w = w;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pearl[] pearls = new Pearl[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            pearls[i] = new Pearl(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // Initial total weights
        long Wt = 0, Wh = 0;
        for (int i = 1; i <= n - m; i++) Wt += pearls[i].w;
        for (int i = n - m + 1; i <= n; i++) Wh += pearls[i].w;

        // Left = table pointer, Right = hanging pointer
        int left = 1, right = n;
        long sum = 0;
        StringBuilder sequence = new StringBuilder();

        while (true) {
            boolean canT = false, canH = false;

            // Option T (take from table end)
            if (left <= n - m) {
                long newWt = Wt - pearls[left].w;
                long newWh = Wh;
                if (newWh <= (long) k * newWt) canT = true;
            }

            // Option H (take from hanging end)
            if (right >= n - m + 1) {
                long newWt = Wt, newWh = Wh;
                // remove hanging pearl
                newWh -= pearls[right].w;

                // shift one pearl from table if available
                if (left <= n - m) {
                    newWh += pearls[left].w;
                    newWt -= pearls[left].w;
                }

                if (newWh <= (long) k * newWt) canH = true;
            }

            if (!canT && !canH) break; // no valid move left

            // Choose best option (greedy by cost)
            if (canT && (!canH || pearls[left].c >= pearls[right].c)) {
                // take from table
                sum += pearls[left].c;
                Wt -= pearls[left].w;
                sequence.append("T");
                left++;
            } else {
                // take from hanging
                sum += pearls[right].c;
                Wh -= pearls[right].w;
                right--;

                if (left <= n - m) {
                    Wh += pearls[left].w;
                    Wt -= pearls[left].w;
                    left++;
                }
                sequence.append("H");
            }
        }

        if (sequence.length() == 0) {
            System.out.println("0 0");
        } else {
            System.out.println(sequence.length() + " " + sum);
            System.out.println(sequence.toString());
        }
    }
}
