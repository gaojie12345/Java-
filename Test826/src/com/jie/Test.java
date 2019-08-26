package com.jie;


import java.lang.reflect.Field;

class Teacher{
    private String name;
    private String address;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
class User{
    private String name;
    private String address;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("Qing");
        teacher.setAddress("陕西");
        teacher.setAge(20);
        User user = new User();
        Test.beanCopy(teacher,user);
        System.out.println(teacher);
        System.out.println(user);
    }
    public static void beanCopy(Object source, Object target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("对象不能为空");
        }
        //1.获取class类对象
        Class<Teacher> sourceClass = Teacher.class;
        Class<User> targetClass = User.class;
        //2.获取类对象的属性
        Field[] sourceField = sourceClass .getDeclaredFields();
        Field[] targetField = targetClass .getDeclaredFields();
        //3.sourceField 与 targetField的属性对应起来
        for (Field s : sourceField) {
            for (Field t : targetField) {
                if (s.getName().equals(t.getName())) {
                    //4.进行属性赋值
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        Object value = s.get(source);
                        t.set(target,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }


    }
}
