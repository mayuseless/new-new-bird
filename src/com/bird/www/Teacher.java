package com.bird.www;

public class Teacher {
    //���췽��
    //�����������ļ�������ͬ�������������ͬ
    //����Ҫ  ���� ���أ�����void��
    private int age;
    public Teacher(){
        age = 18;
    }
    public static void main(String[] arges){
        Teacher t = new Teacher();
        //�Է� �أ����Լ�  if __name__ == '__main__':   �����ⲿ���øú���������
        System.out.println(t.age);

        for (int i = 0;i < 65535; i++){
            if(i%20 == 0){//�����ַ�
                System.out.println();
            }
            System.out.print((char) i);
            System.out.print(" ");
        }
    }
}
