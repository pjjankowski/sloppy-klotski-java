package project.controller;

import java.awt.Point;

import junit.framework.TestCase;
import project.model.Model;
import project.view.SlidingPuzzleView;

public class TestSelectPieceController extends TestCase {

    SlidingPuzzleView app;
    Model model;

    @Override
    protected void setUp() {
        model = new Model();
        app = new SlidingPuzzleView (model);
        app.setVisible(true);
    }

    @Override
    protected void tearDown() {
        app.dispose();
    }

    public void testSelections() {
        //no pieces yet
        assertTrue (model.getList().isEmpty());

        //add in starting pieces
        model.reset();
        assertFalse (model.getList().isEmpty());

        //select an empty region at first
        new SelectPieceController(app, model).selectPiece(new Point(146, 401));
        //make sure the piece currently selected is still considered null
        //for the empty space
        assertTrue(model.getCurrent() == null);

        //select the 1x2 piece starting in the upper left corner
        new SelectPieceController(app, model).selectPiece(new Point(1, 1));
        //make sure the piece chosen is not null
        assertFalse(model.getCurrent() == null);
        //make sure the correct piece has been selected
        assertTrue(model.getCurrent().getX() == 0);
        assertTrue(model.getCurrent().getY() == 0);
        assertTrue(model.getCurrent().getWidth() == 1);
        assertTrue(model.getCurrent().getHeight() == 2);

        //select the 2x2 piece by using the lower right corner
        new SelectPieceController(app, model).selectPiece(new Point(346, 200));
        //make sure the piece chosen is not null
        assertFalse(model.getCurrent() == null);
        //make sure the correct piece has been selected
        assertTrue(model.getCurrent().getX() == 2);
        assertTrue(model.getCurrent().getY() == 1);
        assertTrue(model.getCurrent().getWidth() == 2);
        assertTrue(model.getCurrent().getHeight() == 2);

        //select a 2x1 by selecting the bottom right corner
        new SelectPieceController(app, model).selectPiece(new Point(346, 401));
        //make sure the piece chosen is not null
        assertFalse(model.getCurrent() == null);
        //make sure the correct piece has been selected
        assertTrue(model.getCurrent().getX() == 2);
        assertTrue(model.getCurrent().getY() == 4);
        assertTrue(model.getCurrent().getWidth() == 2);
        assertTrue(model.getCurrent().getHeight() == 1);
    }
}