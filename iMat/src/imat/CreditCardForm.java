/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreditCardForm.java
 *
 * Created on 2013-feb-26, 17:43:30
 */
package imat;
import se.chalmers.ait.dat215.project.*;
import java.util.*;

/**
 *
 * @author Harry
 */
public class CreditCardForm extends javax.swing.JPanel implements TitleLabelInterface {
    private kundvagnPanel kv;
    private double totalPrice;
    private ShoppingCart cart;
    private kvittoPanel kvitto;
    private static String title;
    private boolean homeDeliverySelected;
    private Customer c = IMatDataHandler.getInstance().getCustomer();
    private CreditCard cc = IMatDataHandler.getInstance().getCreditCard();
    /** Creates new form CreditCardForm */
    public CreditCardForm() {
        initComponents();
        title = "Betala";
        initFields();
        
        
        
    }
    
    private void initFields(){
        // Automatic input from saved Customer
        jTextField1.setText(c.getFirstName());
        jTextField4.setText(c.getLastName());
        jTextField6.setText(c.getPostCode());
        jTextField9.setText(c.getPostAddress());
        jTextField2.setText(c.getMobilePhoneNumber());
        jTextField8.setText(c.getPhoneNumber());
        
        jComboBox1.setSelectedItem(cc.getCardType());
        jTextField7.setText(cc.getCardNumber());
        jComboBox2.setSelectedItem(cc.getValidMonth());
        jComboBox4.setSelectedItem(cc.getValidYear());
        jTextField10.setText(""+cc.getVerificationCode());
      
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTextField3.setName("jTextField3"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(imat.IMatApp.class).getContext().getResourceMap(CreditCardForm.class);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jTextField5.setName("jTextField5"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setName("jComboBox3"); // NOI18N

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        setName("Form"); // NOI18N

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setName("jLabel1"); // NOI18N

        jTextField2.setName("jTextField2"); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setName("jLabel2"); // NOI18N

        jTextField4.setName("jTextField4"); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setName("jLabel4"); // NOI18N

        jTextField6.setName("jTextField6"); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj..", "MasterCard", "Visa" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel8.setFont(resourceMap.getFont("jLabel8.font")); // NOI18N
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jTextField7.setName("jTextField7"); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setIcon(resourceMap.getIcon("jLabel11.icon")); // NOI18N
        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mån", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox2.setName("jComboBox2"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "År", "13", "14", "15", "16", "17", "18", "19" }));
        jComboBox4.setName("jComboBox4"); // NOI18N

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel13.setName("jLabel13"); // NOI18N

        jTextField8.setName("jTextField8"); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel14.setName("jLabel14"); // NOI18N

        jTextField9.setName("jTextField9"); // NOI18N
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jTextField10.setText(resourceMap.getString("jTextField10.text")); // NOI18N
        jTextField10.setName("jTextField10"); // NOI18N
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        jLabel16.setFont(resourceMap.getFont("jLabel16.font")); // NOI18N
        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText(resourceMap.getString("jRadioButton1.text")); // NOI18N
        jRadioButton1.setName("jRadioButton1"); // NOI18N

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText(resourceMap.getString("jRadioButton2.text")); // NOI18N
        jRadioButton2.setName("jRadioButton2"); // NOI18N

        jCheckBox1.setSelected(true);
        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        jCheckBox2.setSelected(true);
        jCheckBox2.setText(resourceMap.getString("jCheckBox2.text")); // NOI18N
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jButton3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jButton4))
                    .add(layout.createSequentialGroup()
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel10)
                                    .add(jLabel9)
                                    .add(jLabel7)
                                    .add(jLabel15))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(jTextField10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)
                                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(layout.createSequentialGroup()
                                                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jLabel12)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jComboBox4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(jCheckBox2))))
                                .add(18, 18, 18)
                                .add(jLabel11))))
                    .add(layout.createSequentialGroup()
                        .add(jRadioButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton2))
                    .add(jLabel16)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jCheckBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(268, 268, 268)))
                .add(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13))
                .add(27, 27, 27)
                .add(jCheckBox1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jComboBox4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel12)
                            .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel10)))
                    .add(jLabel11))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel15)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox2)
                .add(5, 5, 5)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel16)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jRadioButton2))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4)
                    .add(jButton3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public double getTotalPrice(){
        return this.totalPrice;
    }
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
    if (jTextField1 == null || jTextField2 == null || jTextField4 == null||
        jTextField6 == null || jTextField9 == null || jTextField8 == null||
        jTextField7 == null || jTextField10 == null|| jTextField10.getText().length() != 3 
        || jTextField7.getText().length() != 16){
            return;
    }
    
    
    if(jCheckBox1.isSelected()){
        Customer c = IMatDataHandler.getInstance().getCustomer();
        
        
        c.setFirstName(firstLetterUpperCase(jTextField1.getText()));
        c.setLastName(firstLetterUpperCase(jTextField4.getText()));
        
        
        c.setPostCode(jTextField6.getText());
        c.setPostAddress(jTextField9.getText());
        c.setMobilePhoneNumber(jTextField2.getText());
        c.setPhoneNumber(jTextField8.getText());
    }
    // Set input to credit card info
    if(jCheckBox2.isSelected()){
        
        cc.setCardType(jComboBox1.getSelectedItem().toString());
        cc.setCardNumber(jTextField7.getText());
        Integer chosenMonth = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        cc.setValidMonth(chosenMonth); 
        Integer chosenYear = Integer.parseInt(jComboBox4.getSelectedItem().toString());
        cc.setValidYear(chosenYear);
        cc.setVerificationCode(Integer.parseInt(jTextField10.getText()));
    }
     
    
    // Proceed to receipt
    
    kvitto = new kvittoPanel(firstLetterUpperCase(jTextField1.getText())+" "+firstLetterUpperCase(jTextField4.getText()), jTextField9.getText(),jTextField6.getText());
    IMatView.setMainPanelto(kvitto);
    IMatView.splashPanel.addLatestPurchases();

}//GEN-LAST:event_jButton4ActionPerformed

public String firstLetterUpperCase(String s){
    String tmp = s.substring(0, 1);
    tmp = tmp.toUpperCase();
    return tmp+s.substring(1,s.length());
}
public boolean isHomeDeliverySelected(){
    // Useless not supported by backebd
    return this.homeDeliverySelected;
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    kv = new kundvagnPanel();
    IMatView.setMainPanelto(kv);
}//GEN-LAST:event_jButton3ActionPerformed

private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
    char c = evt.getKeyChar();
    if(c < '0' || c > '9'){
        evt.consume();
    }
    
    
}//GEN-LAST:event_jTextField6KeyTyped

private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
char c = evt.getKeyChar();
    if(c < '0' || c > '9'){
        evt.consume();
    }
}//GEN-LAST:event_jTextField2KeyTyped

private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
char c = evt.getKeyChar();
    if(c < '0' || c > '9'){
        evt.consume();
    }
}//GEN-LAST:event_jTextField8KeyTyped

private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
char c = evt.getKeyChar();
    if(c < '0' || c > '9' || jTextField7.getText().length() == 16){
        evt.consume();
    }
}//GEN-LAST:event_jTextField7KeyTyped

private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
    char c = evt.getKeyChar();
    if((c < '0' || c > '9') || jTextField10.getText().length() == 3){
        
        evt.consume();
    }
}//GEN-LAST:event_jTextField10KeyTyped

private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
char c = evt.getKeyChar();
    if(c < 'a' || c > 'z'){
        evt.consume();
    }
}//GEN-LAST:event_jTextField1KeyTyped

private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
char c = evt.getKeyChar();
    if(c < 'a' || c > 'z'){
        evt.consume();
    }
}//GEN-LAST:event_jTextField4KeyTyped

private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
    /*char c = evt.getKeyChar();
    if(c < 'a' || c > 'z'){
        evt.consume();
    }*/
}//GEN-LAST:event_jTextField9KeyTyped


public String getTitle() {
        return title;
    }

    public void setTitle(String s) {
        ;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}
