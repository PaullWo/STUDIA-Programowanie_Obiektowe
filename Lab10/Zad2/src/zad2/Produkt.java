package zad2;

public class Produkt {
    private String nazwa;
    private double cena;
    
    public Produkt(String nazwa,double cena){
        this.nazwa=nazwa;
        this.cena=cena;
    }
    public String getNazwa(){
        return nazwa;
    }
    public double getCena(){
        return cena;
    }
    public String opis(){
        return this.nazwa+", "+cena+"zl";
    }
}