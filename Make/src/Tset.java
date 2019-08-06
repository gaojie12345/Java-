import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] data = new int[N];
            int A1 = 0;
            int A2 = 0;
            int A3 = 0;
            int A4 = 0;
            int A5 = 0;
            int flag = 1;
            int count = 0;
            for (int i = 0; i < N; i++) {
                data[i] = scanner.nextInt();
                //A1
                if (data[i] % 5 == 0) {
                    if (data[i] % 2 == 0) {
                        A1 = A1 + data[i];
                    }
                }
                //A2
                if (data[i] % 5 == 1) {
                    A2 = A2 + data[i] * flag;
                    flag = -flag;
                }
                //A3
                if (data[i] % 5 == 2) {
                    A3++;
                }
                //A4
                if (data[i] % 5 == 3) {
                    A4 += data[i];
                    count++;
                }
                //A5
                if (data[i] % 5 == 4) {
                    if (data[i] > A5) {
                        A5 = data[i];
                    }
                }
            }
            if (A1 != 0) {
                System.out.print(A1 + " ");
            }else {
                System.out.print("N" + " ");
            }

            if (A2 != 0) {
                System.out.print(A2 + " ");
            }else {
                System.out.print("N" + " ");
            }

            if (A3 != 0) {
                System.out.print(A3 + " ");
            }else {
                System.out.print("N" + " ");
            }

            if (A4 != 0) {
                DecimalFormat df = new DecimalFormat();
                System.out.print(A4 / count + " ");
            }else {
                System.out.print("N" + " ");
            }

            if (A5 != 0) {
                System.out.print(A5 + " ");
            }else{
                System.out.print("N");
            }

        }
    }
}
