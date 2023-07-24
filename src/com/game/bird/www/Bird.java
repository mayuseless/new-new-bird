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
    //数组  用于存储小鸟飞行八张图片
    private int index = 0;
    //索引，标记小鸟数组图片变量
    private final double v0;
    //小鸟上抛速度,固定
    private double t;
    //小鸟移动时间,不变，单位时间
    private double g;
    //重力加速度
    private double speed;
    //当前速度
    private BufferedImage image;

    //无参构造,初始化小鸟对象  放置对应位置，并使用图片
    public Bird() throws IOException {
        x = 100;
        y = 240;
        v0 = 25;
        t = 0.5;
        g = 6;
        speed = v0;
        //数组初始化长度 = 8
        Images = new BufferedImage[8];

        //加载小鸟八张图
        for (int i = 0;i < 8 ;i++){
            //加载
            BufferedImage img = ImageIO.read(getClass().getResource(i + ".png"));
            //装入
            Images[i] = img;
        }
        //小鸟默认显示第一张图片
        image = Images[0];
    }

    //点击鼠标后,还原速度为初始值
    public void resetspeed(){
        speed = v0;
    }

    //小鸟向上飞  ,鼠标监听,点一下向上飞   ，否则下降
    public void move() {
//        //计算移动距离s,匀速
//        double s = v0*t;
//        y -= s;

        //计算经过重力后速度，匀减速
        double v = speed - g*t;
        //需要给小鸟赋值当前速度，持续变化
        speed = v;
        double s = speed * t;
        y = y - (int)s;
//        System.out.println(y);
        if (y > 644){
            y = 644 - 146;
        }
    }

    //与柱子Column多线程矛盾，另辟
    public void fly(){
        image = Images[index % 8];  //问题：数int  越界溢出,长时间后
        index ++;
    }
    //用来画小鸟方法
    public void paint(Graphics g){
        g.drawImage(image,x,y,null);
    }

    //判断小鸟是否撞柱子
    public boolean hits(Column c1, Column c2){
        if(hit(c1) || hit(c2)) {
            return true;
        }
        return false;
    }
    public boolean hit(Column c1){
        if(this.x +28 >= c1.getX() && this.x + 28 < c1.getX() + 78) {//到柱子
            int top = c1.getY() +644-146;
            int bot = c1.getY() +225+644-146;
            int cur = this.y +24;
//            boolean res = (this.y)<=644 - 146 && (this.y)>=0;//true&&res  地面天空撞击
            if (cur <= top || cur >= bot ){//柱子高
//                System.out.println("Hit!!");
//                System.out.println(cur + "\t" + top + "\t" + bot);
                return true;
            }
        }
        return false;
    }

    //得分  是否得
    public boolean pass(Column c1){
        boolean res = (this.x - c1.getX())<=1 && (this.x - c1.getX())>=0;
        return res;
    }
    public void resetY(){
        this.y = 240;
    }
}
