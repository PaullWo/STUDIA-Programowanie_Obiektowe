package okienkoz4l12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Okienkoz4l12 extends JFrame {
    private final JLabel lb_text;
    private final JLabel lb_dane;
    private JTextField tf_dane;
    private final JButton b_wprowadz;
    private final JButton b_zamknij;
    private final JLabel lb_los;
    
    Okienkoz4l12(){
        Random random = new Random();
        int losowa = random.nextInt(201) - 100;
        DefaultListModel<String> lista = new DefaultListModel<>();  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 204, 255));
        setSize(400, 270);
        setLayout(new FlowLayout());
        lb_text = new JLabel("Program dodający liczby do listy, większe od wylosowanej liczby.");
        add(lb_text);
        lb_dane = new JLabel("Podaj liczbę:");
        add(lb_dane);
        tf_dane = new JTextField(10);
        add(tf_dane);
        b_wprowadz = new JButton("Dodaj");
        add(b_wprowadz);
        b_zamknij = new JButton("Zamknij");
        add(b_zamknij);
        lb_los = new JLabel("Wylosowana liczba: "+losowa);
        add(lb_los);
        JList<String> list = new JList<>(lista);
        add(list);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane);
        b_wprowadz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int liczba = Integer.parseInt(tf_dane.getText());
                    if(liczba>losowa){
                       lista.addElement(tf_dane.getText());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Błędne dane!");
                }
            }
        });
        b_zamknij.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public static void main(String args[]) {
        JFrame f;
        f = new Okienkoz4l12();
    }
}