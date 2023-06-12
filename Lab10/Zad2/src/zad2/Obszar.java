package zad2;

import java.io.Serializable;

public class Obszar implements Serializable{
    private String nazwa;
    private Piekarnia piekarnia;
    
    public Obszar(String nazwa){
        this.nazwa=nazwa;
    }
    public void setPiekarnia(Piekarnia piekarnia){
        this.piekarnia=piekarnia;
    }
    public String getNazwa(){
        return nazwa;
    }
    public Piekarnia getPiekarnia(){
        return piekarnia;
    }
}
