
package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.MetaDataModel;
import vue.Fen_MetaData;
import static vue.chambre.FenC_chambre.fieldCleInfirm;
import vue.malade.FenC_malade;
import static vue.service.FenC_service.fieldCleDocteur;

public class MetaDataController implements ActionListener, MetaDataInterface{ //implementation 
    
    public static int cleDocteur = 0;
    public static int cleSurveillant = 0;
    public static int cleMalade = 0;
    
    private final Fen_MetaData fen_MetaData = new Fen_MetaData(); //déclaration d'une new fen
    private MetaDataModel modelMetaData;
    private int typeCle =0;
    
    public MetaDataController(MetaDataModel mMD, int typeCle) {
        
        this.modelMetaData = mMD;
        this.typeCle = typeCle;
        
        fen_MetaData.getTableDonnee().getColumnModel().getColumn(0).setMaxWidth(0);
        fen_MetaData.getTableDonnee().getColumnModel().getColumn(0).setMinWidth(0);
        fen_MetaData.getTableDonnee().getColumnModel().getColumn(0).setPreferredWidth(0);
        
        fen_MetaData.setVisible(true);
        fen_MetaData.getBtnValider().addActionListener(this);
        fen_MetaData.getBtnAnnuler().addActionListener(this);
        CellReadOnly(fen_MetaData.getTableDonnee());

        switch (typeCle){
            case 1:
                fen_MetaData.getLabelTitre().setText("Selectionner le Docteur à affecter !!!");
                fen_MetaData.getTableDonnee().setModel(mMD.getModelDataDoc());
                break;
            case 2:
                fen_MetaData.getLabelTitre().setText("Selectionner l'infirmière à affecter !!!");
                fen_MetaData.getTableDonnee().setModel(mMD.getModelDataInf());
                break;
            case 3:
                fen_MetaData.getLabelTitre().setText("Selectionner le malade correspondant !!!");
                fen_MetaData.getTableDonnee().setModel(mMD.getModelDataMal());
                break;
        }

    }

        public void CellReadOnly(JTable table){
        for (int i=0; i < table.getColumnCount(); i++){
            Class<?> col_class = table.getColumnClass(i);
            table.setDefaultEditor(col_class, null);
        }
    }  
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fen_MetaData.getBtnAnnuler())){
            fen_MetaData.dispose();
        }
        else if(ae.getSource().equals(fen_MetaData.getBtnValider())){ //losrque le buton valider est actionné
            int i = fen_MetaData.getTableDonnee().getSelectedRow();
            if(i>=0){
                if(typeCle == 1) {
                    cleDocteur = modelMetaData.getCleDocteur(i);
                    fieldCleDocteur.setText(modelMetaData.getModelDataDoc().getValueAt(i, 1).toString() +", "+ modelMetaData.getModelDataDoc().getValueAt(i, 2).toString() +","+ modelMetaData.getModelDataDoc().getValueAt(i, 3).toString());
                }else if(typeCle == 2){
                    cleSurveillant = modelMetaData.getCleInfirmier(i);
                    fieldCleInfirm.setText(modelMetaData.getModelDataInf().getValueAt(i, 1).toString() +", "+ modelMetaData.getModelDataInf().getValueAt(i, 2).toString() +","+ modelMetaData.getModelDataInf().getValueAt(i, 3).toString());
                }else if(typeCle == 3){
                    cleMalade = modelMetaData.getCleMalade(i);
                    //fieldCleDocteur.setText(modelMetaData.getModelDataDoc().getValueAt(i, 1).toString() +", "+ modelMetaData.getModelDataDoc().getValueAt(i, 2).toString() +","+ modelMetaData.getModelDataDoc().getValueAt(i, 3).toString());
                }
                fen_MetaData.dispose();
            }
        }
    }
}