import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IO {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\高杰\\Desktop");

        listAllFiles(file);

        /*if (file.exists()) {
            file.delete();
        }else {
            file.createNewFile();
        }*/

        //System.out.println(file.getParentFile());
        //System.out.println(file.getParent());


        //多级父目录不存在就创建
        /*if (!file.getParentFile().exists()) {
            //有多少父目录就创建多少级
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }else {
            file.createNewFile();
        }
        */

        /*if (file.exists() && file.isFile()){
            System.out.println(file.length());
            System.out.println(new Date(file.lastModified()));
        }*/


        //列出目录中的全部组成
        /*if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1);
            }
        }*/

    }

    public static void listAllFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        }else {
            File[] res = file.listFiles();
            if (res!=null) {
                for (File file1 :res) {
                    listAllFiles(file1);
                }
            }
        }
    }


}
