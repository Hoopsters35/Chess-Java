public class Piece {
    private PieceType type;
    private TeamColor color;
    private boolean moved;

    public Piece(PieceType type, TeamColor color) {
        this.type = type;
        this.color = color;
        this.moved = false;
    }

    /**
     * Get exact copy of this.
     * @return
     *      New piece that is a deep copy of this
     */
    public Piece copy() {
        Piece copy = new Piece(this.type, this.color);
        copy.setMoved(this.moved);

        return copy;
    }

    /**
     * Get this piece type.
     * @return
     *      PieceType of this
     */
    public PieceType getType() {
        return type;
    }

    /**
     * Get the color of this.
     * @return
     *      TeamColor of this
     */
    public TeamColor getColor() {
        return color;
    }

    /**
     * Check if the piece has moved or not.
     * @return
     *      true iff this has moved
     */
    public boolean hasMoved() {
        return moved;
    }

    /**
     * Set whether the piece has moved or not.
     * @param moved
     *      New status of this.moved
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
