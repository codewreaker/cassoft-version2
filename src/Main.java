
import controllers.LoginController;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import models.Database;
import views.Login;
import views.MainView;

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
                MainView mv = new MainView();
                Database db = new Database();
                Login lg = new Login();
                LoginController lc = new LoginController(lg, mv, db);
                lc.control();
            }
        });
    }
}
