package tictoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Nitro 5
 */
public class Main {
    private static char turn = 'X';
    private static JLabel title2;
    private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private static String winner = " ";
    private static char[][] chars = new char[3][3];

    public static void main(String[] args) {
        JFrame frame = new JFrame("XO");
        frame.setSize(420, 470);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("XO");
        title.setBackground(Color.white);
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 7, 7));
        panel.setBackground(Color.black);

        JLabel title2 = new JLabel("Player 1 turn");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBackground(Color.white);
        title2.setOpaque(true);
        title2.setFont(new Font("Tahoma", Font.BOLD, 25));
        title2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setFont(new Font("Tahoma", Font.BOLD, 60));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                int m = i;
                int n = j;
                label.addMouseListener(new MouseListener() {

                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {

                    }

                    // clicked
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        if (label.getText().equals(" ")) {
                            label.setText(turn + "");
                            chars[m][n] = turn;
                            if (turn == 'X') {
                                label.setForeground(Color.red);
                                turn = 'O';
                                title2.setText("Player 2 turn");
                            } else {
                                label.setForeground(Color.blue);
                                turn = 'X';
                                title2.setText("Player 1 turn");
                            }
                        } else {
                            title2.setText("This place is taken");
                        }
                    }

                });
                labels.add(label);
                panel.add(label);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(title2);
        JButton button = new JButton("Reset");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(new Font("Tahoma", Font.BOLD, 18));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                turn = 'X';
                title2.setText("Player 1 turn");
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    JLabel label = (JLabel) panel.getComponent(i);
                    label.setText(" ");
                }
            }
        });
        p.add(button);
        frame.add(p, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
