package zad2;

import java.util.ArrayList;
import java.util.List;

public class Piekarnia {
    private String nazwa;
    private List<Produkt> lista_produktow= new ArrayList<Produkt>();
    private List<Dostawca> lista_dostawcow= new ArrayList<Dostawca>();
    
    public Piekarnia(String nazwa){
        this.nazwa=nazwa;
    }
    public String getNazwa(){
        return nazwa;
    }
    //Obsluga produktow
    public void dodajProdukt(Produkt produkt){
        lista_produktow.add(produkt);
    }
    public void usunProduktIndex(int index){
        lista_produktow.remove(index);
    }
    public Produkt zwrocProduktIndex(int index){
        return lista_produktow.get(index);
    }
    public int iloscProduktow(){
        return lista_produktow.size();
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
    public void dodajDostawce(Dostawca dostawca){
        lista_dostawcow.add(dostawca);
        lista_dostawcow.get(lista_dostawcow.size()-1).setPiekarnia(this);
    }
    public void usunDostawcaIndex(int index){
        lista_dostawcow.remove(index);
    }
    public Dostawca zwrocDostawcaIndex(int index){
        return lista_dostawcow.get(index);
    }
    public Dostawca zwrocDostawcaObszar(Obszar obszar){
        Dostawca szukany_dostawca=null;
        for(Dostawca dostawca: lista_dostawcow){
            if(dostawca.getObszar()==obszar)  szukany_dostawca=dostawca;
        }
        return szukany_dostawca;
    }
    public void opisDostawcy(){
        System.out.println(opis()+" Lista dostawcow: ");
        for(Dostawca dostawca: lista_dostawcow){
            System.out.println(dostawca.opis());
        }
    }
}
