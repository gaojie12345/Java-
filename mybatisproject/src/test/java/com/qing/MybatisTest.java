package com.qing;

import com.qing.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

/**
 * Mybabtis的API
 * sqlSessionfactory:代表一个数据库(一个数据库对应一个sqlSessionfactory)
 * sqlSeesion
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testIinit() {
        String mybatisConfigFile = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(mybatisConfigFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("test.queryUserById", 1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUserByName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<User> userList = sqlSession.selectList("test.queryUserByName","vri");
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = 0;
        try {
            User user = new User();
            user.setUserName("MMMM");
            user.setUserAddr("USA");
            flag = sqlSession.insert("test.addUser",user);
            sqlSession.commit();
            System.out.println("flag" + flag);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void modifyUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = 0;
        try {
            User user = new User();
            user.setUserId(1);
            user.setUserName("TTTT");
            flag = sqlSession.update("test.modifyUser",user);
            sqlSession.commit();
            System.out.println("flag" + flag);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = 0;
        try {

            flag = sqlSession.delete("test.deleteUser",10);
            sqlSession.commit();
            System.out.println("flag" + flag);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
