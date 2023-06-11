package zad1_l13;

import static java.lang.Math.round;

public class Kolo extends Figura{
    public Kolo(){
        super();
    }
    @Override
    public String informacja(){
        return "Kolo o promieniu "+getDlugosc()+"cm, pole wynosi "+round(pole()*100.0)/100.0+" cm2.";
    }
    @Override
    public double pole(){
        return (Math.PI*getDlugosc()*getDlugosc());
    }
}
