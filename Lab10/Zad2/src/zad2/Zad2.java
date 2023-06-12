package zad2;

public class Zad2 {
    public static void main(String[] args) {
        //Test klasy Piekarnia
        Piekarnia piekarniaABC=new Piekarnia("ABC");
        Produkt chleb=new Produkt("chleb",5);
        Produkt bulka=new Produkt("bulka",2.99);
        Produkt bagieta=new Produkt("bagieta",4.2);
        piekarniaABC.opisProdukty();
        piekarniaABC.dodajProdukt(chleb);
        piekarniaABC.dodajProdukt(bulka);
        piekarniaABC.dodajProdukt(bagieta);
        piekarniaABC.opisProdukty();
        piekarniaABC.usunProduktIndex(2);
        piekarniaABC.opisProdukty();
    }
    
}
