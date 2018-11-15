package project.controller;

import javax.swing.JOptionPane;

import project.model.Model;
import project.view.SlidingPuzzleView;

public class ResetController {

    SlidingPuzzleView app;
    Model model;

    public ResetController(SlidingPuzzleView app, Model model) {
        this.app = app;
        this.model = model;
    }

    public void reset() {
        //to be implemented here
        //JOptionPane.showConfirmDialog (app, "Do you wish to reset the puzzle?") == JOptionPane.OK_OPTION;
        int resetCheck = JOptionPane.showConfirmDialog (app, "Do you wish to reset the puzzle?");
        if (resetCheck == 0) { //reset only if the user clicks "Yes"
            model.reset();
            // refresh display
            app.repaint();
        }
    }
}