
package com.javapb.travel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    * Se consideră o matrice dreptunghiulară cu m linii și n coloane, cu valori naturale.
    * Traversăm matricea pornind de la colțul stânga-sus la colțul dreapta-jos.
    * O traversare constă în mai multe deplasări. La fiecare deplasare se execută un salt pe orizontală și un pas pe verticală.
    * Un salt înseamnă că putem trece de la o celulă la oricare altă celulă aflată pe aceeași linie,
    * iar un pas înseamnă că putem trece de la o celulă la celula aflată imediat sub ea.
    * Excepție face ultima deplasare (cea în care ne aflăm pe ultima linie), când vom face doar un salt pentru a ajunge în colțul dreapta-jos,
    * dar nu vom mai face și pasul corespunzător. Astfel traversarea constă în vizitarea a 2m celule.
    * Scrieți un program care să determine suma minimă care se poate obține pentru o astfel de traversare. *
    Exemplu: 4 5, [3 4 5 7 9; 6 6 3 4 4; 6 3 3 9 6; 6 5 3 8 2] Output: 28. Drumul este: (1,1) -> (1,3) -> (2,3) -> (2,2) -> (3,2) -> (3,3) -> (4,3) -> (4,5)
    * */
    public static void main(String[] args) {
        MatrixTravel matrixTravel = new MatrixTravel();
        List<Node> road = new ArrayList<Node>();
        road = matrixTravel.getRoad();
        for (int i = 0; i < road.size(); i++) {
            System.out.println((road.get(i).getX() + 1) + " " + (road.get(i).getY() + 1));
        }
    }
}
