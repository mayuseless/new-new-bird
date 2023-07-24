import com.game.bird.www.*;

import javax.swing.*;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Main {
    //java 程序运行的入口 , 开始标志
    //主体函数main
    //java 程序运行的入口 , 开始标志
    //主体函数main
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("像素鸟");
        World world = new World();
        frame.add(world);
        frame.setVisible(true);
        frame.setSize(432,644);//800,146  _  432,644
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        world.action();
    }
}