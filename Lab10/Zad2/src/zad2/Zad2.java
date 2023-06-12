package zad2;

public class Zad2 {
    public static void main(String[] args) {
    //Dodawanie piekarni
        Piekarnia piekarniaABC=new Piekarnia("ABC");
    //Dodawanie produktow
        Produkt chleb=new Produkt("chleb",5);
        Produkt bulka=new Produkt("bulka",2.99);
        Produkt bagieta=new Produkt("bagieta",4.2);
        piekarniaABC.dodajProdukt(chleb);
        piekarniaABC.dodajProdukt(bulka);
        piekarniaABC.dodajProdukt(bagieta);
        //piekarniaABC.usunProduktIndex(2);
    //Dodawanie obszarow miasta
        Obszar anielina=new Obszar("Anielina");
        Obszar centrum=new Obszar("Centrum");
        Obszar stojadla=new Obszar("Stojadla");
    //Dodawanie dostawcow
        Dostawca PiotrJez=new Dostawca("Piotr","Jez",centrum);
        Dostawca MaciejMlot=new Dostawca("Maciej","Mlot",stojadla);
        Dostawca MateuszGruz=new Dostawca("Mateusz","Gruz",anielina);
        piekarniaABC.dodajDostawce(PiotrJez);
        piekarniaABC.dodajDostawce(MateuszGruz);
        piekarniaABC.dodajDostawce(MaciejMlot);
    //Dodawanie sklepow
        Sklep sklepABC=new Sklep("ABC","Minsk Mazowiecki,ul. Warszawska 123",stojadla);
        Sklep sklepBiedronka=new Sklep("Biedronka","Minsk Mazowiecki,ul. Warszawska 40",centrum);
        Sklep sklepZabka=new Sklep("Zabka","Minsk Mazowiecki,ul. Wesola 99",anielina);
        Sklep sklepHaval=new Sklep("Haval","Minsk Mazowiecki,ul. Budowlana 10",centrum);
    /*Opisy
        piekarniaABC.opisProdukty();
        piekarniaABC.opisDostawcy();
        System.out.println(MaciejMlot.opis()+" dla piekarni "+MaciejMlot.getPiekarnia().getNazwa());
        System.out.println(sklepBiedronka.opis());
    */
    //Test zamowienia
        Zamowienie test=new Zamowienie(MaciejMlot,sklepABC);
        test.opisZamowienia();
        test.dodajProdukt(bagieta);
        test.dodajProdukt(bulka);
        test.opisZamowienia();
    }
    
}
