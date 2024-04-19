package Piony;

import package2.Board;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Figure{

    public int xPos, yPos;
    public int col, row;
    public int tileSize = 100;
    public boolean isWhite;
    public String name;
    public Board board;
    public BufferedImage image;
    public boolean isFirstMove;



    // Need to return the list of all legal moves
    // ??????????????

    public Figure(Board board){
        this.board = board;
    }

    public void draw(Graphics g){
        g.drawImage(image, col*tileSize + 13, row*tileSize + 13, null);
    }

    public abstract boolean validMoves(int col, int row);

    public abstract boolean checkIfCollidingWithPiece(int col, int row);

    public boolean checkIfSameTeam(Figure figure1, Figure figure2){

        if(figure1.isWhite == figure2.isWhite){
            return false;
        }
        return true;

    }
}
