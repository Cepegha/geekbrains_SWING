import javax.swing.*;
import java.awt.*;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 *
 * BorderLayout - ���������� �� ����������� ����� �� ������
 *
 */
public class TestFrame {
    public static void main(String[] args) {
        createGUI();
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //��������� ������� ������ ��� �������� ����
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //���������� ����������� �� ������ �� ����������� �����
        JButton northButton = new JButton("NORTH (PAGE_START) ");
        panel.add(northButton, BorderLayout.NORTH);

        JButton southButton = new JButton("SOUTH (PAGE_END) ");
        panel.add(southButton, BorderLayout.SOUTH);

        JButton eastButton = new JButton("EAST (LINE_EAST) ");
        panel.add(eastButton, BorderLayout.EAST);

        JButton westButton = new JButton("WEST (LINE_WEST) ");
        panel.add(westButton, BorderLayout.WEST);

        JButton centerButton = new JButton("CENTER");
        panel.add(centerButton, BorderLayout.CENTER);

        //������ �� �����
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension (550, 300));
        frame.pack(); //������������� ��������� � ������� ����
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
