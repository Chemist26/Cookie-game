package guiPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CookieClickerGUI implements ActionListener {

    private int clickCount = 0;
    private JLabel clickLabel;
    private SoundManager soundManager;

    public CookieClickerGUI() {
        soundManager = new SoundManager();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Cookie Clicker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the cookie button and labels
        JButton cookieButton = createCookieButton();
        JLabel instructionLabel = new JLabel("Click the cookie!");
        clickLabel = new JLabel("You clicked: 0 times");

        // Set custom fonts and colors for labels
        Font instructionFont = new Font("Arial", Font.BOLD, 20);
        instructionLabel.setFont(instructionFont);
        instructionLabel.setForeground(Color.BLUE);

        Font clickFont = new Font("SansSerif", Font.PLAIN, 18);
        clickLabel.setFont(clickFont);
        clickLabel.setForeground(Color.RED);

        // Create and configure the main panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(cookieButton);
        panel.add(instructionLabel);
        panel.add(clickLabel);

        // Add the panel to the frame and set frame properties
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createCookieButton() {
        // Create the cookie button with an image
        ImageIcon cookieIcon = new ImageIcon("res/cookie.png");
        JButton button = new JButton(cookieIcon);
        button.addActionListener(this);
        return button;
    }

    // START APP
    public static void main(String[] args) {
        new CookieClickerGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickCount++;
        clickLabel.setText("You clicked: " + clickCount + " times");
        soundManager.playClickSound();
    }
}
