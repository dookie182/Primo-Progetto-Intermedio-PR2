import java.util.Hashtable;
import java.util.Iterator;

public class MyDataCounterHT<E extends Comparable<E>> implements DataCounter<E> {
    //AF: f: E -> Integer tale che 0 <= i < this.getSize() => f(myhash.keySet().toArray[i] = this.getCount(myhash.keySet().toArray[i]);
    //IR: myhash != null && myhash.size == this.getSize() &&
    // forall i. 0 <= i < this.getSize() => myhash.keySet().toArray[i] != null      &&
    //                                      myhash.entrySet().toArray[i] > 0;       &&
    //                                      myhash.entrySet().toArray[i] != null    &&
    //forall i,j. 0 <= i,j < this.getSize() => tm.keySet().toArray[i] != tm.keySet().toArray[j];

    private Hashtable<E,Integer> myhash;

    public MyDataCounterHT(){
        myhash = new Hashtable();
    }


    //incrementa il valore associato all’elemento data di tipo E
    public void incCount(E data) throws NullPointerException{

       if(data == null)
           throw new NullPointerException();

        if(myhash.containsKey(data))
            myhash.replace(data, myhash.get(data)+1);
        else
            myhash.put(data, 1);
    }

    // restituisce il numero degli elementi presenti nella collezione
    public int getSize(){
        return myhash.size();
    }


    //restituisce il valore corrente associato al parametro data,
    // e 0 se data non appartiene alla collezione
    public int getCount(E data) throws NullPointerException{

        if(data == null)
            throw  new NullPointerException();

        if(myhash.containsKey(data))
            return myhash.get(data);
        else
            return 0;

    }

    // restituisce un iteratore (senza remove) per la collezione
    public Iterator<E> getIterator() throws UnsupportedOperationException{

        Iterator<E> myit = new MyIterator<E>(myhash);
          return myit;

    }

}
