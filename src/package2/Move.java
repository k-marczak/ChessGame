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
    public Figure capture;

    public Move(Board board, JPanelComp panel) {
        this.board = board;
        this.panel = panel;

        capture = board.getFigure(newX, newY);
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
        if (pieceXY != null) {
            board.selectedFigure = pieceXY;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        System.out.println("Mouse released!");
        int newX1 = e.getX() / 100;
        int newY1 = e.getY() / 100;
        Figure figureXY = board.getFigure(newX1, newY1);
        newX = e.getX() / 100;
        newY = e.getY() / 100;

        if(figureXY == null){
            if ((board.selectedFigure.validMoves(newX, newY) && !(board.selectedFigure.checkIfCollidingWithPiece(newX, newY)))) {
                board.selectedFigure.col = newX;
                board.selectedFigure.row = newY;
            }
        }else {
            System.out.println("Ej, to nie jest NULL!");
            // Jeżeli nie jest nullem, to zrób to.
            // Musi sprawdzić czy są one z tego samego teamu czy nie.

            if ((!figureXY.isWhite && !board.selectedFigure.isWhite) || (figureXY.isWhite && board.selectedFigure.isWhite)){
                System.out.println("Nie można wykonać ruchu, ponieważ Ej, są to te same kolory");

            }else {
                System.out.println("Nie są te same kolory, ale czy warunki są spełnione? ");
                if ((board.selectedFigure.validMoves(newX, newY) && !(board.selectedFigure.checkIfCollidingWithPiece(newX, newY)))) {
                    System.out.println("SĄ");
                    board.selectedFigure.col = newX;
                    board.selectedFigure.row = newY;
                }
            }
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
