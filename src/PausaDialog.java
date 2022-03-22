/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author sorino7782
 */
public class PausaDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form PausaDialog
     */
    public PausaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Color c = new Color (0, 0, 0,180);
        this.setBackground(c);
        jPanel1.setBackground(c);
        jLabel1.setBackground(c);
        InizVetLabel();
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelResume = new javax.swing.JLabel();
        LabelExit = new javax.swing.JLabel();
        LabelReturn = new javax.swing.JLabel();

        setIconImage(null);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pausa.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(198, 116, 284, 54);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(294, 440, 91, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resume.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 250, 133, 45);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackToHome.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(208, 330, 270, 81);

        LabelResume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N
        LabelResume.setText("jLabel5");
        LabelResume.setSize(new java.awt.Dimension(26, 27));
        jPanel1.add(LabelResume);
        LabelResume.setBounds(240, 260, 26, 27);

        LabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N
        LabelExit.setText("jLabel5");
        LabelExit.setSize(new java.awt.Dimension(26, 27));
        jPanel1.add(LabelExit);
        LabelExit.setBounds(240, 450, 26, 27);

        LabelReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N
        LabelReturn.setText("jLabel5");
        LabelReturn.setSize(new java.awt.Dimension(26, 27));
        jPanel1.add(LabelReturn);
        LabelReturn.setBounds(160, 355, 26, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(680, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ESCAPE){
            doClose(RET_OK);
        }else if(evt.getKeyCode()==evt.VK_DOWN){
            for(int i=0;i<3;i++){
                String s=LabVet[i].getIcon().toString();
                if(s.contains("buttonW.png")){
                    if(i==2){
                        LabVet[i].setIcon(icon1);
                        LabVet[0].setIcon(icon);
                        i=3;
                    }else{
                        LabVet[i].setIcon(icon1);
                        LabVet[i+1].setIcon(icon);
                        i=3;
                    }
                }
            }
        }else if(evt.getKeyCode()==evt.VK_UP){
            for(int i=0;i<3;i++){
                String s=LabVet[i].getIcon().toString();
                if(s.contains("buttonW.png")){
                    if(i==0){
                        LabVet[i].setIcon(icon1);
                        LabVet[2].setIcon(icon);
                        i=3;
                    }else{
                        LabVet[i].setIcon(icon1);
                        LabVet[i-1].setIcon(icon);
                        i=3;
                    }
                }
            }
        }else if(evt.getKeyCode()==evt.VK_ENTER){
            for(int i=0;i<3;i++){
                String s=LabVet[i].getIcon().toString();
                if(s.contains("buttonW.png")){
                    switch(i){
                        case 0:
                            doClose(RET_OK);
                            break;
                        case 1:
                        case 2:
                            Color c = new Color (0, 0, 0,180);
                            p=new PanelExit();
                            p.setNewTitle();
                            p.setBackground(c);
                            p.setLocation(0, 0);
                            oldPanel=new JPanel();
                            oldPanel=(JPanel)this.getContentPane();
                            setContentPane(p);
                            p.setYes();
                            ButtonYes=1;
                            removeKeyListener(this.getKeyListeners()[0]);
                            addKeyListener(AreYouSure);
                            repaint();
                            if(i==1)Modalita="Return";
                            else Modalita="Exit";
                            break;
                    }
                    i=3;
                }
            }
        }
    }//GEN-LAST:event_formKeyPressed
    
    KeyListener old=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            formKeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    
    KeyListener AreYouSure=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==e.VK_LEFT || e.getKeyCode()== e.VK_RIGHT){
                if(ButtonYes==1){
                    ButtonYes=0;
                    
                    p.setNo();
                    
                    ButtonNo=1;
                }else if(ButtonNo==1){
                    ButtonNo=0;
                    
                    p.setYes();
                    
                    ButtonYes=1;
                }else{
                    p.setYes();
                    ButtonYes=1;
                }
            }else if(e.getKeyCode()==e.VK_ENTER){
                if(Modalita.equals("Return")){
                    if(ButtonYes==1){
                        doClose(RET_CANCEL);
                    }else{
                        setContentPane(oldPanel);
                        removeKeyListener(AreYouSure);
                        addKeyListener(old);
                    }
                }else if(Modalita.equals("Exit")){
                    if(ButtonYes==1){
                        System.exit(0);
                    }else{
                        setContentPane(oldPanel);
                        removeKeyListener(AreYouSure);
                        addKeyListener(old);
                    }
                }
                
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    
    private void InizVetLabel(){
        LabVet[0]=LabelResume;
        LabVet[1]=LabelReturn;
        LabVet[2]=LabelExit;
        LabVet[0].setIcon(icon);
    }
    
    //doClose(RET_CANCEL);
    //doClose(RET_OK);

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PausaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PausaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PausaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PausaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PausaDialog dialog = new PausaDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelExit;
    private javax.swing.JLabel LabelResume;
    private javax.swing.JLabel LabelReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
    
    JLabel LabVet[]=new JLabel[3];
    ImageIcon icon=new ImageIcon(getClass().getResource("img/buttonW.png"));
    ImageIcon icon1=new ImageIcon(getClass().getResource("img/button.png"));
    PanelExit p;
    int ButtonYes=0,ButtonNo=0;
    JPanel oldPanel;
    String Modalita="";
}
