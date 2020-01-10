package Swing;
import Model.Square;


public class main {

    public static void main(String[] args) {
        Square square = new Square(100,50);
        SwingMainFrame swingMainFrame = new SwingMainFrame(square);
        swingMainFrame.execute();
    }
}
