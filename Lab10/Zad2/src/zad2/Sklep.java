package zad2;

import java.util.ArrayList;
import java.util.List;

public class Sklep {
    private String nazwa;
    private String adres;
    private Obszar obszar;
    private List<Zamowienie> lista_zamowien=new ArrayList<Zamowienie>();
    
    public Sklep(String nazwa,String adres,Obszar obszar){
        this.nazwa=nazwa;
        this.adres=adres;
        this.obszar=obszar;
    }
    public String getNazwa(){
        return nazwa;
    }
    public String getAdres(){
        return adres;
    }
    public Obszar getObszar(){
        return obszar;
    }
    public boolean sprawdzObszar(Obszar obszar){
        return this.obszar==obszar;
    }
    public String opis(){
        return "Sklep "+nazwa+" w "+adres+".";
    }
    //Obsluga zamowien
    public void utworzZamowienie(){
        
    }
}
