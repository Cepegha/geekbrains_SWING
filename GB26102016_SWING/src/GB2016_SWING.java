import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 * <p>
 * ****Произведение 2 целых чисел****
 * <p>
 * 2 основных пакета граф.интерфейсов GUI
 * <p>
 * AWT - Abstarct Windiws Toolkit
 * <p>
 * SWING - более кросс-платформенный, содержит компонеты как кнопки, поля ввода, таблицы...
 * <p>
 * JFrame - Container/контейнер для группировки графических компонентов (есть еще JWindiws, IApplet), который содержит ряд методов для настройки интерфейса
 * Container c = getContentPanel();
 * c.add (Component comp), c.remove (Component comp)
 * JLable - самый популярный компонент
 * JTextField - текстовое поле
 * <p>
 * Handler - слушатель событий присваиваем кнопке
 * ловим нажание кнопки ActionListener
 * actionPerformed - имплементированный метод исполняет действие по клику
 *
 * FlowLayout - отвечает за размещение слева направо, после заполненпия переход на новую строку
 */
public class GB2016_SWING extends JFrame {
    JLabel jLabel1 = new JLabel("Введите длину прямоугольника");
    ;
    JLabel jLabel2 = new JLabel("Введите ширину прямоугольника");
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField(10);
    ;
    JTextField jTextField2 = new JTextField(10);
    ;
    JButton jButton;


    GB2016_SWING() {
        //создание окна
        super("Произведение 2 чисел");
        this.setSize(300, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null); //окно в центре экрана
        Container c = getContentPane(); //получаем доступ к панели
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30)); // ФлоуЛайоут менеджер размещения - отвечает за расположение, 20/30 - столбцы

        jButton = new JButton("OK");
        c.add(jLabel1);
        c.add(jTextField1);
        c.add(jLabel2);
        c.add(jTextField2);
        c.add(jButton);
        c.add(jLabel3);
        this.setVisible(true);
        //ловим события кнопки слушателем
        Handler fh = new Handler();
        jButton.addActionListener(fh);
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton) {
                //реализуем простейший трай, лучше конечно в отдельном методе
                try {
                    int x = Integer.parseInt(jTextField1.getText());
                    int y = Integer.parseInt(jTextField2.getText());
                    int z = x * y;
                    //выводим всплывающее окно
                    JOptionPane.showMessageDialog(null, z);
                    //результат в лейбл3
                    jLabel3.setText(String.valueOf(z));
                } catch (NumberFormatException num) {
                    jTextField1.setText("Только числа");
                    jTextField2.setText("Только числа");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GB2016_SWING();

    }
}
