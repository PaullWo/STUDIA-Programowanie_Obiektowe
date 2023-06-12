package zad1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class Okno extends JFrame {
    private JPanel danePanel;
    private JTextField imieField;
    private JTextField nazwiskoField;
    private JComboBox<String> miejscowoscComboBox;
    private JRadioButton studentRadio;
    private JRadioButton pracownikRadio;
    private JButton dalejButton;

    private JPanel studentPanel;
    private JTextField uczelniaField;
    private JTextField kierunekField;
    private JTextField[] ocenyFields;
    private JButton zapiszStudentButton;

    private JPanel pracownikPanel;
    private JTextField firmaField;
    private JTextField stanowiskoField;
    private JTextField poboryBruttoField;
    private JTextField[] kursyFields;
    private JButton zapiszPracownikButton;

    public Okno() {
        setTitle("Formularz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        JPanel radioPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        studentRadio = new JRadioButton("Student");
        pracownikRadio = new JRadioButton("Pracownik");
        buttonGroup.add(studentRadio);
        buttonGroup.add(pracownikRadio);
        radioPanel.add(studentRadio);
        radioPanel.add(pracownikRadio);
        add(radioPanel);

        danePanel = new JPanel(new GridLayout(4, 2));
        imieField = new JTextField();
        nazwiskoField = new JTextField();
        miejscowoscComboBox = new JComboBox<>(new String[]{"", "Minsk", "Otwock", "Karwia","Czarnowka Wielka"});
        danePanel.add(new JLabel("Imię:"));
        danePanel.add(imieField);
        danePanel.add(new JLabel("Nazwisko:"));
        danePanel.add(nazwiskoField);
        danePanel.add(new JLabel("Miejscowość:"));
        danePanel.add(miejscowoscComboBox);
        danePanel.add(new JLabel());
        danePanel.add(new JLabel());
        add(danePanel);

        studentPanel = new JPanel(new GridLayout(8, 2));
        studentPanel.setPreferredSize(new Dimension(400, 150));
        uczelniaField = new JTextField();
        kierunekField = new JTextField();
        ocenyFields = new JTextField[5];
        for (int i = 0; i < ocenyFields.length; i++){
            ocenyFields[i] = new JTextField();
            studentPanel.add(new JLabel("Ocena " + (i + 1) + ":"));
            studentPanel.add(ocenyFields[i]);
        }
        zapiszStudentButton = new JButton("Zapisz");
        studentPanel.add(new JLabel("Uczelnia:"));
        studentPanel.add(uczelniaField);
        studentPanel.add(new JLabel("Kierunek:"));
        studentPanel.add(kierunekField);
        studentPanel.add(new JLabel());
        studentPanel.add(zapiszStudentButton);

        pracownikPanel = new JPanel(new GridLayout(9, 2));
        pracownikPanel.setPreferredSize(new Dimension(400, 150));
        firmaField = new JTextField();
        stanowiskoField = new JTextField();
        poboryBruttoField = new JTextField();
        kursyFields = new JTextField[5];
        for (int i = 0; i < kursyFields.length; i++){
            kursyFields[i] = new JTextField();
            pracownikPanel.add(new JLabel("Kurs " + (i + 1) + ":"));
            pracownikPanel.add(kursyFields[i]);
        }
        zapiszPracownikButton = new JButton("Zapisz");
        pracownikPanel.add(new JLabel("Firma:"));
        pracownikPanel.add(firmaField);
        pracownikPanel.add(new JLabel("Stanowisko:"));
        pracownikPanel.add(stanowiskoField);
        pracownikPanel.add(new JLabel("Pobory brutto:"));
        pracownikPanel.add(poboryBruttoField);
        pracownikPanel.add(new JLabel());
        pracownikPanel.add(zapiszPracownikButton);

        dalejButton = new JButton("Dalej");
        add(dalejButton);

        dalejButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(studentRadio.isSelected()) {
                    remove(danePanel);
                    remove(dalejButton);
                    add(studentPanel);
                }else if (pracownikRadio.isSelected()){
                    remove(danePanel);
                    remove(dalejButton);
                    add(pracownikPanel);
                }
                pack();
            }
        });

        zapiszStudentButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String imie = imieField.getText();
                String nazwisko = nazwiskoField.getText();
                String miejscowosc = (String) miejscowoscComboBox.getSelectedItem();
                String uczelnia = uczelniaField.getText();
                String kierunek = kierunekField.getText();
                List<Double> oceny=new ArrayList<Double>();
                for (int i = 0; i < ocenyFields.length; i++) {
                    String ocenaStr = ocenyFields[i].getText();
                    if (!ocenaStr.isEmpty()) {
                        oceny.add(Double.parseDouble(ocenaStr));
                    }
                }
                Student student = new Student(imie, nazwisko, miejscowosc, uczelnia, kierunek, oceny);
                //Wyswietlenie w oknie dialogowym
                JOptionPane.showMessageDialog(Okno.this, student.info() + ", średnia ocen: " + student.oblicz(), "Student", JOptionPane.INFORMATION_MESSAGE);
                //Zapis do pliku
                try {
                    PrintWriter zapis_student;
                    zapis_student = new PrintWriter("student.txt");
                    zapis_student.println(student.info() + ", średnia ocen: " + student.oblicz());
                    zapis_student.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        zapiszPracownikButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String imie = imieField.getText();
                String nazwisko = nazwiskoField.getText();
                String miejscowosc = (String)miejscowoscComboBox.getSelectedItem();
                String firma = firmaField.getText();
                String stanowisko = stanowiskoField.getText();
                double poboryBrutto = Double.parseDouble(poboryBruttoField.getText());
                List<String> kursy=new ArrayList<String>();
                for (int i = 0; i < kursyFields.length; i++) {
                    if (!kursyFields[i].getText().isEmpty())
                        kursy.add(kursyFields[i].getText());
                }
                Pracownik pracownik = new Pracownik(imie, nazwisko, miejscowosc, firma, stanowisko, poboryBrutto, kursy);
                //Wyswietlenie w oknie dialogowym
                JOptionPane.showMessageDialog(Okno.this, pracownik.info() + " wypłata: " + pracownik.oblicz()+"zl.", "Pracownik", JOptionPane.INFORMATION_MESSAGE);
                //Zapis do pliku
                try {
                    PrintWriter zapis_pracownik;
                    zapis_pracownik = new PrintWriter("pracownik.txt");
                    zapis_pracownik.println(pracownik.info() + " wypłata: " + pracownik.oblicz()+"zl.");
                    zapis_pracownik.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setSize(300, 300);
    }
}
