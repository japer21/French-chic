/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javafx.util.Pair;
import metier.Client;


/**
 *
 * @author jperk
 */
public class Session {
    
    public Session(){
         
    }
    public TypeEcran traiterConnexion(){
        return TypeEcran.ECRAN_ACCUEIL;
    }
    
    public TypeEcran affichageAccueilPerso(){
        return TypeEcran.ECRAN_ACCUEIL_PERSO;
    }
    public TypeEcran affichagePanier(){
        return TypeEcran.ECRAN_PANIER;
    }
    public Pair<TypeEcran,Client> traiterAuthentification(String id,String mdp){
        Client c = rechercherClientParPseudo(id,mdp);
        Pair<TypeEcran,Client> mypair = new Pair<>(TypeEcran.ECRAN_ACCUEIL_PERSO,c);
        return mypair;
    }
    public Client rechercherClientParPseudo(String id,String mdp){
        return new Client(id,mdp);
    }
}
