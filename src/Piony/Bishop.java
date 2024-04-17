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
}
