import org.junit.Test;

import java.sql.*;

public class JDBCDemo1 {
    @Test
    //select
    /*public void test() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            try {
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                                "root", "gouqing612..");
                //3.执行SQL
                String sql = "select * from user";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                //3.1遍历结果集
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String userName = resultSet.getNString("username");
                    String password = resultSet.getNString("password");
                    System.out.println("id为:" + id + ",用户名为:" + userName + ",密码为:" + password);
                }
                //4.释放资源
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/


    //insert
    /*public void test1() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            try {
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                                "root", "gouqing612..");
                //3.执行SQL
                String sql = "insert into user(username,password)" + "values ('test','456')";
                Statement statement = connection.createStatement();
                int resultRows = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                System.out.println(resultRows);
                //4.释放资源
                connection.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    //delete
    /*public void test2(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            try {
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                                "root","gouqing612..");
                //3.执行SQL
                String sql = "delete from user where id = 4";
                Statement statement = connection.createStatement();
                int resultRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
                System.out.println(resultRows);
                //4.释放资源
                connection.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    /*public void test3() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            try {
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                                "root", "gouqing612..");
                //3.执行SQL
                String name = "zs' or 1=1";
                String pass = "ddasd";
                String sql = "select * from user where username = '"+name+" "+
                        "and password = '"+pass+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    System.out.println("登陆成功");
                } else {
                    System.out.println("登陆失败");
                }
                //4.释放资源
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    //SQL漏洞（PreparedStatement解决）
    public void test4() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            try {
                Connection connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                                "root", "gouqing612..");
                //3.执行SQL
                String sql = "select * from user" + " where username = ? and password = ?";
                //预处理SQL
                PreparedStatement statement = connection.prepareStatement(sql);
                String userName = "zs";
                String passWord = "12553";
                statement.setString(1,userName);
                statement.setString(2,passWord);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("登陆成功");
                } else {
                    System.out.println("登陆失败");
                }
                //4.释放资源
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
