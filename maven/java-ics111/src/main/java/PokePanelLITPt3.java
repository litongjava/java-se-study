import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

public class PokePanelLITPt3 extends JPanel {
  Font font = new Font("Arial", Font.PLAIN, 30);

  JPanel topPanel = new JPanel();
  JPanel centerPanel = new JPanel();
  JPanel bottomPanel = new JPanel();

  public PokePanelLITPt3() {
    this.setPreferredSize(new Dimension(1000, 800));
    topPanel.setBackground(Color.gray);
    centerPanel.setBackground(Color.white);
    bottomPanel.setBackground(Color.white);

  }

}
