package zad1_l13;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class Trojkat extends Figura{
    public Trojkat(){
        super();
    }
    @Override
    public String informacja(){
        return "Trojkat rownoboczny o boku dlugosci "+getDlugosc()+"cm, pole wynosi "+round(pole()*100.0)/100.0+" cm2.";
    }
    @Override
    public double pole(){
        return ((getDlugosc()*getDlugosc()*sqrt(3))/4);
    }
}
