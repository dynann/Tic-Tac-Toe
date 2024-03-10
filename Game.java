import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Game extends JPanel implements ActionListener{

    int width;
    int height;
    //text label
    JLabel textLabel = new JLabel();

    //add text panel
    JPanel textPanel = new JPanel();
    
    //board
    JPanel boardPanel = new JPanel();
    JButton restartButton = new JButton();

    //button
    JButton[][] button = new JButton[3][3];
    String x = "X";
    String o = "O";
    String currentPlayer = x;
    boolean gameCheck = false;
    int turns = 0;

    //constructor
    Game(int width, int height, JLabel textLabel, JPanel boardPanel, JPanel restartPanel, JButton restartButton)
    {
        this.width = width;
        this.height = height;
        this.textLabel = textLabel;
        this.boardPanel = boardPanel;
        this.restartButton = restartButton;
        // setPreferredSize(new Dimension(this.width, this.height));
        setBackground(Color.lightGray);
        textLabel.setBackground(new Color(106, 90, 205));
        textLabel.setForeground(Color.black);
        restartPanel.setBackground(new Color(222, 49, 99));
//        restartPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 5));
        restartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 12));
        restartPanel.setPreferredSize(new Dimension(50,50));
        textLabel.setText("Tic Tac Toe");
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setOpaque(true);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.LIGHT_GRAY);
        restartButton.setText("restart");
        restartButton.setForeground(Color.white);
        restartButton.setBackground(new Color(0, 128, 128));
        restartButton.setFocusable(false);
        restartPanel.add(restartButton);

        restartButton.addActionListener(this);
    }

    public void buttonSeleted()
    {

        for(int i = 0 ; i < 3; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                JButton tile = new JButton();
                button[i][j] = tile;
                boardPanel.add(tile);

                tile.setBackground(new Color(159, 226, 191));
                tile.setForeground(Color.BLACK);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameCheck) return;

                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == "")
                        {
                            tile.setText(String.valueOf(currentPlayer));
                            turns++;
                            checkWinner();
                            if(!gameCheck)
                            {
                                currentPlayer = currentPlayer == x ? o : x;
                            }
                        }


                    }
                } );

            }
        }
    }

    void checkWinner()
    {
        for(int i = 0 ; i < 3 ; i++)
        {
            if(button[i][0].getText() == "") continue;
            if(button[i][0].getText()  == button[i][1].getText() && button[i][1].getText() == button[i][2].getText() )
            {
                for(int j = 0 ; j < 3 ; j++)
                {
                    setWinner(button[i][j]);
                }
                gameCheck = true;
                return;
            };
        }

        for(int i = 0 ; i < 3 ; i++)
        {
            if (button[0][i].getText() == "") continue;

            if(button[0][i].getText() == button[1][i].getText() && button[1][i].getText() == button[2][i].getText())
            {
                for(int j = 0 ; j < 3 ; j++)
                {
                    setWinner(button[j][i]);
                }
                gameCheck = true;
                return;
            }
        }

        if(button[0][0].getText() == button[1][1].getText() && button[1][1].getText() == button[2][2].getText() && button[0][0].getText() != "")
        {
            setWinner(button[0][0]);
            setWinner(button[1][1]);
            setWinner(button[2][2]);
            gameCheck = true;
            return;
        }
        if(button[0][2].getText() == button[1][1].getText() && button[1][1].getText() == button[2][0].getText() && button[0][2].getText() != "")
        {
            setWinner(button[0][2]);
            setWinner(button[1][1]);
            setWinner(button[2][0]);
            gameCheck = true;
            return;
        }
        if(turns==9)
        {
            for(int i = 0 ; i < 3 ; i++)
            {
                for(int j = 0 ; j < 3 ; j++)
                {
                    checkTied(button[i][j]);
                }
            }
        }


    }


    void setWinner(JButton button)
    {
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(100, 149, 237));
        textLabel.setText(currentPlayer + " won");
    }
    void checkTied(JButton button)
    {
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(204, 204, 255));
        textLabel.setText("Draw");
        System.out.println("hello");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == restartButton)
        {
            turns = 0;
            for(int r = 0 ; r < 3 ; r++)
            {
                for(int c = 0 ; c < 3 ; c++)
                {
//                    this.button[r][c].setText("");
                    gameCheck = false;
                    gameRestart(button[r][c]);
                }

            }

        }
    }
    void gameRestart(JButton button)
    {
        button.setText("");
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(159, 226, 191));
    }


}
