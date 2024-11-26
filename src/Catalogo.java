import java.util.*;

class TroppiProdotti extends Exception {}
class ProdottoEsistente extends Exception {}
class ProdottoInesistente extends Exception {}

public class Catalogo {
    final static int NUMERO_MASSIMO_PRODOTTI = 100000;
    HashMap<Integer, Prodotto> prodotti;

    public Catalogo() {
        prodotti = new HashMap<>(NUMERO_MASSIMO_PRODOTTI);
    }

    public void aggiungiProdotto(Prodotto prodotto) throws TroppiProdotti, ProdottoEsistente {
        if(prodotti.size() >= NUMERO_MASSIMO_PRODOTTI) throw new TroppiProdotti();
        if(prodotti.containsKey(prodotto.getCodice())) throw new ProdottoEsistente();
        prodotti.put(prodotto.getCodice(), (Prodotto) prodotto.clone());
    }

    public void eliminaProdotto(int codice) throws ProdottoInesistente {
        if(prodotti.isEmpty() || !prodotti.containsKey(codice)) throw new ProdottoInesistente();
        prodotti.remove(codice);
    }

    public void eliminaProdotto(String titolo) throws ProdottoInesistente {
        for(Prodotto prodotto : prodotti.values())
            if(prodotto.getTitolo().equals(titolo))
                eliminaProdotto(prodotto.getCodice());

        throw new ProdottoInesistente();
    }

    public Prodotto cercaProdotto(int codice) throws ProdottoInesistente {
        if(prodotti.isEmpty() || !prodotti.containsKey(codice))
            throw new ProdottoInesistente();

        return (Prodotto) prodotti.get(codice).clone();
    }

    public Prodotto cercaProdotto(String titolo) throws ProdottoInesistente {
        for(Prodotto prodotto : prodotti.values())
            if(prodotto.getTitolo().equals(titolo))
                return (Prodotto) prodotto.clone();

        throw new ProdottoInesistente();
    }

    public Prodotto[] elencaProdotti() {
        Prodotto[] tmp = prodotti.values().toArray(new Prodotto[0]);
        return tmp;
    }
}
