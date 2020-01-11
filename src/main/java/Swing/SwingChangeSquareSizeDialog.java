package Swing;

import View.ChangeSquareSizeDialog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class SwingChangeSquareSizeDialog extends JDialog implements ChangeSquareSizeDialog {

    private int squareNewSize;
    private JTextField jTextFieldSquareNewSize;

    public SwingChangeSquareSizeDialog(JFrame jframe){
        createUI();
        setLocationRelativeTo(jframe);
    }

    private void createUI() {
        add(inputPanel(), BorderLayout.NORTH);
        add(buttonPanel(), BorderLayout.SOUTH);
        setJDialogSettings();
    }


    private JPanel inputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input new square size (side)"));
        jTextFieldSquareNewSize= new JTextField(10);
        inputPanel.add(jTextFieldSquareNewSize);
        return inputPanel;
    }

    private JPanel buttonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(acceptButton());
        buttonPanel.add(cancelButton());
        return buttonPanel;
    }

    private JButton cancelButton() {
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> {
            squareNewSize=0;
            jTextFieldSquareNewSize.setText("");
            setVisible(false);
        });
        return cancel;
    }

    private JButton acceptButton() {
        JButton accept = new JButton("Accept");
        accept.addActionListener(e-> {
            squareNewSize = parseInt(jTextFieldSquareNewSize.getText());
            jTextFieldSquareNewSize.setText("");
            setVisible(false);
        });
        return accept;
    }

    private void setJDialogSettings() {
        setTitle("New square size");
        setResizable(false);
        setModal(true);
        pack();

    }

    @Override
    public int getNewSquareSize() {
        setVisible(true);
        return squareNewSize;
    }
}
