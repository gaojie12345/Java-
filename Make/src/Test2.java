import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;//学生数
        int m = 0;//操作的次数
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0;i < n;i++) {
                data[i] = scanner.nextInt();
            }
            //老师开始询问
            for (int i =0;i < m;i++) {
                String c = scanner.next();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (c.equals("Q")) {
                    int s = Math.min(a,b);
                    int e = Math.max(a,b);
                    int max = 0;
                    for (int j = s;j < e;j++) {
                        max = Math.max(max,data[j]);
                    }
                    System.out.println(max);
                }
                if (c.equals("U")) {
                    data[a-1] = b;
                }
            }
        }
    }
}
