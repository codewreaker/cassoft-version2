/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftModels.Operations;
import cassoftViews.AddStudent;
import cassoftViews.MainView;
import cassoftViews.Settings;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 *
 * @author Israel Agyeman-Premp
 */
public class MainController {

    private MouseMotionListener mouseMotionListener;
    private MouseListener mouseListener;
    private Database db;
    private MainView mv;
    private Operations op;
    private AddStudent add;
    private Settings settings;
    private int xMouse;
    private int yMouse;
    private KeyAdapter keyAdapter;
    private Border border;
    public static String surName;
    public static String firstName;

    public MainController(MainView mv, Database db) {
        this.db = db;
        this.mv = mv;
    }

    /**
     * This method initiates the listeners.
     */
    public void control() {
        mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == mv.close()) {
                    if (JOptionPane.showConfirmDialog(mv, "Are you sure you want to quit?") == 0) {
                        System.exit(0);
                    }
                } else if (e.getSource() == mv.minimise()) {
                } else if (e.getSource() == mv.maximise()) {
                    {                        
                        mv.bg().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/UI-02.png")));
                        mv.dispose();
                        mv.setUndecorated(false);
                        mv.setVisible(true);
                        mv.minimise().setVisible(false);
                        mv.maximise().setVisible(false);
                        mv.close().setVisible(false);

                    }
                } else if (e.getSource() == mv.studHistory()) {
                    //put code for student history here
                } else if (e.getSource() == mv.studView()) {
                    //put code to view student here
                } else if (e.getSource() == mv.studDelete()) {
                    //put code to delete student here
                } else if (e.getSource() == mv.settingsBtn()) {
                    // put code for application settings here
                } else if (e.getSource() == mv.addStudent()) {
                    // put code for adding student here
                } else if (e.getSource() == mv.viewHistory()) {
                    // put code for viewing general statistics here
                } else if (e.getSource() == mv.searchComboBox()) {
                    // put code for the combo box here (search)
                } else if (e.getSource() == mv.search()) {
                    //search button
                } else if (e.getSource() == mv.saveButton()) {
                    //put code for saving here
                } else if (e.getSource() == mv.mainTable()) {
                    // put code for clicking any part of the table
                }else if (e.getSource() == mv.home()) {
                    // put code for viewing home screen when the home button is pressed
                }  else {
                    // System.out.println("Where have you clicked");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {/**/}

            @Override
            public void mouseReleased(MouseEvent e) {/**/}

            @Override
            public void mouseEntered(MouseEvent e) {/**/}

            @Override
            public void mouseExited(MouseEvent e) {/**/}
        };

  

        mv.close().addMouseListener(mouseListener);
        mv.minimise().addMouseListener(mouseListener);
        mv.maximise().addMouseListener(mouseListener);
        mv.studHistory().addMouseListener(mouseListener);
        mv.studView().addMouseListener(mouseListener);
        mv.studDelete().addMouseListener(mouseListener);
        mv.settingsBtn().addMouseListener(mouseListener);
        mv.addStudent().addMouseListener(mouseListener);
        mv.saveButton().addMouseListener(mouseListener);
        mv.viewHistory().addMouseListener(mouseListener);
        mv.search().addMouseListener(mouseListener);
        mv.home().addMouseListener(mouseListener);
        //mv.searchTextField().addMouseListener(mouseListener);
        mv.mainTable().addMouseListener(mouseListener);
        mv.bg().addMouseListener(mouseListener);
        mv.bg().addMouseMotionListener(mouseMotionListener);
        this.border = mv.getAmountPaidField().getBorder();

    }

}