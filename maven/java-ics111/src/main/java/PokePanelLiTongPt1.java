import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PokePanelLiTongPt1 extends JPanel {

	JLabel label1 = new JLabel("Click button to make a pokeman");
	JLabel label2 = new JLabel();
	JButton button1 = new JButton("Make a Pokemon");

	public PokePanelLiTongPt1() {
		setBackground(Color.cyan);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(label1);
		JPanel rowPanel = new JPanel();
		rowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rowPanel.add(button1);
		rowPanel.add(label2);

		add(rowPanel);

		button1.addActionListener(new GUIListener());
	}

	private class GUIListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == button1) {
				ValidatedPokemonLITPt2 poke = new ValidatedPokemonLITPt2("Balbassur", "Bob", 1, 2);
				label2.setText("You made a " + poke.getSpecies());
			}
		}

	}

}
