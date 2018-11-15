package project.model;

import junit.framework.TestCase;

public class TestPiece extends TestCase {

    public void testMake() {
        //ensure that each new piece is made properly
        //following the constructor Piece(x, y, width, height)
        Piece p = new Piece(0, 3, 2, 1);
        assertEquals(0, p.getX());
        assertEquals(3, p.getY());
        assertEquals(2, p.getWidth());
        assertEquals(1, p.getHeight());
    }
}
