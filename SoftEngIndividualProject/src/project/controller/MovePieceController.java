package project.controller;

import javax.swing.JOptionPane;

import project.model.Model;
import project.model.Piece;
import project.view.SlidingPuzzleView;

public class MovePieceController {

    SlidingPuzzleView app;
    Model model;

    public MovePieceController(SlidingPuzzleView app, Model model) {
        this.app = app;
        this.model = model;
    }

    public void moveSelectedUp() {
        boolean makeMove = true;
        if (model.isSelected(model.getCurrent())) { //only move if a piece
            //is selected
        //first, check that the move won't go out of bounds
        if (model.getCurrent().getY() == 0) { //will go out of bounds
            makeMove = false;
            //if the selected piece would go out of bounds, do not move
        }
        else {
            for (Piece p : model.getList()) {
                //checks for top left square of the piece above
                if (p.getY() == (model.getCurrent().getY() - 1)
                        && p.getX() == model.getCurrent().getX()) {
                    //if there's a piece directly above the selected piece,
                    //in the same column,
                    //do not move
                    makeMove = false;
                }
                //checks for the right square of the piece above,
                //if it has one
                if (p.getWidth() == 2) {
                    if (p.getY() == (model.getCurrent().getY() - 1)
                            && (p.getX() + 1) == model.getCurrent().getX()) {
                        //if there's a piece directly above the selected piece,
                        //in the same column,
                        //do not move
                        makeMove = false;
                    }
                }
                //checks for the bottom square of the piece above,
                //if it has one
                if (p.getHeight() == 2) {
                    if ((p.getY() + 1) == (model.getCurrent().getY() - 1)
                            && p.getX() == model.getCurrent().getX()) {
                        //if there's a piece directly above the selected piece,
                        //in the same column,
                        //do not move
                        makeMove = false;
                    }
                }
                  //checks for the bottom right square of the piece above,
                  //if it has one, (meaning it is the 2x2)
                    if (p.getWidth() == 2 && p.getHeight() == 2) {
                        if ((p.getY() + 1) == (model.getCurrent().getY() - 1)
                                && (p.getX() + 1) == model.getCurrent().getX()) {
                            //if there's a piece directly above the selected piece,
                            //in the same column,
                            //do not move
                            makeMove = false;
                        }
                    }
                //if the selected piece is 2 wide,
                //also check to make sure the selected piece is unobstructed
                //the next column over
                if (model.getCurrent().getWidth() == 2) {
                    if (p.getY() == (model.getCurrent().getY() - 1)
                            && p.getX() == model.getCurrent().getX() + 1) {
                        makeMove = false;
                    }
                    //checks for the bottom square of the piece above,
                    //if it has one
                    if (p.getHeight() == 2) {
                        if ((p.getY() + 1) == (model.getCurrent().getY() - 1)
                                && p.getX() == model.getCurrent().getX() + 1) {
                            //if there's a piece directly above the selected piece,
                            //in the same column,
                            //do not move
                            makeMove = false;
                        }
                    }
                }
            }
            //if there is nothing stopping the move, make the move
            if (makeMove) {
                //update the move counter
                model.setMoveCounter(model.getMoveCounter() + 1);
                //move the piece up
                model.getCurrent().setY(model.getCurrent().getY() - 1);
                //deselect the piece after moving
                //if needed
                //model.setCurrent(null);
            }
        }
        }

        // refresh display
        app.repaint();
    }

    public void moveSelectedLeft() {
        boolean makeMove = true;
        if (model.isSelected(model.getCurrent())) { //only move if a piece
            //is selected
        //first, check that the move won't go out of bounds
        if (model.getCurrent().getX() == 0) { //will go out of bounds
            makeMove = false;
            //if the selected piece would go out of bounds, do not move
        }
        else {
            for (Piece p : model.getList()) {
                if (p.getX() == (model.getCurrent().getX() - 1)
                        && p.getY() == model.getCurrent().getY()) {
                    //if there's a piece directly left of the selected piece,
                    //in the same row,
                    //do not move
                    makeMove = false;
                }
                //if the selected piece is 2 tall,
                //also check to make sure the selected piece is unobstructed
                //the next row down
                if (model.getCurrent().getHeight() == 2) {
                    if (p.getX() == (model.getCurrent().getX() - 1)
                            && p.getY() == model.getCurrent().getY() + 1) {
                        makeMove = false;
                    }
                    //if the nonselected piece is 2 wide,
                    //also have to check its right square
                    //to the selected piece's lower square
                    if (p.getWidth() == 2) {
                        if (p.getX() + 1 == (model.getCurrent().getX() - 1)
                                && p.getY() == model.getCurrent().getY() + 1) {
                            //if there's a piece directly left of the selected piece,
                            //in the same row,
                            //do not move
                            makeMove = false;
                    }
                    }
                }
                //if the nonselected
                //piece is two tall, also have to check the
                //bottom square
                if (p.getHeight() == 2) {
                    if (p.getX() == (model.getCurrent().getX() - 1)
                            && p.getY() + 1 == model.getCurrent().getY()) {
                        //if there's a piece directly left of the selected piece,
                        //in the same row,
                        //do not move
                        makeMove = false;
                }
                }
                  //if the nonselected
                //piece is two wide, also have to check the
                    //right square
                    if (p.getWidth() == 2) {
                        if (p.getX() + 1 == (model.getCurrent().getX() - 1)
                                && p.getY() == model.getCurrent().getY()) {
                            //if there's a piece directly left of the selected piece,
                            //in the same row,
                            //do not move
                            makeMove = false;
                    }
                      //if the nonselected
                        //piece is the 2x2, also have to check the
                        //bottom right square
                        if (p.getHeight() == 2) {
                            if (p.getX() + 1 == (model.getCurrent().getX() - 1)
                                    && p.getY() + 1 == model.getCurrent().getY()) {
                                //if there's a piece directly left of the selected piece,
                                //in the same row,
                                //do not move
                                makeMove = false;
                        }
                    }
                    }
            }
            //if there is nothing stopping the move, make the move
            if (makeMove) {
                //update the move counter
                model.setMoveCounter(model.getMoveCounter() + 1);
                //move the piece up
                model.getCurrent().setX(model.getCurrent().getX() - 1);
                //deselect the piece after moving
                //if needed
                //model.setCurrent(null);
            }
        }
        }
        // refresh display
        app.repaint();
    }

    public void moveSelectedRight() {
        boolean makeMove = true;
        if (model.isSelected(model.getCurrent())) { //only move if a piece
            //is selected
        //first, check that the move won't go out of bounds
        if (model.getCurrent().getX() == 3) { //will go out of bounds
            makeMove = false;
            //if the selected piece would go out of bounds, do not move
        }
        //also need to check the piece's right square
        //won't go out of bounds
        else if (model.getCurrent().getX() == 2 && model.getCurrent().getWidth() == 2) {
            makeMove = false;
        }
        else {
            for (Piece p : model.getList()) {
                if (p.getX() == (model.getCurrent().getX() + 1)
                        && p.getY() == model.getCurrent().getY()) {
                    //if there's a piece directly right of the selected piece,
                    //in the same row,
                    //do not move
                    makeMove = false;
                }
                //if the selected piece is 2 tall,
                //also check to make sure the selected piece is unobstructed
                //the next row down
                if (model.getCurrent().getHeight() == 2) {
                    if (p.getX() == (model.getCurrent().getX() + 1)
                            && p.getY() == model.getCurrent().getY() + 1) {
                        makeMove = false;
                    }
                }
                //if the nonselected piece is 2 tall,
                //also make sure that its lower square does
                //not collide with the top square of the
                //selected piece
                if (p.getHeight() == 2) {
                    if (p.getX() == (model.getCurrent().getX() + 1)
                            && p.getY() + 1 == model.getCurrent().getY()) {
                        makeMove = false;
                    }
                }
                //if the selected piece is 2 wide,
                //make sure it does not collide with any other pieces
                if (model.getCurrent().getWidth() == 2) {
                    //if the selected piece is 2x2
                    //also have to check for the bottom left square
                    if (model.getCurrent().getHeight() == 2) {
                        if (p.getX() == (model.getCurrent().getX() + 2)
                                && p.getY() == model.getCurrent().getY() + 1) {
                            makeMove = false;
                        }
                    }
                  //if the nonselected piece is 2x2
                    //also have to check for the bottom left square
                    if (p.getHeight() == 2) {
                        if (p.getX() == (model.getCurrent().getX() + 2)
                                && p.getY() + 1 == model.getCurrent().getY()) {
                            makeMove = false;
                        }
                    }
                    if (p.getX() == (model.getCurrent().getX() + 2)
                            && p.getY() == model.getCurrent().getY()) {
                        makeMove = false;
                    }
                }
            }
            //if there is nothing stopping the move, make the move
            if (makeMove) {
                //update the move counter
                model.setMoveCounter(model.getMoveCounter() + 1);
                //move the piece up
                model.getCurrent().setX(model.getCurrent().getX() + 1);
                //deselect the piece after moving
                //if needed
                //model.setCurrent(null);
            }
        }
        }

        // refresh display
        app.repaint();
    }

    public void moveSelectedDown() {
        boolean makeMove = true;
        if (model.isSelected(model.getCurrent())) { //only move if a piece
            //is selected
        //first, check if the move wins
        if (model.getCurrent().getY() == 3 && model.getCurrent().getHeight() == 2
                && model.getCurrent().getX() == 1 && model.getCurrent().getWidth() == 2) {
            //the winning move has been made!
            //congratulate the user,
            //and move the 2x2 piece off the board
            makeMove = false;
            model.setMoveCounter(model.getMoveCounter() + 1);
            model.getCurrent().setY(model.getCurrent().getY() + 3);
            model.setCurrent(null);
            JOptionPane.showMessageDialog(app, "You Win!");
        }
        //next, check that the move won't go out of bounds
        else if (model.getCurrent().getY() == 4) { //will go out of bounds
            makeMove = false;
            //if the selected piece would go out of bounds, do not move
        }
        else if (model.getCurrent().getY() == 3 && model.getCurrent().getHeight() == 2) {
            makeMove = false;
        }
        else {
            for (Piece p : model.getList()) {
                if (p.getY() == (model.getCurrent().getY() + 1)
                        && p.getX() == model.getCurrent().getX()) {
                    //if there's a piece directly above the selected piece,
                    //in the same column,
                    //do not move
                    makeMove = false;
                }
              //checks for the right square of the piece below,
                //if it has one
                if (p.getWidth() == 2) {
                    if (p.getY() == (model.getCurrent().getY() + 1)
                            && (p.getX() + 1) == model.getCurrent().getX()) {
                        //if there's a piece directly above the selected piece,
                        //in the same column,
                        //do not move
                        makeMove = false;
                    }
                }
                //if the selected piece is 2 wide,
                //also check to make sure the selected piece is unobstructed
                //the next column over
                if (model.getCurrent().getWidth() == 2) {
                    if (p.getY() == (model.getCurrent().getY() + 1)
                            && p.getX() == model.getCurrent().getX() + 1) {
                        makeMove = false;
                    }
                }
              //if the selected piece is the 2 squares tall, need to check the bottom square
                if (model.getCurrent().getHeight() == 2) {
                    if (p.getY() == (model.getCurrent().getY() + 2)
                            && p.getX() == model.getCurrent().getX()) {
                        makeMove = false;
                    }
                    if (p.getWidth() == 2) {
                        if (p.getY() == (model.getCurrent().getY() + 2)
                                && p.getX() + 1 == model.getCurrent().getX()) {
                            makeMove = false;
                        }
                    }
                }
             //if the selected piece is the 2x2, need to check for the bottom right square
             //as well
                if (model.getCurrent().getHeight() == 2 &&
                        model.getCurrent().getWidth() == 2) {
                    if (p.getY() == (model.getCurrent().getY() + 2)
                            && p.getX() == model.getCurrent().getX() + 1) {
                        makeMove = false;
                    }
                }
            }
            //if there is nothing stopping the move, make the move
            if (makeMove) {
                //update the move counter
                model.setMoveCounter(model.getMoveCounter() + 1);
                //move the piece up
                model.getCurrent().setY(model.getCurrent().getY() + 1);
                //deselect the piece after moving
                //if needed
                //model.setCurrent(null);
            }
        }
        }

        // refresh display
        app.repaint();
    }
}