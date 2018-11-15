package project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import project.controller.MovePieceController;
import project.controller.ResetController;
import project.controller.SelectPieceController;
import project.model.Model;

public class SlidingPuzzleView extends JFrame {

    private JPanel contentPane;
    Model model;

    /**
     * Create the frame.
     */
    public SlidingPuzzleView(Model m) {
        this.model = m;
        setTitle("SlidingPuzzleApp");
                 setBounds(100, 100, 765, 600);
                 contentPane = new JPanel();
                 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                 setContentPane(contentPane);

                 PuzzleView panel = new PuzzleView(m);
                 panel.setBackground(Color.WHITE);
                 panel.setSize(new Dimension(500, 500));
                 /** Register controller to react to mouse events on SlidingPuzzleView */
                 panel.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                         new SelectPieceController(SlidingPuzzleView.this, m).selectPiece(e.getPoint());
                     }
                 });

                 JLabel label = new JLabel(Integer.toString(model.getMoveCounter()));

                 JButton btnReset = new JButton("Reset");
                 btnReset.addActionListener(new ActionListener()
                 {
                   @Override
                public void actionPerformed(ActionEvent e)
                   {
                     // reset the puzzle when the button is pushed, after prompting
                     // the user
                     new ResetController(SlidingPuzzleView.this, model).reset();
                     label.setText(Integer.toString(model.getMoveCounter()));
                   }
                 });

                 JButton buttonUp = new JButton("^");
                 buttonUp.addActionListener(new ActionListener()
                 {
                     @Override
                  public void actionPerformed(ActionEvent e)
                     {
                       new MovePieceController(SlidingPuzzleView.this, model).moveSelectedUp();
                       label.setText(Integer.toString(model.getMoveCounter()));
                     }
                   });

                 JButton button_1 = new JButton("<");
                 button_1.addActionListener(new ActionListener()
                 {
                     @Override
                  public void actionPerformed(ActionEvent e)
                     {
                       new MovePieceController(SlidingPuzzleView.this, model).moveSelectedLeft();
                       label.setText(Integer.toString(model.getMoveCounter()));
                     }
                   });

                 JButton button_2 = new JButton(">");
                 button_2.addActionListener(new ActionListener()
                 {
                     @Override
                  public void actionPerformed(ActionEvent e)
                     {
                       new MovePieceController(SlidingPuzzleView.this, model).moveSelectedRight();
                       label.setText(Integer.toString(model.getMoveCounter()));
                     }
                   });

                 JButton btnV = new JButton("V");
                 btnV.addActionListener(new ActionListener()
                 {
                     @Override
                  public void actionPerformed(ActionEvent e)
                     {
                       new MovePieceController(SlidingPuzzleView.this, model).moveSelectedDown();
                       label.setText(Integer.toString(model.getMoveCounter()));
                     }
                   });

                 JLabel lblMoves = new JLabel("Moves:");

                 GroupLayout gl_contentPane = new GroupLayout(contentPane);
                 gl_contentPane.setHorizontalGroup(
                     gl_contentPane.createParallelGroup(Alignment.LEADING)
                         .addGroup(gl_contentPane.createSequentialGroup()
                             .addComponent(panel, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                             .addGap(29)
                             .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                 .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                     .addGroup(gl_contentPane.createSequentialGroup()
                                         .addGap(14)
                                         .addComponent(button_1))
                                     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                         .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                             .addGap(21)
                                             .addComponent(lblMoves)
                                             .addPreferredGap(ComponentPlacement.UNRELATED)
                                             .addComponent(label))
                                         .addGroup(gl_contentPane.createSequentialGroup()
                                             .addGap(52)
                                             .addComponent(btnReset))
                                         .addComponent(buttonUp, Alignment.TRAILING)))
                                 .addComponent(btnV))
                             .addGap(18)
                             .addComponent(button_2)
                             .addContainerGap(130, Short.MAX_VALUE))
                 );
                 gl_contentPane.setVerticalGroup(
                     gl_contentPane.createParallelGroup(Alignment.LEADING)
                         .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                             .addContainerGap()
                             .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                 .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                                 .addGroup(gl_contentPane.createSequentialGroup()
                                     .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                         .addComponent(label)
                                         .addComponent(lblMoves))
                                     .addGap(178)
                                     .addComponent(buttonUp)
                                     .addGap(27)
                                     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                         .addComponent(button_2)
                                         .addComponent(button_1))
                                     .addGap(17)
                                     .addComponent(btnV)
                                     .addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                                     .addComponent(btnReset)))
                             .addContainerGap())
                 );
                 contentPane.setLayout(gl_contentPane);
         }
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                           showMenu(e);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
