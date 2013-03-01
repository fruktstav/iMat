/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShoppingListPanel.java
 *
 * Created on 2013-feb-23, 00:27:30
 */
package imat;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import se.chalmers.ait.dat215.project.*;
/**
 *
 * @author victorsandell
 */
public class ShoppingListPanel extends javax.swing.JPanel {

    /** Creates new form ShoppingListPanel */
    public ShoppingListPanel(/*Order order*/) {
        initComponents();
        
        jPanel2.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < 9; i++){
            Product p = new Product();
            p = IMatDataHandler.getInstance().getProduct(i+10);
            ImageIcon icon = IMatDataHandler.getInstance().
                    getImageIcon(p, 55, 55);
            jPanel2.add(new JLabel(icon));
        }
    }
    
    public void setList(ArrayList<String> s){
        //addWhatNot()
    }
    
    public void addFoodImage(Icon icon){
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(175, 220));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(175, 220));
        setSize(new java.awt.Dimension(175, 220));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(imat.IMatApp.class).getContext().getResourceMap(ShoppingListPanel.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2, java.awt.BorderLayout.WEST);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(6, 3));
        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(20, 24));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jPanel3.add(jButton1, java.awt.BorderLayout.EAST);

        add(jPanel3, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}