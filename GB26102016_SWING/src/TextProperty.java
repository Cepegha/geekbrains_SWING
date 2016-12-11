import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 * <p>
 * Оконное приложение JFrame с использованием радиобаттонов, чекбоксов, всплывающего списка
 * <p>
 * *** Настройка обычного текста ***
 */
public class TextProperty extends JFrame {
    JButton b;
    JRadioButton rb1, rb2, rb3;
    JCheckBox cb1, cb2, cb3;
    JComboBox box;
    JLabel l;
    int size = 12;
    String stylename;
    int style;

    TextProperty() {
        super("Текст - настройки");
        setSize(350, 300);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        String[] s = {"Черный", "Синий", "Розовый", "Красный"};
        box = new JComboBox(s);

        l = new JLabel("Самый обычный текст");
        l.setFont(new Font("italica", Font.PLAIN, size));
        l.setSize(20, 50);

        cb1 = new JCheckBox("Курсив");
        cb2 = new JCheckBox("Жирный");
        cb3 = new JCheckBox("Курсив+Жирный");

        rb1 = new JRadioButton("15");
        rb2 = new JRadioButton("20");
        rb3 = new JRadioButton("25");

        ButtonGroup g = new ButtonGroup();
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);

        c.add(l);
        c.add(box);
        c.add(cb1);
        c.add(cb2);
        c.add(cb3);
        c.add(rb1);
        c.add(rb2);
        c.add(rb3);

        Listen lis = new Listen();
        box.addItemListener(lis);
        cb1.addItemListener(lis);
        cb2.addItemListener(lis);
        cb3.addItemListener(lis);
        rb1.addItemListener(lis);
        rb2.addItemListener(lis);
        rb3.addItemListener(lis);

    }

    public class Listen implements Propertys {
        @Override
        public void style(JCheckBox c) {
            if (c.getText()=="Курсив"){
                if (c.isSelected()){
                    l.setFont(new Font ("italica", Font.ITALIC, size));
                    style = Font.ITALIC;
                }
                else {
                    l.setFont(new Font ("italica", Font.PLAIN, size));
                    style = Font.PLAIN;
                }
            }
            if (c.getText()=="Жирный"){
                if (c.isSelected()){
                    l.setFont(new Font ("bold", Font.BOLD, size));
                    style = Font.BOLD;
                }
                else {
                    l.setFont(new Font ("bold", Font.PLAIN, size));
                    style = Font.PLAIN;
                }
            }

            if (c.getText()=="Курсив+Жирный"){
                if (c.isSelected()){
                    l.setFont(new Font ("bold+italica", 3, size));
                    style = 3;
                }
                else {
                    l.setFont(new Font ("bold+italica", Font.PLAIN, size));
                    style = Font.PLAIN;
                }
            }


        }

        @Override
        public void size(JRadioButton b) {
            if (b.getText()=="15"){
                if (b.isSelected()){
                    l.setFont(new Font (stylename, style, 15));
                    size = 15;
                }
                else {
                    l.setFont(new Font (stylename, style, size));
                }
            }
            if (b.getText()=="20"){
                if (b.isSelected()){
                    l.setFont(new Font (stylename, style, 20));
                    size = 20;
                }
                else {
                    l.setFont(new Font (stylename, style, size));
                }
            }
            if (b.getText()=="25"){
                if (b.isSelected()){
                    l.setFont(new Font (stylename, style, 25));
                    size = 25;
                }
                else {
                    l.setFont(new Font (stylename, style, size));
                }
            }
        }

        @Override
        public void color(JComboBox box) {
            int index = box.getSelectedIndex();
            if (index==0){
                l.setForeground(Color.BLACK);
            }
            if (index==1){
                l.setForeground(Color.BLUE);
            }
            if (index==2){
                l.setForeground(Color.MAGENTA);
            }
            if (index==3){
                l.setForeground(Color.RED);
            }

        }

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (e.getSource()==cb1){
                style(cb1);
            }
            if (e.getSource()==cb2){
                style(cb2);
            }
            if (e.getSource()==cb3){
                style(cb3);
            }
            if (e.getSource()==rb1){
                size(rb1);
            }
            if (e.getSource()==rb2){
                size(rb2);
            }
            if (e.getSource()==rb3){
                size(rb3);
            }
            if (e.getSource()==box){
                color(box);
            }
        }
    }



    public static void main(String[] args) {
        TextProperty textProperty = new TextProperty();
        textProperty.setVisible(true);
    }
}
