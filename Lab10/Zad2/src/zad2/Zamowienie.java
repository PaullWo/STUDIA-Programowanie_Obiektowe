package zad2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zamowienie implements Serializable{
    private Dostawca dostawca;
    private Sklep sklep;
    private double koszt;
    private List<ZamowionyProdukt>lista_produktow=new ArrayList<ZamowionyProdukt>();
    
    public Zamowienie(Dostawca dostawca,Sklep sklep){
        this.dostawca=dostawca;
        this.sklep=sklep;
        koszt=0;
    }
    public Dostawca getDostawca(){
        return dostawca;
    }
    public Sklep getSklep(){
        return sklep;
    }
    public void dodajProdukt(Produkt produkt){
        Scanner scan = new Scanner(System.in);
        System.out.println("=====================" );
        System.out.println("DODAWANIE PRODUKTU");
        System.out.println("Podaj ilosc "+produkt.getNazwa()+": ");
        double ilosc = scan.nextDouble();
        System.out.println("=====================" );
        ZamowionyProdukt zamowiony_produkt=new ZamowionyProdukt(produkt,ilosc);
        lista_produktow.add(zamowiony_produkt);
        double cena=(zamowiony_produkt.getProdukt().getCena())*(zamowiony_produkt.getIlosc());
        koszt=koszt+cena;
    }
    public void usunProduktIndex(int index){
        lista_produktow.remove(index);
    }
    public ZamowionyProdukt zwrocProduktIndex(int index){
        return lista_produktow.get(index);
    }
    public void opisProdukty(){
        System.out.println("Lista zamowionych produktow: ");
        for(ZamowionyProdukt produkt: lista_produktow){
            System.out.println(produkt.getProdukt().getNazwa()+", ilosc: "+ produkt.getIlosc());
        }
    }
    public double getKoszt(){
        return (Math.round(koszt*100.0)/100.0);
    }
    public void opisZamowienia(){
        System.out.println("Zamowienia dla sklepu "+sklep.opis());
        System.out.println(dostawca.opis());
        opisProdukty();
        System.out.println("Laczny koszt = "+koszt+" zl.");
    }

}
