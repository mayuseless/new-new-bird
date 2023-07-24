package com.bird.www;

//封装性：属性私有化，在外部提供获取属性值（友元函数friend）的get方法和设置属性值的set方法
//属性私有化就是利用private修饰属性
public class Student {
    private int no;
    private char name;
    private int age;
    private double score;

    //在外部提供获取属性值（友元函数friend）的get方法和设置属性值的set方法
    public int getNo(){
        return no;
    }
    public void setNo(int theNo){
        no = theNo;
    }
    public char getName(){
        return name;
    }
    public void setName(char theName){
        name = theName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int theAge){
        age = theAge;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double theScore){
        score = theScore;
    }

    public static void main(String[] args){
        //java 创建对象一般形式
        //类名  对象 = new  类名();
        Student s = new Student();
        Student s1 = null;
        s1 = new Student();
        //java中调用属性使用方式
        //对象.属性
        //属性在new创建时候 默认 default 初始化(int 0,double 0.0,boolean false)

        System.out.println(s.age);
        s.age = 18;
        System.out.println(s.age);
        //get 取值   set 设置值（破坏封装性）
        System.out.println(s.getAge());//Ctrl + 鼠标左，跳选

        s.setAge(25);
        System.out.println(s.getAge());

    }

}
