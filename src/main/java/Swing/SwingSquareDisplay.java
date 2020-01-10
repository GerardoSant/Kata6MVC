package Swing;

import Model.Square;
import View.SquareDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingSquareDisplay  extends JPanel implements SquareDisplay {

    Square square;

    public SwingSquareDisplay(Square square) {
        this.square= square;
        displaySquare(square);
    }

    public void displaySquare(Square square) {
        repaint();
    }

    public int getDisplayWidth() {
        return this.getWidth();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect( square.getPosition(), this.getHeight()/2-square.getSide()/2 , square.getSide(), square.getSide());
    }
}
