import javax.swing.*;
import java.awt.event.ItemListener;

/**
 * Created by cepegha@gmail.com on 07.12.2016.
 */
public interface Propertys extends ItemListener{

    public void style(JCheckBox c);
    public void size(JRadioButton b);
    public void color(JComboBox box);

}
