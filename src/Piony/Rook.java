package Piony;

import package2.Board;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rook extends Figure{
    public Rook(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;


        if(!isWhite){
            try {
                this.image = ImageIO.read(new File("ROOK.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }else{
            try {
                this.image = ImageIO.read(new File("Rook_white.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean validMoves(int col, int row) {
        return this.col == col || this.row == row;
    }

    @Override
    public boolean checkIfCollidingWithPiece(int col, int row) {
        // Lewo...
        if(this.col > col){
            for(int i = this.col - 1; i > col; i--){
                if(board.getFigure(i, this.row) != null){
                    return true;
                }
            }
        }
        // Prawo...
        if(this.col < col){
            for(int i = this.col + 1; i < col; i++){
                if(board.getFigure(i, this.row) != null){
                    return true;
                }
            }
        }
        // Góra...
        if(this.row > row){
            for(int i = this.row - 1; i > row; i--){
                if(board.getFigure(this.col, i) != null){
                    return true;
                }
            }
        }
        // Dół...
        if(this.row < row){
            for(int i = this.row + 1; i < row; i++){
                if(board.getFigure(this.col, i) != null){
                    return true;
                }
            }
        }
        return false;
    }
}
