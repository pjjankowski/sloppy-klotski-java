package project.model;

import junit.framework.TestCase;

public class TestModel extends TestCase {

    public void testInit() {
        Model m = new Model();
        //test to begin that model is made with 0 pieces,
        //and no currently selected pieces
        assertEquals (m.getCurrent(), null);
        assertEquals (0, m.getList().size());
        assertEquals(0, m.getMoveCounter());
    }

    public void testReset() {
        Model m = new Model();
        m.reset();
        //test to begin that model is reset made with 10 pieces,
        //and no currently selected pieces
        assertEquals (m.getCurrent(), null);
        assertEquals (10, m.getList().size());
        assertEquals(0, m.getMoveCounter());
    }

    public void testMakeCurrent() {
        Model m = new Model();
        m.reset();
        //test to begin that model correctly chooses the selected piece
        //out of all pieces

        //make sure that null is counted as nothing selected
        assertFalse(m.isSelected(m.getCurrent()));

        //first choose the 1x2 piece that begins in the upper left corner
        m.makeCurrent(0, 0);
        assertEquals (m.getCurrent().getX(), 0);
        assertEquals (m.getCurrent().getY(), 0);
        assertEquals (m.getCurrent().getWidth(), 1);
        assertEquals (m.getCurrent().getHeight(), 2);
        //make sure that the selected piece is not null anymore
        assertTrue(m.isSelected(m.getCurrent()));

        //see if you can select the 2x2 using the bottom right corner
        m.makeCurrent(3, 2);
        assertEquals (m.getCurrent().getX(), 2);
        assertEquals (m.getCurrent().getY(), 1);
        assertEquals (m.getCurrent().getWidth(), 2);
        assertEquals (m.getCurrent().getHeight(), 2);

        //see if you can select the same 1x2 as before using the bottom piece
        m.makeCurrent(0, 1);
        assertEquals (m.getCurrent().getX(), 0);
        assertEquals (m.getCurrent().getY(), 0);
        assertEquals (m.getCurrent().getWidth(), 1);
        assertEquals (m.getCurrent().getHeight(), 2);

        //see if you can select the 2x2 using the upper right corner
        m.makeCurrent(3, 1);
        assertEquals (m.getCurrent().getX(), 2);
        assertEquals (m.getCurrent().getY(), 1);
        assertEquals (m.getCurrent().getWidth(), 2);
        assertEquals (m.getCurrent().getHeight(), 2);
    }
}
