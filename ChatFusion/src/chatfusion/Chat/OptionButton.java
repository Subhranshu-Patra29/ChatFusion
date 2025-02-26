
package chatfusion.Chat;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;


public class OptionButton extends JButton {
    
    public OptionButton()
    {
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isSelected())
            g.setColor(new Color(62,91,244));
            g.fillRect(0, getHeight() - 2, getWidth(), getHeight());
    }
}
