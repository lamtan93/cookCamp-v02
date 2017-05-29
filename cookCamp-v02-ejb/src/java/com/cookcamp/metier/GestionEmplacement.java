
package com.cookcamp.metier;

import Outil.CustomException;
import com.cookcamp.entite.Emplacement;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionEmplacement implements GestionEmplacementLocal {
    
    
    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

   
    @Override
    public Collection<Emplacement> getEmplacements()
    {
        String jpql = "Select e from Emplacement e ";
        Query query = em.createQuery(jpql);
        return query.getResultList();
        
    }
    
    
    @Override
    public Emplacement verifierEmplacement(String numeroTable) throws CustomException
    {
        String jpql = "select epl from Emplacement epl where epl.numero=:numeroTable";
        Query query = em.createQuery(jpql);
        query.setParameter("numeroTable", numeroTable);
        
        try {
            Emplacement emplacement = (Emplacement) query.getSingleResult();
            return emplacement;
        } catch (NoResultException ne) 
        {
            HashMap<String,String> hashMapErreurs = new HashMap<>();
            hashMapErreurs.put("problemeEmplacement", "Table non existé !");
            throw new CustomException(CustomException.PROBLEME_EMPLACEMENT, hashMapErreurs);
        }
        
       
    
    }
}
