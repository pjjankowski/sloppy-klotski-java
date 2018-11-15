package project.controller;

import java.awt.Point;

import junit.framework.TestCase;
import project.model.Model;
import project.view.SlidingPuzzleView;

public class TestMovePieceController extends TestCase {

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

    public void testEachDirection() {
        //no pieces yet
        assertTrue (model.getList().isEmpty());

        //add in starting pieces
        model.reset();
        assertFalse (model.getList().isEmpty());

        //select the intially moveable 2x1 by selecting the bottom right corner
        new SelectPieceController(app, model).selectPiece(new Point(211, 425));
        //make sure the piece chosen is not null
        assertFalse(model.getCurrent() == null);

        //before moving, make sure that the initial x and y coordinates are correct
        assertTrue (model.getCurrent().getX() == 2);
        assertTrue (model.getCurrent().getY() == 4);

        //move it left three times, where it should stop at the left edge of the screen,
        //then right once
        new MovePieceController(app, model).moveSelectedLeft();
        new MovePieceController(app, model).moveSelectedLeft();
        new MovePieceController(app, model).moveSelectedLeft();
        new MovePieceController(app, model).moveSelectedRight();

        //make sure that the x coordinate has moved correctly,
        //but the piece otherwise is unchanged
        assertTrue (model.getCurrent().getX() == 1);
        assertTrue (model.getCurrent().getY() == 4);

        //select the now moveable 1x1 that was just above the 2x1
        //that has now been moved
        new SelectPieceController(app, model).selectPiece(new Point(320, 389));

        //before moving, make sure that the initial x and y coordinates are correct
        assertTrue (model.getCurrent().getX() == 3);
        assertTrue (model.getCurrent().getY() == 3);

        //move it down, where there is space,
        //and make sure moving down again doesn't take the piece offscreen
        new MovePieceController(app, model).moveSelectedDown();
        new MovePieceController(app, model).moveSelectedDown();

        //make sure that the y coordinate has moved correctly,
        //but the piece otherwise is unchanged
        assertTrue (model.getCurrent().getX() == 3);
        assertTrue (model.getCurrent().getY() == 4);

        //move it back up to where it was originally
        new MovePieceController(app, model).moveSelectedUp();
        assertTrue (model.getCurrent().getX() == 3);
        assertTrue (model.getCurrent().getY() == 3);

        //make sure it will not go out of bounds by attempting to move right
        //when already at the right edge of the board
        new MovePieceController(app, model).moveSelectedRight();
        assertTrue (model.getCurrent().getX() == 3);
        assertTrue (model.getCurrent().getY() == 3);

        //make sure it will not go on top of the 2x2 above by attempting to move up again
        new MovePieceController(app, model).moveSelectedUp();
        assertTrue (model.getCurrent().getX() == 3);
        assertTrue (model.getCurrent().getY() == 3);

        //now select the 2x2 that should be unable to move in any direction
        new SelectPieceController(app, model).selectPiece(new Point(346, 200));

        //make sure the original position is correct
        assertTrue(model.getCurrent().getX() == 2);
        assertTrue(model.getCurrent().getY() == 1);
        assertTrue(model.getCurrent().getWidth() == 2);
        assertTrue(model.getCurrent().getHeight() == 2);

        //try moving in every direction, (should all be blocked off)
        new MovePieceController(app, model).moveSelectedUp();
        new MovePieceController(app, model).moveSelectedLeft();

        assertTrue(model.getCurrent().getX() == 2);
        assertTrue(model.getCurrent().getY() == 1);
        assertTrue(model.getCurrent().getWidth() == 2);
        assertTrue(model.getCurrent().getHeight() == 2);

        new MovePieceController(app, model).moveSelectedDown();
        new MovePieceController(app, model).moveSelectedRight();

        assertTrue(model.getCurrent().getX() == 2);
        assertTrue(model.getCurrent().getY() == 1);
        assertTrue(model.getCurrent().getWidth() == 2);
        assertTrue(model.getCurrent().getHeight() == 2);
    }
}