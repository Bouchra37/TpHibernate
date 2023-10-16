/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.Date;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import ma.projet.classes.Categorie;
import javax.persistence.EntityManager;


public class ProduitService implements IDao<Produit>{
    
    @Override
    public boolean create(Produit o){
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
    public Produit getById(int id){
        Produit p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = (Produit) session.get(Produit.class, id);
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
    public List<Produit> getAll(){
        
         List<Produit> p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = session.createQuery("from Produit").list();
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
    
        public List<Produit> getProduitsByCategorie(Categorie categorie) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("FROM Produit WHERE categorie = :categorie").setParameter("categorie", categorie).list();
            
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
        
    public List<Produit> getProduitsCommandesEntreDates(Date dateDebut, Date dateFin) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("SELECT lc.produit_id FROM LigneCommande lc WHERE lc.commande.dateCommande BETWEEN :dateDebut AND :dateFin")
                    .setParameter("dateDebut", dateDebut)
                    .setParameter("dateFin", dateFin)
                    .list();
            
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
    
         public List<Produit> getProduitsPrixSuperieur() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            produits = session.getNamedQuery("Produit.findProduits")
                    .setParameter("prix", 100.0) 
                    .list();
            
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


    
}
