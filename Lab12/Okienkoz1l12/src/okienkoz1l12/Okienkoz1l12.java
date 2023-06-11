package okienkoz1l12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Okienkoz1l12 extends JFrame{

    private final JLabel lbImie;
    private JTextField tfImie;
    private final JButton bOK;
    private final JButton bClose;

    Okienkoz1l12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLayout(new FlowLayout());
        lbImie = new JLabel("Liczba:");
        add(lbImie);
        tfImie = new JTextField(10);
        add(tfImie);
        bOK = new JButton("OK");
        add(bOK);
        bClose = new JButton("Zamknij");
        add(bClose);
        
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    int liczba=Integer.parseInt(tfImie.getText());
                    JOptionPane.showMessageDialog(null, "Podana liczba to: \t" + tfImie.getText());
                }catch(NumberFormatException ex){
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
        f = new Okienkoz1l12 (); 
    }
    
}
