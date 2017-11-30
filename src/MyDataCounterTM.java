import java.util.Iterator;
import java.util.TreeMap;

public class MyDataCounterTM<E extends Comparable<E>> implements DataCounter<E> {
    //AF: f: E -> Integer tale che 0 <= i < this.getSize() => f(tm.keySet().toArray[i] = this.getCount(tm.keySet().toArray[i]);
    //IR: tm != null && tm.size == this.getSize() &&
    // forall i. 0 <= i < this.getSize() => tm.keySet().toArray[i] != null      &&
    //                                      tm.entrySet().toArray[i] > 0        &&
    //                                      tm.entrySet().toArray[i] != null    &&
    //forall i,j. 0 <= i,j < this.getSize() => tm.keySet().toArray[i] != tm.keySet().toArray[j];


    private TreeMap<E, Integer> tm;


    public MyDataCounterTM(){
        tm = new TreeMap<>();
    }

    public void incCount(E data) throws NullPointerException {
        if(data == null)
            throw new NullPointerException();

        if(tm.containsKey(data))
            tm.replace(data,tm.get(data)+1);
        else
            tm.put(data,1);
    }


    public int getSize() {
        return tm.size();
    }


    public int getCount(E data) throws NullPointerException {

        if(data == null)
            throw new NullPointerException();

        if(tm.containsKey(data))
            return tm.get(data);
        else
            return 0;
    }

    public Iterator<E> getIterator() throws UnsupportedOperationException {

        Iterator<E> myit = new MyIterator<E>(tm);
        return myit;
    }
}
