/*
 * PanelComboBox.java
 *
 * Created on 31 de mayo de 2005, 01:43 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package reservaciones.pantallas;

import reservaciones.dominio.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alfredow
 */
public class PanelComboBox extends PanelData {
   public PanelComboBox(JComboBox jc){
       super(jc);
   }
   public PanelComboBox(JPanel p,String str,String atr){
      super(p,str);
      atributoName = atr;
      comp = new JComboBox();
      comp.setName(name);
      p.add(comp);
   } 

    public String leerTexto(String name0){ return ""; }
   
    public void escribirElementos(DatosMultiples datos){
       String name0,str;
        if (datos == null)
            return;
        Datos d;
    
        for (int i = 0; i < datos.numeroDatos(); i++) {
            d = datos.getDatos(i);
            str = (String)d.leerValor(atributoName);
            ((JComboBox) comp).addItem(str);
 //     if (str == null || str.equals(" ") == true)
 //        str = "";
            System.out.println("Valor Combo["+i+"] : "+str);
        }       
    }
    
    public void escribirElementos(Datos datos){}
    public void leerElementos(DatosMultiples datos){}
    public void leerElementos(Datos datos){
       //JComboBox cb = (JComboBox)e.getSource();
        //String str = (String)((JComboBox) comp).getSelectedItem();
        int i = ((JComboBox) comp).getSelectedIndex() + 1;
        Integer index = i;
        String str = (String) index.toString();
        if (datos != null)
            datos.escribirValor(name,str);   
     }
}