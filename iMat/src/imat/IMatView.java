/*
 * IMatView.java
 */

package imat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.LinkedList;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.util.List;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * The application's main frame.
 */
public class IMatView extends FrameView {
    public static List<ShoppingItemList> savedShoppingListItems;
    
    private static JPanel currentMainPanel;
    private static List<JPanel> mainPanelHistory;
    private static int historyLocation;
    public static SplashPanel splashPanel;
    public static kundvagnPanel cartPanel;
    public static SavedListsPanel historyPanel;
    public static SavedListsPanel savedListsPanel;
    private FoodMatrixPanel favoritePanel;
    private static List<Product> shoppingItems;
    public static SettingsPanel settingsPanel;
    
    public IMatView(SingleFrameApplication app) {
        super(app);
        
        initComponents();
        manuallyInitComponents();
        mainPanelHistory = new ArrayList<JPanel>();
        
        cartPanel = new kundvagnPanel();
        shoppingItems = new ArrayList<Product>();
        historyPanel = new SavedListsPanel("Tidigare inköp", null);
        settingsPanel = new SettingsPanel();
        
        favoritePanel  = new FoodMatrixPanel("Favoriter");
        IMatDataHandler.getInstance().getShoppingCart().
                addShoppingCartListener(new CartListener());
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        
        //Done for later use
        savedShoppingListItems = ListSaveLoad.getInstance().loadList();
        savedListsPanel = new SavedListsPanel("Sparade inköpslistor", savedShoppingListItems);
        
        splashPanel = new SplashPanel();
        splashPanel.addLatestPurchases();
        splashPanel.addSavedPurchases(savedShoppingListItems);
        
        setMainPanelto(splashPanel);
        if(IMatDataHandler.getInstance().getShoppingCart().getItems().isEmpty()){
            kundvagnPanel.betalaBtn.setEnabled(false);
            kundvagnPanel.emptyCartBtn.setEnabled(false);
            kundvagnPanel.sparaInkopBtn.setEnabled(false);
        }
        savedListsPanel.updateShoppingList();
        historyPanel.updateHistoryList();
        
        jLabel2.setText(IMatDataHandler.getInstance().getShoppingCart().getItems().size() + " varor");
        jLabel3.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + " kr");
    }
    public static List<Product> getShoppingItems() {
        return shoppingItems;
    }
    
    private void changeToPreviousMainPanel() {

        if (historyLocation != 0) {
            historyLocation--;
            changeMainPanel(mainPanelHistory.get(historyLocation));
        }
    }
    private void changeToNextMainPanel() {
        if (historyLocation!= mainPanelHistory.size()-1) {
            historyLocation++;
            changeMainPanel(mainPanelHistory.get(historyLocation));
        }
    }
    private static void changeMainPanel(JPanel panel){
            jPanel4.removeAll();
            currentMainPanel = panel;
            jPanel4.add(panel, BorderLayout.CENTER);
            
            
            if(panel instanceof TitleLabelInterface){
                TitleLabelInterface p = (TitleLabelInterface)panel;
                setTitle(p.getTitle());
            }
            
            jPanel4.revalidate();
            jPanel4.repaint();
    }
    
    public static void clearLatest(){
        jPanel7.removeAll();
        shoppingItems.clear();
        jPanel7.revalidate();
        jPanel7.repaint();
    }
    
    public static void setMainPanelto(JPanel panel) {
        if(mainPanelHistory.isEmpty() || panel != mainPanelHistory.get(historyLocation)) {
            mainPanelHistory.add(panel);
            historyLocation = mainPanelHistory.size()-1;
            changeMainPanel(panel);
            panel.revalidate();
        }
        
    }
    //TODO rename, this isnt the mainpanel,
    //it is the panel holding the main panel
    public static JPanel getMainPanel() {
        return jPanel4;
    }
    
    public static void saveShoppingLists(){
        System.out.println(IMatView.savedShoppingListItems.size());
        ListSaveLoad.getInstance().saveList(savedShoppingListItems);
    }
    /**
     * private class responsible for updating texts when
     * changes are made to the shoppingCart.
     */
    private class CartListener implements ShoppingCartListener{
        private void setCartLabels(ShoppingCart cart) {
            jLabel2.setText(cart.getItems().size() + " varor");
            jLabel3.setText(cart.getTotal() + " kr");
        }
        
        public void shoppingCartChanged(CartEvent ce) {
            if(IMatDataHandler.getInstance().getShoppingCart().getItems().isEmpty()){
                kundvagnPanel.betalaBtn.setEnabled(false);
                kundvagnPanel.emptyCartBtn.setEnabled(false);
                kundvagnPanel.sparaInkopBtn.setEnabled(false);
            }else{
                kundvagnPanel.betalaBtn.setEnabled(true);
                kundvagnPanel.emptyCartBtn.setEnabled(true);
                kundvagnPanel.sparaInkopBtn.setEnabled(true);
            }
            ShoppingCart cart = IMatDataHandler.getInstance().
                    getShoppingCart();
            setCartLabels(cart);
            if(ce.getShoppingItem() == null) {
                return;
            }
            for(Component panel : jPanel7.getComponents()) {
                LatestPurchasePanel lPanel = ((LatestPurchasePanel)panel); 
                if(lPanel.getItem().getProduct() == ce.getShoppingItem().getProduct()) {
                    lPanel.setItem(ce.getShoppingItem());
                    lPanel.updateTexts();
                }
            }
            if(ce.isAddEvent()) {
                boolean itemAlreadyInList = false;
                for(Product item : shoppingItems) {
                    itemAlreadyInList |= item.equals(ce.getShoppingItem().getProduct());
                }
                
                if(!itemAlreadyInList || shoppingItems.isEmpty()) {
                    LatestPurchasePanel lpp = new LatestPurchasePanel(ce.getShoppingItem());
                    if(jPanel7.getComponentCount() < 1) {
                        addPurchasePanel(lpp, BorderLayout.NORTH);
                    } else if(jPanel7.getComponentCount() > 1) {
                        shoppingItems.remove(0);
                        jPanel7.remove(0);
                        jPanel7.revalidate();
                        jPanel7.repaint();
                        Component comp = jPanel7.getComponent(0);
                        jPanel7.remove(0);
                        jPanel7.add(comp, BorderLayout.NORTH);
                        this.addPurchasePanel(lpp, BorderLayout.SOUTH);
                    } else {
                        this.addPurchasePanel(lpp, BorderLayout.SOUTH);
                    }
                }
            }
            jPanel7.revalidate();
            jPanel7.repaint();
        }
        private void addPurchasePanel(LatestPurchasePanel lpp, String layout) {
            jPanel7.add(lpp, layout);
            shoppingItems.add(lpp.getItem().getProduct());
        }
    }
    
    public static void setTitle(String s){
        jLabel1.setText(s);
    }
    /**
     * Overrides certain initation manually that aren't allowed by netbeans
     */
    private void manuallyInitComponents() {
        jButton1.setBorder(BorderFactory.createEmptyBorder());
        jButton1.setContentAreaFilled(false);
        jButton2.setBorder(BorderFactory.createEmptyBorder());
        jButton2.setContentAreaFilled(false);
        jButton3.setBorder(BorderFactory.createEmptyBorder());
        jButton3.setContentAreaFilled(false);
        jButton4.setBorder(BorderFactory.createEmptyBorder());
        jButton4.setContentAreaFilled(false);
        jButton5.setBorder(BorderFactory.createEmptyBorder());
        jButton5.setContentAreaFilled(false);
        jButton8.setBorder(BorderFactory.createEmptyBorder());
        jButton8.setContentAreaFilled(false);
    }
    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = IMatApp.getApplication().getMainFrame();
            aboutBox = new IMatAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        IMatApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchPanel1 = new imat.SearchPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(imat.IMatApp.class).getContext().getResourceMap(IMatView.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(resourceMap.getColor("jPanel6.background")); // NOI18N
        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel6.add(jLabel4);

        jPanel1.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(550, 80));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(resourceMap.getColor("jPanel9.background")); // NOI18N
        jPanel9.setName("jPanel9"); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(350, 80));

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 81));

        jLabel2.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/resources/cartIconSmall.png"))); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setToolTipText(resourceMap.getString("jButton5.toolTipText")); // NOI18N
        jButton5.setAutoscrolls(true);
        jButton5.setBorderPainted(false);
        jButton5.setName("jButton5"); // NOI18N
        jButton5.setPressedIcon(resourceMap.getIcon("jButton5.pressedIcon")); // NOI18N
        jButton5.setRolloverIcon(resourceMap.getIcon("jButton5.rolloverIcon")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(resourceMap.getColor("jPanel7.background")); // NOI18N
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jPanel7.border.border.lineColor")), resourceMap.getString("jPanel7.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel7.border.titleFont"), resourceMap.getColor("jPanel7.border.titleColor"))); // NOI18N
        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 80));
        jPanel7.setVerifyInputWhenFocusTarget(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jSeparator1.setForeground(resourceMap.getColor("jSeparator1.foreground")); // NOI18N
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setName("jSeparator1"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton5)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton8.setIcon(resourceMap.getIcon("jButton8.icon")); // NOI18N
        jButton8.setToolTipText(resourceMap.getString("jButton8.toolTipText")); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setName("jButton8"); // NOI18N
        jButton8.setPressedIcon(resourceMap.getIcon("jButton8.pressedIcon")); // NOI18N
        jButton8.setRolloverIcon(resourceMap.getIcon("jButton8.rolloverIcon")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setToolTipText(resourceMap.getString("jButton4.toolTipText")); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setPressedIcon(resourceMap.getIcon("jButton4.pressedIcon")); // NOI18N
        jButton4.setRolloverIcon(resourceMap.getIcon("jButton4.rolloverIcon")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setToolTipText(resourceMap.getString("jButton3.toolTipText")); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setPressedIcon(resourceMap.getIcon("jButton3.pressedIcon")); // NOI18N
        jButton3.setRolloverIcon(resourceMap.getIcon("jButton3.rolloverIcon")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setToolTipText(resourceMap.getString("jButton2.toolTipText")); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setPressedIcon(resourceMap.getIcon("jButton2.pressedIcon")); // NOI18N
        jButton2.setRolloverIcon(resourceMap.getIcon("jButton2.rolloverIcon")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setToolTipText(resourceMap.getString("jButton1.toolTipText")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setPressedIcon(resourceMap.getIcon("jButton1.pressedIcon")); // NOI18N
        jButton1.setRolloverIcon(resourceMap.getIcon("jButton1.rolloverIcon")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(resourceMap.getIcon("jLabel5.icon")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton8))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel3.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

        searchPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("searchPanel1.border.lineColor"))); // NOI18N
        searchPanel1.setName("searchPanel1"); // NOI18N
        mainPanel.add(searchPanel1, java.awt.BorderLayout.WEST);

        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel4.setName("jPanel4"); // NOI18N
        jScrollPane1.setViewportView(jPanel4);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(resourceMap.getColor("jPanel8.background")); // NOI18N
        jPanel8.setForeground(resourceMap.getColor("jPanel8.foreground")); // NOI18N
        jPanel8.setName("jPanel8"); // NOI18N

        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(resourceMap.getIcon("jButton7.icon")); // NOI18N
        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton6)
                .addComponent(jButton7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        mainPanel.add(jPanel5, java.awt.BorderLayout.CENTER);

        setComponent(mainPanel);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setMainPanelto(splashPanel);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseMoved
// TODO add your handling code here:
}//GEN-LAST:event_jButton1MouseMoved

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    setMainPanelto(savedListsPanel);
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    setMainPanelto(cartPanel);
    cartPanel.updateCart();
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    changeToPreviousMainPanel();
}//GEN-LAST:event_jButton7ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    changeToNextMainPanel();
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    historyPanel.updateHistoryList();
    setMainPanelto(historyPanel);
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    List<Product> favList = IMatDataHandler.getInstance().favorites();
        
    favoritePanel.removePanels();
    
    for(Product p: favList){
        favoritePanel.addPanels(new FoodPanel(p, 120, 120));
    }
    favoritePanel.setLayout(((favList.size()/3)+1), 3);
    setMainPanelto(favoritePanel);
    favoritePanel.repaint();
    favoritePanel.revalidate();
    
    IMatDataHandler.getInstance().shutDown();
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    setMainPanelto(settingsPanel);
    settingsPanel.update();
}//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private static javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private imat.SearchPanel searchPanel1;
    // End of variables declaration//GEN-END:variables

    
    private JDialog aboutBox;
}
