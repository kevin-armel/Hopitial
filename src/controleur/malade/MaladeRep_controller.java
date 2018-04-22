
package controleur.malade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Malade;
import vue.malade.FenRep_malade;



///////////////////////////////////////////////////////////////
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 


public class MaladeRep_controller implements ActionListener, MaladeRep_Interface{
    
    private Malade modelMalade = new Malade();
    private final FenRep_malade fenRep_malade = new FenRep_malade();

    public MaladeRep_controller(Malade m) {
        this.modelMalade = m;
        
        //Creation panel
        /*
        setContentPane(createDemoPanel( ));
            public static JPanel createDemoPanel( ) {
            JFreeChart chart = createChart(createDataset( ) );  
            return new ChartPanel( chart ); 
            }
        */
        JFreeChart chart = new JFreeChart(new PiePlot());  
        ChartPanel panelGraph = new ChartPanel( chart );
        
        
        fenRep_malade.getBtnBack().addActionListener(this);
        fenRep_malade.setVisible(true);
        fenRep_malade.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(fenRep_malade.getBtnBack())){
            fenRep_malade.dispose();
            MaladeController mc = new MaladeController(modelMalade);
        }
    }
    
    
//}



   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      dataset.setValue( "MotoG" , new Double( 40 ) );    
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   


   /*public static void main( String[ ] args ) {
      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }*/
}