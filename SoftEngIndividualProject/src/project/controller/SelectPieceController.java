package project.controller;

import java.awt.Point;

import project.model.Model;
import project.view.SlidingPuzzleView;

public class SelectPieceController {

    SlidingPuzzleView app;
    Model model;

    public SelectPieceController(SlidingPuzzleView app, Model model) {
        this.app = app;
        this.model = model;
    }

    public void selectPiece(Point point) {

        double xCoordinate = (point.getX()/100);
        double yCoordinate = (point.getY()/100);
        int xUsed;
        int yUsed;

        //first determine what column the piece is that the user clicked on, if any
        if (xCoordinate < 1) { //first column
            xUsed = 0;
        }
        else if (xCoordinate < 2) { //second column
            xUsed = 1;
        }
        else if (xCoordinate < 3) { //third column
            xUsed = 2;
        }
        else { //last column
            xUsed = 3;
        }

        //next determine what row the piece is that the user clicked on, if any
        if (yCoordinate < 1) { //first row
            yUsed = 0;
        }
        else if (yCoordinate < 2) { //second row
            yUsed = 1;
        }
        else if (yCoordinate < 3) { //third row
            yUsed = 2;
        }
        else if (yCoordinate < 4) { //fourth row
            yUsed = 3;
        }
        else { //fifth row
            yUsed = 4;
        }
        //make the piece with the provided row and column the selected piece
        //or if there is no piece there, deselect everything
        model.makeCurrent(xUsed, yUsed);

        // refresh display
        app.repaint();
    }

}