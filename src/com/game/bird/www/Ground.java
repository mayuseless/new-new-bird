package com.game.bird.www;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    //引入地面，接受图片，转动态
    private BufferedImage ground_Image;
    //用于接受开始(地面图片ground)图片
    int x;
    //图片的横坐标

    public Ground() throws IOException {
        ground_Image = ImageIO.read(getClass().getResource("ground.png"));
        x = 0;
    }
    //描绘图片（粘贴）
    public void paint(Graphics g){
        //描绘图片的画笔
        g.drawImage(ground_Image,x,644 - 146,null);
    }

    public void move(){
        x = x-2;
        if (x <= 432 - 800){
            x = 0;
        }
    }

}
