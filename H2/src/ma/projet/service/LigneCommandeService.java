/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import ma.projet.classes.LigneCommande;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class LigneCommandeService implements IDao<LigneCommande>{
    
    @Override
    public boolean create(LigneCommande o){
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
    public LigneCommande getById(int id){
        LigneCommande p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = (LigneCommande) session.get(LigneCommande.class, id);
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
    public List<LigneCommande> getAll(){
        
         List<LigneCommande> p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = session.createQuery("from LigneCommande").list();
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
    
}
