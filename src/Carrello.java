import java.util.*;

public class Carrello {
    LinkedList<Prodotto> prodotti;

    public Carrello() {
        prodotti = new LinkedList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add((Prodotto) prodotto.clone());
    }

    public void eliminaProdotto(int codice) {
        Iterator<Prodotto> i = prodotti.iterator();
        Prodotto prodotto;

        while (i.hasNext()) {
            prodotto = i.next();
            if (prodotto.getCodice() == codice) {
                i.remove();
            }
        }
    }

    public Prodotto[] elencaProdotti() {
        Prodotto[] tmp = prodotti.toArray(new Prodotto[0]);
        return tmp;
    }

    public double calcolaImporto() {
        Iterator<Prodotto> i = prodotti.iterator();
        double totale = 0.0;
        Prodotto prodotto;

        while (i.hasNext()) {
            prodotto = i.next();
            totale += prodotto.getPrezzo() * prodotto.getQuantita();
        }

        return totale;
    }
}
