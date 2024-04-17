package Piony;

import package2.Board;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Knight extends Figure{

    public Knight(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;

        if(!isWhite){
            try {
                this.image = ImageIO.read(new File("KNIGHT.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }else{
            try {
                this.image = ImageIO.read(new File("Knight_white.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean validMoves(int col, int row) {
        return Math.abs(col - this.col) * Math.abs(row - this.row) == 2;
    }

    @Override
    public boolean checkIfCollidingWithPiece(int col, int row) {
        return false;
    }
}
