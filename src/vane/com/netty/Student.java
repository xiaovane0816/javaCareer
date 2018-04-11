package vane.com.netty;

import java.io.Serializable;

/**
 * Created by wenshaobo on 2018/3/28.
 */
public class Student implements Serializable {
    String name;
    String classs;
    int age;

    @Override
    public String toString() {
        return "Student [name=" + name + ", classs=" + classs + ", age=" + age + "]";
    }

    public Student(String name, String classs, int age) {
        super();
        this.name = name;
        this.classs = classs;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}