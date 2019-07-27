
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.nextLine();//shangjia
            String string2 = scanner.nextLine();//xiaohong

            //将商家的数据存储起来
            ArrayList<Character> arrayList = new ArrayList<>();
            for (int i = 0; i < string1.length(); i++) {
                char ch = string1.charAt(i);//将字符串转化为char数组
                arrayList.add(ch);
            }
            int count = 0;
            for (int i = 0; i < string2.length(); i++) {
                char ch2 = string2.charAt(i);//将小红的那组字符串转化为char数组
                for (int j = 0; j < arrayList.size(); j++) {
                    if (ch2 == arrayList.get(j)) {
                        arrayList.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == string2.length()) {
                System.out.println("Yes" + " " + arrayList);
            } else {
                System.out.println("No" + " " + (string2.length() - count));
            }
            scanner.close();
        }
    }
}
