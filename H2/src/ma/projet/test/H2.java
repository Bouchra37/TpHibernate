/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommande;
import ma.projet.classes.LigneCommandePrimaire;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;


/**
 *
 * @author G(
 */
public class H2 {


    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        
        CommandeService css = new CommandeService();
        CategorieService cs = new CategorieService();
        ProduitService ps = new ProduitService();
        LigneCommandeService ligneCommandeService = new LigneCommandeService();

      
                
        /* cs.create(new Categorie("code1","lib1"));
        cs.create(new Categorie("code2","lib2"));  
        cs.create(new Categorie("code3","lib3")); */
        
        /* Commande commande1 = new Commande("commande1", new Date());
        Commande commande2 = new Commande("commande2", new Date());
        
        css.create(commande1);
        css.create(commande2); */
        
        /*ps.create(new Produit("ref1",80,cs.getById(2)));
        ps.create(new Produit("ref2",90,cs.getById(2)));
        ps.create(new Produit("ref3",100,cs.getById(2)));
        ps.create(new Produit("ref4",500,cs.getById(3))); */

        //ps.getProduitsByCategorie(cs.getById(1));
        
       ps.getProduitsCommandesEntreDates(new Date(123,9,1), new Date(123,9,5));

        LigneCommande ligneCommande = new LigneCommande();
        LigneCommandePrimaire pk = new LigneCommandePrimaire();
         /*pk.setCommande(css.getById(3));
        pk.setProduit(ps.getById(4)); 
        ligneCommande.setPk(pk);
        ligneCommande.setQuantite(5);
        
        ligneCommandeService.create(ligneCommande);
*/

        css.afficherProduitsCommandesDansCommande(css.getById(3));
        
        
    }
    
}
