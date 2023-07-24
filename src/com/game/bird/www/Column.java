package com.game.bird.www;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//柱子
public class Column {
    //引入柱子，接受图片，转动态
    private BufferedImage column_Image;
    //用于接受柱子(column.png)图片
    int x,y ,discount = 255;
    //图片的横，纵坐标，跨过柱子数count，二分进程距离discount（432+78）/2
    private Random random = new Random();//随机数
    public Column(int no) throws IOException {
        column_Image = ImageIO.read(getClass().getResource("column.png"));
        x = 500 + discount * no;
        y = -(1200 - 644)/2 - random.nextInt(100);
        //random.nextInt(100)随机（0，1）放大100
    }
    public void paint(Graphics g){
        //描绘图片的画笔
        g.drawImage(column_Image,x,y,null);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void move(){
        x = x - 2;
        if (x <= - 78){
             x = 432;
             y = -(1200 - 644)/2 - random.nextInt(100);
        }
    }

}
