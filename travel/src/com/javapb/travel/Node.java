package com.javapb.travel;

public class Node {
    private Integer x;
    private Integer y;

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Node() {
        this.x = 0;
        this.y = 0;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
