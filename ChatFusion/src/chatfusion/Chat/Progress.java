
package chatfusion.Chat;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    private ProgressType progressType = ProgressType.NONE;
    
    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }

    public static enum ProgressType {
        NONE, DOWN_FILE, CANCEL, FILE
    }

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }
}
