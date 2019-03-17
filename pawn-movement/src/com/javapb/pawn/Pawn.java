package com.javapb.pawn;

public class Pawn {
    private Integer positionX;
    private Integer positionY;

    public Pawn() {
        this.positionX = -1;
        this.positionY = -1;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }
}
