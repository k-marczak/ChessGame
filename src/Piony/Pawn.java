package Piony;

import package2.Board;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pawn extends Figure {

    boolean isFirstMove = true;

    public Pawn(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;


        if (!isWhite) {
            try {
                this.image = ImageIO.read(new File("PAWN.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        } else {
            try {
                this.image = ImageIO.read(new File("Pawn_white.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public boolean validMoves(int col, int row) {
        int colorIndex = isWhite ? 1 : -1;


        // Move pawn through 2 bricks
        if (isFirstMove && this.col == col && row == this.row - colorIndex * 2 && (board.getFigure(col, row) == null)) {
            isFirstMove = false;
            return true;
        }

        // Move pawn through 1 brick
        if (this.col == col && row == this.row - colorIndex && (board.getFigure(col, row) == null)) {
            return true;
        }

        // Bicie Lewa strona
        if (col == this.col - 1 && row == this.row - colorIndex && board.getFigure(col, row) != null){
            return true;
        }


        // Bicie Prawa strona
        if (col == this.col + 1 && row == this.row - colorIndex && board.getFigure(col, row) != null){
            return true;
        }



        return false;
    }

    @Override
    public boolean checkIfCollidingWithPiece(int col, int row) {
        return false;
    }
}


