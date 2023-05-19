
public class MatrixChainMulplication {
    static int[][] d;
    static int[][] rec;

    public static void MatrixChainMul(int[] p) {
        int n = p.length;
        d = new int[n][n];
        rec = new int[n][n];
        for(int i = 1; i < n; i++) {
            d[i][i] = 0;
        }
        for(int len = 2; len < n; len++) {
            for(int i = 1; i < n - len+1; i++) {
                int j = i+len-1;
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    int m = d[i][k] + d[k+1][j] + p[i-1]*p[i]*p[j];
                    if(m<min) {
                        min = m;
                        d[i][j] = m;
                        rec[i][j] = k;
                    }
                }
            }
        }
    }
    public static void output() {
        for(int i = 1; i < d.length; i++) {
            for(int j = 1; j < d.length; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 1; i < d.length; i++) {

            for(int j = 1; j < d.length; j++) {
                System.out.print(rec[i][j] + "\t");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] p = {2,3,7,9,5,2,4};
        MatrixChainMul(p);
        output();
    }
}