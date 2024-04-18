package Piony;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import package2.*;

public class Bishop extends Figure {

    public Bishop(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;


        if(!isWhite){
            try {
                this.image = ImageIO.read(new File("Bishop.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }else{
            try {
                this.image = ImageIO.read(new File("Bishop_white.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public boolean validMoves(int col, int row) {
        return Math.abs(this.col - col) == Math.abs(this.row - row);
    }

    @Override
    public boolean checkIfCollidingWithPiece(int col, int row) {

        // UP_LEFT
        if(this.col > col && this.row > row){
            for(int i = 1; i < Math.abs(this.col - col); i++){
                if(board.getFigure(this.col - i, this.row - i) != null){
                    return true;
                }
            }
        }


        // UP_RIGHT
        if(this.col < col && this.row > row){
            for(int i = 1; i < Math.abs(this.col - col); i++){
                if(board.getFigure(this.col + i, this.row - i) != null){
                    return true;
                }
            }
        }

        // DOWN_LEFT
        if(this.col > col && this.row < row){
            for(int i = 1; i < Math.abs(this.col - col); i++){
                if(board.getFigure(this.col - i, this.row + i) != null){
                    return true;
                }
            }
        }


        // DOWN_RIGHT
        if(this.col < col && this.row < row){
            for(int i = 1; i < Math.abs(this.col - col); i++){
                if(board.getFigure(this.col + i, this.row + i) != null){
                    return true;
                }
            }
        }

        return false;
    }
}
