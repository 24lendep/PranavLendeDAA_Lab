import java.util.*;

public class Main {

    public static String LRS(String s) {
        int n = s.length();
        int[][] c = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
                    c[i][j] = 1 + c[i-1][j-1];
                } else {
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
                }
            }
        }

        printMatrix(c, n);

        StringBuilder res = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
                res.append(s.charAt(i-1));
                i--;
                j--;
            } else if (c[i-1][j] > c[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        return res.reverse().toString();
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        String lrs = LRS(s);
        System.out.println("LRS is: " + lrs);
        System.out.println("Length of LRS: " + lrs.length());
    }
}
