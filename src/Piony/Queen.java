package Piony;

import package2.Board;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Queen extends Figure{
    public Queen(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;


        if(!isWhite){
            try {
                this.image = ImageIO.read(new File("QUEEN.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }else{
            try {
                this.image = ImageIO.read(new File("Queen_white.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }
    }

    public boolean validMoves(int col, int row) {
        return this.col == col || this.row == row || Math.abs(this.col - col) == Math.abs(this.row - row);
    }

    @Override
    public boolean checkIfCollidingWithPiece(int col, int row) {
        return false;
    }
}
