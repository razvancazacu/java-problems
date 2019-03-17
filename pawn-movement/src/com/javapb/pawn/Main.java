package com.javapb.pawn;


/*
O tablă de șah se citește ca o matrice n*n în care pozițiile libere au valoarea 0,
iar cele ocupate de o piesă sunt marcate prin valoarea 1.
Scrieți un program care determină drumul pe care poate ajunge un pion de pe prima linie (cea mai de sus)
pe ultima linie (cea mai de jos) luând un număr maxim de piese.
Pe prima linie nu există piese, iar pionul poate porni din orice poziție de pe prima linie.
Poziția inițială a pionului se consideră liberă. Pionul aflat în poziția (i,j) se poate deplasa astfel:
în poziția (i+1,j) dacă e liberă; în poziția (i+1, j-1) dacă există piesă în această poziție; în poziția (i+1, j+1) dacă există piesă în această poziție. * */
/*      5
        0 0 0 0 0
        0 1 0 1 0
        0 1 1 1 1
        0 0 0 1 1
        0 1 0 1 1
*/

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameTable gameTable = GameTable.getInstance();
        List<Integer> list = gameTable.getRoad();
        for (int i = 0; i < list.size(); i = i + 2) {
            System.out.println(list.get(i) + " " + list.get(i + 1));
        }
    }
}
