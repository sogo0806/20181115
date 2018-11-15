import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameMain extends JFrame {
    private JLabel jlb = new JLabel();
    private ImageIcon icon = new ImageIcon("Lion.png");
    private Container cp;
    private Timer t1 ;
    private int dirFlag = 1;
    private int x=0,y=0,higx=200,higy=250;
    public FrameMain(){
        init();
    }
    private void init (){
        this.setBounds(100,100,600,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(null);
        Image img = icon.getImage();
        Image img2 = img.getScaledInstance(150,200,Image.SCALE_SMOOTH);
        icon.setImage(img2);
        jlb.setBounds(x,y,150,500);
        jlb.setIcon(icon);
        cp.add(jlb);


        t1 = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag){
                    case 1:
                        if (y-4 > 0){
                           y-=10;
                        }else {
                            dirFlag = 2;
                        }
                        break;

                    case 2:
                        if (y+4< 800-higy){
                            y+=10;
                        }else {
                            dirFlag = 1;
                        }
                        break;

                    case 3:
                        if (x-4 > 0){
                            x-=10;
                        }else {
                            dirFlag = 4;
                        }
                        break;

                    case 4:
                        if (x + 4< 600-higx){
                            x+=10;
                        }else {
                            dirFlag = 3;
                        }
                        break;
                }
                jlb.setLocation(x,y);
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_SPACE:
                        t1.start();
                        break;

                    case KeyEvent.VK_LEFT:
                        jlb.setIcon(icon);
                        jlb.setLocation(jlb.getX()-5,jlb.getY());
                        dirFlag=3;
                        break;

                    case KeyEvent.VK_RIGHT:
                        jlb.setIcon(icon);
                        jlb.setLocation(jlb.getX()+5,jlb.getY());
                        dirFlag=4;
                        break;

                    case KeyEvent.VK_UP:
                        jlb.setIcon(icon);
                        jlb.setLocation(jlb.getX(),jlb.getY()-5);
                        dirFlag=1;
                        break;

                    case KeyEvent.VK_DOWN:
                        jlb.setIcon(icon);
                        jlb.setLocation(jlb.getX(),jlb.getY()+5);
                        dirFlag=2;
                        break;
                }
            }
        });

    }
}