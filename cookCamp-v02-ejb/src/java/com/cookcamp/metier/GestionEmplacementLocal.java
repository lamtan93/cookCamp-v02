/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.metier;

import Outil.CustomException;
import com.cookcamp.entite.Emplacement;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface GestionEmplacementLocal {

    public Collection<Emplacement> getEmplacements();

    public Emplacement verifierEmplacement(String numeroTable) throws CustomException;
    
}
