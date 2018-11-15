package project;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import project.controller.ExitController;
import project.model.Model;
import project.view.SlidingPuzzleView;

public class Main {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Model m = new Model();
                    m.reset(); //set up the initial configuration
                    SlidingPuzzleView frame = new SlidingPuzzleView(m);
                    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    //Only exit if the user says "Yes" on the exit controller
                    // Disposing the window will complete the application
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            if (new ExitController().confirm(frame)) {
                                frame.dispose();
                            }
                        }
                    });
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
