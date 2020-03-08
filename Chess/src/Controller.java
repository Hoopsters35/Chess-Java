public class Controller {
    private View view;
    private Game model;

    public Controller(View view) {
        this.view = view;
        this.model = new Game();
        updateBoard();
    }

    private void updateBoard() {
        for (int file = 0; file < Board.GRID_SIZE; file++) {
            for (int rank = 0; rank < Board.GRID_SIZE; rank++) {
                Square square = this.model.getBoard().getSquare(Coordinate.fromIndices(file, rank));
                if (square.occupied()) {
                    this.view.placePiece(file, Board.GRID_SIZE - rank - 1, square.getPiece());
                }
            }
        }
    }

    /*
     * ======================
     * == Public interface ==
     * ======================
     */

    public void processMove(int startX, int viewStartY, int endX, int viewEndY) {
        int startY = Board.GRID_SIZE - 1 - viewStartY;
        int endY = Board.GRID_SIZE - 1 - viewEndY;
        System.out.println(String.format("Start x: %d, start y: %d", startX, startY));
        System.out.println(String.format("End x: %d, end y: %d", endX, endY));

        /* Convert to coordinates */
        Coordinate start = Coordinate.fromIndices(startX, startY);
        Coordinate end = Coordinate.fromIndices(endX, endY);
        /* Check for move legality */
        if (this.model.isLegalMove(start, end)) {
            System.out.println("Move is legal");
            /* Make move */
            this.model.makeMove(Coordinate.fromIndices(startX, startY), Coordinate.fromIndices(endX, endY));

        } else {
            /* Reset illegal move */
            System.out.println("Move is not legal");

        }

        this.view.clearBoard();
        this.updateBoard();
    }
}
