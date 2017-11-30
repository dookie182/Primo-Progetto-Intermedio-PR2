import java.util.*;

public class MyIterator<E extends Comparable<E>> implements Iterator<E>{

    //Iteratore che non supporta il metodo remove;

    private Iterator<E> myit;

    //Costruttore iteratore ordinato rispetto alle occorrenze delle chiavi della HashTable;
    public MyIterator(Hashtable<E,Integer> mytab){

        Set<E> myset = mytab.keySet();
        List<E> tmp = new ArrayList<>();
        tmp.addAll(myset);
        tmp.sort(new Comparator<E>() {

            public int compare(E o1, E o2) {
                if(mytab.get(o1) < mytab.get(o2))
                    return 1;
                if(mytab.get(o1) > mytab.get(o2))
                    return -1;

                return o1.compareTo(o2);
            }
        });

        myit = tmp.iterator();

    }

    //Costruttore iteratore ordinato rispetto alle occorrenze delle chiavi della TreeMap;
    public MyIterator(TreeMap<E,Integer> mytab) {

        Set<E> myset = mytab.keySet();
        List<E> tmp = new ArrayList<>();
        tmp.addAll(myset);
        tmp.sort(new Comparator<E>() {

            public int compare(E o1, E o2) {
                if(mytab.get(o1) < mytab.get(o2))
                    return 1;
                if(mytab.get(o1) > mytab.get(o2))
                    return -1;
                return o1.compareTo(o2);
            }
        });

        myit = tmp.iterator();

    }


    public boolean hasNext() {
        return myit.hasNext();
    }


    public E next() {
        return myit.next();
    }

    public void remove()throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

}
