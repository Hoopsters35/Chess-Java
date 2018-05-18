package Game;

import Game.Pieces.MoveType;

public class Rook extends Piece {

    public Rook(Coordinates coordinates, TeamColor team) {
        super(coordinates, team);
    }

    @Override
    void initMoveDirections() {
        this.moveDirections = new MoveType[][]{
                {MoveType.NONE, MoveType.KILL, MoveType.NONE},
                {MoveType.KILL, MoveType.NONE, MoveType.KILL},
                {MoveType.NONE, MoveType.KILL, MoveType.NONE}};
    }

    @Override
    void initPieceType() {
        this.type = PieceType.ROOK;
    }

    /*@Override
    protected void updatePossibleMoves() {
        this.moves.clear();
        Coordinates curID = this.square.getID();
        final int curRank = curID.getRank();
        final int curFile = curID.getFile();
        final int[] directions = {-1, 1};
        for (int direction : directions) {
            boolean checkSquare = true;
            int multiplier = 1;
            while (checkSquare) {
                checkSquare = addMoveIfLegal(curRank + direction * multiplier, curFile);
                multiplier++;
            }
            checkSquare = true;
            multiplier = 1;
            while (checkSquare) {
                checkSquare = addMoveIfLegal(curRank, curFile + direction * multiplier);
                multiplier++;
            }
        }
    }
    private boolean addMoveIfLegal(int rank, int file) {
        boolean allowNext = false;
        if (this.board.inBounds(rank) && this.board.inBounds(file)){
            Coordinates idToCheck = new Coordinates(rank, file);
            Square square = this.board.getSquare(idToCheck);
            allowNext = square.isOccupied();
            if (!square.isOccupied() || square.getPiece().getTeam() != this.team) {
                this.moves.add(idToCheck);
            }
        }
        return allowNext;
    }*/

}
