import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
                if (a > data[i]) {
                    a += data[i];
                } else {
                    a += res(a, data[i]);
                }
            }
        }
    }

    public static int res(int a, int b) {
        /*int temp = 0;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;*/
        if (b == 0) {
            return a;
        } else {
            return res(b, a % b);
        }
    }
}
