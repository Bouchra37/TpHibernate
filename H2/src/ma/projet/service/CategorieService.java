/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class CategorieService implements IDao<Categorie>{
    
    @Override
    public boolean create(Categorie o){
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
    public Categorie getById(int id){
        Categorie p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = (Categorie) session.get(Categorie.class, id);
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
    public List<Categorie> getAll(){
        
         List<Categorie> p = null;
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = session.createQuery("from Categorie").list();
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
