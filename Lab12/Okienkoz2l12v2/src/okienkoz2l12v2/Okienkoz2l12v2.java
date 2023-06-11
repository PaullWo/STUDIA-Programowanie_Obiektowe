package okienkoz2l12v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Okienkoz2l12v2 extends JFrame {

    private final JLabel lbImie;
    private JTextField tfImie;
    private final JLabel lbNazwisko;
    private JTextField tfNazwisko;
    private final JLabel lbWzrost;
    private JTextField tfWzrost;
    private final JLabel lbWaga;
    private JTextField tfWaga;
    private final JButton bPrzeliczWage;
    private final JButton bPrzeliczWzrost;
    private final JButton bClose;

    Okienkoz2l12v2() {
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

        bPrzeliczWage = new JButton("Przelicz wagę");
        add(bPrzeliczWage);

        bPrzeliczWzrost = new JButton("Przelicz wzrost");
        add(bPrzeliczWzrost);

        bClose = new JButton("Zamknij");
        add(bClose);

        bPrzeliczWage.addActionListener(new ActionListener() {
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

        bPrzeliczWzrost.addActionListener(new ActionListener() {
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

        bClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String args[]) {
        JFrame f;
        f = new Okienkoz2l12v2();
    }
}
