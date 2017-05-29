
package Outil;

import java.util.HashMap;


public class CustomException extends Exception {
    
    public static int Connexion_Employe = 10;
    public static int Hacker_Detected = 20;
    public static int PROBLEME_PANIER = 30;
    public static int PROBLEME_EMPLACEMENT = 40;
    
    private int numero;
    
    private HashMap<String, String> hashMapErreur;
    
    public CustomException()
    {
        
    }
    
    public CustomException(int numero, HashMap<String,String> hashMapErreur)
    {
        this.numero = numero;
        this.hashMapErreur = hashMapErreur;
    }
    
   

    public CustomException(int numero, HashMap<String, String> hashMapErreur, String message) {
        super(message);
        this.numero = numero;
        this.hashMapErreur = hashMapErreur;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public HashMap<String, String> getHashMapErreur() {
        return hashMapErreur;
    }

    public void setHashMapErreur(HashMap<String, String> hashMapErreur) {
        this.hashMapErreur = hashMapErreur;
    }
    
    
    
}
