
 package com.odl.userinterface;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.odl.bean.User;
import com.odl.facade.ODLDataFacade;

/**
 * The Class PhysicianAssignCategoryObservationType.
 *
 * @author pejakalabhargava
 * @author amitkatti
 *
 */
public class PhysicianAssignCategoryObservationType extends javax.swing.JFrame {

	/** The user. */
	User user;
    
    /** The parent frame. */
    PhysicianLandingScreen parentFrame;
    
    /** The data facade. */
    ODLDataFacade dataFacade = new ODLDataFacade();
    
    /** The category list. */
    Map<String,String>  categoryList = new HashMap<String,String>();
    
    /** The obs type list. */
    Map<String,String>  obsTypeList = new HashMap<String,String>();

	/**
	 * Creates new form AssignPatientToClass.
	 *
	 * @param user the user
	 * @param landingFrameForUser the landing frame for user
	 */
    public PhysicianAssignCategoryObservationType(User user, PhysicianLandingScreen landingFrameForUser) {
	    this.user = user;
	    parentFrame = landingFrameForUser;
	    categoryList = dataFacade.populateAllCategories();
		obsTypeList = dataFacade.populateAllObservationTypes();
	    initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CATEGORY OBSERVATION TYPE ASSOCIATION");

        jComboBox1.setFocusable(false);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Choose a  Category:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Choose an Observation Type:");

        jComboBox2.setFocusable(false);
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Associate ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        populateComboBox();
        this.setLocationRelativeTo(null);
    }// </editor-fold>       
    
    /**
     * Populate combo box.
     */
    private void populateComboBox() {
    	for (String value : categoryList.keySet()) {
    		jComboBox1.addItem(value);
    	}
    	for (String value : obsTypeList.keySet()) {
    		jComboBox2.addItem(value);
    	}	
	}

    /**
     * J button1 action performed.
     *
     * @param evt the evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    this.setVisible(false);
	    if(parentFrame != null) {parentFrame.setVisible(true);}
    }                                        

    /**
     * J combo box1 action performed.
     *
     * @param evt the evt
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * J combo box1 item state changed.
     *
     * @param evt the evt
     */
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * J combo box2 item state changed.
     *
     * @param evt the evt
     */
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * J combo box2 action performed.
     *
     * @param evt the evt
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * J button3 action performed.
     *
     * @param evt the evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	jButton3.setEnabled(false);
        String categoryName =  (String) jComboBox1.getSelectedItem();
    	int catId = Integer.parseInt(categoryList.get(categoryName));
        String obsName =  (String) jComboBox2.getSelectedItem();
    	int typeID = Integer.parseInt(obsTypeList.get(obsName));;
    	boolean status = dataFacade.associateCategoryToObservationType(catId,typeID);
        if(status == true) {
        	JOptionPane.showMessageDialog(null,obsName+ " is associated to " + categoryName +" category");
        } else {
        	JOptionPane.showMessageDialog(null,"Association Failed....Try Again Later");
        }
        jButton3.setEnabled(true);
 
    }                                        

    /**
     * The main method.
     *
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
            java.util.logging.Logger.getLogger(PhysicianAssignCategoryObservationType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhysicianAssignCategoryObservationType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhysicianAssignCategoryObservationType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhysicianAssignCategoryObservationType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhysicianAssignCategoryObservationType(null,null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j button3. */
    private javax.swing.JButton jButton3;
    
    /** The j combo box1. */
    private javax.swing.JComboBox jComboBox1;
    
    /** The j combo box2. */
    private javax.swing.JComboBox jComboBox2;
    
    /** The j label1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j label2. */
    private javax.swing.JLabel jLabel2;
    
    /** The j label3. */
    private javax.swing.JLabel jLabel3;
    
    /** The j label4. */
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}