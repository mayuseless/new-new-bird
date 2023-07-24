package com.game.bird.www;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    //������棬����ͼƬ��ת��̬
    private BufferedImage ground_Image;
    //���ڽ��ܿ�ʼ(����ͼƬground)ͼƬ
    int x;
    //ͼƬ�ĺ�����

    public Ground() throws IOException {
        ground_Image = ImageIO.read(getClass().getResource("ground.png"));
        x = 0;
    }
    //���ͼƬ��ճ����
    public void paint(Graphics g){
        //���ͼƬ�Ļ���
        g.drawImage(ground_Image,x,644 - 146,null);
    }

    public void move(){
        x = x-2;
        if (x <= 432 - 800){
            x = 0;
        }
    }

}
