package reservaciones.pantallas;

import reservaciones.dominio.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public abstract class PanelData {

    protected Vector<JPanel> paneles;
    protected JPanel panel;
    protected int panelIndex;
    protected JComponent comp;
    protected String name;
    protected String atributoName;
    
    public PanelData(JPanel p,String str) {
        panel = p;
        name = str;
     }
    public PanelData(JComponent jc) {
        comp = jc;
    }
    public void setPanelIndex(Vector<JPanel> ps,int i){
        paneles = ps;
        panelIndex = i;
    }
    public void setName(String str){
        name = str;
    }
    public String getName() { return name; }
    public void setAtributoName(String str){
        atributoName = str;
    }
    public String getAtributoName() { return atributoName; }
    
    public abstract String leerTexto(String name0);
    public abstract void escribirElementos(DatosMultiples datos);
    public abstract void escribirElementos(Datos datos);
    public abstract void leerElementos(DatosMultiples datos);
    public abstract void leerElementos(Datos datos);
}