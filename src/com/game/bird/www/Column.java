package com.game.bird.www;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//����
public class Column {
    //�������ӣ�����ͼƬ��ת��̬
    private BufferedImage column_Image;
    //���ڽ�������(column.png)ͼƬ
    int x,y ,discount = 255;
    //ͼƬ�ĺᣬ�����꣬���������count�����ֽ��̾���discount��432+78��/2
    private Random random = new Random();//�����
    public Column(int no) throws IOException {
        column_Image = ImageIO.read(getClass().getResource("column.png"));
        x = 500 + discount * no;
        y = -(1200 - 644)/2 - random.nextInt(100);
        //random.nextInt(100)�����0��1���Ŵ�100
    }
    public void paint(Graphics g){
        //���ͼƬ�Ļ���
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
