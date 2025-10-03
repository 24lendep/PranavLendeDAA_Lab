import java.util.*;

public class lcs1 {
    public int[][] lcs1(char p[], char q[]) {
        int c[][] = new int[p.length + 1][q.length + 1];
        for (int i = 0; i <= p.length; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= q.length; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i <= p.length; i++) {
            for (int j = 1; j <= q.length; j++) {
                if (p[i - 1] == q[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        lcs1 l1 = new lcs1();
        String p = "XMJYAUZ";
        String q = "MZJAWXU";
        char p1[] = p.toCharArray();
        char q1[] = q.toCharArray();
        int sol[][] = l1.lcs1(p1, q1);
        int cost = sol[p1.length][q1.length];
        System.out.println("Max Cost (Length of LCS): " + cost);
        for (int i = 0; i <= p1.length; i++) {
            for (int j = 0; j <= q1.length; j++) {
                System.out.print(sol[i][j] + "\t");

            }
            System.out.println();
        }
    }
}
