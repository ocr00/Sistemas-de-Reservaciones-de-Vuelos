package reservaciones.pantallas;

import reservaciones.dominio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTabla extends PanelData {

    private JScrollPane scrollPane;
    
    private int xsize;
    private int ysize;
    
    public PanelTabla(JTable jt) {
        super(jt);
    }
    public PanelTabla(JPanel p,String str,int x,int y) {
        super(p,str);
        xsize = x;
        ysize = y;
        comp = new JTable();
        comp.setName(str);
        ((JTable) comp).setPreferredScrollableViewportSize(new Dimension(x, y));
        scrollPane = new JScrollPane(comp);
        p.add(scrollPane);
    }
    public String leerTexto(String name0){ return ""; }
    
    public void escribirElementos(DatosMultiples datos) {

        String name0,str;
        if (datos == null || datos.numeroDatos() == 0)
            return;
        String name = datos.getName();
        Datos d = datos.getDatos(0);
        int filas = datos.numeroDatos();
        int columnas = d.numeroAtributos();
    
        String[] names = new String[columnas];
        Object[][] data = new String[filas][columnas];
    
        for (int i = 0; i < datos.numeroDatos(); i++) {
            d = datos.getDatos(i);
        
            for (int j = 0; j < d.numeroAtributos(); j++) {
                if (i == 0){
                    name = (String)d.leerNombre(j);
                    names[j] = name;
                }
                str = (String)d.leerValor(j);
                data[i][j] = str;
 //     if (str == null || str.equals(" ") == true)
 //        str = "";
                System.out.println("Valor Tabla["+i+"]["+j+"] : "+str);
        }
    }
    panel = new JPanel();
    comp = new JTable(data,names);
    ((JTable) comp).setPreferredScrollableViewportSize(new Dimension(xsize, ysize));
    JScrollPane scrollPane = new JScrollPane(comp);
    panel.add(scrollPane);
    paneles.setElementAt(panel,panelIndex);
  }
    public void escribirElementos(Datos datos){}
    public void leerElementos(DatosMultiples datos){}
    public void leerElementos(Datos datos){}
    
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}