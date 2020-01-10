package Controller;

import Controller.Commands.MoveCommand;
import Controller.Commands.ResetCommand;
import Model.Square;
import View.MoveSquareDialog;
import View.SquareDisplay;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private SquareDisplay squareDisplay;
    private Square square;
    private MoveSquareDialog dialog;

    public CommandFactory(SquareDisplay squareDisplay, Square square, MoveSquareDialog dialog) {
        this.squareDisplay = squareDisplay;
        this.square = square;
        this.dialog = dialog;
    }

    public Map<String,Command> build(){
        Map<String,Command> commands = new HashMap<String, Command>();
        commands.put("Move",new MoveCommand(squareDisplay, dialog, square));
        commands.put("Reset", new ResetCommand(square, squareDisplay));
        return commands;
    }
}
