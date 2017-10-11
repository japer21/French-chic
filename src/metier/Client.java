/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jperk
 */
public class Client {
    private int id;
    private String pseudo;
    private String mdp;
    public String nom;
    public String prenom;
    public String adresse;
    
    public Client(String p, String m){
        this.pseudo=p;
        this.mdp=m;
    }
    
    public void setId(int _id){
        this.id=_id;
    }
    public void setPseudo(String p){
        this.pseudo=p;
    }
    public void setMdp(String m){
        this.mdp=m;
    }
    public void setNom(String n){
        this.nom=n;
    }
    public void setPrenom(String p){
        this.prenom=p;
    }
    public void setAdresse(String adr){
        this.adresse=adr;
    }
    
    public int getId(){
        return this.id;
    }
    public String getPseudo(){
        return this.pseudo;
    }
    public String getMdp(){
        return this.mdp;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getAdr(){
        return this.adresse;
    }
}
