
import java.awt.event.ContainerListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitandrea
 */
public class PanelExit extends javax.swing.JPanel {

    ContainerListener getContain;

    /**
     * Creates new form PanelExit
     */
    public PanelExit() {
        initComponents();
        setSize(680, 620);
        jLabel1.setLocation(0, 0);
    }
    
    public void setYes(){
        ImageIcon icon=new ImageIcon(getClass().getResource("img/buttonW.png"));
        ButtonYes.setIcon(icon);
        icon =new ImageIcon(getClass().getResource("img/button.png"));
        ButtonNO.setIcon(icon);
    }
    
    public void setNo(){
        ImageIcon icon=new ImageIcon(getClass().getResource("img/buttonW.png"));
        ButtonNO.setIcon(icon);
        icon =new ImageIcon(getClass().getResource("img/button.png"));
        ButtonYes.setIcon(icon);
    }
    
    public void setNewTitle(){
        ImageIcon ic=new ImageIcon(getClass().getResource("img/pausa.png"));
        ImageIcon ic1=new ImageIcon(getClass().getResource("img/sostituto.png"));
        jLabel1.setIcon(ic1);
        JLabel l=new JLabel(ic);
        l.setSize(282,54);
        l.setLocation(198,116);
        add(l);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ButtonNO = new javax.swing.JLabel();
        ButtonYes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(680, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/title.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AreYouSure.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Yes.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/No.png"))); // NOI18N

        ButtonNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N

        ButtonYes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(ButtonYes)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(65, 65, 65)
                .addComponent(ButtonNO)
                .addGap(6, 6, 6)
                .addComponent(jLabel4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addGap(120, 120, 120)
                .addComponent(jLabel2)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonYes)
                            .addComponent(ButtonNO)))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonNO;
    private javax.swing.JLabel ButtonYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
