package Controller.Commands;

import Controller.Command;
import Model.Square;
import Swing.SwingMoveSquareDialog;
import View.MoveSquareDialog;
import View.SquareDisplay;

public class MoveCommand implements Command {

    SquareDisplay squareDisplay;
    MoveSquareDialog moveSquareDialog;
    Square square;

    public MoveCommand(SquareDisplay squareDisplay, MoveSquareDialog moveSquareDialog, Square square) {
        this.squareDisplay = squareDisplay;
        this.moveSquareDialog = moveSquareDialog;
        this.square = square;
    }

    public void execute() {
        moveSquare();
    }

    private void moveSquare() {
        square.setPosition(square.getPosition()+moveSquareDialog.getSquarePositionChange());
        squareDisplay.displaySquare(square);
    }


}
