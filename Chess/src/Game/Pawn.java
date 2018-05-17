package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Pawn extends Piece {

    Pawn(Board board, TeamColor team) {
        this.team = team;
        this.hasMoved = false;
        this.moves = new ArrayList<>();
        this.board = board;
        this.type = PieceType.PAWN;
        this.URL = PRE_IMAGE + (team == TeamColor.WHITE ? "WhitePawn.png" : "BlackPawn.png");
        initImage();
    }
    @Override
    protected void updatePossibleMoves() {
        final int direction = (this.team == TeamColor.WHITE) ? 1 : -1;
        this.moves.clear();
        Coordinates id = this.square.getID();
        int nextRank = id.getRank() + direction;
        if (board.inBounds(nextRank)){
            /*
            Check directly in front of the piece
             */
            int curFile = id.getFile();
            Coordinates idToCheck = new Coordinates(nextRank, curFile);
            if(!board.getSquare(idToCheck).isOccupied()) {
                this.moves.add(idToCheck);
                /*
                Check if moving twice is possible
                 */
                if(!this.hasMoved && board.inBounds(nextRank + direction)) {
                    addMoveIfLegal(nextRank + direction, curFile, false);
                }
            }
            /*
            Check front left
             */
            int leftFile = curFile - direction;
            if (board.inBounds(leftFile)) {
                addMoveIfLegal(nextRank, leftFile, true);
            }
            /*
            Check front right
             */
            int rightFile = curFile + direction;
            if (board.inBounds(rightFile)){
                addMoveIfLegal(nextRank, rightFile, true);
            }
        }
    }

    /**
     * Given a rank and file, check if the move is legal.
     * @param rank
     *      Index of the alpha component of a tile
     * @param file
     *      Index of the numeric component of a tile
     * @param capture
     *      Determines if a capture is legal
     */
    private void addMoveIfLegal(int rank, int file, boolean capture) {
        Coordinates idToCheck = new Coordinates(rank, file);
        if (!board.getSquare(idToCheck).isOccupied()
                || (capture && board.getSquare(idToCheck).getPiece().getTeam() != team)) {
            moves.add(idToCheck);
        }
    }

}