package project.controller;

import junit.framework.TestCase;
import project.model.Model;
import project.view.SlidingPuzzleView;

public class TestResetController extends TestCase {

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

    public void testReset() {
        // Just execute without fully testing
        //to make sure that the reset popup at least appears
        Thread thread = new Thread() {
            @Override
            public void run() {
                new ResetController(app, model).reset();
            }
        };
        thread.start();
    }
}