
package chatfusion.Chat.Forms;

import chatfusion.Chat.ModernScrollBarUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar{
    
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5,5));
        setUnitIncrement(20);
        setBackground(new Color(165,165,255));
    }
}
