
package chatfusion.Chat;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;


public class MenuButton extends JButton {
   
    public Icon getIconSimple() {
        return iconSimple;
    }
    public void setIconSimple(Icon iconSimple) {
        this.iconSimple = iconSimple;
    }
    
    public Icon getIconSelected() {
        return iconSelected;
    }
    public void setIconSelected(Icon iconSelected) {
        this.iconSelected = iconSelected;
    }
    
    private Icon iconSimple;
    private Icon iconSelected;
    
    public MenuButton()
    {
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        if(b)
            setIcon(iconSelected);
        else
            setIcon(iconSimple);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isSelected())
            g.setColor(new Color(62,91,244));
            g.fillRect(0, getHeight() - 3, getWidth(), getHeight());
    }
}
