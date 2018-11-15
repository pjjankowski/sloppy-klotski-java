package project.model;

/**
     * Piece
     */
    public class Piece {

        // the row of the piece's leftmost square(s),
        private int x;

        // the column of the piece's topmost square(s),
        private int y;

        // the width coordinate of the piece, in squares
        private int width;

        // the y coordinate of the piece, in squares
        private int height;

        public Piece(int xC, int yC, int widthC, int heightC) {
            this.setX(xC);
            this.setY(yC);
            this.setWidth(widthC);
            this.setHeight(heightC);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
}