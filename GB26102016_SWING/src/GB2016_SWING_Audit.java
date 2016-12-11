import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 */
public class GB2016_SWING_Audit extends JFrame {

    JTextField[] field = new JTextField[5];
    JButton jButton;
    JLabel[] label = new JLabel[5];
    int correct_ans = 0;
    int res[] = new int[5];

    GB2016_SWING_Audit() {
        //создание окна
        super("Аудит таблицы умножения");
        this.setSize(170, 500);
        this.setLocationRelativeTo(null); //окно в центре экрана
        Container c = getContentPane(); //получаем доступ к панели
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30)); // ФлоуЛайоут менеджер размещения - отвечает за расположение, 20/30 - столбцы
        Random r = new Random();
        int[] temp1 = new int[5];
        int[] temp2 = new int[5];
        int[] res = new int[5];

        for (int i = 0; i < 5; i++) {
            temp1[i] = r.nextInt(10) + 1;
            temp2[i] = r.nextInt(10) + 1;
            this.res[i] = temp1[i] * temp2[i];//обязательно this
            label[i] = new JLabel(String.valueOf(temp1[i]) + " * " + String.valueOf(temp2[i]));
            field[i] = new JTextField(5);
            jButton = new JButton("OK");

            c.add(label[i]);
            c.add(field[i]);
        }
        c.add(jButton);
        this.setVisible(true);
        //ловим события кнопки слушателем
        Handler fh = new Handler();
        jButton.addActionListener(fh);
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int res_user[] = new int[5];
            if (e.getSource() == jButton) {
                for (int i = 0; i < 5; i++) {
                    res_user[i] = Integer.parseInt(field[i].getText());
                    if (res_user[i] == res[i])
                        correct_ans++;
                }
            switch (correct_ans){
                case 5:
                    JOptionPane.showMessageDialog(null, "Оценка 5");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Оценка 4");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Оценка 3");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Неудовлетворительно");
                    break;
            }
            }
        }
    }

    public static void main(String[] args) {
        new GB2016_SWING_Audit();

    }
}