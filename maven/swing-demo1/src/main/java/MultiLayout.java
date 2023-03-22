import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author litong
 * @date 2020年12月30日_下午9:33:05 
 * @version 1.0 
 * @desc
 */
@SuppressWarnings("serial")
public class MultiLayout extends JFrame {
  public static void main(String[] args) {
    MultiLayout multiLayout = new MultiLayout();
    multiLayout.demo1();
  }

  // 定义组件
  private JPanel jp1, jp2;
  private JButton jb1, jb2, jb3, jb4, jb5, jb6;

  private void demo1() {
    jp1=new JPanel();
    jp2=new JPanel();
    
    jb1=new JButton("西瓜");
    jb2=new JButton("苹果");
    jb3=new JButton("荔枝");
    jb4=new JButton("葡萄");
    jb5=new JButton("桔子");
    jb6=new JButton("香蕉");
    
    //默认布局流
    jp1.add(jb1);
    jp1.add(jb2);
    jp2.add(jb3);
    jp2.add(jb4);
    jp2.add(jb5);
    
    //添加组件到JFrame
    this.add(jp1,BorderLayout.NORTH);
    this.add(jp2,BorderLayout.SOUTH);
    this.add(jb6,BorderLayout.CENTER);
    
    //#设置窗体#
    this.setSize(300,250);
    this.setLocation(200,200);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }

}
