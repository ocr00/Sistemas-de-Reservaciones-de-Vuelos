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
public class PanelTexto extends PanelData {
   public PanelTexto(JPanel p,String str, int length){
      super(p,str);
      comp = new JTextField(length);
      comp.setName(name);
      p.add(comp);
   }
   public PanelTexto(JTextField jc){
       super(jc);
   }
   public String leerTexto(String name0) {
       
        String str = ((JTextField) comp).getText();
        System.out.println(name0+": "+str);
        
        return str;
   }
   public void escribirElementos(DatosMultiples datos){}
        
   public void escribirElementos(Datos datos) {

        int i = datos.leerIndice(name);
        String name = datos.leerNombre(i);
        String str = datos.leerValor(i);
        ((JTextField) comp).setText(str);
        System.out.println(name+": "+str);
   }    
   public void leerElementos(DatosMultiples datos){}
    
   public void leerElementos(Datos datos) {
    
        String name = ((JComponent) comp).getName();
        String str = ((JTextField) comp).getText();
        int i = datos.leerIndice(name);
        datos.escribirValor(i,str);
        System.out.println(name+": "+str);     
   }
}