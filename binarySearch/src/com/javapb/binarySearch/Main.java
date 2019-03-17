package com.javapb.binarySearch;

public class Main {
/*Se dă o secvență de numere întregi strict crescătoare, care se continuă cu o
 secvenţă de numere întregi strict descrescătoare, întregul șir având N elemente.
 Scrieți un program care determină punctul din șir înaintea căruia toate
 elementele sunt strict crescătoare, şi după care toate elementele sunt strict descrescătoare.
 Dacă șirul este strict crescător sau strict descrescător, punctul nu există. *
Exemplu: N = 10, arr[] = {2, 4, 7, 10000, 122, 83, 10, 9, 7}. Ieşire: 122
*/
    public static void main(String[] args) {
    SequenceSearch ob = new SequenceSearch();
        System.out.println(ob.getPoint(0,ob.getArrayDimension()));
    }
}
