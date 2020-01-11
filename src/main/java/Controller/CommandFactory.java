package Controller;

import Controller.Commands.ChangeCommand;
import Controller.Commands.MoveCommand;
import Controller.Commands.ResetCommand;
import Model.Square;
import View.ChangeSquareSizeDialog;
import View.MoveSquareDialog;
import View.SquareDisplay;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private SquareDisplay squareDisplay;
    private Square square;
    private MoveSquareDialog dialog;
    private ChangeSquareSizeDialog changeSquareSizeDialog;

    public CommandFactory(SquareDisplay squareDisplay, Square square, MoveSquareDialog dialog, ChangeSquareSizeDialog changeSquareSizeDialog) {
        this.squareDisplay = squareDisplay;
        this.square = square;
        this.dialog = dialog;
        this.changeSquareSizeDialog = changeSquareSizeDialog;
    }

    public Map<String,Command> build(){
        Map<String,Command> commands = new HashMap<String, Command>();
        commands.put("Move",new MoveCommand(squareDisplay, dialog, square));
        commands.put("Reset", new ResetCommand(square, squareDisplay));
        commands.put("Change", new ChangeCommand(square, squareDisplay, changeSquareSizeDialog));
        return commands;
    }
}
