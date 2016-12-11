import javax.swing.*;
import java.awt.*;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 */
public class GridFrameLayout {
    public static void main(String[] args) {
        createGUI();
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //��������� ������� ������ ��� �������� ����
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new Button("1"));
        panel.add(new Button("2"));
        panel.add(new Button("3"));
        panel.add(new Button("4"));
        panel.add(new Button("5"));
        panel.add(new Button("6"));

        //������ �� �����
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension (550, 300));
        frame.pack(); //������������� ��������� � ������� ����
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
