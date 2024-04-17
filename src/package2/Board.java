package package2;

import Piony.*;

import java.awt.*;
import java.util.ArrayList;

public class Board{

    // Tablica, wymiary kafelka i columny/wiersze //
    public int tileSize = 100;
    public int cols = 8;
    public int rows = 8;


    // Wybrana figura za pomocą Mouse Listenera. //
    public Figure selectedFigure;


    // ArrayLista w której są wszystkie figury w grze.
    public ArrayList<Figure> pieces = new ArrayList<>();


    // Konstruktor Board // Jest wywoływany przez JPanel Comp, w celu przekazania jej potem do Move, oraz w celu narysowania szachownicy //
    // Konstruktor Board jest tworzony i przekazywany do Move, w celu dostania się do selectedFigure.
    public Board(){

        // Białe Piony
        pieces.add(new Pawn(this, 0, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 1, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 2, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 3, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 4, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 5, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 6, 6, true, "Pawn"));
        pieces.add(new Pawn(this, 7, 6, true, "Pawn"));

        pieces.add(new Rook(this, 0, 7, true, "Rook"));
        pieces.add(new Knight(this, 1, 7, true, "Knight"));
        pieces.add(new Bishop(this, 2, 7, true, "Bishop"));
        pieces.add(new Queen(this, 3, 7, true, "Queen"));
        pieces.add(new King(this, 4, 7, true, "King"));
        pieces.add(new Bishop(this, 5, 7, true, "Bishop"));
        pieces.add(new Knight(this, 6, 7, true, "Knight"));
        pieces.add(new Rook(this, 7, 7, true, "Rook"));

        // Czarne Piony
        pieces.add(new Pawn(this, 0, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 1, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 2, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 3, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 4, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 5, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 6, 1, false, "Pawn"));
        pieces.add(new Pawn(this, 7, 1, false, "Pawn"));

        pieces.add(new Rook(this, 0, 0, false, "Rook"));
        pieces.add(new Knight(this, 1, 0, false, "Knight"));
        pieces.add(new Bishop(this, 2, 0, false, "Bishop"));
        pieces.add(new Queen(this, 3, 0, false, "Queen"));
        pieces.add(new King(this, 4, 0, false, "King"));
        pieces.add(new Bishop(this, 5, 0, false, "Bishop"));
        pieces.add(new Knight(this, 6, 0, false, "Knight"));
        pieces.add(new Rook(this, 7, 0, false, "Rook"));
    }

    // Rysowanie wszystkiego!! Szachowiny oraz piony // Metoda jest wywoływana w JPanel Comp.
    public void paintComponent(Graphics g){
        // Rysowanie szachownicy //
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.pink);
                    g.fillRect(tileSize * j,tileSize * i,tileSize,tileSize);
                }else {
                    g.setColor(Color.GRAY);
                    g.fillRect(tileSize * j,tileSize * i,tileSize,tileSize);
                }
            }
        }
        // Rysowanie pionów //
        for(Figure piece : pieces){
            piece.draw(g);
        }
        g.dispose();
    }


    // Przekazanie odpowiedniego pionka do Move, który jest na tej samej kolumnie i wierszu co w argumencie metody.
    public Figure getFigure(int col, int row){

        for(Figure piece : pieces){
            if(piece.col == col && piece.row == row){
                return piece;
            }
        }
        return null;
    }
}