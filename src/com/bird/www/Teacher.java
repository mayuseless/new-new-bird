package com.bird.www;

public class Teacher {
    //构造方法
    //方法名和类文件名字相同，或和类名字相同
    //不需要  方法 返回（不是void）
    private int age;
    public Teacher(){
        age = 18;
    }
    public static void main(String[] arges){
        Teacher t = new Teacher();
        //自反 回，是自己  if __name__ == '__main__':   当从外部调用该函数（包）
        System.out.println(t.age);

        for (int i = 0;i < 65535; i++){
            if(i%20 == 0){//换行字符
                System.out.println();
            }
            System.out.print((char) i);
            System.out.print(" ");
        }
    }
}
