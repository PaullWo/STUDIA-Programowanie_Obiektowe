package okienkoz3l12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Okienkoz3l12 extends JFrame {

    private final JLabel lbImie;
    private JTextField tfImie;
    private final JLabel lbNazwisko;
    private JTextField tfNazwisko;
    private final JLabel lbWzrost;
    private JTextField tfWzrost;
    private final JLabel lbWaga;
    private JTextField tfWaga;

    Okienkoz3l12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        lbImie = new JLabel("Imię:");
        add(lbImie);
        tfImie = new JTextField(10);
        add(tfImie);

        lbNazwisko = new JLabel("Nazwisko:");
        add(lbNazwisko);
        tfNazwisko = new JTextField(10);
        add(tfNazwisko);

        lbWzrost = new JLabel("Wzrost (cm):");
        add(lbWzrost);
        tfWzrost = new JTextField(10);
        add(tfWzrost);

        lbWaga = new JLabel("Waga (kg):");
        add(lbWaga);
        tfWaga = new JTextField(10);
        add(tfWaga);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPlik = new JMenu("Plik");
        menuBar.add(menuPlik);

        JMenuItem miZamknij = new JMenuItem("Zamknij");
        menuPlik.add(miZamknij);

        JMenu menuPrzeliczJednostki = new JMenu("PrzeliczJednostki");
        menuBar.add(menuPrzeliczJednostki);

        JMenuItem miPrzeliczWage = new JMenuItem("PrzeliczWage");
        menuPrzeliczJednostki.add(miPrzeliczWage);

        JMenuItem miPrzeliczWzrost = new JMenuItem("PrzeliczWzrost");
        menuPrzeliczJednostki.add(miPrzeliczWzrost);

        miPrzeliczWage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String imie = tfImie.getText();
                    String nazwisko = tfNazwisko.getText();
                    double wzrost = Double.parseDouble(tfWzrost.getText());
                    double waga = Double.parseDouble(tfWaga.getText());
                    Osoba osoba = new Osoba(imie, nazwisko, wzrost, waga);
                    //JOptionPane.showMessageDialog(null, "Waga w funtach: " + wagaFunt);
                    tfWaga.setText(Double.toString(osoba.wagaNaFunty()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Błędne dane!");
                }
            }
        });

        miPrzeliczWzrost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String imie = tfImie.getText();
                    String nazwisko = tfNazwisko.getText();
                    double wzrost = Double.parseDouble(tfWzrost.getText());
                    double waga = Double.parseDouble(tfWaga.getText());
                    Osoba osoba = new Osoba(imie, nazwisko, wzrost, waga);
                    //JOptionPane.showMessageDialog(null, "Wzrost w calach: " + wzrostCale);
                    tfWzrost.setText(Double.toString(osoba.wzrostNaCale()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Błędne dane!");
                }
            }
        });
        
        miZamknij.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String args[]) {
        JFrame f;
        f = new Okienkoz3l12();
    }
}