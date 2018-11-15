package project.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import project.model.Model;
import project.model.Piece;

    /**
     * Knows how to visually present the puzzle.
     */
    public class PuzzleView extends JPanel {

        Model model;

           public PuzzleView(Model m) {
               this.model = m;
           }

           @Override
           public void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   g.setColor(Color.white);
                   g.fillRect(0, 0,  400, 500); //the puzzle background is white
                   //fillRect(x, y, width, height)

                   for (Piece p : model.getList()) {
                       //draw each piece
                       g.setColor(Color.gray);
                       if (p.getWidth() == 2 && p.getHeight() == 2) {
                           //if the piece is 2x2, make it red
                           g.setColor(Color.red);
                       }
                       if (model.isSelected(p)) {
                           //if the piece is selected, highlight it yellow
                           g.setColor(Color.yellow);
                       }
                       g.fillRect((p.getX() * 100), (p.getY() * 100),
                               ((p.getWidth()) * 100),
                               ((p.getHeight()) * 100));

                       //draw a white border for each piece, too
                       g.setColor(Color.white);
                       g.drawRect((p.getX() * 100), (p.getY() * 100),
                               ((p.getWidth()) * 100),
                               ((p.getHeight()) * 100));
                   }
                   //the 10 starting pieces
                   //using gray for most,
                   //red for the 2x2,
                   //yellow for regular selected,
                   //green for the 2x2 selected
/*
                   //if (resetFlag == 0) {
                   g.setColor(Color.gray); //the starting pieces
                   g.fillRect(0, 0,  100, 200); //top left
                   g.setColor(Color.white);
                   g.drawRect(0, 0, 100, 200);

                   g.setColor(Color.gray);
                   g.fillRect(100, 0,  100, 100); //top middle left
                   g.setColor(Color.white);
                   g.drawRect(100, 0, 100, 100);

                   g.setColor(Color.gray);
                   g.fillRect(200, 0,  100, 100); //top middle right
                   g.setColor(Color.white);
                   g.drawRect(200, 0, 100, 100);

                   g.setColor(Color.gray);
                   g.fillRect(300, 0,  100, 100); //top right
                   g.setColor(Color.white);
                   g.drawRect(300, 0, 100, 100);

                   g.setColor(Color.gray);
                   g.fillRect(0, 200,  100, 200); //middle left
                   g.setColor(Color.white);
                   g.drawRect(0, 200, 100, 200);

                   g.setColor(Color.gray);
                   g.fillRect(100, 100,  100, 200); //middle
                   g.setColor(Color.white);
                   g.drawRect(100, 100, 100, 200);

                   g.setColor(Color.red);
                   g.fillRect(200, 100,  200, 200); //large
                   g.setColor(Color.white);
                   g.drawRect(200, 100, 200, 200);

                   g.setColor(Color.gray);
                   g.fillRect(100, 300,  200, 100); //lower middle
                   g.setColor(Color.white);
                   g.drawRect(100, 300, 200, 100);

                   g.setColor(Color.gray);
                   g.fillRect(300, 300,  100, 100); //lower right
                   g.setColor(Color.white);
                   g.drawRect(300, 300, 100, 100);

                   g.setColor(Color.gray);
                   g.fillRect(200, 400,  200, 100); //bottom
                   g.setColor(Color.white);
                   g.drawRect(200, 400, 200, 100); */
           }
    }