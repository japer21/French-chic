/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.*;
import metier.Client;

/**
 *
 * @author jperk
 */
public class VueJetable extends javax.swing.JFrame {
     JTextField usernameTxtField;
       JLabel usernameLabel ;
        JLabel passwordLabel;
        JButton seConnecter ;
        JPasswordField passwordField ;
        JLabel jLabel1 ;
        GroupLayout layout;
        Session s;
        public  Pair<TypeEcran,Client> mypair;
    public VueJetable(){
         s = new Session();
        TypeEcran ecranAccueil = s.traiterConnexion();
        if(ecranAccueil==TypeEcran.ECRAN_ACCUEIL){
            System.out.println("ECRAN_ACCUEIL");
            initComponents();
        }
        Dimension d=new Dimension(800,600);
        this.setSize(d);
        this.setResizable(true);
        
        this.setVisible(true);
    }
        public void initComponents() {

        usernameTxtField = new JTextField();
        usernameLabel = new JLabel();
         passwordLabel = new JLabel();
         seConnecter = new JButton();
         passwordField = new JPasswordField();
         jLabel1 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameLabel.setText("Pseudo:");

        passwordLabel.setText("Mot de passe:");

        seConnecter.setText("Se connecter");
        seConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    seConnecterActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(VueJetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

           private void seConnecterActionPerformed(ActionEvent evt) throws IOException {
               ecranPerso(usernameTxtField.getText(),Arrays.toString(passwordField.getPassword()));
           }
        });

        passwordField.setText("jPasswordField1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("French Chic");

         layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(242, 242, 242)
                            .addComponent(seConnecter))))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(seConnecter)
                .addGap(117, 117, 117))
        );

        pack();
    }
        public void ecranPerso(String usr, String pswd) throws IOException{
            this.mypair=s.traiterAuthentification(usr, pswd);
            if(mypair.getKey()==TypeEcran.ECRAN_ACCUEIL_PERSO){
                System.out.println("ECRAN_PERSO de:  "+mypair.getValue().getPseudo()+" "+mypair.getValue().getMdp());
                this.getContentPane().removeAll();
                
                JLabel welcomeUser=new JLabel();
                JLabel produitJourLabel = new JLabel();
                JLabel getProduitJour = new JLabel();
                File fc = new File("iphone-x.png");
                Image img = ImageIO.read(fc);
                
                                JLabel ic = new JLabel();
                                ic.setSize(200, 200);
                                
                Image resizedImage = 
                    img.getScaledInstance(ic.getWidth(), ic.getHeight(), 0);
                ic.setIcon(new ImageIcon(resizedImage));
                welcomeUser.setText("Bonjour "+mypair.getValue().getPseudo());
                produitJourLabel.setText("Porduit du jour: ");
                getProduitJour.setText("iPhone X");
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)                                
                               .addComponent(ic, 200, 200, 200)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(produitJourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getProduitJour, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produitJourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getProduitJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                    .addComponent(ic, 200, 200, 200)
                .addContainerGap(264, Short.MAX_VALUE))
        );
            }
            
        }
        public static void main(String args[]) {
            VueJetable view = new VueJetable();
        }
}
