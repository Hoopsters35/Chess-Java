package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class King extends Piece {

    King(Board board, TeamColor team) {
        this.team = team;
        this.hasMoved = false;
        this.moves = new ArrayList<>();
        this.board = board;
        this.type = PieceType.KING;
        this.URL =  PRE_IMAGE + (team == TeamColor.WHITE ? "WhiteKing.png" : "BlackKing.png");
        initImage();
    }
    @Override
    protected void updatePossibleMoves() {
        Coordinates id = this.square.getID();
        final int curRank = id.getRank();
        final int curFile = id.getFile();
        final int[] adjust = {-1, 0, 1};
        for (int rankAdjust : adjust) {
            for (int fileAdjust : adjust) {
                addMoveIfLegal(curRank + rankAdjust, curFile + fileAdjust);
            }
        }
    }
    private void addMoveIfLegal(int rank, int file) {
        if (this.board.inBounds(rank) && this.board.inBounds(file)) {
            Coordinates idToCheck = new Coordinates(rank, file);
            Square squareToCheck = board.getSquare(idToCheck);
            if (!board.inCheck(squareToCheck, this.team) &&
                    (!squareToCheck.isOccupied() || squareToCheck.getPiece().getTeam() != this.team)) {
                this.moves.add(idToCheck);
            }
        }
    }

}