package zad1_l13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame{
    private final JPanel panel;
    private final JLabel label_text;
    private final JLabel label_kolor;
    private JRadioButton radio_czerwony;
    private JRadioButton radio_zielony;
    private JRadioButton radio_niebieski;
    private final JLabel label_dlugosc;
    private JSlider slider_dlugosc;
    private final JButton button_czysc;
    private final JButton button_rysuj;
    
    public Okno(){
        getContentPane().setBackground(new Color(141, 167, 142));
        setSize(500, 540);
        setLayout(new FlowLayout());
        label_text = new JLabel("Program rysujący figury.");
        add(label_text);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(450, 450));
        add(panel);
        //Powinno sie jeszcze dodac do grupy radiobuttonow
        label_kolor = new JLabel("Wybierz kolor:");
        panel.add(label_kolor);
        radio_czerwony=new JRadioButton("Czerwony");
        panel.add(radio_czerwony);
        radio_zielony=new JRadioButton("Zielony");
        panel.add(radio_zielony);
        radio_niebieski=new JRadioButton("Niebieski");
        panel.add(radio_niebieski);
        label_dlugosc = new JLabel("Wybierz dlugosc boku/promienia:");
        panel.add(label_dlugosc);
        slider_dlugosc=new JSlider(JSlider.HORIZONTAL,10,100,10);
        slider_dlugosc.setMajorTickSpacing(10);
        slider_dlugosc.setPaintTicks(true);
        slider_dlugosc.setPaintLabels(true);
        panel.add(slider_dlugosc);
        button_czysc = new JButton("Czyść");
        panel.add(button_czysc);
        button_rysuj = new JButton("Rysuj");
        panel.add(button_rysuj);
        button_czysc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        button_rysuj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Figura figura = null;
               Graphics g = panel.getGraphics();
               int dlugosc=slider_dlugosc.getValue();
               if(radio_czerwony.isSelected()){
                   figura=new Trojkat();
                   figura.setDlugosc(dlugosc);
                   g.setColor(Color.red);
                   g.drawString(figura.informacja(),40,380);
                   int tabX[]={150,150+figura.getDlugosc(),150+figura.getDlugosc()/2};
                   int tabY[]={200+figura.getDlugosc(),200+figura.getDlugosc(),200};
                   int n = tabX.length;
                   g.fillPolygon( tabX, tabY, n );
               }else if(radio_zielony.isSelected()){
                   figura=new Kwadrat();
                   figura.setDlugosc(dlugosc);
                   g.setColor(Color.green);
                   g.fillRect(170,200,figura.getDlugosc(),figura.getDlugosc());
                   g.drawString(figura.informacja(),60,380);
               }else if(radio_niebieski.isSelected()){
                   figura=new Kolo();
                   figura.setDlugosc(dlugosc);
                   g.setColor(Color.blue);
                   g.fillOval(170, 200, figura.getDlugosc(), figura.getDlugosc());
                   g.drawString(figura.informacja(),60,380);
               }
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
