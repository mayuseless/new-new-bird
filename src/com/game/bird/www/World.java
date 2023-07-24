package com.game.bird.www;
//demo文件
//导包
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class World extends JPanel {
    //extends JPanel 继承
    //属性，全局变量
    //用于接受背景图片
    private BufferedImage bg_Image;
    //用于接受开始(背景图片bg)图片
    private BufferedImage start_Image;
    //开始图片
    private BufferedImage gameover_Image;
    //结束图片
    private boolean start = true;    //初始页面正常显示
    //声明道路，占坑
    private Ground ground = null;  //地面
    private Column column1 = null,column2 = null;  //柱子
    private Bird bird = null;
    //给类初始化，放萝卜
    private int score = 0;
    //记录分手吧
    private boolean gameover = false;
    //标记游戏是否结束;
    public void init() throws IOException {
        ground = new Ground();
        column1 = new Column(0);
        column2 = new Column(1);//此处仅是设计两个柱子
        bird = new Bird();
    }



    public World() throws IOException {
        //throws IOException 抛出问题交给别人

        //引入背景图片到项目中，有变量接受，用于后续操作
        //赋值
        bg_Image = ImageIO.read(Objects.requireNonNull(getClass().getResource("bg.png")));
        start_Image = ImageIO.read(Objects.requireNonNull(getClass().getResource("start.png")));

        init();//调用类坑与萝卜，进行初始化类
    }

    //paint   alt + (/)
    //paint + 回车   重写,告诉编译器这个方法是重写方法
    @Override
    public void paint(Graphics g) {
        //g 就是我们描绘图片的画笔    bgImage图片   0,0坐标左上角
        g.drawImage(bg_Image, 0, 0, null);
        //开始菜单的图层在柱子上
        column1.paint(g);
        column2.paint(g);
        if (start) {      //start是否显示start_Image，鼠标监听前维持1
            g.drawImage(start_Image, 0, 0, null);
        }else {
            //小鸟
            bird.paint(g);
        }
        //地面为最上图层
        ground.paint(g);//但是位置为高度差

        //重设字体   得分 左上角
        Font font = new Font(Font.MONOSPACED , Font.BOLD , 30);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("得分："+score , 10 ,50);

        if(gameover){
            try {
                gameover_Image = ImageIO.read(Objects.requireNonNull(getClass().getResource("gameover.png")));
                g.drawImage(gameover_Image, 0 , 0 ,null);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //鼠标监听
    public void action(){
        addMouseListener(new MouseAdapter() {
            //mousep   alt +(/)
            //mousep + 回车
            @Override
            public void mouseReleased(MouseEvent e) {
            //鼠标点击后，start_Image不显示
            start = false;

            System.out.println("鼠标监听到了");
            if(!start && !gameover) {//游戏开始，且没有结束  鼠标点击后重置小鸟速度
                bird.resetspeed();
            }
            if(!start && gameover) {//游戏开始，且有结束  鼠标点击后重置游戏
                start = true;
                gameover = false;
                score = 0;
                bird.resetY();
            }
            }
        });

        //子线程  (与while主线程无关) 创建线程对象，并开启线程
        new Thread(new Runnable() {  //Runnabe 线程接口，不可以被创建，但可重载匿名对象（无名类，只被用一次）
            @Override
            public void run() {
                while (true){
                    bird.fly();
                    //开始后允许小鸟移动
                    if(!start) {
                        bird.move();
                    }
                    try {
                        Thread.sleep(50);  //一秒一循环一扇翅膀,共8 * 0.125
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }).start();

        //子线程  音乐
        new PlaySound("cross.wav").start();

        //主线程 维持刷新
        while (true){
            repaint();//继承，对paint再调用
            ground.move();//柱子动
            if(!start){
                column1.move();
                column2.move();
                boolean result = bird.hits(column1,column2);

                if(result){
                    gameover = true;//游戏结束唯一判定
                }
                boolean pass = bird.pass(column1) || bird.pass(column2);
                if(pass && !gameover){
                    score++;
                }
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        try {
//            while (true){
//                Thread.sleep(10);
//                repaint();//继承，对paint再调用
//                ground.move();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }




    //java 程序运行的入口 , 开始标志
    //主体函数main
    public static void main(String[] args) throws IOException {

        //输出,控制台输出
//        System.out.println("first java");


        //创建窗口
        //Java中的创建对象又叫new对象
        JFrame frame = new JFrame("像素鸟");

        //游戏世界创建，添加到窗口
        World world = new World();
        frame.add(world);


        //显示创建出来的窗口
        frame.setVisible(true);
        //设置大小
        frame.setSize(432,644);//800,146  _  432,644
        //窗口居中
        frame.setLocationRelativeTo(null);
        //让窗口不能修改
        frame.setResizable(false);
        //关闭能退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //调用action鼠标监听
        world.action();


    }
}
