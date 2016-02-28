/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptobpcs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author atia
 */
public class RadioListener implements ActionListener {
    private JButton jbutton1;
    private JButton jbutton2;
    private JButton jbutton3;
    private JButton jbutton4;
    
    public RadioListener (JButton j1, JButton j2, JButton j3, JButton j4) {
        this.jbutton1 = j1;
        this.jbutton2 = j2;
        this.jbutton3 = j3;
        this.jbutton4 = j4;
    }
    
    public void actionPerformed(ActionEvent e) {
        JRadioButton radioButton = (JRadioButton) e.getSource();
        
        if (radioButton.getText().equals("Stefanoify")) {
            jbutton1.setEnabled(true);
            jbutton2.setEnabled(true);
            jbutton3.setEnabled(false);
            jbutton4.setEnabled(false);
        } else {
            jbutton1.setEnabled(false);
            jbutton2.setEnabled(false);
            jbutton3.setEnabled(true);
            jbutton4.setEnabled(true);
        }
    }
}
