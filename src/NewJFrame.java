
//import com.apple.eawt.Application;
//import java.awt.Image;
//import com.apple.eawt.Application;
//import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.ImageIcon;
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
public class NewJFrame extends javax.swing.JFrame {
 
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        addKeyListener(ListPrinc);
        p1=(JPanel) this.getContentPane();
        resetPrinc();
//        Image img12 = new ImageIcon("src/ic.ico").getImage();  // your desired image  
//        Application app = Application.getApplication();
//        app.setDockIconImage(img12);
        //setExtendedState(this.MAXIMIZED_BOTH);
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
        ButtonStartGame = new javax.swing.JLabel();
        ButtonExit = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space Invader");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/title.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startGame.png"))); // NOI18N

        ButtonStartGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N

        ButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(ButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(ButtonStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(ButtonStartGame)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ButtonExit)))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(680, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    public void resetPrinc(){
        ButtonExitV=0;
        
        ImageIcon icon=new ImageIcon(buttonWUrl);
        ButtonStartGame.setIcon(icon);
        icon=new ImageIcon(buttonUrl);
        ButtonExit.setIcon(icon);


        ButtonStartGameV=1;
    }
    
    public void resetExit(){
        p.setYes();
        ButtonYes=1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonExit;
    private javax.swing.JLabel ButtonStartGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    int ButtonStartGameV=0;
    int ButtonExitV=0;
    PanelExit p;
    
    KeyListener ListPrinc=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==e.VK_UP || e.getKeyCode()== e.VK_DOWN){
            if(ButtonStartGameV==1){
                ButtonStartGameV=0;
                
                ImageIcon icon=new ImageIcon(buttonWUrl);
                ButtonExit.setIcon(icon);
                icon=new ImageIcon(buttonUrl);
                ButtonStartGame.setIcon(icon);
                
                ButtonExitV=1;
            }else if(ButtonExitV==1){
                ButtonExitV=0;
                
                ImageIcon icon=new ImageIcon(buttonWUrl);
                ButtonStartGame.setIcon(icon);
                icon=new ImageIcon(buttonUrl);
                ButtonExit.setIcon(icon);
                
                
                ButtonStartGameV=1;
            }else{
                ButtonStartGameV=1;
                ImageIcon icon=new ImageIcon(buttonWUrl);
                ButtonStartGame.setIcon(icon);
            }   
        }
        if(e.getKeyCode()==e.VK_ENTER){
            if(ButtonExitV==1){
                p=new PanelExit();
                p.setLocation(0, 0);
                
                setContentPane(p);
                
                pack();
                setVisible(true);
                addKeyListener(ListExit);
                removeKeyListener(ListPrinc);
                resetExit();
            }else if(ButtonStartGameV==1){
                //parte il gioco
                ps=new PanelLevel1();
                ps.setLocation(0, 0);
                setContentPane(ps);
                pack();
                setVisible(true);
                ps.animazioneNemici(true);
                removeKeyListener(ListPrinc);
                addKeyListener(Livello1);
                addKeyListener(Livello1Sparo);
            }
        }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    
    
    KeyListener ListExit= new KeyListener() {
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
            }
            if(e.getKeyCode()==e.VK_ENTER){
                if(ButtonYes==1){
                    System.exit(0);
                }else if(ButtonNo==1){
                    setContentPane(p1);
                    ButtonNo=0;
                    ButtonYes=0;
                    addKeyListener(ListPrinc);
                    removeKeyListener(ListExit);
                    resetPrinc();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    
    
    KeyListener Livello1=new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(escButton==0){
                if(e.getKeyCode()==e.VK_LEFT){
                    ps.cannoneLeft();
                }else if(e.getKeyCode()==e.VK_RIGHT){
                    ps.cannoneRight();
                }
            }
            if(e.getKeyCode()==e.VK_ESCAPE){
                if(escButton==0){
                    escButton=1;
                    ps.animazioneNemici(false);
                    ps.SetEscape(false);
                    CreaPO();
                    po.setVisible(true);
                    if(po.getReturnStatus()==po.RET_CANCEL){
                        setContentPane(p1);
                        removeKeyListener(Livello1);
                        removeKeyListener(Livello1Sparo);
                        addKeyListener(ListPrinc);
                    }
                    
                    escButton=0;
                    ps.animazioneNemici(true);
                    ps.SetEscape(true);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    PausaDialog po;
    
    private void CreaPO(){
        po=new PausaDialog(this, true);
    }
    
    KeyListener Livello1Sparo=new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(escButton==0){
                if(e.getKeyCode()==e.VK_SPACE){
                    ps.animMissile();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    };
    
    int escButton=0;
    int ButtonYes=0;
    int ButtonNo=0;
    JPanel p1=new JPanel();
    
    URL buttonWUrl = getClass().getResource("img/buttonW.png");
    URL buttonUrl = getClass().getResource("img/button.png");
    
    PanelLevel1 ps;
}