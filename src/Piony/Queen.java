package Piony;

import package2.Board;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Queen extends Figure {
    public Queen(Board board, int col, int row, boolean isWhite, String name) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = name;


        if (!isWhite) {
            try {
                this.image = ImageIO.read(new File("QUEEN.png"));
            } catch (IOException e) {
                System.out.println("Nie ma pliku...");
                throw new RuntimeException(e);
            }
        } else {
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

        // Lewo...
        if (this.col > col) {
            for (int i = this.col - 1; i > col; i--) {
                if (board.getFigure(i, this.row) != null) {
                    return true;
                }
            }
        }
        // Prawo...
        if (this.col < col) {
            for (int i = this.col + 1; i < col; i++) {
                if (board.getFigure(i, this.row) != null) {
                    return true;
                }
            }
        }
        // Góra...
        if (this.row > row) {
            for (int i = this.row - 1; i > row; i--) {
                if (board.getFigure(this.col, i) != null) {
                    return true;
                }
            }
        }
        // Dół...
        if (this.row < row) {
            for (int i = this.row + 1; i < row; i++) {
                if (board.getFigure(this.col, i) != null) {
                    return true;
                }
            }
        }

        // UP_LEFT
        if (this.col > col && this.row > row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getFigure(this.col - i, this.row - i) != null) {
                    return true;
                }
            }
        }


        // UP_RIGHT
        if (this.col < col && this.row > row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getFigure(this.col + i, this.row - i) != null) {
                    return true;
                }
            }
        }

        // DOWN_LEFT
        if (this.col > col && this.row < row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getFigure(this.col - i, this.row + i) != null) {
                    return true;
                }
            }
        }


        // DOWN_RIGHT
        if (this.col < col && this.row < row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getFigure(this.col + i, this.row + i) != null) {
                    return true;
                }
            }
        }

        return false;
    }
}
