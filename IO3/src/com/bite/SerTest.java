package com.bite;

import java.io.*;

class Person implements Serializable {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class SerTest {
    public static void main(String[] args) throws IOException {
        //希望将此对象序列化保存到文件中
        Person per = new Person(44,"张安");
        File file = new File("C:\\Users\\高杰\\Desktop\\TestIo.TXT");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(per);
        out.close();


    }
}
