package Controller.Commands;

import Controller.Command;
import Model.Square;
import View.ChangeSquareSizeDialog;
import View.SquareDisplay;

public class ChangeCommand implements Command {

    private Square square;
    private SquareDisplay display;
    private ChangeSquareSizeDialog change;

    public ChangeCommand(Square square, SquareDisplay display, ChangeSquareSizeDialog change) {
        this.square = square;
        this.display = display;
        this.change = change;
    }

    @Override
    public void execute() {
        int squareSizeChange=change.getNewSquareSize();
        if (squareSizeChange > 0){
            square.setSide(squareSizeChange);
            display.displaySquare(square);
        }

    }
}
