package zad2;

public class ZamowionyProdukt {
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
