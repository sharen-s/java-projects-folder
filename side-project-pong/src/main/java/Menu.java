import javax.swing.*;
import java.awt.*;

public class Menu {
    JMenu jMenu = new JMenu();
    public void setjMenu(JMenu jMenu) {
        this.jMenu = jMenu;
        jMenu.add(new PopupMenu());
    }


}
