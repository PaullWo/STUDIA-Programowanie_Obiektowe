package zad2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        anielina.setPiekarnia(piekarniaABC);
        centrum.setPiekarnia(piekarniaABC);
        stojadla.setPiekarnia(piekarniaABC);
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
    //Tworzenie zamowien
        sklepABC.utworzZamowienie();
        sklepBiedronka.utworzZamowienie();
        sklepHaval.utworzZamowienie();
    //Plik obiektow
        //Zapis do pliku
        try{
        System.out.println("===========================");
        System.out.println("Odczyt i zapis do pliku: ");
        ObjectOutputStream plik= new ObjectOutputStream(new FileOutputStream("plik.ser"));
        plik.writeObject(sklepHaval);
        plik.close();
        //Odczyt z pliku
        ObjectInputStream plik2= new ObjectInputStream( new FileInputStream("plik.ser"));
        Sklep sklepHaval2=(Sklep)plik2.readObject();
        sklepHaval2.opisZamowien();
        plik2.close();
        }catch(IOException e){
            System.out.println("Błąd pliku!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zad2.class.getName()).log(Level.SEVERE, null, ex);
        }
    //Opis zamowien
        sklepABC.opisZamowien();
        MaciejMlot.opisZamowien();
        PiotrJez.opisZamowien();
    }
    
}
