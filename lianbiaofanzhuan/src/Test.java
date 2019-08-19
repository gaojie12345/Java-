import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        StringBuffer sb = new StringBuffer();
        int begin = 0;
        int end = split.length - 1;
        while (begin <= end) {
            sb.append(split[begin]);
            sb.append(",");
            if (end != begin) {
                sb.append(split[end]);
                sb.append(",");
            }
            begin++;
            end--;
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
    }
}

