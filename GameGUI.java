package cwk4;

import javax.swing.*;
import java.awt.*;

/**
 * Provides a GUI interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 04/04/2023
 */
public class GameGUI {
    private final WIN game = new SpaceWars("Horatio");
    private final JFrame frame = new JFrame("Game GUI");
    private final JPanel eastPanel = new JPanel();
    private final JPanel outputPanel = new JPanel();
    private final JMenuBar menubar = new JMenuBar();
    private final JTextArea listing = new JTextArea();
    private final JMenu forcesMenu = new JMenu("Forces");
    private final JMenu battlesMenu = new JMenu("Battles");
    private final JButton clearButton = new JButton("Clear");
    private final JButton viewStateButton = new JButton("View State");
    private final JMenuItem listASFItem = new JMenuItem("List ASF");
    private final JMenuItem recallForceItem = new JMenuItem("Recall Force");
    private final JMenuItem activateForceItem = new JMenuItem("Activate Force");
    private final JMenuItem listBattlesItem = new JMenuItem("List All Battles");

    /**
     * Constructs a game GUI object.
     */
    public GameGUI() {
        // Set the window size
        frame.setPreferredSize(new Dimension(800, 600));

        // Create the GUI
        makeFrame();
        makeMenuBar();
    }

    /**
     * Runs the GUI.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
        new GameGUI();
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        // Create the output panel listing the result from top to bottom
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setVisible(true);
        outputPanel.add(listing);

        // Set up the east panel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.WHITE);
        eastPanel.add(Box.createVerticalStrut(10));
        viewStateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        eastPanel.add(viewStateButton);
        eastPanel.add(Box.createVerticalStrut(10));
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        eastPanel.add(clearButton);

        // Set up the view button
        viewStateButton.addActionListener(e -> listing.setText(game.toString()));
        viewStateButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewStateButton.setForeground(Color.WHITE);
        viewStateButton.setBackground(Color.BLUE);

        // Set up the clear button
        clearButton.addActionListener(e -> listing.setText(""));
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLUE);

        // Arrange the components on the frame and show the GUI
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(outputPanel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar() {
        // Create a menubar
        menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
        menubar.setVisible(true);

        // Arrange the components on the menubar
        menubar.add(forcesMenu);
        menubar.add(Box.createHorizontalStrut(100));
        menubar.add(battlesMenu);

        // Add the menu items for forces and battles
        recallForceItem.addActionListener(e -> {
            String forceRef = JOptionPane.showInputDialog("Force reference: ");
            game.recallForce(forceRef);
            JOptionPane.showMessageDialog(frame, "Force" + forceRef + "recalled");
        });

        // Add action listeners for each menu item
        activateForceItem.addActionListener(e -> {
            String forceNum = JOptionPane.showInputDialog("Force reference: ");
            JOptionPane.showMessageDialog(frame, activateResult(game.activateForce(forceNum)));
        });
        listASFItem.addActionListener(e -> listing.setText(game.getASFleet()));
        listBattlesItem.addActionListener(e -> listing.setText(game.getAllBattles()));

        // Arrange the components on the forcesMenu
        forcesMenu.add(recallForceItem);
        forcesMenu.add(activateForceItem);
        forcesMenu.add(listASFItem);

        // Arrange the components on the battlesMenu
        battlesMenu.add(listBattlesItem);

        // Arrange the components on the frame
        frame.setJMenuBar(menubar);
    }

    /**
     * Process the result of activating a force.
     *
     * @param code The result of activating a force.
     * @return A string representation of the result of activating a force.
     */
    public static String activateResult(int code) {
        switch (code) {
            case 0:
                return "Force is activated";
            case 1:
                return "Force is not in the UFF dock or is destroyed";
            case 2:
                return "Not enough money";
            default:
                return "No such force";
        }
    }
}
