package com.bird.www;
//当前这个文件叫做类文件
//下方这一组大括号括起来就是一个类，用class修饰表示的类
//class关键字后面跟着的是类的名字
public class Test1 {
    //类中有属性和方法
    //属性就是我们的静态值（例如：姓名、学号、班级）
    //方法就是行为（例如：能跑能跳）函数
    //属性的写法是
    //权限修饰符 数据类型 属性名
    private int age;
    private char name;
    //Java数据类型就是八个分别是：btye short int long（整数） float double（小数） char（字符） boolean(布尔）
    private double score;
    //方法的定义形式是
    //权限修饰符号 返回值类型   方法名（函数）([参数类型   参数名])
    public void method(int a){
        //void 无返回，不需要结果
    }
    //方法括号中有参数   有参方法    ，无参数叫无参方法
    public int method1(int b){
        //不是void  有返回，需要结果，return进行返回，return跟的结果为执行反馈
        return 0;
    }
}