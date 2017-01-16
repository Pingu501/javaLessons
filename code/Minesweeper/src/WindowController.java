import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Max on 15.01.17.
 */
public class WindowController {

    private JLabel scoreLabel;

    public WindowController(int x, int y) {
        int borderMargin = 20;
        int buttonSize = 30;

        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Minesweeper");

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(borderMargin, borderMargin, borderMargin, borderMargin));
        window.add(contentPanel);

        scoreLabel = new JLabel("Your score: 0");
        scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(scoreLabel);

        // Calculate window size

        Dimension labelSize = scoreLabel.getPreferredSize();
        int width = buttonSize * x + (2 * borderMargin);
        int height = buttonSize * y + (2 * borderMargin) + labelSize.height;

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
                mineButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("CLICKED  " + ii + jj);
                    }
                });

                minefield.add(mineButton);
            }
        }

        contentPanel.add(minefield);

        window.setSize(width, height + 22);
        contentPanel.setMaximumSize(new Dimension(width, height));

        window.setVisible(true);
    }

}
