import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/7/7 18:24
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe 借鉴：动态规划
 */
public class 数字和为sum的方法数 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n,sum,A[];
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        sum = cin.nextInt();
        A = new int[n];
        for(int i = 0; i < n ; i++){
            A[i] = cin.nextInt();
        }
        System.out.println(getTypeCount(n,sum,A));
    }
    //母函数解法
    public static BigInteger getTypeCount(int n,int sum,int[] A){
        BigInteger c[] = new BigInteger[1005];
        BigInteger c1[] = new BigInteger[1005];
        BigInteger c2[] = new BigInteger[1005];
        init(c);init(c1);init(c2);

        c1[0] = BigInteger.ONE;
        c1[A[0]] = BigInteger.ONE;
        for(int i = 1; i < n; i++){
            init(c2);
            init(c);
            int a = A[i];
            c2[0] = BigInteger.ONE;
            c2[a] = BigInteger.ONE;
            for(int j = 0; j <= sum; j++){
                if(!c1[j].equals(BigInteger.ZERO)){
                    c[j] = c[j].add(c1[j].multiply(c2[0]));
                    if(j + a <= sum) {
                        c[j + a] = c[j + a].add(c1[j].multiply(c2[a]));
                    }
                }
            }
            System.arraycopy(c, 0, c1, 0, sum + 1);
        }
        return c1[sum];
    }
    public static void init(BigInteger c[]){
        for(int i = 0;i < c.length; i++){
            c[i] = BigInteger.ZERO;
        }
    }
}
