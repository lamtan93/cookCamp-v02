package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.Employe;
import com.cookcamp.entite.Fonction;
import com.cookcamp.entite.Information;
import com.cookcamp.entite.Ingredient;
import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import com.cookcamp.entite.Promotion;
import com.cookcamp.entite.Tva;
import com.cookcamp.entite.Type;
import com.cookcamp.entite.TypePaiement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestBDD implements TestBDDLocal {

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

    @Override
    public void creerBase() {
        // Partie Omar
        Type t1 = new Type("Entree");
        Type t2 = new Type("Plat");
        Type t3 = new Type("Dessert");
        Type t4 = new Type("Boisson");

        Produit p1 = new Produit("img/imgEntree/Burrata.jpg", 10, "Entrée Fraiche", "Burrata", 12f);
        Produit p2 = new Produit("img/imgEntree/CapreseDiBufala.jpg", 10, "Tomates fraiches servies avec Moza", "Caprese Di Bufala", 10f);
        Produit p3 = new Produit("img/imgEntree/FocacciaMilano.jpg", 10, "Entrée Paysanne", "Focaccia Milano", 15f);
        Produit p4 = new Produit("img/imgPlat/Arabiatta.jpg", 12, "plat de pates ", "Arabiatta", 12.5f);
        Produit p5 = new Produit("img/imgPlat/Farfale.jpg", 18, "plat de farfales  ", "Farfalle", 12.8f);
        Produit p6 = new Produit("img/imgPlat/LasagneBolognese.jpg", 6, "plat de lasagne cuisiné au boeuf ", "Lasagne Bolognese", 10.8f);
        Produit p7 = new Produit("img/imgPlat/LasagneBresaola.jpg", 9, "plat de lasagne cuisiné avec bresaola ", "Lasagne Bresaola", 13.8f);
        Produit p8 = new Produit("img/imgPlat/LasagneVegetariene.jpg", 9, "plat de lasagne cuisiné avec des légumes ", "Lasagne Vegetarienne", 16.8f);
        Produit p9 = new Produit("img/imgPlat/Pizza4Fromaggi.jpg", 9, "pizza avec quatre fromages", "pizza fromaggi ", 12.2f);
        Produit p10 = new Produit("img/imgPlat/PizzaCalzoneEmiliano.jpg", 9, "pizza soufflé à l'air", "Calzone Emiliano ", 15.2f);
        Produit p11 = new Produit("img/imgPlat/PizzaCalzoneNapoletano.jpg", 25, "pizza soufflé à l'air de Naples", "Calzone Napoletano ", 16.2f);
        Produit p12 = new Produit("img/imgPlat/PizzaCanadese.jpg", 25, "pizza avec surement de la tomate et du sirop d'erable", "Pizza Canadese ", 11.2f);
        Produit p13 = new Produit("img/imgPlat/PizzaCarlofortina.jpg", 25, "pizza avec surement de la tomate et du boeuf", "Pizza Carlofortina ", 18.2f);
        Produit p14 = new Produit("img/imgPlat/Pizzamargherita.jpg", 25, "pizza Marguarita ", "Pizza Marguarita ", 11.2f);
        Produit p15 = new Produit("img/imgPlat/PizzaParmigiana.jpg", 9, "pizza avec du parmesan ", "Pizza Parmigiana ", 14.85f);
        Produit p16 = new Produit("img/imgPlat/PizzaRegina.jpg", 14, "pizza avec de la regine de cannabis ", "Pizza Regina ", 15.85f);
        Produit p17 = new Produit("img/imgPlat/pizzaVegetariana.jpg", 14, "pizza vegetarienne ", "Pizza Vegetariana ", 10.85f);
        Produit p18 = new Produit("img/imgPlat/SaladeArtichauts.jpg", 14, "Salade avec ses artichauts de saison ", "Salade artichauts ", 22.92f);
        Produit p19 = new Produit("img/imgPlat/SaladeMozzarella.jpg", 19, "Salade avec sa mozzarella de saison ", "Salade Mozzarella ", 25.92f);
        Produit p20 = new Produit("img/imgPlat/SaladeVegetarienne.jpg", 19, "Salade avec ses légumes ", "Salade Vegetarienne ", 27.92f);
        Produit p21 = new Produit("img/imgBoissons/Chinotto.jpg", 19, "Boisson alcoolisé", "Chinoto ", 12f);
        Produit p22 = new Produit("img/imgBoissons/Limonade.jpg", 11, "Boisson sans alcool", "Limonade ", 4f);
        Produit p23 = new Produit("img/imgBoissons/OrangeSanguine.jpg", 15, "Boisson sans alcool", "Orange Sanguine", 4.5f);
        Produit p24 = new Produit("img/imgBoissons/Peroni.jpg", 15, "Boisson avec alcool", "Peroni", 9f);
        Produit p25 = new Produit("img/imgBoissons/Prosecco.jpg", 18, "Boisson avec alcool", "Prosecco", 15f);
        Produit p26 = new Produit("img/imgBoissons/RoccaRubbia.jpg", 18, "Boisson avec alcool", "Rocca Rubbia", 35f);
        Produit p27 = new Produit("img/imgBoissons/SanPellegrino.jpg", 45, "Boisson sans alcool", "San pellegrino", 8f);
        Produit p28 = new Produit("img/imgBoissons/VinRose.jpg", 78, "Boisson avec alcool", "Vin Rose", 25f);
        Produit p29 = new Produit("img/imgBoissons/VinRouge.jpg", 18, "Boisson avec alcool", "Vin Rouge", 38f);
        Produit p30 = new Produit("img/imgDessert/BabaAuLimoncello.jpg", 15, "Dessert Alcoolise", "Baba Au Limoncello", 6f);
        Produit p31 = new Produit("img/imgDessert/Cheesecake.jpg", 15, "Fromage Blanc", "Cheesecake", 3f);
        Produit p32 = new Produit("img/imgDessert/GlaceBio.jpg", 15, "Creme glacee", "Glace Bio", 9f);
        Produit p33 = new Produit("img/imgDessert/Moelleux.jpg", 15, "Tout Chocolat", "Moelleux", 3f);
        Produit p34 = new Produit("img/imgDessert/PannacottafruitRouge.jpg", 15, "Un nom compliqué pour faire style", "PannaCotta Fruits Rouges", 5f);
        Produit p35 = new Produit("img/imgDessert/SableAuxPommes.jpg", 15, "Croustillants a l'exterieur, fondant a l'interieur", "Sable aux pommes", 4f);
        Produit p36 = new Produit("img/imgDessert/SaladeDeFruits.jpg", 15, "Le seul dessert qui vaut le coup", "Salade de fruits", 2f);
        Produit p37 = new Produit("img/imgDessert/Tiramisu.jpg", 15, "Chocolat caramel", "Tiramisu", 2f);

        p30.setType(t3);
        p31.setType(t3);
        p32.setType(t3);
        p33.setType(t3);
        p34.setType(t3);
        p35.setType(t3);
        p36.setType(t3);
        p37.setType(t3);
        
        
        List<Produit> boisson = new ArrayList<>();
        boisson.add(p21);
        boisson.add(p22);
        boisson.add(p22);
        boisson.add(p23);

        boisson.add(p24);

        boisson.add(p25);
        boisson.add(p26);
        boisson.add(p27);
        boisson.add(p28);
        boisson.add(p29);
     
        

        p1.setType(t1);
        p2.setType(t1);
        p3.setType(t1);
        p4.setType(t2);
        p5.setType(t2);
        p6.setType(t2);
        p7.setType(t2);
        p8.setType(t2);
        p9.setType(t2);
        p10.setType(t2);
        p11.setType(t2);
        p12.setType(t2);
        p13.setType(t2);
        p14.setType(t2);
        p15.setType(t2);
        p16.setType(t2);
        p17.setType(t2);
        p18.setType(t2);
        p19.setType(t2);
        p20.setType(t2);


        
        
        Ingredient ing1 = new Ingredient("oeuf", "France");
        Ingredient ing2 = new Ingredient("moule", "Begique");
        Ingredient ing3 = new Ingredient("gruyere", "Suisse");
        Ingredient ing4 = new Ingredient("semoule", "Algerie");
        Ingredient ing5 = new Ingredient("soja", "Chine");
        Ingredient ing6 = new Ingredient("sel", "France");
        Ingredient ing7 = new Ingredient("poivre", "France");
        Ingredient ing8 = new Ingredient("thym", "France");
        Ingredient ing9 = new Ingredient("tomates", "Maroc");
        Ingredient ing10 = new Ingredient("pâte", "Italie");
        Ingredient ing11 = new Ingredient("poivron", "Algerie");
        Ingredient ing12 = new Ingredient("basilic", "Grece");
        Ingredient ing13 = new Ingredient("parmesan", "Italie");
        Ingredient ing14 = new Ingredient("creme fraiche", "France");
        Ingredient ing15 = new Ingredient("emmental", "France");
        Ingredient ing16 = new Ingredient("coppa", "Italie");
        Ingredient ing17 = new Ingredient("farine", "Allemagne");
        Ingredient ing18 = new Ingredient("champignons", "France");
        Ingredient ing19 = new Ingredient("anchois", "Grece");
        Ingredient ing20 = new Ingredient("aubergines", "Belgique");
        Ingredient ing21 = new Ingredient("courgettes", "Hollande");
        Ingredient ing22 = new Ingredient("piments", "Tunisie");
        Ingredient ing23 = new Ingredient("romarin", "Hollande");
        
        p9.getIngredients().add(ing3);
        p9.getIngredients().add(ing9);
        p9.getIngredients().add(ing10);
        p9.getIngredients().add(ing11);
        p9.getIngredients().add(ing12);
        p9.getIngredients().add(ing13);
        p9.getIngredients().add(ing15);
        p9.getIngredients().add(ing16);
        p9.getIngredients().add(ing17);
        
        p37.getIngredients().add(ing1);
        p37.getIngredients().add(ing14);
        
        p1.getIngredients().add(ing1);
        p1.getIngredients().add(ing2);
        p1.getIngredients().add(ing3);
        p1.getIngredients().add(ing4);
        
        p2.getIngredients().add(ing1);
        p2.getIngredients().add(ing5);
        p2.getIngredients().add(ing6);
        p2.getIngredients().add(ing7);
        
        p3.getIngredients().add(ing8);
        p3.getIngredients().add(ing9);
        p3.getIngredients().add(ing10);
        p3.getIngredients().add(ing2);
        
        p4.getIngredients().add(ing2);
        p4.getIngredients().add(ing15);
        p4.getIngredients().add(ing10);
        p4.getIngredients().add(ing22);
        
        p5.getIngredients().add(ing8);
        p5.getIngredients().add(ing18);
        p5.getIngredients().add(ing19);
        p5.getIngredients().add(ing23);
       

        //TVA
        Tva tv1 = new Tva(5.5f, new Date());
        Tva tv2 = new Tva(10f, new Date());
        Tva tv3 = new Tva(20f, new Date());
           for(Produit p :boisson){
            p.setType(t4);
            p.setTva(tv3);
        }

        p1.setTva(tv1);
        p2.setTva(tv2);
        p3.setTva(tv3);
        p4.setTva(tv1);
        p5.setTva(tv1);
        p6.setTva(tv1);
        p7.setTva(tv1);
        p8.setTva(tv1);
        p9.setTva(tv1);
        p10.setTva(tv1);
        p11.setTva(tv2);
        p12.setTva(tv2);
        p13.setTva(tv2);
        p14.setTva(tv2);
        p15.setTva(tv2);
        p16.setTva(tv2);
        p17.setTva(tv3);
        p18.setTva(tv3);
        p19.setTva(tv3);
        p20.setTva(tv3);
        p30.setTva(tv1);
        p31.setTva(tv1);
        p32.setTva(tv1);
        p33.setTva(tv1);
        p34.setTva(tv1);
        p35.setTva(tv1);
        p36.setTva(tv1);
        p37.setTva(tv1);
        
        //----------------------------------
        Information inf1 = new Information("Calories", "300");
        Information inf2 = new Information("Taille", "25cm");
        p9.getInformations().add(inf2);
        p9.getInformations().add(inf1);
        
        
        //Promos
        Promotion pro1 = new Promotion(0.25f, new GregorianCalendar(2016, 7, 25).getTime(), new GregorianCalendar(2016, 6, 25).getTime());
        Promotion pro2 = new Promotion(0.2f, new GregorianCalendar(2016, 7, 01).getTime(), new GregorianCalendar(2016, 6, 26).getTime());
        p1.getPromotions().add(pro1);
        p2.getPromotions().add(pro2);
        p3.getPromotions().add(pro1);
        p3.getPromotions().add(pro2);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);
        em.persist(p8);
        em.persist(p9);
        em.persist(p10);
        em.persist(p11);
        em.persist(p12);
        em.persist(p13);
        em.persist(p14);
        em.persist(p15);
        em.persist(p16);
        em.persist(p17);
        em.persist(p18);
        em.persist(p19);
        em.persist(p20);
        em.persist(p30);
        em.persist(p37);
        em.persist(p31);
        em.persist(p32);
        em.persist(p33);
        em.persist(p34);
        em.persist(p35);
        em.persist(p36);
        for (Produit b : boisson) {
            em.persist(b);
        }
        

        
        
        Menu m1 = new Menu("Midi", "Menu Uno", 9.9f);
        m1.getProduits().add(p2);
        m1.getProduits().add(p3);
        m1.getProduits().add(p13);
        m1.getProduits().add(p9);
        m1.getProduits().add(p23);
        m1.setTva(tv3);
        
        Menu m2 = new Menu("Soir", "Menu Bambino", 5.5f);
        m2.getProduits().add(p1);
        m2.getProduits().add(p2);
        m2.getProduits().add(p3);
        m2.getProduits().add(p10);
        m2.getProduits().add(p11);
        m2.getProduits().add(p12);
        m2.getProduits().add(p22);
        m2.getProduits().add(p23);
        m2.getProduits().add(p24);
        
        Menu m3 = new Menu("Midi", "Menu Halal", 10f);
        m3.getProduits().add(p2);
        m3.getProduits().add(p8);
        m3.getProduits().add(p26);
        m3.getProduits().add(p37);
        m3.getPromotions().add(pro1);
        
        em.persist(m2);
        em.persist(m1);
        em.persist(m3);

        
        //-------------------Abdel-----------
        
        

        
           //---Employe-------------
        Employe employe01 = new Employe("LAM", "Tan", "1234");
        Employe employe02 = new Employe("GASQUE", "Yoann", "1245");
        Employe employe03 = new Employe("LIV", "Leon", "4567");
        Employe employe04 = new Employe("NASSIVERA", "Rémi", "4578");
        Employe employe05 = new Employe("Zrod", "Omar", "7891");
        Employe employe06 = new Employe("Feta", "Abdel", "7878");

        Fonction fonctionServeur = new Fonction("Serveur");
        Fonction fonctionCuisinier = new Fonction("Cuisinier");
        Fonction fonctionResponsable = new Fonction("Responsable");

        Collection<Employe> listServeurs = fonctionServeur.getEmployes();
        listServeurs.add(employe01);
        listServeurs.add(employe02);

        Collection<Employe> listResponsables = fonctionResponsable.getEmployes();
        listResponsables.add(employe03);
        listResponsables.add(employe04);

        Collection<Employe> listCuisiniers = fonctionCuisinier.getEmployes();
        listCuisiniers.add(employe05);
        listCuisiniers.add(employe06);

        em.persist(fonctionServeur);
        em.persist(fonctionCuisinier);
        em.persist(fonctionResponsable);
        
        
        
        
        //        em.persist(ligneCommandeProduit01);
        Emplacement em1 = new Emplacement("1", 5, "Libre");
        Emplacement em2 = new Emplacement("2", 5, "Libre");
        Emplacement em3 = new Emplacement("3", 5, "Libre");
        Emplacement em4 = new Emplacement("4", 5, "Libre");
        Emplacement em5 = new Emplacement("5", 10, "Libre");
        Emplacement em6 = new Emplacement("6", 10, "Libre");
        Emplacement em7 = new Emplacement("7", 8, "Libre");
        Emplacement em8 = new Emplacement("8", 9, "Libre");
        Emplacement em9 = new Emplacement("9", 4, "Libre");
        
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>apres emplacemcement");
        Commande c01 = new Commande("en cours", em1);
        Commande c02 = new Commande("en cours", em2);
        Commande c03 = new Commande("en cours", em3);
        Commande c04 = new Commande("en cours", em4);
        Commande c05 = new Commande("en cours", em5);
        Commande c06 = new Commande("en cours", em6);

        System.out.println("###############################################################avant persitance ligne de commande ###############");
        LignedeCommandeProduit ligne = new LignedeCommandeProduit();
        ligne.setProduit(p29);
        //em.persist(ligne);
        LignedeCommandeProduit l02 = new LignedeCommandeProduit();
        l02.setProduit(p9);

        LignedeCommandeProduit l03 = new LignedeCommandeProduit();
        l03.setProduit(p1);
        List<LignedeCommandeProduit> premier = new ArrayList();
        premier.add(l03);
        premier.add(l02);
        premier.add(ligne);
//        for (LignedeCommandeProduit ldcp : premier) {
//            em.persist(ldcp);
//        }
        LignedeCommandeProduit l04 = new LignedeCommandeProduit(p14);
        LignedeCommandeProduit l05 = new LignedeCommandeProduit(p2);
        LignedeCommandeProduit l06 = new LignedeCommandeProduit(p3);
        LignedeCommandeProduit l07 = new LignedeCommandeProduit(p1);
        LignedeCommandeProduit l08 = new LignedeCommandeProduit(p15);
        LignedeCommandeProduit l09 = new LignedeCommandeProduit(p18);
        LignedeCommandeProduit l10 = new LignedeCommandeProduit(p10);
        LignedeCommandeProduit l12 = new LignedeCommandeProduit(p24);
        LignedeCommandeProduit l13 = new LignedeCommandeProduit(p21);
        LignedeCommandeProduit l14 = new LignedeCommandeProduit(p8);
        LignedeCommandeProduit l15 = new LignedeCommandeProduit(p17);
        LignedeCommandeProduit l16 = new LignedeCommandeProduit(p18);
        LignedeCommandeProduit l17 = new LignedeCommandeProduit(p23);
        LignedeCommandeProduit l18 = new LignedeCommandeProduit(p7);
        LignedeCommandeProduit l19 = new LignedeCommandeProduit(p8);
        LignedeCommandeProduit l20 = new LignedeCommandeProduit(p19);

        System.out.println("#######################################################apres ligne de commande Produit########################");

        l04.setCommande(c02);
        l06.setCommande(c02);
        l07.setCommande(c02);
        l08.setCommande(c02);
        l09.setCommande(c03);
        l10.setCommande(c03);
        l12.setCommande(c03);
        l13.setCommande(c04);
        l14.setCommande(c04);
        l15.setCommande(c05);
        l16.setCommande(c05);
        l17.setCommande(c06);
        l18.setCommande(c06);
        l19.setCommande(c06);
        l20.setCommande(c06);

        List<LignedeCommandeProduit> deux = new ArrayList();

        deux.add(l04);
        deux.add(l05);
        deux.add(l06);
        deux.add(l07);
        deux.add(l08);
        deux.add(l09);
        deux.add(l10);
        deux.add(l12);
        deux.add(l13);
        deux.add(l14);
        deux.add(l15);
        deux.add(l16);
        deux.add(l17);
        deux.add(l18);
        deux.add(l19);
        deux.add(l20);

        for (LignedeCommandeProduit ldcp : premier) {
            ldcp.setCommande(c01);
            em.persist(ldcp);
        }
        for (LignedeCommandeProduit ldcp : deux) {

            em.persist(ldcp);
        }

        System.out.println("#######################################################apres ligne de commande Menu########################");

        LigneCommandeMenu lm1 = new LigneCommandeMenu();
        lm1.setMenu(m3);
        lm1.getProduits().add(p1);
        lm1.getProduits().add(p15);
        lm1.getProduits().add(p29);

        
        LigneCommandeMenu lm4 = new LigneCommandeMenu();
        lm4.getProduits().add(p15);
        lm4.setMenu(m1);

        LigneCommandeMenu lm5 = new LigneCommandeMenu();
        lm5.getProduits().add(p9);
        lm4.setMenu(m2);
        

        LigneCommandeMenu line2 = new LigneCommandeMenu();
        line2.setMenu(m1);
        
        LigneCommandeMenu lm6 = new LigneCommandeMenu();
        lm6.setMenu(m2);

        LigneCommandeMenu lm7 = new LigneCommandeMenu();
        lm7.setMenu(m3);

        List<LigneCommandeMenu> quatre = new ArrayList();
        quatre.add(lm1);
        quatre.add(lm4);
        quatre.add(lm5);
        quatre.add(line2);
        quatre.add(lm6);
        quatre.add(lm7);
        
        LigneCommandeMenu lp1 = new LigneCommandeMenu();
        lp1.setMenu(m3);
        lp1.setPrix(m3.getPrix());
        lp1.getProduits().add(p2);
        lp1.getProduits().add(p20);
        
        LigneCommandeMenu lp2 = new LigneCommandeMenu();
        lp2.setMenu(m2);
        lp2.setPrix(m2.getPrix());
        lp2.getProduits().add(p3);
        lp2.getProduits().add(p19);
        
        LigneCommandeMenu lp3 = new LigneCommandeMenu();
        lp3.setMenu(m1);
        lp3.setPrix(m1.getPrix());
        lp3.getProduits().add(p1);
        lp3.getProduits().add(p12);
//
//        LigneCommandeMenu lm6 = new LigneCommandeMenu(m1);
        LigneCommandeMenu lm2 = new LigneCommandeMenu(m2);
        lm2.setMenu(m1);
        lm2.setPrix(m1.getPrix());
        lm2.getProduits().add(p1);
        lm2.getProduits().add(p12);

        lp1.setCommande(c02);
        lp2.setCommande(c02);
        lp3.setCommande(c02);
        lm1.setCommande(c02);
        lp1.setCommande(c03);
        lp2.setCommande(c03);
        lp3.setCommande(c03);
        lp1.setCommande(c04);
        lp2.setCommande(c04);
        lp1.setCommande(c05);
        lp2.setCommande(c05);
        lp1.setCommande(c06);
        lp2.setCommande(c06);
        lp3.setCommande(c06);
        lm2.setCommande(c06);

        List<LigneCommandeMenu> trois = new ArrayList();
        
        trois.add(lp1);
        trois.add(lp2);
        trois.add(lp3);
        trois.add(lm1);
        trois.add(lm2);
        
        
        for (LigneCommandeMenu ldcm : quatre) {
            ldcm.setCommande(c01);
            em.persist(ldcm);
        }
        for (LigneCommandeMenu ldcm : trois) {

            em.persist(ldcm);
        }
       
    }
}
