/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftViews.Settings;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Seamus
 */
public class SettingsController {

    private Settings settings;
    private Database database;
    private ActionListener actionListener;
    private Border border;

    public SettingsController(Settings settings, Database database) {
        this.settings = settings;
        this.database = database;
        settings.setVisible(true);
        showCurrentSettings();
    }

    public void control() {
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == settings.getAdminSaveBtn()) {
                    saveSettings();
                }
            }
        };
        settings.getAdminSaveBtn().addActionListener(actionListener);
        settings.getFeedingTextField().getBorder();
    }

    public void saveSettings() {
        try {
            int year = Integer.parseInt((String) settings.getSchoolYearComboBox().getSelectedItem());
            int term = Integer.parseInt((String) settings.getSchoolTermComboBox().getSelectedItem());
            double schoolFee = Double.parseDouble((String) settings.getSchoolFeesTextField().getText());
            double feedingFee = Double.parseDouble((String) settings.getFeedingTextField().getText());
            double classesFee = Double.parseDouble((String) settings.getClassesTextField().getText());

            if (database.updateSettings(year, term, schoolFee, feedingFee, classesFee)) {
                JOptionPane.showMessageDialog(settings, "Settings Saved.");
                settings.dispose();
            } else {
                JOptionPane.showMessageDialog(settings, "Failed.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(settings, "Please double check the amounts entered.");
            Toolkit.getDefaultToolkit().beep();
        }

    }

    public void showCurrentSettings() {
        ArrayList array = database.getSetting();
        if(array.isEmpty()){
            return;
        }
        settings.getSchoolYearComboBox().setSelectedItem(array.get(0) + "");
        settings.getSchoolTermComboBox().setSelectedItem(array.get(1) + "");
        settings.getSchoolFeesTextField().setText(array.get(2) + "");
        settings.getClassesTextField().setText(array.get(3) + "");
        settings.getFeedingTextField().setText(array.get(4) + "");
    }
}
