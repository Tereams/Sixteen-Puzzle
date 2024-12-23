package demo.tereams.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            if(y>0){
                data[x][y]=data[x][y-1];
                data[x][y-1]=0;
                y--;
                initImages();
            }
        }
        else if (keyCode == 38) {
            if(x>0){
                data[x][y]=data[x-1][y];
                data[x-1][y]=0;
                x--;
                initImages();
            }
        }
        else if (keyCode == 39) {
            if(y<3){
                data[x][y]=data[x][y+1];
                data[x][y+1]=0;
                y++;
                initImages();
            }
        }
        else if (keyCode == 40) {
            if(x<3){
                data[x][y]=data[x+1][y];
                data[x+1][y]=0;
                x++;
                initImages();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    int[][] data = new int[4][4];
    int x=0;
    int y=0;

    public GameJFrame() {
        initJFrame();

        initJMenuBar();
        intiData();
        initImages();

        this.setVisible(true);
    }

    private void intiData() {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random rand = new Random();
        for(int i=0;i<tempArr.length;i++) {
            int index = rand.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        for(int i=0;i<tempArr.length;i++) {
            if(tempArr[i]==0) {
                x=i/4;
                y=i%4;
            }
            this.data[i/4][i%4]=tempArr[i];
        }
    }

    private void initImages() {

        this.getContentPane().removeAll();

        for(int j =0; j<4; j++){
            for(int i = 0; i<4; i++){
                int num=data[j][i];
                JLabel label = new JLabel(new ImageIcon("image/meinv/meinv2/block_" + num/4 + "_" + num%4 + ".png"));
                label.setBounds(105*i+83,105*j+134,105,105);
                if(num==0){
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
                }else{
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));}

                this.getContentPane().add(label);
            }
        }

        JLabel label = new JLabel(new ImageIcon("image/bg.png"));
        label.setBounds(40,40,508,560);
        this.getContentPane().add(label);

        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        JMenuBar jmb = new JMenuBar();

        JMenu functionJm = new JMenu("Game");
        JMenu aboutJm = new JMenu("About");

        JMenuItem restartItem = new JMenuItem("Restart Game");
        JMenuItem reLoginItem = new JMenuItem("ReLogin");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        functionJm.add(restartItem);
        functionJm.add(reLoginItem);
        functionJm.add(exitItem);
        aboutJm.add(aboutItem);

        jmb.add(functionJm);
        jmb.add(aboutJm);

        this.setJMenuBar(jmb);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("Jigsaw Game");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
    }

}
