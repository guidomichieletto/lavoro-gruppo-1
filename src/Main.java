public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        try{
            catalogo.aggiungiProdotto(new Libro(
                    1,
                    "La divina commedia",
                    "Test",
                    1200,
                    10.20f,
                    1,
                    "Alighieri, Dante",
                    "Test",
                    1000
                    ));

            catalogo.aggiungiProdotto(new Libro(
                    2,
                    "I promessi sposi",
                    "Test",
                    1600,
                    10.20f,
                    1,
                    "Manzoni, Alessandro",
                    "Test",
                    1000
            ));

            catalogo.aggiungiProdotto(new DVD(
                    10,
                    "Harry Potter e la camera dei segreti",
                    "Test",
                    2010,
                    10.20f,
                    1,
                    "JK Rowling",
                    "Test",
                    1.20f
            ));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Carrello carrello = new Carrello();
        try{
            carrello.aggiungiProdotto(catalogo.cercaProdotto(1));
            carrello.aggiungiProdotto(catalogo.cercaProdotto("I promessi sposi"));
            System.out.println(carrello.calcolaImporto());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for(Prodotto prodotto : carrello.elencaProdotti()) {
            System.out.println(prodotto);
        }

        try{
            catalogo.eliminaProdotto("Harry Potter e la camera dei segreti");
            carrello.eliminaProdotto(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}