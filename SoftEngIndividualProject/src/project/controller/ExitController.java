package project.controller;

import javax.swing.JOptionPane;

import project.view.SlidingPuzzleView;

public class ExitController {
    public boolean confirm(SlidingPuzzleView app) {
        return JOptionPane.showConfirmDialog (app, "Do you wish to exit SlidingPuzzle?") == JOptionPane.OK_OPTION;
    }
}