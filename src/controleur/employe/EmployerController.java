
package controleur.employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import model.Employe;
import vue.Fen_accueil;
import vue.employe.FenC_employe;
import vue.employe.FenRUD_employe;
import vue.employe.FenRep_employe;
import vue.employe.Fen_employe;



public class EmployerController implements ActionListener, MouseListener{
    
    private Employe modelEmploye = new Employe();
    private final Fen_employe fen_employe = new Fen_employe();
    private final FenC_employe fenC_employe = new FenC_employe();
    private final FenRUD_employe fenRUD_employe = new FenRUD_employe();
    private final FenRep_employe fenRep_employe = new FenRep_employe();
    private final Fen_accueil fen_accueil = new Fen_accueil();
    //private JButton
    
    public EmployerController(Employe e){
        this.modelEmploye = e;
        fen_employe.setVisible(true);
        fen_employe.repaint();
        fen_employe.getBtnBack().addActionListener(this);
        fen_employe.getBtnC_employ().addActionListener(this);
        fen_employe.getBtnRUD_employ().addActionListener(this);
        fen_employe.getBtnRep_employ().addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("employe");
        if(ae.getSource() == fen_employe.getBtnBack()){
            fen_employe.setVisible(false);
            fen_accueil.setVisible(true);
            fen_accueil.repaint();
        }else if(ae.getSource() == fen_employe.getBtnC_employ()){
            fen_employe.setVisible(false);
            EmployeC_controller eCc = new EmployeC_controller(modelEmploye);
        }else if(ae.getSource() == fen_employe.getBtnRUD_employ()){
            fen_employe.setVisible(false);
            EmployeRUD_controller eRUDc = new EmployeRUD_controller(modelEmploye);
        }else if(ae.getSource() == fen_employe.getBtnRep_employ()){
            fen_employe.setVisible(false);
            EmployeRep_controller eRepc = new EmployeRep_controller(modelEmploye);
        }
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        
        /*if(me.equals(fenRUD_employe.getTableDonnees())){
            System.out.println("table");
        }*/
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
