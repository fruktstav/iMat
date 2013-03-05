/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FoodPanel.java
 *
 * Created on 2013-feb-22, 16:23:07
 */
package imat;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import se.chalmers.ait.dat215.project.*;
/**
 *
 * @author victorsandell
 */
public class FoodMatrixPanel extends javax.swing.JPanel implements TitleLabelInterface{
    
    private String title;
    
    public FoodMatrixPanel(String title) {
        initComponents();
        foodPanels = new ArrayList<FoodPanel>();
        this.title = title;
        totalHeight = 225;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(742, 644));

        jPanel2.setName("jPanel2"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(614, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String s){
        this.title = s;
    }
    
    public void setLayout(int row, int col){
        jPanel2.setLayout(new GridLayout(row, 3, 10, 10));
    }
    public void addPanels(FoodPanel p){
        p.revalidate();
        jPanel2.add(p);
        this.repaint();
        
        if(foodPanels.size() % 3 == 0){
            totalHeight += 175;
        }
        if(foodPanels.size() <= 4)
            this.setPreferredSize(new Dimension(400, totalHeight));
        else
            this.setPreferredSize(new Dimension(550, totalHeight));
        foodPanels.add(p);
        reDraw();
    }

    public void removePanels() {
        jPanel2.removeAll();
        totalHeight = 225;
        foodPanels.clear();
    }
    
    public void reDraw(){
        for(FoodPanel fp: foodPanels){
            fp.setStar();
        }
    }
    
    private List<FoodPanel> foodPanels;
    private int totalHeight;
}
