package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Okno extends JFrame{

    private final JRadioButton radio_USD;
    private final JRadioButton radio_EURO;
    private final JPanel panel;
    private JTextField text;
    private final  JButton button_dodaj;
    private final  JButton button_rysuj;
    private final  JButton button_czysc;
    DefaultListModel<Double> lista = new DefaultListModel<>();
    public Okno() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(141, 167, 142));
        setSize(600, 600);
        setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 550));
        add(panel);
        panel.add(new JLabel("Wybierz walute:"));
        panel.add(radio_USD = new JRadioButton("USD"));
        panel.add(radio_EURO = new JRadioButton("EURO"));
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(radio_EURO);
        bg1.add(radio_USD);
        panel.add(new JLabel("Podaj kurs waluty:"));
        panel.add(text = new JTextField("",10));
        panel.add(button_dodaj=new JButton("Dodaj"));
        panel.add(button_rysuj=new JButton("Rysuj"));
        panel.add(button_czysc=new JButton("Czyść"));
        JList<Double> list = new JList<>(lista);
        panel.add(list);
        JScrollPane scrollPane = new JScrollPane(list);
        panel.add(scrollPane);
        button_czysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                lista.removeAllElements();
            }
        });
        button_dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double liczba = Double.parseDouble(text.getText());
                    lista.addElement(liczba);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Błędne dane!");
                }
            }
        });
        button_rysuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = panel.getGraphics();
                g.drawLine(50,200,50,450);
                g.drawLine(500,450,50,450);
                double suma=0;
                for(int i=0;i<lista.getSize();i++){
                    suma=suma+lista.get(i);
                }
                double srednia=suma/lista.getSize();
                if(radio_USD.isSelected())
                    g.drawString("Srednia kursu walut dla USD wynosi: "+srednia,50,480);
                if(radio_EURO.isSelected())
                    g.drawString("Srednia kursu walut dla EURO wynosi: "+srednia,50,480);
                int startx=50;
                int koniecx=500;
                int koniecy=450;
                int dlugoscx=koniecx-startx;
                int skokx=dlugoscx/lista.getSize();
                int poprzednix=50;
                double poprzedniy=koniecy-(lista.get(0)*10);
                for(int i=0;i<lista.getSize();i++){
                    int aktualnyx=poprzednix+skokx;
                    double aktualnyy=koniecy-(lista.get(i)*10);
                    g.drawLine(poprzednix, (int) poprzedniy,aktualnyx, (int) aktualnyy);
                    poprzednix=aktualnyx;
                    poprzedniy=aktualnyy;

                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
