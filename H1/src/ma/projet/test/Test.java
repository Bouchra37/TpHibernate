    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor

 * convertir de date vers chaîne => dateFormat.format(date)
 */
package ma.projet.test;

import java.text.ParseException;
import ma.projet.service.ProduitService;
import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Test {

    public static void main(String[] args){
        
            ProduitService ps = new ProduitService();
    
           /* ps.create(new Produit("marque1","ref1",new Date(),801,"designation1"));
            ps.create(new Produit("marque2","ref2",new Date(),802,"designation2"));
            ps.create(new Produit("marque3","ref3",new Date(),803,"designation3"));
            ps.create(new Produit("marque4","ref4",new Date(),804,"designation4"));
            ps.create(new Produit("marque5","ref5",new Date(),805,"designation5")); */

            List<Produit> produits = ps.findAll();
            if (produits != null) {
                for (Produit produit : produits) {
                    System.out.println("ID : " + produit.getId());
                    System.out.println("Marque : " + produit.getMarque());
                    System.out.println("Référence : " + produit.getReference());
                    System.out.println("Date : " + produit.getDateAchat());
                    System.out.println("Prix : " + produit.getPrix());
                    System.out.println("Désignation : " + produit.getDesignation());
                    System.out.println("---------------------------");
                }
            } else {
                System.out.println("Aucun produit trouvé.");
            }
            
            
            /*
            
            Produit produit2 = ps.findById(2);
            if(produit2!=null){
                System.out.println("ID : " + produit2.getId());
                System.out.println("Marque : " + produit2.getMarque());
                System.out.println("Référence : " + produit2.getReference());
                System.out.println("Date : " + produit2.getDateAchat());
                System.out.println("Prix : " + produit2.getPrix());
                System.out.println("Désignation : " + produit2.getDesignation());
                System.out.println("---------------------------");
            }
            else{
                System.out.println("Aucun produit trouvé avec l'Id 2.");
            }
            
            
            //ps.delete(ps.findById(3));
            
            
            Produit produit1 = ps.findById(1);
            produit1.setDesignation("des1");
            ps.update(produit1);
            
            
            List<Produit> produitss = ps.findAll();
            if (produitss != null) {
                System.out.println("Les produits dont le prix est supérieur à 100 DH sont : ");
                for (Produit produit : produitss) {
                    if (produit.getPrix()>100){
                        System.out.println("ID : " + produit.getId());
                        System.out.println("Marque : " + produit.getMarque());
                        System.out.println("Référence : " + produit.getReference());
                        System.out.println("Date : " + produit.getDateAchat());
                        System.out.println("Prix : " + produit.getPrix());
                        System.out.println("Désignation : " + produit.getDesignation());
                        System.out.println("---------------------------");
                    }
                }
            } else {
                System.out.println("Aucun produit trouvé.");
            }
            
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //formater les dates
            
            
            System.out.println("Entrez la date de début (yyyy-MM-dd) : ");
            String firstDate = scanner.nextLine();
            System.out.println("Entrez la date de fin (yyyy-MM-dd) : ");
            String secondDate = scanner.nextLine();
            
            try {

            Date startDate = dateFormat.parse(firstDate); //convertir en date
            Date endDate = dateFormat.parse(secondDate);
            
            List<Produit> produitsss = ps.findAll();
            if (produits != null) {
                System.out.println("Les produits commandés entre " + firstDate + " et " + secondDate + " sont : ");
                for (Produit produit : produits) {
                    Date dateAchat = produit.getDateAchat();
                    if (dateAchat != null && (dateAchat.after(startDate) || dateAchat.equals(startDate)) && (dateAchat.before(endDate) || dateAchat.equals(endDate))) {
                        System.out.println("ID : " + produit.getId());
                        System.out.println("Marque : " + produit.getMarque());
                        System.out.println("Référence : " + produit.getReference());
                        System.out.println("Date : " + produit.getDateAchat());
                        System.out.println("Prix : " + produit.getPrix());
                        System.out.println("Désignation : " + produit.getDesignation());
                        System.out.println("***************************");
                    }
                }
            } else {
                System.out.println("Aucun produit trouvé.");
            }
        } catch (ParseException ex) {
                System.out.println("Format de date invalide.");
        }


          */      
    }
    
    
    
    
}
