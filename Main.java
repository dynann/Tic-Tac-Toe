import javax.swing.*;
import java.awt.*;

public class Main {
   public static void main(String[] args)
   {
      int width = 650;
      int height = 700;
      JFrame frame = new JFrame("Tic Tac Toe");
      JLabel textLabel = new JLabel();
      JPanel textPanel = new JPanel();
      JPanel boardPanel = new JPanel();
      JPanel restartPanel = new JPanel();
      JButton restartButton = new JButton();
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setSize(width, height);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      Game tictac = new Game(width, height, textLabel, boardPanel, restartPanel, restartButton);
      textPanel.setLayout(new BorderLayout());
      textPanel.add(textLabel);
      frame.add(tictac);
      tictac.buttonSeleted();
      frame.add(restartPanel);
      frame.add(restartPanel, BorderLayout.SOUTH);
      frame.add(textPanel);
      frame.add(textPanel, BorderLayout.NORTH);
      frame.add(boardPanel);
   }

}