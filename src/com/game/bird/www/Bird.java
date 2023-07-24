package com.game.bird.www;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.lang.Math.*;

public class Bird {
    private int x;
    private int y;
    private BufferedImage Images[];
    //����  ���ڴ洢С����а���ͼƬ
    private int index = 0;
    //���������С������ͼƬ����
    private final double v0;
    //С�������ٶ�,�̶�
    private double t;
    //С���ƶ�ʱ��,���䣬��λʱ��
    private double g;
    //�������ٶ�
    private double speed;
    //��ǰ�ٶ�
    private BufferedImage image;

    //�޲ι���,��ʼ��С�����  ���ö�Ӧλ�ã���ʹ��ͼƬ
    public Bird() throws IOException {
        x = 100;
        y = 240;
        v0 = 25;
        t = 0.5;
        g = 6;
        speed = v0;
        //�����ʼ������ = 8
        Images = new BufferedImage[8];

        //����С�����ͼ
        for (int i = 0;i < 8 ;i++){
            //����
            BufferedImage img = ImageIO.read(getClass().getResource(i + ".png"));
            //װ��
            Images[i] = img;
        }
        //С��Ĭ����ʾ��һ��ͼƬ
        image = Images[0];
    }

    //�������,��ԭ�ٶ�Ϊ��ʼֵ
    public void resetspeed(){
        speed = v0;
    }

    //С�����Ϸ�  ,������,��һ�����Ϸ�   �������½�
    public void move() {
//        //�����ƶ�����s,����
//        double s = v0*t;
//        y -= s;

        //���㾭���������ٶȣ��ȼ���
        double v = speed - g*t;
        //��Ҫ��С��ֵ��ǰ�ٶȣ������仯
        speed = v;
        double s = speed * t;
        y = y - (int)s;
//        System.out.println(y);
        if (y > 644){
            y = 644 - 146;
        }
    }

    //������Column���߳�ì�ܣ����
    public void fly(){
        image = Images[index % 8];  //���⣺��int  Խ�����,��ʱ���
        index ++;
    }
    //������С�񷽷�
    public void paint(Graphics g){
        g.drawImage(image,x,y,null);
    }

    //�ж�С���Ƿ�ײ����
    public boolean hits(Column c1, Column c2){
        if(hit(c1) || hit(c2)) {
            return true;
        }
        return false;
    }
    public boolean hit(Column c1){
        if(this.x +28 >= c1.getX() && this.x + 28 < c1.getX() + 78) {//������
            int top = c1.getY() +644-146;
            int bot = c1.getY() +225+644-146;
            int cur = this.y +24;
//            boolean res = (this.y)<=644 - 146 && (this.y)>=0;//true&&res  �������ײ��
            if (cur <= top || cur >= bot ){//���Ӹ�
//                System.out.println("Hit!!");
//                System.out.println(cur + "\t" + top + "\t" + bot);
                return true;
            }
        }
        return false;
    }

    //�÷�  �Ƿ��
    public boolean pass(Column c1){
        boolean res = (this.x - c1.getX())<=1 && (this.x - c1.getX())>=0;
        return res;
    }
    public void resetY(){
        this.y = 240;
    }
}
