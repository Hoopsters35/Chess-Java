import java.util.ArrayList;

public class Knight extends Piece {

    Knight(Board board, Board.TeamColor team) {
        this.team = team;
        this.hasMoved = false;
        this.moves = new ArrayList<>();
        this.board = board;
        this.type = Board.PieceType.KNIGHT;

    }

    @Override
    protected void updatePossibleMoves() {
        moves.clear();
        String curID = this.square.getID();
        final int curRank = this.board.LETTERS.indexOf(curID.charAt(0));
        final int curFile = this.board.NUMBERS.indexOf(curID.charAt(1));
        final int[] rankAdjustments = {2, 1, -1, -2};
        final int[] fileAdjustments = {1, 2, 2, 1};
        final int[] directions = {-1, 1};
        for (int i = 0; i < rankAdjustments.length; i++) {
            for (int direction : directions) {
                addMoveIfLegal(curRank + rankAdjustments[i], curFile + fileAdjustments[i] * direction);
            }
        }
    }
    protected void addMoveIfLegal(int rank, int file) {
        if (this.board.inBounds(rank) && this.board.inBounds(file)) {
            String idToCheck = board.indexToID(rank, file);
            Square square = board.getSquare(idToCheck);
            if (!square.isOccupied() || (square.getPiece().getTeam() != this.team)) {
                moves.add(idToCheck);
            }
        }
    }

}
