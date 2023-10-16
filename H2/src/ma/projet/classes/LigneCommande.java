/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    =========>association biderectionnel
 */
package ma.projet.classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommande {
    @Id
    LigneCommandePrimaire pk;
  
    
    private int quantite;

    public LigneCommande(){
        
    }

    public LigneCommandePrimaire getPk() {
        return pk;
    }

    public void setPk(LigneCommandePrimaire pk) {
        this.pk = pk;
    }

 

    

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
}
