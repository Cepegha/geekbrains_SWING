import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by cepegha@gmail.com on 11.12.2016.
 */
public class KeyFrame extends JFrame {
    private JLabel label;

    public KeyFrame(){
        super("Test frame");
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);

        label = new JLabel();
        label.setFont(new Font("Calibri",Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        class Listener extends KeyAdapter{
            @Override
            public void keyReleased(KeyEvent e) {
                label.setText(e.getKeyText(e.getKeyCode()));
            }
        }

        Listener lis = new Listener();
        panel.addKeyListener(lis);

        /* 2 вариант ловить нажатия
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                label.setText(e.getKeyText(e.getKeyCode()));
            }
        });
        */
        panel.add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, 200)); //предпочтительный размер
        getContentPane().add(panel); //тоже самое что Frame.add...
    }

    public static void main(String[] args) {
        KeyFrame frame = new KeyFrame();
            frame.pack();//оптимизируем размер окна по предпочтительным размерам
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
