package zad1_l13;

public abstract class Figura {
    private int dlugosc;
    
    public Figura(){
        dlugosc=10;
    }
    public int getDlugosc(){
        return dlugosc;
    }
    public void setDlugosc(int dlugosc){
        this.dlugosc=dlugosc;
    }
    public abstract String informacja();
    public abstract double pole();
}
