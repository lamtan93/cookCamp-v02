/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.metier;

import Outil.CustomException;
import com.cookcamp.entite.Employe;
import com.cookcamp.entite.Fonction;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GestionAuthentificationLocal {

    public Employe authentifier(String mdp) throws CustomException;

    public List<Fonction> getFontions(Employe e);
    
}
