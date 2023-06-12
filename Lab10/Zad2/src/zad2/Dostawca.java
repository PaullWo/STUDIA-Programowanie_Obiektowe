package zad2;

import java.util.ArrayList;
import java.util.List;

public class Dostawca {
    private String imie;
    private String nazwisko;
    private Obszar obszar;
    private Piekarnia piekarnia;
    //private List<Zamowienia> lista_zamowien=new ArrayList<Zamowienia>();
    
    public Dostawca(String imie,String nazwisko,Obszar obszar){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.obszar=obszar;
    }
    public void setPiekarnia(Piekarnia piekarnia){
        this.piekarnia=piekarnia;
    }
    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public Obszar getObszar(){
        return obszar;
    }
    public Piekarnia getPiekarnia(){
        return piekarnia;
    }
    public boolean sprawdzObszar(Obszar obszar){
        return this.obszar==obszar;
    }
    public String opis(){
        return "Dostawca "+imie+" "+nazwisko+", podlegajacy obszar: "+getObszar().getNazwa()+".";
    }
    //Obsluga zamowien
}
