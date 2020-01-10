package Swing;

import View.MoveSquareDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class SwingMoveSquareDialog extends JDialog implements MoveSquareDialog {


    private int positionChange;
    private JFrame jframe;
    private JTextField jtfPositionChange;


    public SwingMoveSquareDialog(JFrame frame) {
        createUI();
    }

    private void createUI() {
        JPanel inputPanel = new JPanel();
        JLabel text = new JLabel("Enter position change");
        jtfPositionChange = new JTextField(10);
        inputPanel.add(text, BorderLayout.NORTH);
        inputPanel.add(jtfPositionChange,BorderLayout.SOUTH);
        JPanel buttonPanel = new JPanel();
        JButton accept = new JButton("Accept");
        addAcceptListener(accept);
        JButton cancel = new JButton("Cancel");
        addCancelListener(cancel);
        buttonPanel.add(accept);
        buttonPanel.add(cancel);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
        setModal(true);
        setLocationRelativeTo(jframe);
        setVisible(false);
    }

    public int getSquarePositionChange() {
        setVisible(true);
        int res = positionChange;
        positionChange=0;
        return res;
    }

    private void addAcceptListener(JButton button){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    positionChange= parseInt(jtfPositionChange.getText());
                    jtfPositionChange.setText("");
                    setVisible(false);
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Position change must be an integer number");
                }

            }
        });
    }

    private void addCancelListener(JButton button){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtfPositionChange.setText("");
                setVisible(false);
            }
        });
    }

}
