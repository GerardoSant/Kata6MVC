package Controller.Commands;

import Controller.Command;
import Model.Square;
import View.SquareDisplay;

public class ResetCommand implements Command {

    private Square square;
    private SquareDisplay squareDisplay;

    public ResetCommand(Square square, SquareDisplay squareDisplay) {
        this.square = square;
        this.squareDisplay = squareDisplay;
    }

    public void execute() {
        resetSquarePosition();
    }

    private void resetSquarePosition(){
        square.setPosition(squareDisplay.getDisplayWidth()/2 - square.getSide()/2);
        squareDisplay.displaySquare(square);
    }
}
