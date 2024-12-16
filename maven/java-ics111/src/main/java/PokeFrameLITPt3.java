import javax.swing.JFrame;

public class PokeFrameLITPt3 {
	
	/**
	 * main method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// setup basic JFrame

		JFrame frm = new JFrame("PokemanGUI");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add StudentPanel object to Frame
		frm.getContentPane().add(new PokeLIPanelPt3());
		// Display to screen
		frm.pack();
		frm.setVisible(true);

	}
}
