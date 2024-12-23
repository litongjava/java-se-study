import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * main panel.
 * @author Tong Li
 *
 */
public class PokeLIPanelPt3 extends JPanel {

  private static final String[] POKEMON_SPECIES = { "Bulbasaur", "Venusaur", "Ivysaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise" };
  private static final int[] POKEMON_NUMBERS = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  private static final int HP_MIN = 1;
  private static final int HP_MAX = 141;

  private ArrayList<ValidatedPokemonLITPt2> pokemonList = new ArrayList<>();

  /**
   * Constructor holds everything.
   */
  public PokeLIPanelPt3() {

    this.setBackground(Color.LIGHT_GRAY);

    // Upper part - Create Pokemon
    JPanel upperPanel = new JPanel(new BorderLayout());

    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    inputPanel.setBackground(Color.gray);

    JLabel labelChoice = new JLabel("Pokemon Available:");
    Choice choosierDrop = new Choice();
    for (String species : POKEMON_SPECIES) {
      choosierDrop.add(species);
    }

    JLabel labelName = new JLabel("Enter Name:");
    JTextField nameField = new JTextField(15);
    JButton makePokemonButton = new JButton("Make Pokemon");

    inputPanel.add(labelChoice);
    inputPanel.add(choosierDrop);
    inputPanel.add(labelName);
    inputPanel.add(nameField);
    inputPanel.add(makePokemonButton);

    JPanel newPokemonPanel = new JPanel(new BorderLayout());
    JLabel newPokemonLabel = new JLabel("New Pokemon:");
    newPokemonLabel.setHorizontalAlignment(SwingConstants.LEFT); // Align label to the left
    JTextArea newPokemonArea = new JTextArea(5, 30);
    newPokemonArea.setEditable(false);
    JScrollPane newPokemonScroll = new JScrollPane(newPokemonArea);

    newPokemonPanel.add(newPokemonLabel, BorderLayout.WEST);
    newPokemonPanel.add(newPokemonScroll, BorderLayout.CENTER);

    upperPanel.add(inputPanel, BorderLayout.NORTH);
    upperPanel.add(newPokemonPanel, BorderLayout.CENTER);

    this.add(upperPanel, BorderLayout.NORTH);

    // Lower part - List Pokemon
    JPanel lowerPanel = new JPanel(new BorderLayout());
    JButton listPokemonButton = new JButton("List Pokemon");
    JTextArea listPokemonArea = new JTextArea(10, 40);
    listPokemonArea.setEditable(false);

    lowerPanel.add(listPokemonButton, BorderLayout.NORTH);
    lowerPanel.add(new JScrollPane(listPokemonArea), BorderLayout.CENTER);

    this.add(lowerPanel, BorderLayout.CENTER);

    // Action Listeners
    makePokemonButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String selectedSpecies = choosierDrop.getSelectedItem();
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
          JOptionPane.showMessageDialog(upperPanel.getParent(), "Please enter a name for the Pokemon.", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        int speciesIndex = choosierDrop.getSelectedIndex();
        int number = POKEMON_NUMBERS[speciesIndex];
        int hp = new Random().nextInt(HP_MAX - HP_MIN + 1) + HP_MIN;
        ValidatedPokemonLITPt2 newPokemon = new ValidatedPokemonLITPt2(selectedSpecies, name, number, hp);
        pokemonList.add(newPokemon);
        newPokemonArea.setText(newPokemon.toString());
        nameField.setText("");
      }
    });

    listPokemonButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        StringBuilder list = new StringBuilder();
        for (ValidatedPokemonLITPt2 pokemon : pokemonList) {
          list.append(pokemon).append("\n");
        }
        listPokemonArea.setText(list.toString());
      }
    });
  }

}
