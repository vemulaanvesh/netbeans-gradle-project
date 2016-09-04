package org.netbeans.gradle.project.properties.ui;

import java.io.File;
import java.net.URL;
import org.netbeans.gradle.project.api.config.ActiveSettingsQuery;
import org.netbeans.gradle.project.api.config.PropertyReference;
import org.netbeans.gradle.project.properties.GradleLocation;
import org.netbeans.gradle.project.properties.GradleLocationDef;
import org.netbeans.gradle.project.properties.global.CommonGlobalSettings;
import org.netbeans.gradle.project.properties.global.GlobalSettingsEditor;
import org.netbeans.gradle.project.properties.global.SettingsEditorProperties;
import org.netbeans.gradle.project.util.NbFileUtils;
import org.openide.filesystems.FileChooserBuilder;

@SuppressWarnings("serial")
public class GradleInstallationPanel extends javax.swing.JPanel implements GlobalSettingsEditor {
    private static final URL HELP_URL = NbFileUtils.getSafeURL("https://github.com/kelemen/netbeans-gradle-project/wiki/Gradle-Installation");

    private GradleLocation selectedGradleLocation;

    public GradleInstallationPanel() {
        selectedGradleLocation = null;

        initComponents();
    }

    private void selectGradleLocation(GradleLocation newLocation) {
        selectedGradleLocation = newLocation;
        jGradleLocationDescription.setText(newLocation != null ? newLocation.toLocalizedString() : "");
    }

    @Override
    public final void updateSettings(ActiveSettingsQuery globalSettings) {
        PropertyReference<GradleLocationDef> gradleLocation = CommonGlobalSettings.gradleLocation(globalSettings);
        PropertyReference<File> gradleUserHomeDir = CommonGlobalSettings.gradleUserHomeDir(globalSettings);

        GradleLocationDef locationDef = gradleLocation.getActiveValue();
        if (locationDef != null) {
            selectGradleLocation(locationDef.getLocation());
            jPreferWrapperCheck.setSelected(locationDef.isPreferWrapper());
        }
        else {
            selectGradleLocation(null);
            jPreferWrapperCheck.setSelected(false);
        }

        File userHome = gradleUserHomeDir.getActiveValue();
        jGradleUserHomeEdit.setText(userHome != null ? userHome.getPath() : "");
    }

    @Override
    public final void saveSettings(ActiveSettingsQuery globalSettings) {
        PropertyReference<GradleLocationDef> gradleLocation = CommonGlobalSettings.gradleLocation(globalSettings);
        PropertyReference<File> gradleUserHomeDir = CommonGlobalSettings.gradleUserHomeDir(globalSettings);

        gradleLocation.setValue(getGradleLocationDef());
        gradleUserHomeDir.setValue(getGradleUserHomeDir());
    }

    @Override
    public SettingsEditorProperties getProperties() {
        SettingsEditorProperties.Builder result = new SettingsEditorProperties.Builder(this);
        result.setHelpUrl(HELP_URL);

        return result.create();
    }

    private GradleLocationDef getGradleLocationDef() {
        if (selectedGradleLocation == null) {
            return null;
        }

        return new GradleLocationDef(selectedGradleLocation, jPreferWrapperCheck.isSelected());
    }

    private File getGradleUserHomeDir() {
        String result = jGradleUserHomeEdit.getText();
        if (result == null) {
            return null;
        }

        result = result.trim();
        return result.isEmpty() ? null : new File(result);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jGradlePathCaption = new javax.swing.JLabel();
        jGradleLocationDescription = new javax.swing.JTextField();
        jChangeGradleLocationButton = new javax.swing.JButton();
        jGradleUserHomeCaption = new javax.swing.JLabel();
        jGradleUserHomeEdit = new javax.swing.JTextField();
        jBrowseUserHomeDirButton = new javax.swing.JButton();
        jPreferWrapperCheck = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jGradlePathCaption, org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jGradlePathCaption.text")); // NOI18N

        jGradleLocationDescription.setEditable(false);
        jGradleLocationDescription.setText(org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jGradleLocationDescription.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jChangeGradleLocationButton, org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jChangeGradleLocationButton.text")); // NOI18N
        jChangeGradleLocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeGradleLocationButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jGradleUserHomeCaption, org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jGradleUserHomeCaption.text")); // NOI18N

        jGradleUserHomeEdit.setText(org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jGradleUserHomeEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jBrowseUserHomeDirButton, org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jBrowseUserHomeDirButton.text")); // NOI18N
        jBrowseUserHomeDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseUserHomeDirButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jPreferWrapperCheck, org.openide.util.NbBundle.getMessage(GradleInstallationPanel.class, "GradleInstallationPanel.jPreferWrapperCheck.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jGradleUserHomeEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGradlePathCaption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addComponent(jBrowseUserHomeDirButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jGradleUserHomeCaption)
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jChangeGradleLocationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGradleLocationDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPreferWrapperCheck)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGradlePathCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGradleLocationDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChangeGradleLocationButton)
                    .addComponent(jPreferWrapperCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGradleUserHomeCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGradleUserHomeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBrowseUserHomeDirButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jChangeGradleLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeGradleLocationButtonActionPerformed
        GradleLocation currentLocation = selectedGradleLocation;
        GradleLocation newLocation = GradleLocationPanel.tryChooseLocation(this, currentLocation);
        if (newLocation != null) {
            selectGradleLocation(newLocation);
        }
    }//GEN-LAST:event_jChangeGradleLocationButtonActionPerformed

    private void jBrowseUserHomeDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseUserHomeDirButtonActionPerformed
        FileChooserBuilder dlgChooser = new FileChooserBuilder(GradleInstallationPanel.class);
        dlgChooser.setDirectoriesOnly(true);

        File f = dlgChooser.showOpenDialog();
        if (f != null && f.isDirectory()) {
            File file = f.getAbsoluteFile();
            jGradleUserHomeEdit.setText(file.toString());
        }
    }//GEN-LAST:event_jBrowseUserHomeDirButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBrowseUserHomeDirButton;
    private javax.swing.JButton jChangeGradleLocationButton;
    private javax.swing.JTextField jGradleLocationDescription;
    private javax.swing.JLabel jGradlePathCaption;
    private javax.swing.JLabel jGradleUserHomeCaption;
    private javax.swing.JTextField jGradleUserHomeEdit;
    private javax.swing.JCheckBox jPreferWrapperCheck;
    // End of variables declaration//GEN-END:variables
}
