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
        Dostawca DawidLos=new Dostawca("Dawid","Los",anielina);
        piekarniaABC.dodajDostawce(PiotrJez);
        piekarniaABC.dodajDostawce(MateuszGruz);
        piekarniaABC.dodajDostawce(MaciejMlot);
        piekarniaABC.dodajDostawce(DawidLos);
    //Opisy
        piekarniaABC.opisProdukty();
        piekarniaABC.opisDostawcy();
        System.out.println(MaciejMlot.opis()+" dla piekarni "+MaciejMlot.getPiekarnia().getNazwa());
        
    }
    
}
