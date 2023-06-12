package zad1;

import java.util.ArrayList;
import java.util.List;

class Pracownik extends Osoba {
    private String firma;
    private String stanowisko;
    private double pobory_brutto;
    private List<String> ukonczone_kursy=new ArrayList<String>();

    public Pracownik(String imie, String nazwisko, String miejscowosc, String firma, String stanowisko, double pobory_brutto, List<String> ukonczone_kursy) {
        super(imie, nazwisko, miejscowosc);
        this.firma = firma;
        this.stanowisko = stanowisko;
        this.pobory_brutto = pobory_brutto;
        this.ukonczone_kursy = ukonczone_kursy;
    }
    public String info() {
        return "Pracownik na stanowisku " + stanowisko + ", firma: " + firma+", ukonczyl kursy "+kursyInfo();
    }
    public String kursyInfo(){
        String napis="";
        for (String kurs : ukonczone_kursy) {
            napis =napis+kurs+",";
        }
        return napis;
    }
    public double oblicz() {
        return (Math.round((pobory_brutto * 0.81)*100.0)/100.0);
    }
}