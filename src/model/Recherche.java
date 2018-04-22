
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import static model.Accueil.connex;


public class Recherche {

    private DefaultTableModel dModelData;
    
    public Recherche() {
    
    }
    
    
    public DefaultTableModel getModelDataEmploye(){
        DefaultTableModel modelDataEmploye = new DefaultTableModel();
        modelDataEmploye.addColumn("numero employe");
        modelDataEmploye.addColumn("Nom");
        modelDataEmploye.addColumn("Prenom");
        modelDataEmploye.addColumn("Adresse");
        modelDataEmploye.addColumn("Teléphone");
        modelDataEmploye.addColumn("Spécialité Docteur");
        modelDataEmploye.addColumn("Code service Infirmier");
        modelDataEmploye.addColumn("Rotation Infirmier");
        modelDataEmploye.addColumn("Salaire Infirmier");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT employe.numero, employe.nom, employe.prenom, employe.adresse, employe.tel, docteur.specialite, infirmier.code_service, infirmier.rotation, infirmier.salaire FROM employe LEFT JOIN infirmier ON employe.numero = infirmier.numero LEFT JOIN docteur ON employe.numero = docteur.numero;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataEmploye.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return modelDataEmploye;
        
    }
    
    public DefaultTableModel getModelDataChambre(){
        DefaultTableModel modelDataChambre = new DefaultTableModel();
        modelDataChambre.addColumn("numero Chambre");
        modelDataChambre.addColumn("Code service");
        modelDataChambre.addColumn("Nombre de lit");
        modelDataChambre.addColumn("Nom Surveillant");
        modelDataChambre.addColumn("Prenom Surveillant");
        modelDataChambre.addColumn("Adresse Surveillant");
        modelDataChambre.addColumn("Teléphone Surveillant");
        modelDataChambre.addColumn("Rotation Infirmier");
        modelDataChambre.addColumn("Salaire Infirmier");
        

        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT chambre.no_chambre, chambre.code_service, chambre.nb_lits, employe.nom, employe.prenom, employe.adresse, employe.tel, infirmier.rotation, infirmier.salaire FROM employe LEFT JOIN infirmier ON employe.numero = infirmier.numero LEFT JOIN chambre ON chambre.surveillant = employe.numero  WHERE (chambre.code_service IS NOT NULL AND chambre.no_chambre IS NOT NULL) ORDER BY `chambre`.`no_chambre` ASC;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataChambre.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataChambre;
        
    }
    
    public DefaultTableModel getModelDataMalade(){
        DefaultTableModel modelDataMalade = new DefaultTableModel();
        modelDataMalade.addColumn("numero malade");
        modelDataMalade.addColumn("Nom");
        modelDataMalade.addColumn("Prenom");
        modelDataMalade.addColumn("Teléphone");
        modelDataMalade.addColumn("Adresse");
        modelDataMalade.addColumn("Mutuelle Malade");

        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT malade.numero, malade.nom, malade.prenom, malade.tel, malade.adresse, malade.mutuelle FROM malade ORDER BY `malade`.`nom` ASC;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataMalade.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataMalade;
        
    }
    
    public DefaultTableModel getModelDataSoigne(){
        DefaultTableModel modelDataSoigne = new DefaultTableModel();
        
        modelDataSoigne.addColumn("Nom Docteur");
        modelDataSoigne.addColumn("Prenom Docteur");
        modelDataSoigne.addColumn("Adresse Docteur");
        modelDataSoigne.addColumn("Teléphone Docteur");
        modelDataSoigne.addColumn("Sexe Docteur");
        modelDataSoigne.addColumn("Email Docteur");
        modelDataSoigne.addColumn("Nom Malade");
        modelDataSoigne.addColumn("Prenom Malade");
        modelDataSoigne.addColumn("Teléphone Malade");
        modelDataSoigne.addColumn("Adresse Malade");
        modelDataSoigne.addColumn("Mutuelle Malade");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT employe.nom, employe.prenom, employe.adresse, employe.tel, employe.sexe, employe.email, malade.nom, malade.prenom, malade.tel, malade.adresse, malade.mutuelle FROM employe LEFT JOIN soigne ON employe.numero = soigne.no_docteur LEFT JOIN malade ON malade.numero=soigne.no_malade WHERE (soigne.no_docteur= employe.numero AND soigne.no_malade = malade.numero) ORDER BY `employe`.`numero` ASC;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataSoigne.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataSoigne;
        
    }
    
    public DefaultTableModel getModelDataHospitalisation(){
        DefaultTableModel modelDataHospita = new DefaultTableModel();

        modelDataHospita.addColumn("Nom Malade");
        modelDataHospita.addColumn("Prénom Malade");
        modelDataHospita.addColumn("Teléphone Malade");
        modelDataHospita.addColumn("Adresse Malade");
        modelDataHospita.addColumn("Date de Naissance");
        modelDataHospita.addColumn("Taille Malade");
        modelDataHospita.addColumn("Poids Malade");
        modelDataHospita.addColumn("Sexe du Malade");
        modelDataHospita.addColumn("Mutuelle");
        modelDataHospita.addColumn("Code service");
        modelDataHospita.addColumn("Numéro de chambre");
        modelDataHospita.addColumn("Nombre de lit");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT malade.nom, malade.prenom, malade.tel, malade.adresse, malade.age, malade.taille, malade.poids, malade.sexe, malade.mutuelle, hospitalisation.code_service, hospitalisation.no_chambre, hospitalisation.lit FROM malade LEFT JOIN hospitalisation ON hospitalisation.no_malade = malade.numero WHERE (hospitalisation.no_malade=malade.numero) ORDER BY `malade`.`numero` ASC;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataHospita.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataHospita;
        
    }
     
    public DefaultTableModel getModelDataService(){
        DefaultTableModel modelDataService = new DefaultTableModel();

        modelDataService.addColumn("Code du service");
        modelDataService.addColumn("Nom du service");
        modelDataService.addColumn("Batiment du service");
        modelDataService.addColumn("Nom du directeur");
        modelDataService.addColumn("Prénom du directeur");
        modelDataService.addColumn("Téléphone du directeur");
        modelDataService.addColumn("Adresse du directeur");
        modelDataService.addColumn("Email du directeur");
    
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT service.code,service.nom,service.batiment, employe.nom, employe.prenom, employe.adresse, employe.tel, employe.sexe, employe.email FROM employe LEFT JOIN service ON employe.numero = service.directeur WHERE (service.directeur= employe.numero) ORDER BY `service`.`code` ASC;");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataService.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataService;
        
    }
    
    public DefaultTableModel findExpressionE(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("numero employe");
        modelDataR.addColumn("Nom");
        modelDataR.addColumn("Prenom");
        modelDataR.addColumn("Adresse");
        modelDataR.addColumn("Teléphone");
        modelDataR.addColumn("Spécialité Docteur");
        modelDataR.addColumn("Code service Infirmier");
        modelDataR.addColumn("Rotation Infirmier");
        modelDataR.addColumn("Salaire Infirmier");
        
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.adresse, employe.tel, infirmier.code_service, infirmier.rotation, infirmier.salaire FROM employe "
                    + "LEFT JOIN infirmier ON employe.numero = infirmier.numero "
                    + "LEFT JOIN docteur ON employe.numero = docteur.numero"
                    + " WHERE (employe.nom='"+ expression +"' OR employe.prenom='"+expression+"' OR employe.tel='"+expression+"' OR docteur.specialite='"+expression+"' OR infirmier.code_service='"+expression+"' OR infirmier.rotation='"+expression+"');");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

public DefaultTableModel findExpressionC(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("numero Chambre");
        modelDataR.addColumn("Code service");
        modelDataR.addColumn("Nom Surveillant");
        modelDataR.addColumn("Prenom Surveillant");
        modelDataR.addColumn("Adresse Surveillant");
        modelDataR.addColumn("Teléphone Surveillant");
        modelDataR.addColumn("Rotation Infirmier");
        modelDataR.addColumn("Salaire Infirmier");
        modelDataR.addColumn("Nombre de lit");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT employe.numero, employe.nom, employe.prenom, employe.adresse, employe.tel, infirmier.code_service, infirmier.rotation, infirmier.salaire FROM employe "
                    + "LEFT JOIN infirmier ON employe.numero = infirmier.numero "
                    + "LEFT JOIN docteur ON employe.numero = docteur.numero"
                    + " WHERE (employe.nom='"+ expression +"' OR employe.prenom='"+expression+"' OR employe.tel='"+expression+"' OR docteur.specialite='"+expression+"' OR infirmier.code_service='"+expression+"' OR infirmier.rotation='"+expression+"');");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

public DefaultTableModel findExpressionM(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("numero malade");
        modelDataR.addColumn("Nom");
        modelDataR.addColumn("Prenom");
        modelDataR.addColumn("Teléphone");
        modelDataR.addColumn("Adresse");
        modelDataR.addColumn("Mutuelle Malade");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT malade.numero, malade.nom, malade.prenom, malade.tel, malade.adresse, malade.mutuelle FROM malade "
                    + " WHERE (malade.nom='"+ expression +"' OR malade.prenom='"+expression+"' OR malade.tel='"+expression+"' OR malade.adresse='"+expression+"' OR malade.mutuelle='"+expression+"');");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

public DefaultTableModel findExpressionH(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("Nom Malade");
        modelDataR.addColumn("Prénom Malade");
        modelDataR.addColumn("Teléphone Malade");
        modelDataR.addColumn("Adresse Malade");
        modelDataR.addColumn("Date de Naissance");
        modelDataR.addColumn("Taille Malade");
        modelDataR.addColumn("Poids Malade");
        modelDataR.addColumn("Sexe du Malade");
        modelDataR.addColumn("Mutuelle");
        modelDataR.addColumn("Code service");
        modelDataR.addColumn("Numéro de chambre");
        modelDataR.addColumn("Nombre de lit");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT malade.nom, malade.prenom, malade.tel, malade.adresse, malade.age, malade.taille, malade.poids, malade.sexe, malade.mutuelle, hospitalisation.code_service, hospitalisation.no_chambre, hospitalisation.lit "
                    + "FROM malade LEFT JOIN hospitalisation ON hospitalisation.no_malade = malade.numero "
                    + "WHERE ((hospitalisation.no_malade=malade.numero)"
                    + " AND (malade.nom='"+ expression +"' OR malade.prenom='"+expression+"' OR malade.tel='"+expression+"' OR malade.age="+Date.parse(expression)+" "
                            + "OR malade.taille="+Double.parseDouble(expression)+" OR malade.poids="+Double.parseDouble(expression)+" OR malade.sexe='"+expression+"' "
                                    + "OR malade.mutuelle='"+expression+"' OR hospitalisation.code_service ='"+expression+"' OR hospitalisation.no_chambre ="+Integer.parseInt(expression)+" OR hospitalisation.lit= "+Integer.parseInt(expression)+"));");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

public DefaultTableModel findExpressionSo(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("Nom Docteur");
        modelDataR.addColumn("Prenom Docteur");
        modelDataR.addColumn("Adresse Docteur");
        modelDataR.addColumn("Teléphone Docteur");
        modelDataR.addColumn("Sexe Docteur");
        modelDataR.addColumn("Email Docteur");
        modelDataR.addColumn("Nom Malade");
        modelDataR.addColumn("Prenom Malade");
        modelDataR.addColumn("Teléphone Malade");
        modelDataR.addColumn("Adresse Malade");
        modelDataR.addColumn("Mutuelle Malade");
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT employe.nom, employe.prenom, employe.adresse, employe.tel, employe.sexe, employe.email, malade.nom, malade.prenom, malade.tel, malade.adresse, malade.mutuelle "
                    + "FROM employe LEFT JOIN soigne ON employe.numero = soigne.no_docteur LEFT JOIN malade ON malade.numero=soigne.no_malade "
                    + "WHERE ((soigne.no_docteur= employe.numero AND soigne.no_malade = malade.numero) "
                    + "AND (employe.nom='"+ expression +"' OR employe.prenom='"+expression+"' OR employe.tel='"+expression+"' OR employe.sexe='"+expression+"' OR employe.email='"+expression+"' "
                            + "OR malade.nom='"+expression+"' OR malade.prenom='"+expression+"' OR malade.tel='"+expression+"' OR malade.mutuelle='"+expression+"'));");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

public DefaultTableModel findExpressionSe(String expression){
        DefaultTableModel modelDataR = new DefaultTableModel();
        modelDataR.addColumn("Code du service");
        modelDataR.addColumn("Nom du service");
        modelDataR.addColumn("Batiment du service");
        modelDataR.addColumn("Nom du directeur");
        modelDataR.addColumn("Prénom du directeur");
        modelDataR.addColumn("Téléphone du directeur");
        modelDataR.addColumn("Adresse du directeur");
        modelDataR.addColumn("Email du directeur"); 
        try {
            ArrayList<String> liste = new ArrayList<String>();
            //J'effectue une jointure pour avoir les informations des employe tous confondus.
            liste = connex.remplirChampsRequete("SELECT DISTINCT service.code, service.nom, service.batiment, employe.nom, employe.prenom, employe.adresse, employe.tel, employe.sexe, employe.email "
                    + "FROM employe LEFT JOIN service ON employe.numero = service.directeur "
                    + "WHERE ((service.directeur= employe.numero) "
                    + "AND (employe.nom='"+ expression +"' OR employe.prenom='"+expression+"' OR employe.tel='"+expression+"' OR employe.sexe='"+expression+"' OR employe.email+'"+expression+"' "
                            + "OR service.code='"+expression+"' OR service.nom='"+expression+"' OR service.batiment='"+expression+"'));");
            Iterator iter = liste.iterator();
            
            while(iter.hasNext()){
                String string = new String();
                ArrayList<String> data = new ArrayList<String>();  
                string = (String)iter.next();
                for(String str:string.split("___")){
                    data.add(str);
                }
                ArrayList<Object> objet = new ArrayList<Object>();
                for(int j=0; j<data.size(); j++){
                    objet.add(data.get(j));
                }
                modelDataR.addRow(objet.toArray());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelDataR;
    }

}