package s03;

public class Ex1 {
    /*
    *  Consulte l'élément à qui se trouve après l'arc numéro i.
    *  L'itreateur se déplace à la position i et sort l'élèment à i+1
    *
    */
    static int g(List l, int i) {
        ListItr li = new ListItr(l); //creat a list IT
        for(int k=0; k<i; k++)
            li.goToNext();
        return li.consultAfter();
    }
    /*
    *
    * L'itérateur se déplace et controle si chaque élément == e. Si c'est le cas il va retourné "true".
    *
    */
    static boolean f(List l, int e) {
        ListItr li = new ListItr(l); //creat a list IT
        while(!li.isLast()) {
            // return des que e == l élèment après l'arc courrant
            if (li.consultAfter()==e) return true;
            li.goToNext();
        }
        return false;
    }
}
