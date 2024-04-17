package package2;

import Piony.Figure;
import Piony.Queen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Move implements MouseListener {

    int newX;
    int newY;


    public Board board;

    JPanel panel;
    public Move(Board board, JPanelComp panel){
        this.board = board;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed!");
        newX = e.getX() / 100;
        newY = e.getY() / 100;
        Figure pieceXY = board.getFigure(newX, newY);
        if(pieceXY != null){
            board.selectedFigure = pieceXY;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released!");
        newX = e.getX() / 100;
        newY = e.getY() / 100;
        if(board.selectedFigure.validMoves(newX, newY)){
            board.selectedFigure.col = newX;
            board.selectedFigure.row = newY;
        }
        panel.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
