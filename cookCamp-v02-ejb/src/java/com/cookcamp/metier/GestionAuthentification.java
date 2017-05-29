package com.cookcamp.metier;

import Outil.CustomException;
import com.cookcamp.entite.Employe;
import com.cookcamp.entite.Fonction;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionAuthentification implements GestionAuthentificationLocal {

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

    @Override
    public Employe authentifier(String mdp) throws CustomException {

        HashMap<String, String> hashMapErr = new HashMap<>();

        String characteresInterdits = "azertyuiop^^$qsdfghjklmù*wxcvbn,;:!¨¨£%µ?./§&é'(-è_çà)=+-*/";

        if (mdp == null || mdp.trim().isEmpty()) {
            hashMapErr.put("problemeLogin", "Mot de passe ne peut pas etre vide !");
            mdp = "";

        } else if (mdp.trim().length() <4 || mdp.trim().length()>4) {
            hashMapErr.put("problemeLogin", "Longeur n'est pas bonne !");

        }else
        {
            hashMapErr.put("problemeLogin", "Mot de passe incorrect !");
        }

        for (int i = 0; i < mdp.length(); i++) {
            for (int j = 0; j < characteresInterdits.length(); j++) {

                if (mdp.charAt(i) == characteresInterdits.charAt(j)) {
                    hashMapErr.put("problemeLogin", "Mot de passe ne peut pas contenir des caractères !");
                }
            }

        }

        mdp = mdp.trim();
        try {
            String jpql = "Select e from Employe e WHERE e.login=:login";
            Query query = em.createQuery(jpql);
            query.setParameter("login", mdp);
            Employe emp = (Employe) query.getSingleResult();
            return emp;
        } catch (NoResultException ne) {

            throw new CustomException(CustomException.Connexion_Employe, hashMapErr);

        }

 
    }

    @Override
    public List<Fonction> getFontions (Employe e)
    {
        List<Fonction> listFonction = (List<Fonction>) e.getFonctions();
        return listFonction;
    }
    
}
