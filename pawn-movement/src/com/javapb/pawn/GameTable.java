package com.javapb.pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameTable {
    private static Integer[][] table;
    private static Pawn pawn;
    private static Integer dimension;
    private static GameTable ourInstance = new GameTable();

    public static GameTable getInstance() {
        return ourInstance;
    }

    private GameTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("number of lines and columns:");
        dimension = scanner.nextInt();
        table = new Integer[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        pawn = new Pawn();
    }

    public List<Integer> getRoad() {
        Integer val = 0;
        Integer valMax = -1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < dimension; i++) {
            pawn.setPositionX(0);
            pawn.setPositionY(i);
            List<Integer> tempList = new ArrayList<Integer>();
            while (pawn.getPositionX() != dimension - 1) {
                if (checkRange(pawn.getPositionX() + 1, pawn.getPositionY() - 1) && table[pawn.getPositionX() + 1][pawn.getPositionY() - 1] == 1) {
                    pawn.setPositionX(pawn.getPositionX() + 1);
                    pawn.setPositionY(pawn.getPositionY() - 1);
                    tempList.add(pawn.getPositionX());
                    val++;
                } else if (checkRange(pawn.getPositionX() + 1, pawn.getPositionY() + 1) && table[pawn.getPositionX() + 1][pawn.getPositionY() + 1] == 1) {
                    pawn.setPositionX(pawn.getPositionX() + 1);
                    pawn.setPositionY(pawn.getPositionY() + 1);
                    val++;
                } else if (checkRange(pawn.getPositionX() + 1, pawn.getPositionY()) && table[pawn.getPositionX() + 1][pawn.getPositionY()] == 0) {
                    pawn.setPositionX(pawn.getPositionX());
                    pawn.setPositionY(pawn.getPositionY());
                } else {
                    break;
                }
                tempList.add(pawn.getPositionX());
                tempList.add(pawn.getPositionY());
            }
            if (val > valMax) {
                valMax = val;
                list = tempList;
            }
            val = 0;
        }
        System.out.println("This road captured " + valMax + " pieces " );
        return list;
    }

    public boolean checkRange(Integer x, Integer y) {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension)
            return false;
        return true;
    }
}
