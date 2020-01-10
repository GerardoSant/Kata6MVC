package Swing;

import View.MoveSquareDialog;
import javax.swing.*;
import java.awt.*;
import static java.lang.Integer.parseInt;

public class SwingMoveSquareDialog extends JDialog implements MoveSquareDialog {

    private int positionChange;
    private JFrame jframe;
    private JTextField jtfPositionChange;

    public SwingMoveSquareDialog(JFrame frame) {
        this.jframe=frame;
        createUI();
    }

    public int getSquarePositionChange() {
        setVisible(true);
        int posChange = positionChange;
        positionChange=0;
        return posChange;
    }

    private void createUI() {
        add(inputPanel(), BorderLayout.NORTH);
        add(buttonPanel(),BorderLayout.SOUTH);
        setJDialogSettings();
    }

    private JPanel inputPanel() {
        JPanel inputPanel = new JPanel();
        JLabel text = new JLabel("Enter position change");
        jtfPositionChange = new JTextField(10);
        inputPanel.add(text, BorderLayout.NORTH);
        inputPanel.add(jtfPositionChange,BorderLayout.SOUTH);
        return inputPanel;
    }

    private void setJDialogSettings() {
        pack();
        setModal(true);
        setLocationRelativeTo(jframe);
        setVisible(false);
    }

    private JPanel buttonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(acceptButton());
        buttonPanel.add(cancelButton());
        return buttonPanel;
    }

    private JButton acceptButton(){
        JButton button= new JButton("Accept");
        button.addActionListener(e-> {
            try {
                positionChange= parseInt(jtfPositionChange.getText());
                jtfPositionChange.setText("");
                setVisible(false);
            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, "Position change must be an integer number");
            }
        });
        return button;
    }

    private JButton cancelButton(){
        JButton button = new JButton("Cancel");
        button.addActionListener(e -> {
            jtfPositionChange.setText("");
            setVisible(false);
        });
        return button;
    }
}
