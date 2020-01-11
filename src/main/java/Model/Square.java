package Model;

public class Square {

    int position;
    int side;

    public Square(int position, int side) {
        this.position = position;
        this.side= side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
