//package main.java;

public class StaticEntity extends Entity {
    public StaticEntity(int x, int y) {
        super (x, y);
    }
    public StaticEntity(Position pos) {
        super (pos);
    }

    protected int getPoints() {
        return 0;
    }
}
