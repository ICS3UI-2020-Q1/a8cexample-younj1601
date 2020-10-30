import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JPanel topPanel;
  JPanel buttonPanel;

  JButton[] numberButtons;
  JButton addButton;
  JButton subtractButton;
  JButton multButton;
  JButton divButton;
  JButton equalButton;
  JButton decimalButton;

  JTextField display;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main panel with a border layout
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    //initialize the button panel with a grid layout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4,4));

    //initialize the top panel with the default layout
    topPanel = new JPanel();

    //create the display
    display = new JTextField("0");
    //set a perfered size so Flow layout knows it should be bigger
    display.setPreferredSize(new Dimension(800,100));
    //add it to the top
    topPanel.add(display);

    //creating the number buttons
    numberButtons = new JButton[10];
    for(int i = 0; i < numberButtons.length; i++){
      numberButtons[i] = new JButton("" + i);
      //set the action command
      numberButtons[i].setActionCommand("" + i);
      //add action Listener
      numberButtons[i].addActionListener(this);
    }

    //create the operation buttons
    equalButton = new JButton("=");
    equalButton.addActionListener(this);
    equalButton.setActionCommand("equal");

    addButton = new JButton("+");
    addButton.addActionListener(this);
    addButton.setActionCommand("add");

    subtractButton = new JButton("-");
    subtractButton.addActionListener(this);
    subtractButton.setActionCommand("subtract");

    multButton = new JButton("x");
    multButton.addActionListener(this);
    multButton.setActionCommand("multiply");

    divButton = new JButton("/");
    divButton.addActionListener(this);
    divButton.setActionCommand("divide");

    decimalButton = new JButton(".");
    decimalButton.addActionListener(this);
    decimalButton.setActionCommand("decimal");

    //add the buttons to the grid
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);
    buttonPanel.add(divButton);

    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);
    buttonPanel.add(multButton);

    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);
    buttonPanel.add(subtractButton);

    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(decimalButton);
    buttonPanel.add(addButton);
    buttonPanel.add(equalButton);

    //assemble the panels
    mainPanel.add(topPanel, BorderLayout.PAGE_START);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);
    
    //add the mail panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
