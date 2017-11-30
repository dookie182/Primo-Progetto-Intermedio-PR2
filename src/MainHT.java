import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainHT {

    public static void main(String[] args){
        DataCounter<String> tabht = new MyDataCounterHT<>();
        FileReader fr;                                      //Dichiaro un file reader per leggere un input da file;
        String testo = new String();                        //Dichiaro la stringa testo che conterrà tutto il testo inserito;
        String percorso;                                    //Dichiaro la stringa del percorso del file da leggere;
        int counter = 1;                                    //Contatore per stampare a schermo le chiavi;
        int words = 0;                                      //Contatore del numero di parole totali inserite;

        System.out.println("Inserire il percorso del file da analizzare");

        Scanner sr = new Scanner(System.in);                //Richiedo da tastiera il percorso del file da analizzare;
        percorso = sr.nextLine();

        try {
            fr = new FileReader(percorso);
            BufferedReader br = new BufferedReader(fr);
            String input;

            while((input = br.readLine())!=null) {
                testo += input;                             //Concateno le stringhe che leggo con quelle già lette;

                //Elimino la punteggiatura e trasformo la stringa input in caratteri minuscoli. Successivamente invoco il metodo
                //split che inserisce tutte le parole separate da uno spazio in un array di stringhe;
                String[] arrInput = input.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
                for (String str : arrInput) {
                    tabht.incCount(str);                    //Aggiungo le nuove parole alla tabella hash e incremento
                                                            //le occorrenze delle parole già inserite;
                    words += 1;                             //words = numero parole totali inserite;
                }
            }
            //Creo un iteratore ordinato rispetto alle occorrenze delle chiavi nella HashTable;
            Iterator<String> i = tabht.getIterator();

            //Stampo a schermo il numero di caratteri conteggiando anche gli spazi;
            System.out.println("Numero caratteri con spazi:"+ testo.length());

            //Sostituisco tutti gli spazi con stringa vuota;
            testo = testo.replaceAll(" ", "");

            //Stampo a schermo il numero di caratteri senza conteggiare gli spazi;
            System.out.println("Numero caratteri senza spazi:"+ testo.length());

            //Stampo a schermo il numero di parole totali inserite;
            System.out.println("Numero parole:"+ words);

            //Stampo a schermo una tabella contenente tutte le chiavi e le relative occorrenze;
            while(i.hasNext()){
                String e = i.next();
                System.out.println(counter + ". "+ e + " " + tabht.getCount(e) );
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
