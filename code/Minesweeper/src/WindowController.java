import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Max on 15.01.17.
 */
public class WindowController {

    private Minesweeper minesweeper;
    private JButton[][] fields;

    public WindowController(int x, int y, Minesweeper minesweeper) {
        this.minesweeper = minesweeper;

        int borderMargin = 20;
        int buttonSize = 30;

        fields = new JButton[x][y];

        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Minesweeper");

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(borderMargin, borderMargin, borderMargin, borderMargin));
        window.add(contentPanel);

        // Calculate window size
        int width = buttonSize * x + (2 * borderMargin);
        int height = buttonSize * y + (2 * borderMargin);

        JPanel minefield = new JPanel();
        minefield.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        minefield.setLayout(new GridLayout(x, y));
        minefield.setMaximumSize(new Dimension(width, height));

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                JButton mineButton = new JButton("");
                mineButton.setMaximumSize(new Dimension(buttonSize, buttonSize));
                mineButton.setPreferredSize(mineButton.getMaximumSize());

                int ii = i;
                int jj = j;

                mineButton.addMouseListener(new MouseAdapter(){
                    boolean pressed;

                    @Override
                    public void mousePressed(MouseEvent e) {
                        mineButton.getModel().setArmed(true);
                        mineButton.getModel().setPressed(true);
                        pressed = true;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //if(isRightButtonPressed) {underlyingButton.getModel().setPressed(true));
                        mineButton.getModel().setArmed(false);
                        mineButton.getModel().setPressed(false);

                        if (pressed) {
                            minesweeper.clickField(ii, jj, false);
                        }
                        pressed = false;

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        pressed = false;
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        pressed = true;
                    }
                });

                minefield.add(mineButton);
                fields[i][j] = mineButton;
            }
        }

        contentPanel.add(minefield);

        window.setSize(width, height + 22);
        contentPanel.setMaximumSize(new Dimension(width, height));

        window.setVisible(true);
    }

    public void updateField(Field field) {
        JButton button = fields[field.getPositionX()][field.getPositionY()];

        switch (field.getStatus()) {
            case COVERED: break;
            case FLAGGED:
                button.setText("F");
                button.setBackground(Color.GRAY);
                break;
            case OPENED:
                button.setBackground(Color.GRAY);
                break;
            case REVEALD:

                break;
        }
    }
}
