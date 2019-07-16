import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/7/7 13:49
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
/*public class 年会抽奖 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            double s = 1;
            for (int i = 1; i <= n; i++) {
                s *= i;
            }
            System.out.println(String.format("%.2f",(s - 1.0) / s * 100) + "%");
        }
    }
}*/

public class 年会抽奖 {
    static Scanner in = new Scanner(System.in);
    static  double[] a=new double[25];
    static void init(){
        a[1]=0;
        a[2]=1;
        for (int i = 3; i <=20; i++) {
            a[i]=(i-1)*(a[i-2]+a[i-1]);
        }
    }
    public static void main(String[] args) {
        init();
        double sum=1;
        String p;
        while(in.hasNext()){
            int n=in.nextInt();
            sum=1;
            for (int i =1; i <=n; i++) {
                sum*=i;
            }
            p=String.format("%.2f",a[n]*100/sum);
            System.out.println(p+"%");
        }
    }
}
