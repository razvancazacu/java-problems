
package com.javapb.travel;

import java.util.ArrayList;
import java.util.List;

public class MatrixTravel {
    private Integer[][] matrix = {{3, 4, 5, 7, 9}, {6, 6, 3, 4, 4}, {6, 3, 3, 9, 6}, {6, 5, 3, 8, 2}};
    private List<Node> road = new ArrayList<Node>();
    private Integer sum;

    public List<Node> getRoad() {
        sum = matrix[0][0];
        Node temp = new Node();
        road.add(new Node(0, 0));
        while (temp.getX() != matrix.length - 1 && temp.getY() != matrix[matrix.length - 1].length - 1) {
            Integer sMax = Integer.MAX_VALUE;
            Node tempPosition = new Node();
            for (int i = 0; i < matrix[temp.getY()].length; i++) {
                if (matrix[temp.getX()][i] + matrix[temp.getX() + 1][i] < sMax && i != temp.getY()) {
                    sMax = matrix[temp.getX()][i] + matrix[temp.getX() + 1][i];
                    tempPosition.setX(temp.getX() + 1);
                    tempPosition.setY(i);
                }
            }
            sum += sMax;
            temp.setY(tempPosition.getY());
            temp.setX(tempPosition.getX());
            road.add(new Node(temp.getX() - 1, temp.getY()));
            road.add(new Node(temp.getX(), temp.getY()));
        }
        road.add(new Node(temp.getX(),matrix[matrix.length - 1].length - 1));
        sum += matrix[temp.getX()][matrix[matrix.length - 1].length - 1];
        System.out.println(sum);
        return road;
    }
}
