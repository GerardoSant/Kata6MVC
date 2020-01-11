package Swing;

import Controller.CommandFactory;
import Model.Square;
import Controller.Command;
import View.SquareDisplay;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SwingMainFrame extends JFrame {

    private Square square;
    private SquareDisplay squareDisplay;
    private SwingMoveSquareDialog moveSquareDialog;
    private SwingChangeSquareSizeDialog changeSquareSizeDialog;
    Map<String, Command> commands;

    public SwingMainFrame(Square square){
        this.square = square;
        createUI();
        commands=new CommandFactory(squareDisplay, square, moveSquareDialog, changeSquareSizeDialog).build();
    }

    public void execute(){
        setVisible(true);
    }

    private void createUI() {
        moveSquareDialog = new SwingMoveSquareDialog(this);
        changeSquareSizeDialog = new SwingChangeSquareSizeDialog(this);
        add(squareDisplay());
        add(buttonsPanel(),BorderLayout.SOUTH);
        setFrameSettings();
    }

    private Component squareDisplay() {
        squareDisplay= new SwingSquareDisplay(square);
        return (Component) squareDisplay;
    }

    private JPanel buttonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(button("Reset"));
        buttonsPanel.add(button("Move"));
        buttonsPanel.add(button("Change"));
        return buttonsPanel;
    }

    private JButton button(final String buttonName){
        JButton button = new JButton(buttonName);
        button.addActionListener(e -> commands.get(buttonName).execute());
        return button;
    }

    private void setFrameSettings() {
        setSize(800, 300);
        setTitle("Block displayer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
