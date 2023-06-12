package zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sklep implements zamowienia{
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
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            Dostawca dostawca=obszar.getPiekarnia().zwrocDostawcaObszar(obszar);
            Zamowienie zamowienie=new Zamowienie(dostawca,this);
            System.out.println("==============================");
            System.out.println("KREATOR ZAMOWIEN DLA SKLEPU "+nazwa);
            System.out.println("Dostepne produkty");
            obszar.getPiekarnia().opisProdukty();
            String wybor="123";
            while(!"0".equals(wybor)){
                System.out.println("Ktory produkt chcesz dodac(jesli koniec wpisz 0): ");
                wybor=read.readLine();
                int pomoc=0;
                for(int i=0;i<obszar.getPiekarnia().iloscProduktow();i++){
                    if(obszar.getPiekarnia().zwrocProduktIndex(i).getNazwa().equals(wybor)){
                        zamowienie.dodajProdukt(obszar.getPiekarnia().zwrocProduktIndex(i));
                        pomoc=1;
                    }
                }
                if(pomoc==0){
                        System.out.println("Nie ma takiego produktu!");
                    }else{
                        pomoc=0;
                    }
            }
            lista_zamowien.add(zamowienie);
            dostawca.dodajZamowienie(zamowienie);
            System.out.println("Utworzono zamowienie!");
            System.out.println("==============================");
        } catch (IOException ex) {
            Logger.getLogger(Sklep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void opisZamowien(){
        System.out.println("Zamowienia w "+opis());
        for(Zamowienie zamowienie: lista_zamowien){
            zamowienie.opisZamowienia();
            System.out.println("==================");
        }
    }
}
