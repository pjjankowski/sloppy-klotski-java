package project.model;

import java.util.ArrayList;

/**
     * Top-level entity class
     */
    public class Model {

        // Keep track of a number of pieces.
        private ArrayList<Piece> list = new ArrayList<>();

        // The currently selected piece.
        private Piece current = null;

        private int moveCounter = 0;

        // Select a piece if the x and y values of the piece
        // match one on the board,
        // or no piece if not
        public void makeCurrent(int x, int y) {
            boolean selectedFlag = false;
            for (Piece p : this.getList()) {
                if (p.getX() == x && p.getY() == y) {
                    //if you clicked on the top left square for a piece
                setCurrent(p);
                selectedFlag = true;
                }
                else if (p.getWidth() == 2 && p.getX() == (x-1) && p.getY() == y) {
                    //if the piece is 2 wide and you clicked on the right side of the piece
                    setCurrent(p);
                    selectedFlag = true;
                }
                else if (p.getHeight() == 2 && p.getX() == (x) && p.getY() == (y-1)) {
                    setCurrent(p);
                    selectedFlag = true;
                    //if the piece is 2 tall and you clicked on the bottom of the piece
                }
                else if (p.getWidth() == 2 && p.getHeight() == 2 &&
                        p.getX() == (x-1) && p.getY() == (y-1)) {
                    setCurrent(p);
                    selectedFlag = true;
                    //if the piece is 2x2 and you clicked in the bottom right corner
                }
                else {
                    //otherwise, don't do anything
                }
                //if after going through all pieces, none of them were clicked,
                //then the area must be empty
                //so all pieces should be deselected
                if (!selectedFlag) {
                    setCurrent(null);
                }
            }
        }

        // Simply determine if a piece is the current one.
        public boolean isSelected(Piece p) {
            return (p != null && p == current);
        }

        /** Reset to starting pieces in model. */
        public void reset() {
            getList().clear();
            setCurrent(null);
            setMoveCounter(0);
            //adding all the starting pieces to our list
            getList().add(new Piece(0, 0, 1, 2)); //top, (0th) row
            getList().add(new Piece(1, 0, 1, 1));
            getList().add(new Piece(2, 0, 1, 1));
            getList().add(new Piece(3, 0, 1, 1));

            getList().add(new Piece(1, 1, 1, 2)); //1st row
            getList().add(new Piece(2, 1, 2, 2));

            getList().add(new Piece(0, 2, 1, 2)); //2nd row

            getList().add(new Piece(1, 3, 2, 1)); //3rd row
            getList().add(new Piece(3, 3, 1, 1));

            getList().add(new Piece(2, 4, 2, 1)); //4th row
        }

        public ArrayList<Piece> getList() {
            return list;
        }

        public Piece getCurrent() {
            return current;
        }

        public void setCurrent(Piece current) {
            this.current = current;
        }

        public int getMoveCounter() {
            return moveCounter;
        }

        public void setMoveCounter(int moveCounter) {
            this.moveCounter = moveCounter;
        }
}