
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitandrea
 */
public class PanelLevel1 extends javax.swing.JPanel {

    /**
     * Creates new form PanelLevel1
     */
    public PanelLevel1() {
        initComponents();
        SetMatriceLabel();
        inizvect();
        
//        CannoneNemici n=new CannoneNemici();
//        n.SetCoordinate(100, 100);
//        Thread tfr=new Thread(n);
//        tfr.start();
//        
//        
//        CannoneNemici n1=new CannoneNemici();
//        n1.SetCoordinate(200, 100);
//        Thread tfr1=new Thread(n1);
//        tfr1.start();
        File fontF = new File("img/space_invaders.ttf");
        Font fontSP = null;
        try {
            fontSP=Font.createFont(Font.TRUETYPE_FONT, fontF);
            fontSP=fontSP.deriveFont(Font.PLAIN,15);
        } catch (FontFormatException ex) {
        } catch (IOException ex) {
        }
        LabelScore.setFont(fontSP);
        LabelScore.setText("Score:"+score);
        
        this.animNem=new Timer(VelocitaNemici, avvio);
    }
    
    public void inizvect(){
        vect[0]=0;
        vect[1]=56;
        vect[2]=110;
        vect[3]=160;
        vect[4]=210;
    }
    
    
    
    
    public void animazioneNemici(boolean flag){
        if(flag)animNem.start();
        else animNem.stop();
    }
    
    boolean flagmissile=false;
    private int xMissile,yMissile;
    
    public void animMissile(){
        if(!flagmissile){
            flagmissile=true;
            xMissile=LabelCannone.getLocation().x+13;
            yMissile=LabelCannone.getLocation().y;
            l.setSize(3,18);
            animMiss.start();
            gestoreCollisioni.start();
        }
    }
    
    ImageIcon icon=new ImageIcon(getClass().getResource("img/cannonBall.jpg"));
    JLabel l=new JLabel(icon);
    ActionListener avvio2=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Escape){
                if(yMissile>0){
                    l.setLocation(xMissile, yMissile=yMissile-10);
                    add(l);
                    repaint();
                }else{
                    animMiss.stop();
                    flagmissile=false;
                    remove(l);
                    repaint();
                    gestoreCollisioni.stop();
                }
            }
        }
    };
    
    Timer animMiss=new Timer(10, avvio2);
    
    
    
    ActionListener avvio3=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(xMissile>0){
                //gestisco tutte le posizioni
                for(int i=0;i<11;i++){
                    if(xMissile>=jPanel.getLocation().x+jPanel5.getLocation().x+matL[4][i].getLocation().x &&
                    xMissile<=jPanel.getLocation().x+jPanel1.getLocation().x+matL[4][i].getLocation().x+37){ 
                        int fall=4;
                        int cont=0;
                        for(int j=4;j>=0;j--){
                            String s=matL[j][i].getIcon().toString();
                            if(!(s.substring(s.length()-15,s.length()).contains("sostituto.png")) && 
                                    !(s.substring(s.length()-15,s.length()).contains("sostituto1.png"))
                                    && !(s.substring(s.length()-15,s.length()).contains("sostituto2.png")) ){
                                fall=j;
                                j=-1;
                            }else cont++;
                        }
                        if(cont<=4){
                            if(yMissile>=jPanel.getLocation().y+vect[fall]+matL[fall][i].getLocation().y    &&
                            yMissile<=jPanel.getLocation().y+vect[fall]+matL[fall][i].getLocation().y+24){
                                switch(fall){
                                    case 4:
                                    case 3:
                                       NumNemiciVivi--;
                                       ImageIcon ic=new ImageIcon(getClass().getResource("img/sostituto.png"));
                                       matL[fall][i].setIcon(ic);
                                       score+=10;
                                       LabelScore.setText("Score:"+score);
                                       break;
                                    case 2:
                                    case 1:
                                        NumNemiciVivi--;
                                        ic=new ImageIcon(getClass().getResource("img/sostituto.png"));
                                        matL[fall][i].setIcon(ic);
                                        score+=20;
                                        LabelScore.setText("Score:"+score);
                                        break;
                                    case 0:
                                        NumNemiciVivi--;
                                        ic=new ImageIcon(getClass().getResource("img/sostituto.png"));
                                        matL[fall][i].setIcon(ic);
                                        score+=40;
                                        LabelScore.setText("Score:"+score);
                                        
                                        break;
                                    default:
                                        break;
                                }
                                
                                animMiss.stop();
                                gestoreCollisioni.stop();
                                remove(l);
                                repaint();
                                flagmissile=false;
                            }
                        }
                        break;  
                    }
                }
            }
        }
    };
    
    Timer gestoreCollisioni=new Timer(10,avvio3);
    
    public void SetEscape(boolean flag){
        Escape=flag;
    }
    
    public void cannoneLeft(){
        if(LabelCannone.getLocation().x>15)LabelCannone.setLocation(LabelCannone.getLocation().x-15,LabelCannone.getLocation().y);
    }
    
    public void cannoneRight(){
        if(LabelCannone.getLocation().x<645) LabelCannone.setLocation(LabelCannone.getLocation().x+15,LabelCannone.getLocation().y);
    }
    
    //CLASSE PER I THREAD CHE SI CREANO QUANDO I NEMICI SPARANO
    public class CannoneNemici implements Runnable{

        @Override
        public void run() {
            MissileNem=new JLabel(ico);
            MissileNem.setSize(4,24);
            MissileNem.setLocation(xMissileNem,yMissileNem);
            add(MissileNem);
            t.start();
        }
        private ActionListener Animazione=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yMissileNem=yMissileNem+10;
                MissileNem.setLocation(xMissileNem,yMissileNem);
                
            }
        };
        
        public void SetCoordinate(int x,int y){
            xMissileNem=x;
            yMissileNem=y;
        }
        
        private Timer t=new Timer(100,Animazione);
        
        private ImageIcon ico=new ImageIcon("src/NemiciBall.jpg");
        private JLabel MissileNem;
        
        public int xMissileNem,yMissileNem;
    } 
    
    public void SetMatriceLabel(){
        matL[0][0]=jLabel1; matL[0][1]=jLabel2; matL[0][2]=jLabel3; matL[0][3]=jLabel4; matL[0][4]=jLabel5; matL[0][5]=jLabel6; 
        matL[0][6]=jLabel7; matL[0][7]=jLabel8; matL[0][8]=jLabel9; matL[0][9]=jLabel10; matL[0][10]=jLabel11;
        
        matL[1][0]=jLabel12; matL[1][1]=jLabel13; matL[1][2]=jLabel14; matL[1][3]=jLabel15; matL[1][4]=jLabel16; matL[1][5]=jLabel17; 
        matL[1][6]=jLabel18; matL[1][7]=jLabel19; matL[1][8]=jLabel20; matL[1][9]=jLabel21; matL[1][10]=jLabel22;
        
        matL[2][0]=jLabel23; matL[2][1]=jLabel24; matL[2][2]=jLabel25; matL[2][3]=jLabel26; matL[2][4]=jLabel27; matL[2][5]=jLabel28; 
        matL[2][6]=jLabel29; matL[2][7]=jLabel30; matL[2][8]=jLabel31; matL[2][9]=jLabel32; matL[2][10]=jLabel33;
        
        matL[3][0]=jLabel34; matL[3][1]=jLabel35; matL[3][2]=jLabel36; matL[3][3]=jLabel37; matL[3][4]=jLabel38; matL[3][5]=jLabel39; 
        matL[3][6]=jLabel40; matL[3][7]=jLabel41; matL[3][8]=jLabel42; matL[3][9]=jLabel43; matL[3][10]=jLabel44;
        
        matL[4][0]=jLabel45; matL[4][1]=jLabel46; matL[4][2]=jLabel47; matL[4][3]=jLabel48; matL[4][4]=jLabel49; matL[4][5]=jLabel50; 
        matL[4][6]=jLabel51; matL[4][7]=jLabel52; matL[4][8]=jLabel53; matL[4][9]=jLabel54; matL[4][10]=jLabel55;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        LabelScore = new javax.swing.JLabel();
        LabelCannone = new javax.swing.JLabel();
        LineaBase = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(680, 620));
        setLayout(null);

        jPanel.setBackground(new java.awt.Color(0, 0, 0));
        jPanel.setOpaque(false);
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 25, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 10, 25, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 10, 25, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 10, 25, 25);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 10, 25, 25);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(250, 10, 25, 25);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(300, 10, 25, 25);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(350, 10, 25, 25);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(400, 10, 25, 25);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(450, 10, 25, 25);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea3.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(500, 10, 25, 25);

        jPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 533, 43));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel45);
        jLabel45.setBounds(0, 10, 37, 24);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel46);
        jLabel46.setBounds(50, 10, 37, 24);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel47);
        jLabel47.setBounds(100, 10, 37, 24);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel48);
        jLabel48.setBounds(150, 10, 37, 24);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel49);
        jLabel49.setBounds(200, 10, 37, 24);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel50);
        jLabel50.setBounds(250, 10, 37, 24);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel51);
        jLabel51.setBounds(300, 10, 37, 24);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel55);
        jLabel55.setBounds(500, 10, 37, 24);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel54);
        jLabel54.setBounds(450, 10, 37, 24);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel53);
        jLabel53.setBounds(400, 10, 37, 24);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel5.add(jLabel52);
        jLabel52.setBounds(350, 10, 37, 24);

        jPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 210, 540, 43));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 10, 35, 25);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 10, 35, 25);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(100, 10, 35, 25);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel15);
        jLabel15.setBounds(150, 10, 35, 25);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel16);
        jLabel16.setBounds(200, 10, 35, 25);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel17);
        jLabel17.setBounds(250, 10, 35, 25);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel18);
        jLabel18.setBounds(300, 10, 35, 25);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel19);
        jLabel19.setBounds(350, 10, 35, 25);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel20);
        jLabel20.setBounds(400, 10, 35, 25);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel21);
        jLabel21.setBounds(450, 10, 35, 25);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel2.add(jLabel22);
        jLabel22.setBounds(500, 10, 35, 25);

        jPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 540, 43));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 10, 35, 25);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel24);
        jLabel24.setBounds(50, 10, 35, 25);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel25);
        jLabel25.setBounds(100, 10, 35, 25);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel26);
        jLabel26.setBounds(150, 10, 35, 25);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel27);
        jLabel27.setBounds(200, 10, 35, 25);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel28);
        jLabel28.setBounds(250, 10, 35, 25);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel29);
        jLabel29.setBounds(300, 10, 35, 25);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel30);
        jLabel30.setBounds(350, 10, 35, 25);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel31);
        jLabel31.setBounds(400, 10, 35, 25);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel32);
        jLabel32.setBounds(450, 10, 35, 25);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea1.png"))); // NOI18N
        jPanel3.add(jLabel33);
        jLabel33.setBounds(500, 10, 35, 25);

        jPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 110, 540, 43));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel34);
        jLabel34.setBounds(0, 10, 37, 24);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel35);
        jLabel35.setBounds(50, 10, 37, 24);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel36);
        jLabel36.setBounds(100, 10, 37, 24);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel37);
        jLabel37.setBounds(150, 10, 37, 24);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel38);
        jLabel38.setBounds(200, 10, 37, 24);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel39);
        jLabel39.setBounds(250, 10, 37, 24);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel40);
        jLabel40.setBounds(300, 10, 37, 24);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel44);
        jLabel44.setBounds(500, 10, 37, 24);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel43);
        jLabel43.setBounds(450, 10, 37, 24);

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel42);
        jLabel42.setBounds(400, 10, 37, 24);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea2.png"))); // NOI18N
        jPanel4.add(jLabel41);
        jLabel41.setBounds(350, 10, 37, 24);

        jPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 160, 540, 43));

        add(jPanel);
        jPanel.setBounds(69, 74, 546, 250);

        LabelScore.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        LabelScore.setForeground(new java.awt.Color(255, 255, 255));
        LabelScore.setText("Score: ");
        add(LabelScore);
        LabelScore.setBounds(6, 6, 218, 40);

        LabelCannone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cannon.png"))); // NOI18N
        LabelCannone.setToolTipText("");
        add(LabelCannone);
        LabelCannone.setBounds(321, 552, 29, 25);

        LineaBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LineaBase.png"))); // NOI18N
        LineaBase.setPreferredSize(new java.awt.Dimension(675, 6));
        add(LineaBase);
        LineaBase.setBounds(6, 583, 668, 6);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCannone;
    private javax.swing.JLabel LabelScore;
    private javax.swing.JLabel LineaBase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    int VelocitaNemici=1000;
    
    ActionListener avvio=new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!flag){
                if(jPanel.getLocation().x>=xlimitiPanelDestra){
                    flag=true;
                    jPanel.setLocation(jPanel.getLocation().x, jPanel.getLocation().y+7);
                    repaint();
                }else{
                    int cont=0;
                    for(int i=4;i>=0;i--){
                        String s=matL[i][xDestraNum].getIcon().toString();
                        if((s.substring(s.length()-15,s.length()).contains("sostituto"))) cont++;
                    }
                    if(cont>4){
                        if(xDestraNum==10) xlimitiPanelDestra+=45;//13
                        else xlimitiPanelDestra+=50;
                        if(xDestraNum!=0) xDestraNum-=1;
                        else animNem.stop();
                    }
                    jPanel.setLocation(jPanel.getLocation().x+7, jPanel.getLocation().y);
                    repaint();
                }
            }else if(jPanel.getLocation().x<=xlimitiPanelSinistra){
                flag=false;
                jPanel.setLocation(jPanel.getLocation().x, jPanel.getLocation().y+7);
                repaint();
            }else{
                int cont=0;
                    for(int i=4;i>=0;i--){
                        String s=matL[i][xSinistraNum].getIcon().toString();
                        if((s.substring(s.length()-15,s.length()).contains("sostituto"))) cont++;
                    }
                    if(cont>4){
                        if(xSinistraNum==0) xlimitiPanelSinistra-=45;//13
                        else xlimitiPanelSinistra-=52;
                        if(xSinistraNum!=10) xSinistraNum+=1;
                        else animNem.stop();
                    }
                jPanel.setLocation(jPanel.getLocation().x-7, jPanel.getLocation().y);
                repaint();
            }
            if(xSinistraNum!=10 || xDestraNum!=0){
                int val=1000/55;
                VelocitaNemici=val*NumNemiciVivi;
                if(VelocitaNemici==18)VelocitaNemici=10;
                animNem.stop();
                if(NumNemiciVivi!=0){
                    animNem=new Timer(VelocitaNemici,avvio);
                    animNem.start();
                }else if(NumNemiciVivi==0){
                   //disattivare tutti i gestori movimento e di collisione e mostrare la pagina Game Over!
                    
                }
            }
        }
    };
    
    private int xlimitiPanelDestra=117,xlimitiPanelSinistra=19;
    private int xDestraNum=10,xSinistraNum=0;
    boolean flag=false;
    
    private Timer animNem;
    
    private boolean Escape=true;
    JLabel matL[][]=new JLabel[5][11]; 
    int vect[]=new int[5];
    int score=0;
    int NumNemiciVivi=55;
}
