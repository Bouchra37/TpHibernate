/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author G(
 */
@Embeddable
public class LigneCommandePrimaire implements java.io.Serializable{
      
    @ManyToOne
    @JoinColumn(name = "commande_id",insertable = false, updatable = false)
    private Commande commande;
    
    @ManyToOne
    @JoinColumn(name = "produit_id",insertable = false, updatable = false)
    private Produit produit;

    public LigneCommandePrimaire() {
    }

    public LigneCommandePrimaire(Commande commande, Produit produit1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
    
    
}
