/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import ma.projet.classes.Commande;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import ma.projet.classes.Produit;


public class CommandeService implements IDao<Commande>{
    
    @Override
    public boolean create(Commande o){
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        }
        catch(HibernateException he){
            if(tx != null){
                 tx.rollback(); 
            }
            return false;
            
        }
        finally{
            if(session != null){
                   session.close();
            }
        }
    }
    
    @Override
    public Commande getById(int id){
        Commande p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = (Commande) session.get(Commande.class, id);
            tx.commit();
            return p;
        }
        catch(HibernateException he){
            if(tx != null){
                 tx.rollback(); 
            }
            return p;
            
        }
        finally{
            if(session != null){
                   session.close();
            }
        }
        
    }
    
    @Override
    public List<Commande> getAll(){
        
         List<Commande> p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = session.createQuery("from Commande").list();
            tx.commit();
            return p;
        }
        catch(HibernateException he){
            if(tx != null){
                 tx.rollback(); 
            }
            return p;
            
        }
        finally{
            if(session != null){
                   session.close();
            }
        }

    }

      /*  public List<Produit> getProduitsCommandesDansCommande(Commande commande) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery(
                    "SELECT lc.produit FROM LigneCommande lc WHERE lc.commande = :commande").setParameter("commande", commande).list();
            
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return produits;
    }
    */
    
public void afficherProduitsCommandesDansCommande(Commande commande) {
    Session session = null;
    Transaction tx = null;
    ProduitService produitService = new ProduitService();

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String sql = "SELECT lc.produit_id, lc.quantite FROM LigneCommande lc " +
                     "WHERE lc.commande_id = :commandeId";
        List<Object[]> results = session.createSQLQuery(sql)
                                        .setParameter("commandeId", commande.getId())
                                        .list();

        // Afficher les détails des produits commandés
        System.out.println("Commande : " + commande.getId() + "    Date : " + commande.getDate());
        System.out.println("Liste des produits :");
        System.out.println("--------------------------------------------------------");
        System.out.println("Référence\tPrix    \tQuantité");
        System.out.println("--------------------------------------------------------");

        for (Object[] result : results) {
            int produitId = (int) result[0];
            int quantite = (int) result[1];

            Produit produit = produitService.getById(produitId);

            // Afficher chaque produit sous forme de ligne
            System.out.printf("%-12s\t%-8sDH    \t%-10s%n",
                produit.getReference(), produit.getPrix(), quantite);
        }

        System.out.println("--------------------------------------------------------");
        tx.commit();
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }
}

}
