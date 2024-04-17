package package2;

import javax.swing.*;

public class JFrameComp extends JFrame {
    JFrame window;
    public JFrameComp() {
        window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel (package2.JPanelComp) to the window. Have to be before centering the window.
        JPanelComp jPanelComp = new JPanelComp();
        window.add(jPanelComp);
        window.pack();

        // Center the window.
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
