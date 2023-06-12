package zad2;

import java.io.Serializable;

public class ZamowionyProdukt implements Serializable{
    private Produkt produkt;
    private double ilosc;
    
    public ZamowionyProdukt(Produkt produkt,double ilosc){
        this.produkt=produkt;
        this.ilosc=ilosc;
    }
    public Produkt getProdukt(){
        return produkt;
    }
    public double getIlosc(){
        return ilosc;
    }
    public String opis(){
        return produkt.opis()+", ilosc: "+ilosc;
    }
}
