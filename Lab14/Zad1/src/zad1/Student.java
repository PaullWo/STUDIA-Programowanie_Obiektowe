package zad1;

import java.util.ArrayList;
import java.util.List;

class Student extends Osoba {
    private String uczelnia;
    private String kierunek;
    private List<Double> oceny=new ArrayList<Double>();

    public Student(String imie, String nazwisko, String miejscowosc, String uczelnia, String kierunek, List<Double> oceny){
        super(imie, nazwisko, miejscowosc);
        this.uczelnia = uczelnia;
        this.kierunek = kierunek;
        this.oceny = oceny;
    }
    public String info() {
        return "Student " + kierunek + ", uczelnia: " + uczelnia;
    }
    public double oblicz() {
        double suma = 0;
        for (double ocena : oceny) {
            suma += ocena;
        }
        return (Math.round((suma / oceny.size())*100.0)/100.0);
    }
}