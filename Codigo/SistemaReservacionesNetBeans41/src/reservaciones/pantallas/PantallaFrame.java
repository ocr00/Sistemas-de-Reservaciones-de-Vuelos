package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.interfaceUsuarioFrame.*;
import reservaciones.dominio.*;
import reservaciones.util.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class PantallaFrame extends Pantalla {
  protected ReservacionesFrame frame;
  protected Vector<JPanel> paneles;
  protected Vector<JButton> botones;
  protected Vector<PanelData> campos;
  protected JPanel panel;
  protected JButton boton;
  protected PanelData campo;
  
  public PantallaFrame() {
    inicializarPantalla();
    crearPantalla();
  }
  protected PantallaFrame(InterfaceUsuario ui,Manejador m) {
    this();
    interfaceUsuario = ui;
    manejador = m;
  }
  public void inicializarInterfaceUsuario() {
	frame = ((InterfaceUsuarioFrame) interfaceUsuario).getReservacionesFrame();
  }
  // Otras Responsabilidades Publicas
  protected void inicializarPantalla() {
    paneles = new Vector<JPanel>();
    botones = new Vector<JButton>();
    campos = new Vector<PanelData>();
   }
  protected void agregarBotonesSalir(JPanel panel){
    boton = new JButton ("Salir");
    panel.add(boton);
    botones.addElement(boton);
    paneles.addElement(panel);
  }
  protected void agregarBotonesServiciosSalir(JPanel panel){

    boton = new JButton ("Servicios");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesSalir(panel);
  }
  public void borrarPantalla() {
    frame.getContentPane().removeAll();
    int bs = botones.size();
    for (int i = 0; i < bs; i++)
    if ((boton = (JButton)botones.elementAt(i)) != null)
      boton.removeActionListener(frame);
  }
  // crear elementos pantalla
  public void crearPantalla() { }
  protected JPanel getPanel(String pname) {
    JPanel p = null;
    int ps = paneles.size();
    String name = null;
    for (int i = 0; name.equals(pname) == false && i < ps; i++){
      p = (JPanel) paneles.elementAt(i);
      name = p.getName();
      if (name.equals(pname) == true)
          break;
    }
    return p;
  }
  protected int getPanelIndex(String pname) {
    JPanel p = null;
    int ps = paneles.size();
    String name = null;
    if (pname == null)
        return -1;
    int i = 0;
    for (i = 0; pname.equals(name) == false && i < ps; i++){
      p = (JPanel) paneles.elementAt(i);
      name = p.getName();
      if (pname.equals(name) == true)
          break;
    }
    return i;
  }
  // Contrato 1: Desplegar Pantalla
  protected void desplegarPantalla() {
    System.out.println("Desplegando: "+ this);
    int ps = paneles.size();
    frame.getContentPane().setLayout(new GridLayout(ps,1));
    for (int i = 0; i < ps; i++)
      frame.getContentPane().add((JComponent)paneles.elementAt(i));
    int bs = botones.size();
    for (int i = 0; i < bs; i++)
      if ((boton = (JButton)botones.elementAt(i)) != null)
        boton.addActionListener(frame);
  }
  public void refrescarPantalla() {
    System.out.println("Desplegando: "+ this);
    int ps = paneles.size();
    frame.getContentPane().setLayout(new GridLayout(ps,1));
    for (int i = 0; i < ps; i++)
      frame.getContentPane().add((JComponent)paneles.elementAt(i));
    int bs = botones.size();
    for (int i = 0; i < bs; i++)
      if ((boton = (JButton)botones.elementAt(i)) != null)
        boton.addActionListener(frame);
  }

  public void escribirElementos(Datos datos) {
    String name0,name;
    PanelData c;
    for (int i = 0; i < datos.numeroAtributos(); i++) {
      name0 = (String)datos.leerNombre(i);
      name = null;
      for (int j = 0; name0.equals(name) == false && j < campos.size(); j++) {
          c = (PanelData) campos.elementAt(j);
          name = c.getName();
          if (name0.equals(name) == true)
            c.escribirElementos(datos);
      }
    }
  }
  public void escribirElementos(DatosMultiples ds) {

    String name0 = "";
    if (ds == null)
        return;
    String name = ds.getName();
    PanelData pd = null;
    Datos d = null;
       
    for (int i = 0; name.equals(name0) == false && i < campos.size(); i++) {
        pd = campos.elementAt(i);
        if (pd == null)
            break;
        name0 = pd.getName();
        if (name.equals(name0)){
            pd.escribirElementos(ds);
            break;
        }
    }
  }
 
  public void leerElementos(Datos datos) {
    String name0,name;
    PanelData c;
    for (int i = 0; i < datos.numeroAtributos(); i++) {
      name0 = (String)datos.leerNombre(i);
      name = null;
      for (int j = 0; name0.equals(name) == false && j < campos.size(); j++) {
          c = (PanelData) campos.elementAt(j);
          name = c.getName();
          if (name0.equals(name) == true)
            c.leerElementos(datos);
      }
    }
  }
  public String leerTexto(String name0) {
    String name = "";
    String str = "";
    PanelData c;
    for (int j = 0; name0.equals(name) == false && j < campos.size(); j++) {
          c = (PanelData) campos.elementAt(j);
          name = c.getName();
          if (name0.equals(name) == true){
            str = c.leerTexto(name0);
            break;
          }
    }
    return str;
  }

  public void setInterfaceUsuario(InterfaceUsuario iu) { interfaceUsuario = iu; }
  public void setManejador(Manejador m) { manejador = m; }
}
