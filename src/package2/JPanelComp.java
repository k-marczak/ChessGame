package package2;

import javax.swing.*;
import java.awt.*;

public class JPanelComp extends JPanel {

    int window_width = 800 , window_height = 800;
    Board board = new Board();
    Move move = new Move(board,this);

    public JPanelComp(){
        setPreferredSize(new Dimension(window_width, window_height));
        this.addMouseListener(move);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);                                     // - Taki must-have przy Swingu. Inaczej coś się rozdupi.
        board.paintComponent(g);                                     // - Rysowanie tablicy szachowej i pionów. Metoda jest stworzona w Board.
    }
}
