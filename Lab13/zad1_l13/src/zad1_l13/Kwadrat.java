package zad1_l13;

import static java.lang.Math.round;

public class Kwadrat extends Figura{
    public Kwadrat(){
        super();
    }
    @Override
    public String informacja(){
        return "Kwadrat o boku dlugosci "+getDlugosc()+"cm, pole wynosi "+round(pole()*100.0)/100.0+" cm2.";
    }
    @Override
    public double pole(){
        return getDlugosc()*getDlugosc();
    }
}
