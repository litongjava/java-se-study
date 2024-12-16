import javax.swing.JFrame;

public class PokeFrameLiTongPt1 {

	/**
	 * main method.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		JFrame frm = new JFrame("Pokemon Marker");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PokePanelLiTongPt1 ps1 = new PokePanelLiTongPt1();
		frm.getContentPane().add(ps1);
		frm.pack();
		frm.setSize(400, 400);
		frm.setVisible(true);

	}

}
