import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
// add this for the listener
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
* Panel for SchoolFrame GUI.
* Demonstrates connecting non-gui objects to GUI
*
* @author L.Miller, B.Polo
* @since 11/27/23
*/

public class SchoolPanel extends JPanel {

  Font font = new Font("Arial", Font.PLAIN, 30);
  /********* label. ************/
  private JLabel lTitle = new JLabel("Kapiolani School Registration");

  /********* label. ************/
  private JLabel lMsg = new JLabel("                ");

  /******* button. ****************/
  private JButton bAdd = new JButton(" Add ");

  /******* button. ****************/
  private JButton bClear = new JButton(" Clear ");

  /********* sub-panel. *********/
  private JPanel topSubPanel = new JPanel();
  /********* sub-panel. *********/
  private JPanel centerSubPanel = new JPanel();
  /********* sub-panel. *********/
  private JPanel bottomSubPanel = new JPanel();
  /** we can declare and initialize ActionListener obj. */
  private GUIListener listener = new GUIListener();

  /******** text field for user entry. *******/
  private JTextField tfName = new JTextField(25);

  /******** text field for user entry. *******/
  private JTextField tfID = new JTextField(10);

  /********** Choice drop down menu for GPA. **/
  private Choice chGPA = new Choice();

  /******** student. *********/
  private Student st;
  /******* capacity of Student array. ****/
  private final int capacity = 10;
  /******** Array of Students. ***************/
  private Student[] stArr = new Student[capacity];
  /******** counter for Students. ***************/
  private int count = 0;

  /******** String for holding Student for display. */
  private String sOut = new String("");
  /****** text are for displaying Student.toString()s. */
  //parameters are default size in (rows,cols) chars
  private JTextArea textArea = new JTextArea(20, 25);

  private JTextArea textArea2 = new JTextArea(5, 25);

  /** Make TextArea scrollable. **********************/
  //textArea is put inside this.              (right here)            
  private JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  /**
  * Constructor holds everything.
  */
  public SchoolPanel() {

    this.setLayout(new BorderLayout()); //Border panel layout
    this.setPreferredSize(new Dimension(800, 1000));
    topSubPanel.setBackground(Color.cyan); //north area color
    centerSubPanel.setBackground(Color.yellow); //center area color
    bottomSubPanel.setBackground(Color.white); //bottomSubPanel area color

    //setFont for everything
    bAdd.setFont(font);
    bClear.setFont(font);
    lTitle.setFont(font);
    lMsg.setFont(font);
    tfName.setFont(font);
    tfID.setFont(font);
    chGPA.setFont(font);
    textArea.setFont(font);
    textArea.setFont(font);
    //adding title to the topSubPanel
    topSubPanel.add(lTitle);

    this.add("North", topSubPanel); //adding top sub-panel to North

    //labels initialized
    JLabel lStudentName = new JLabel("Student Name: ");
    lStudentName.setFont(font);
    JLabel lGPA = new JLabel("Student GPA: ");
    lGPA.setFont(font);
    JLabel lID = new JLabel("Student ID: ");
    lID.setFont(font);

    //add choices to the choice dropdown list
    chGPA.add("0.0");
    chGPA.add("0.5");
    chGPA.add("1.0");
    chGPA.add("1.5");
    chGPA.add("2.0");
    chGPA.add("2.5");
    chGPA.add("3.0");
    chGPA.add("3.5");
    chGPA.add("4.0");
    //chGPA.add("4.5"); 

    //add labels, textFields and choice
    // centerSubPanel.add(textArea2);
    centerSubPanel.add(lStudentName);
    centerSubPanel.add(tfName);
    centerSubPanel.add(lGPA);
    centerSubPanel.add(chGPA);
    centerSubPanel.add(lID);
    centerSubPanel.add(tfID);

    centerSubPanel.add(textArea2);

    //set up the textArea for holding list
    //make the textArea look like the background instead of white
    textArea.setBackground(Color.yellow);
    //make it not editable by user
    textArea.setEditable(false);
    //set up scrollPane appearance and size (textArea already inside it) 
    // scroll.setBorder(null);
    centerSubPanel.add(scroll); //add scrollPane to panel, textArea inside.        
    scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
    //add the center sub-panel to Center of main panel
    this.add("Center", centerSubPanel);

    //adding message and buttons to the bottomSubPanel sub-panel
    bottomSubPanel.add(lMsg);
    bottomSubPanel.add(bAdd);
    bAdd.addActionListener(listener); //add listener to button
    bottomSubPanel.add(bClear);
    bClear.addActionListener(listener); //add listener to button 
    //add bottomSubPanel sub-panel to South area of main panel      
    this.add("South", bottomSubPanel);
  } //close StudentPanel constructor

  /**
  * Private ActionListener class.
  */
  private class GUIListener implements ActionListener {

    /**
    * ActionPerformed method.
    * @param event what button is clicked.
    */
    public void actionPerformed(ActionEvent event) {

      //if "clear" button clicked, run cleaner method  
      if (event.getSource() == bClear) {
        cleaner();
      }
      //if "add" button clicked
      //get the input from the text boxes
      //post error messages if input not valid
      //add student to array if valid
      if (event.getSource() == bAdd) {
        String sName = "";
        String sID = "";
        String sGPA = "";
        int iID = 0;
        double dGPA = 0;

        //get stuff in textBoxes
        sName = tfName.getText();
        sID = tfID.getText();
        //get Choice selection
        sGPA = chGPA.getSelectedItem();

        try {
          //converting sID to integer
          iID = Integer.parseInt(sID);
          //converting sGPA to double
          dGPA = Double.parseDouble(sGPA);

          //Student will throw StudentException if not valid
          st = new Student(sName, iID, dGPA);
          textArea2.setText(st.toString());

          if (count < capacity) {
            stArr[count] = st;
            lMsg.setText("student added");
            count++;
          } else {
            lMsg.setText("array full, cannot add student");
          }

          //redisplay the list of students
          sOut = "";
          for (int j = 0; j < capacity; j++) {
            if (j < count) {
              sOut += (j + 1) + " " + stArr[j] + "\n\n";
            }
          }
          textArea.setText(sOut);
        } catch (NumberFormatException nfe) {
          lMsg.setText("Student ID is not a number");
        } catch (StudentException e) {
          lMsg.setText(e.getMessage());
        }
      } //end for "add" button  
    } //actionEvent method

    /**
    * helper method for ActionListener.
    * clears the TextBoxes resets choice
    */
    private void cleaner() {
      chGPA.select("0.0");
      tfName.setText("");
      tfID.setText("");
      lMsg.setText("          ");
      // textArea.setText("");
      textArea2.setText("");
    } //end cleaner method

  } // end GUIListener private class

} //end SchoolPanel class