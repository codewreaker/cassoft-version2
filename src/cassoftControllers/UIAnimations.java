/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;


import cassoftViews.MainView;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Prophet
 */
public class UIAnimations {

    private MouseMotionListener mouseMotionListener;
    private MouseListener mouseListener;
    private MainView mv;    
    private int xMouse;
    private int yMouse;
    private Border border;
    private int counter = 1;
    public static String surName;
    public static String firstName;

    public UIAnimations(MainView mv) {
        this.mv = mv;        
        hidePaymentDetails();
        mv.setVisible(true);
        mv.fullscreen().setVisible(false);
        control();
    }

    /**
     * This method initiates the listeners.
     */
    private void control() {
        mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == mv.close()) {
                    if (JOptionPane.showConfirmDialog(mv, "Are you sure you want to quit?") == 0) {
                        System.exit(0);
                    }
                } else if (e.getSource() == mv.minimise()) {
                } else if (e.getSource() == mv.maximise()) {
                    switchWindows();
                } else if (e.getSource() == mv.fullscreen()) {
                    fullscreenWindow();
                } else if (e.getSource() == mv.studHistory()) {
                } else if (e.getSource() == mv.studView()) {
                } else if (e.getSource() == mv.studDelete()) {
                } else if (e.getSource() == mv.studPay()) {
                    hidePaymentDetails();
                } else if (e.getSource() == mv.settingsBtn()) {
                } else if (e.getSource() == mv.addStudent()) {
                } else if (e.getSource() == mv.viewHistory()) {
                } else if (e.getSource() == mv.searchComboBox()) {
                    mv.search().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-01.png")));
                } else if (e.getSource() == mv.search()) {
                } else if (e.getSource() == mv.saveButton()) {
                } else if (e.getSource() == mv.mainTable()) {
                } else if (e.getSource() == mv.home()) {
                } else {
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX() + 5;
                yMouse = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {/**/ }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == mv.close()) {
                } else if (e.getSource() == mv.minimise()) {
                } else if (e.getSource() == mv.maximise()) {
                } else if (e.getSource() == mv.studHistory()) {
                    mv.studHistory().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/history-01.png")));
                } else if (e.getSource() == mv.studView()) {
                    mv.studView().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view-01.png")));
                } else if (e.getSource() == mv.studDelete()) {
                    mv.studDelete().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-01.png")));
                } else if (e.getSource() == mv.studPay()) {
                    mv.studPay().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay-01.png")));
                } else if (e.getSource() == mv.settingsBtn()) {
                    mv.settingsBtn().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings-01.png")));
                } else if (e.getSource() == mv.addStudent()) {
                    mv.addStudent().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_student-01.png")));
                } else if (e.getSource() == mv.viewHistory()) {
                    mv.viewHistory().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/summary-01.png")));
                } else if (e.getSource() == mv.home()) {
                    mv.home().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home-01.png")));
                } else {
                    //System.out.println("Where have you clicked");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == mv.close()) {
                } else if (e.getSource() == mv.minimise()) {
                    mv.setState(Frame.ICONIFIED);
                } else if (e.getSource() == mv.maximise()) {
                } else if (e.getSource() == mv.studHistory()) {
                    mv.studHistory().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/history.png")));
                } else if (e.getSource() == mv.studView()) {
                    mv.studView().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view.png")));
                } else if (e.getSource() == mv.studDelete()) {
                    mv.studDelete().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png")));
                } else if (e.getSource() == mv.studPay()) {
                    mv.studPay().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay.png")));
                } else if (e.getSource() == mv.settingsBtn()) {
                    mv.settingsBtn().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png")));
                } else if (e.getSource() == mv.addStudent()) {
                    mv.addStudent().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_student.png")));
                } else if (e.getSource() == mv.viewHistory()) {
                    mv.viewHistory().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/summary.png")));
                } else if (e.getSource() == mv.search()) {
                    mv.search().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));
                } else if (e.getSource() == mv.home()) {
                    mv.home().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png")));
                } else {
                    //System.out.println("Where have you clicked");
                }

            }

        };

        mouseMotionListener = new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                mv.setLocation(x - xMouse, y - yMouse);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };

        mv.close().addMouseListener(mouseListener);
        mv.minimise().addMouseListener(mouseListener);
        mv.maximise().addMouseListener(mouseListener);
        mv.studHistory().addMouseListener(mouseListener);
        mv.studView().addMouseListener(mouseListener);
        mv.studDelete().addMouseListener(mouseListener);
        mv.amountPaidLabel().addMouseListener(mouseListener);
        mv.getAmountPaidField().addMouseListener(mouseListener);
        mv.studPay().addMouseListener(mouseListener);
        mv.settingsBtn().addMouseListener(mouseListener);
        mv.addStudent().addMouseListener(mouseListener);
        mv.saveButton().addMouseListener(mouseListener);
        mv.viewHistory().addMouseListener(mouseListener);
        mv.search().addMouseListener(mouseListener);
        mv.home().addMouseListener(mouseListener);
        mv.fullscreen().addMouseListener(mouseListener);
        //mv.searchTextField().addMouseListener(mouseListener);
        mv.mainTable().addMouseListener(mouseListener);
        mv.bg().addMouseListener(mouseListener);
        mv.bg().addMouseMotionListener(mouseMotionListener);
        this.border = mv.getAmountPaidField().getBorder();
    }

    /**
     * A method that hides and shows the payment details on-click
     */
    private void hidePaymentDetails() {
        if (counter % 2 != 0) {
            mv.saveButton().setVisible(false);
            mv.amountPaidLabel().setVisible(false);
            mv.getAmountPaidField().setVisible(false);
            mv.getCategoryComboBox().setVisible(false);
        } else {
            mv.saveButton().setVisible(true);
            mv.amountPaidLabel().setVisible(true);
            mv.getAmountPaidField().setVisible(true);
            mv.getCategoryComboBox().setVisible(true);
        }
        counter++;
    }

    /**
     * A method that switches the screen between fullscreen and maximised
     */
    private void switchWindows() {
            //This clause minimises
            mv.bg().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/UI-02.png")));
            mv.dispose();
            mv.setUndecorated(false);
            mv.setVisible(true);
            mv.minimise().setVisible(false);            
            mv.maximise().setVisible(false);
            mv.fullscreen().setVisible(true);
            mv.close().setVisible(false);
    }
    
    private void fullscreenWindow(){
        // This clause maximises
            mv.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mv.bg().setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/UI-02.png")));
            mv.dispose();  
            mv.setUndecorated(true);
            mv.setVisible(true);
            mv.minimise().setVisible(true);
            mv.fullscreen().setVisible(false);
            mv.maximise().setVisible(true);
            mv.close().setVisible(true);
    }
}
