package zad2;

import java.util.ArrayList;
import java.util.List;

public class Piekarnia {
    private String nazwa;
    private List<Produkt> lista_produktow= new ArrayList<Produkt>();
    //private List<Dostawca> lista_dostawcow= new ArrayList<Dostawca>();
    public Piekarnia(String nazwa){
        this.nazwa=nazwa;
    }
    public String getNazwa(){
        return nazwa;
    }
    public void dodajProdukt(Produkt produkt){
        lista_produktow.add(produkt);
    }
    public void usunProduktIndex(int index){
        lista_produktow.remove(index);
    }
    public Produkt zwrocProduktIndex(int index){
        return lista_produktow.get(index);
    }
    public void opisProdukty(){
        System.out.println(opis()+" Lista produktow: ");
        for(Produkt produkt: lista_produktow){
            System.out.println(produkt.getNazwa());
        }
    }
    public String opis(){
        return "Piekarnia "+nazwa+".";
    }
    //Obsluga dostawcow
}
