import java.util.Iterator;

public interface DataCounter<E> {

    //Overview: Tipo modificabile che rappresenta un'associazione tra le chiavi e le loro occorenze;
    //Typical Element: coppia <E,Integer> che rappresenta una chiave di tipo E e la sua relativa occorrenza;

    //incrementa il valore associato all’elemento data di tipo E
    public void incCount(E data) throws NullPointerException;
    //REQUIRES: data != null;
    //MODIFIES: this;
    //THROWS: se data == null lancia una NullPointerException (eccezione unchecked, presente in Java);
    //EFFECTS: se data appartiene già alla collezione, incremento l'occorenza relativa alla chiave
    //          "data". Altrimenti inserisco l'elemento nella struttura dati con occorrenza pari a 1;

    // restituisce il numero degli elementi presenti nella collezione
    public int getSize();
    //EFFECTS: restituisce la dimensione della struttura dati utilizzata, ovvero il numero delle chiavi presenti in essa;


    //restituisce il valore corrente associato al parametro data,
    // e 0 se data non appartiene alla collezione
    public int getCount (E data)throws NullPointerException;
    //REQUIRES: data != null;
    //TROWS: se data == null lancia una NullPointerException (eccezione unchecked, presente in Java);
    //EFFECTS: se la chiave "data" appartiene alla collezione, restituisco il valore delle occorrenze
    //          associato alla chiave. Se la chiave "data" non appartiene alla collezione, restituisco 0;


    // restituisce un iteratore (senza remove) per la collezione
    public Iterator<E> getIterator() throws UnsupportedOperationException;
    //THROWS: se si tenta di utilizzare metodo remove sull'iteratore creato, lancia una UnsopportedOperationException;
    //EFFECTS: restiuisce un iteratore che non supporta il metodo remove, ordinato rispetto alle occorrenze delle chiavi
    // presenti nella struttura dati. In caso di chiavi con stesse occorrenze prevale l'ordine naturale di E;
}