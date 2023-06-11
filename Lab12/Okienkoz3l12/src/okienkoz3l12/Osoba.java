package okienkoz3l12;

public class Osoba {
    private String imie;
    private String nazwisko;
    private double wzrost;
    private double waga;

    public Osoba(String imie, String nazwisko, double wzrost, double waga) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    public double wagaNaFunty() {
        return waga * 2.20462;
    }

    public double wzrostNaCale() {
        return wzrost * 0.393701;
    }
}