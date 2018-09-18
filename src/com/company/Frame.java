package com.company;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.io.*;

/**
 * Created by User on 12/24/2016.
 */
public class Frame extends JFrame implements Runnable,KeyListener, ActionListener {
    private ImageIcon shark;
    private JLabel label;

    private ImageIcon sharksFood;
    private JLabel label1;
    private ImageIcon sharksFood2;
    private JLabel label2;
    private ImageIcon sharksFood3;
    private JLabel label3;
    private ImageIcon sharksFood4;
    private JLabel label4;
    private ImageIcon sharksMoron;
    private JLabel labelM;
    private ImageIcon sharksFood5;
    private JLabel label5;

    private JLabel score;
    int count = 0;
    private JLabel life;
    int lifeCount = 3;

    private ImageIcon sharksPoison;
    private JLabel labelp;
    private ImageIcon sharksPoison1;
    private JLabel labelp1;
    private ImageIcon sharksPoison2;
    private JLabel labelp2;
    private ImageIcon sharksPoison3;
    private JLabel labelp3;
    private ImageIcon sharksPoison4;
    private JLabel labelp4;


    private Timer t;

    Random rand = new Random();

    int x = 800,y= 400,x1=100,y1=100,x3=-60,y3=300,x4=30,y4=500,xp = -200,yp = rand.nextInt(500),xM = -90,yM = rand.nextInt(500);
    int x2 = 0,y2 = 250,xp1 = -400,yp1 = rand.nextInt(500),xp2 = -100,yp2 = rand.nextInt(500);
    int x5 = 10,y5 = 450,xp3 = 0,yp3 = rand.nextInt(500),xp4 = -500,yp4 = rand.nextInt(500);


    public Frame() throws Exception {
        super("Hungry Shark Reloaded!");
        this.setLayout(null);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);

        music();

        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Images\\GameBackground.gif"))));

        shark = new ImageIcon(this.getClass().getResource("\\Images\\hungryShark.png"));
        sharksFood = new ImageIcon(this.getClass().getResource("\\Images\\1.png"));
        sharksFood2 = new ImageIcon(this.getClass().getResource("\\Images\\2.png"));
        sharksFood3 = new ImageIcon(this.getClass().getResource("\\Images\\3.png"));
        sharksFood4 = new ImageIcon(this.getClass().getResource("\\Images\\4.png"));
        sharksFood5 = new ImageIcon(this.getClass().getResource("\\Images\\3.png"));
        sharksPoison = new ImageIcon(this.getClass().getResource("\\Images\\6.png"));
        sharksPoison1 = new ImageIcon(this.getClass().getResource("\\Images\\5.png"));
        sharksPoison2 = new ImageIcon(this.getClass().getResource("\\Images\\7.png"));
        sharksPoison3 = new ImageIcon(this.getClass().getResource("\\Images\\5.png"));
        sharksPoison4 = new ImageIcon(this.getClass().getResource("\\Images\\7.png"));
        //sharksMoron = new ImageIcon(this.getClass().getResource("moron.png"));

        label = new JLabel(shark);
        label1 = new JLabel(sharksFood2);
        label2 = new JLabel(sharksFood);
        label3 = new JLabel(sharksFood3);
        label4 = new JLabel(sharksFood4);
        label5 = new JLabel(sharksFood5);

        labelp = new JLabel(sharksPoison);
        labelp1 = new JLabel(sharksPoison1);
        labelp2 = new JLabel(sharksPoison2);
        labelp3 = new JLabel(sharksPoison3);
        labelp4 = new JLabel(sharksPoison4);
        //labelM = new JLabel(sharksMoron);

        score = new JLabel("Score : ");
        life = new JLabel("Life : 3");

        label.setBounds(x,y,79,50);

        score.setBounds(850,10,100,100);
        score.setForeground(Color.ORANGE);
        score.setFont(new Font("Serif", Font.BOLD, 20));
        life.setBounds(10,10,100,100);
        life.setForeground(Color.RED);
        life.setFont(new Font("Serif", Font.BOLD, 20));

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label);

        this.add(score);
        this.add(life);

        this.add(labelp);
        this.add(labelp1);
        this.add(labelp2);
        this.add(labelp3);
        this.add(labelp4);
        //this.add(labelM);

        this.addKeyListener(this);

        t = new Timer(100,  this);
        t.start();



    }

    public void actionPerformed(ActionEvent e) {

        label.setBounds(x,y,79,50);
        label1.setBounds(x1,y1,59,54);
        label2.setBounds(x3,y3,59,54);
        label3.setBounds(x4,y4,59,54);
        label4.setBounds(x2,y2,59,54);
        label5.setBounds(x5,y5,59,54);

        labelp.setBounds(xp,yp,59,54);
        labelp1.setBounds(xp1,yp1,59,54);
        labelp2.setBounds(xp2,yp2,59,54);
        labelp3.setBounds(xp3,yp3,59,54);
        labelp4.setBounds(xp4,yp4,59,54);
        //labelM.setBounds(xM,yM,265,161);

        if(x1>950){
            x1 = -20;
        }
        if(x2 > 950)
        {
            x2 = -20;
        }
        if(x3>950){
            x3 = -20;
        }
        if(x4>950){
            x4 = -20;
        }
        if(x5>950){
            x5 = -20;
        }

        if(xp > 950)
        {
            xp = -20;
            yp = rand.nextInt(550);
        }
        if(xp1 > 950)
        {
            xp1 = -20;
            yp1 = rand.nextInt(550);
        }
        if(xp2 > 950)
        {
            xp2 = -20;
            yp2 = rand.nextInt(550);
        }
        if(xp3 > 950)
        {
            xp3 = -20;
            yp3 = rand.nextInt(550);
        }
        if(xp4 > 950)
        {
            xp4 = -20;
            yp4 = rand.nextInt(550);
        }
        /*if(xM > 950)
        {
            xM = -20;
            yM = rand.nextInt(550);
        }
*/
        if(x <= x1 && x1 <= x+10 && y <= y1+10 && y1 <= y+30)
        {
            x1 = -100;
            y1 = rand.nextInt(500);
            count+=1;
            score.setText("Score : "+ count);
        }
        if(x <= x3 && x3 <= x+10 && y <= y3+10 && y3 <= y+30)
        {
            x3 =-20;
            y3 = rand.nextInt(500);
            count+=3;
            score.setText("Score : "+ count);
        }
        if(x <= x4 && x4 <= x+10 && y <= y4+10 && y4 <= y+30)
        {
            x4 =-60;
            y4 = rand.nextInt(500);
            count+=5;
            score.setText("Score : "+ count);
        }
        if(x <= x2 && x2 <= x+10 && y <= y2+10 && y2 <= y+30)
        {
            x2 = -10;
            y2 = rand.nextInt(500);
            count+=7;
            score.setText("Score : "+ count);
        }
        if(x <= x5 && x5 <= x+10 && y <= y5+10 && y5 <= y+30)
        {
            x5 =-25;
            y5 = rand.nextInt(500);
            count+=5;
            score.setText("Score : "+ count);
        }


        if(x <= xp && xp <= x+10 && y <= yp+20 && yp <= y+30)
        {
            xp =-20;
            yp = rand.nextInt(450);
            count-=3;
            lifeCount--;
            if(count < 0) count = 0;
            if(lifeCount == 0)
            {
                try {
                    new GameOver(count).setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            score.setText("Score : "+ count);
            life.setText("Life : "+ lifeCount);

        }
        if(x <= xp1 && xp1 <= x+10 && y <= yp1+20 && yp1 <= y+30)
        {
            xp1 =-20;
            yp1 = rand.nextInt(450);
            count-=5;
            lifeCount--;
            if(count < 0) count = 0;
            if(lifeCount == 0)
            {
                try {
                    new GameOver(count).setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            score.setText("Score : "+ count);
            life.setText("Life : "+ lifeCount);
        }
        if(x <= xp2 && xp2 <= x+10 && y <= yp2+20 && yp2 <= y+30)
        {
            xp2 =-20;
            yp2 = rand.nextInt(450);
            count-=10;
            lifeCount--;
            if(count < 0) count = 0;
            if(lifeCount == 0)
            {
                try {
                    new GameOver(count).setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            score.setText("Score : "+ count);
            life.setText("Life : "+ lifeCount);
        }
        if(x <= xp3 && xp3 <= x+10 && y <= yp3+20 && yp3 <= y+30)
        {
            xp3 =-50;
            yp3 = rand.nextInt(450);
            count-=5;
            lifeCount--;
            if(count < 0) count = 0;
            if(lifeCount == 0)
            {
                try {
                    new GameOver(count).setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            score.setText("Score : "+ count);
            life.setText("Life : "+ lifeCount);
        }
        if(x <= xp4 && xp4 <= x+10 && y <= yp4+20 && yp4 <= y+30)
        {
            xp4 =-100;
            yp4 = rand.nextInt(450);
            count-=10;
            lifeCount--;
            if(count < 0) count = 0;
            if(lifeCount == 0)
            {
                try {
                    new GameOver(count).setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            score.setText("Score : "+ count);
            life.setText("Life : "+ lifeCount);
        }
        if(x <= xM+300 && xM+300 <= x + 20 && y <= yM+180 && yM+180 <= y + 20)
        {
            JOptionPane.showMessageDialog(this,"Game Over!");
        }


        x1+=8;
        x3+=8;
        x4+=8;
        x2+=8;
        x5+=8;
        xp+=15;
        xp1+=10;
        xp2+=20;
        xp3+=10;
        xp4+=20;
        //xM+=10;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT && x >= 0)
        {
            x-=10;

        }
        if(key == KeyEvent.VK_RIGHT && x <= 900)
        {
            x+=10;

        }
        if(key == KeyEvent.VK_UP && y >= 0)
        {
            y-=10;

        }
        if(key == KeyEvent.VK_DOWN && y <= 500)
        {
            y+=10;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }

    public void music() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Suicide Squad.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
