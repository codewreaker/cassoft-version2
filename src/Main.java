import cassoftControllers.SetUp;
import cassoftControllers.UIAnimations;
import cassoftViews.Login;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import cassoftViews.MainView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Israel Agyeman-Prempeh
 */
public class Main {

    public static void main(String ags[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }//Create and show the GUI.

        /*Setting Icon*/
        //</editor-fold>
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SetUp sp = new SetUp();
                if (sp.hasCredentials()) {
                    /**
                     * credentials.txt is first checked if it exists, the database is connected to
                     * using data from credentials.txt, if credentials.txt does not exist the Set Up
                     * Window pops up to allow the user to specify the details
                     * 
                     * The login is the normal user authentication that uses the login
                     * 
                     * TODO
                     * get the mysql user and password from the setup class and use the data to connect
                     * to the database and authenticate the user like previously
                     */
                    Login login = new Login();
                    MainView mv = new MainView();
                    UIAnimations ui = new UIAnimations(mv);
                    ui.control();
                }

            }
        });
    }
}
