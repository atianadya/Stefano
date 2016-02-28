/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author atia
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setTitle("Stefanography");
        buttonGroup.add(stefanoRadioButton);
        buttonGroup.add(antistefanoRadioButton);
        stefanoRadioButton.setSelected(true);
        browseStefanoButton.setEnabled(false);
        extractButton.setEnabled(false);
        
        RadioListener listener = new RadioListener(browseCoverButton, insertButton, browseStefanoButton, extractButton);
        
        stefanoRadioButton.addActionListener(listener);
        antistefanoRadioButton.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        browseCoverButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        encryptCheckBox = new javax.swing.JCheckBox();
        browseStefanoButton = new javax.swing.JButton();
        extractButton = new javax.swing.JButton();
        keyField = new javax.swing.JTextField();
        stefanoRadioButton = new javax.swing.JRadioButton();
        antistefanoRadioButton = new javax.swing.JRadioButton();
        insertButton = new javax.swing.JButton();
        saveTextButton = new javax.swing.JButton();
        thresholdSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        browseCoverButton.setText("Browse Cover File");
        browseCoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseCoverButtonActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        jLabel1.setText("Message");

        jLabel2.setText("Key");

        encryptCheckBox.setSelected(true);
        encryptCheckBox.setText("Encrypt Message");

        browseStefanoButton.setText("Browse Stefano");
        browseStefanoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseStefanoButtonActionPerformed(evt);
            }
        });

        extractButton.setText("Extract Stefano");
        extractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractButtonActionPerformed(evt);
            }
        });

        stefanoRadioButton.setText("Stefanoify");

        antistefanoRadioButton.setText("Anti-stefanoify");

        insertButton.setText("Insert Message");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        saveTextButton.setText("Save Text");
        saveTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTextButtonActionPerformed(evt);
            }
        });

        thresholdSlider.setMaximum(1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(browseCoverButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseStefanoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extractButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(encryptCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveTextButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(stefanoRadioButton)
                            .addComponent(antistefanoRadioButton)
                            .addComponent(keyField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(thresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(keyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(stefanoRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antistefanoRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptCheckBox)
                    .addComponent(saveTextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(thresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseCoverButton)
                    .addComponent(browseStefanoButton)
                    .addComponent(extractButton)
                    .addComponent(insertButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseCoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseCoverButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getPath());
            InputImage.setImage(chooser.getSelectedFile().getPath());
            JDialog coverDialog = new JDialog();
            JLabel label = new JLabel (new ImageIcon(chooser.getSelectedFile().getPath()));
            coverDialog.setTitle("Cover Image");
            coverDialog.add(label);
            coverDialog.pack();
            coverDialog.setVisible(true);
        }
        
    }//GEN-LAST:event_browseCoverButtonActionPerformed

    private void browseStefanoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseStefanoButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getPath());
            InputImage.setImage(chooser.getSelectedFile().getPath());
        }
        
    }//GEN-LAST:event_browseStefanoButtonActionPerformed

    private void extractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractButtonActionPerformed
        if (!InputImage.isNull()) {
            // extract message from image
            // put message in text area
            // ???
            // profit
        }
    }//GEN-LAST:event_extractButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        String msg = "";
        String key = keyField.getText();
        key = key.length() > 25 ? key.substring(0, 25) : key;
        
        if (encryptCheckBox.isSelected()) {
            // encrypt with vigenere first okkkk
        }
        
        StegaDialog stegaDialog = new StegaDialog(this,false);
        
        // calculate psnr pl0x --> psnrValLabel
        
        stegaDialog.setTitle("Stefano Image");
        if (!InputImage.isNull()) {
            ImageIcon imgicon = new ImageIcon(InputImage.getImage());
            stegaDialog.setLabel(imgicon);
        } else {
            System.out.println("null");
        }
        stegaDialog.pack();
        stegaDialog.setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void saveTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTextButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.addChoosableFileFilter(filter);
        BufferedWriter writer = null;
        int returnval = chooser.showSaveDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String filename = file.getPath();
            try {
                writer = new BufferedWriter( new FileWriter( filename+".txt"));
                writer.write(textArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(this, "Yheeeeyy",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Neeeeyy!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        if (returnval == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel");
        }
    }//GEN-LAST:event_saveTextButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton antistefanoRadioButton;
    private javax.swing.JButton browseCoverButton;
    private javax.swing.JButton browseStefanoButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox encryptCheckBox;
    private javax.swing.JButton extractButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyField;
    private javax.swing.JButton saveTextButton;
    private javax.swing.JRadioButton stefanoRadioButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JSlider thresholdSlider;
    // End of variables declaration//GEN-END:variables
}