package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaConsultaHorarios extends PantallaFrame {

/*  public PantallaConsultaHorarios(InterfaceUsuario ui,Manejador m) {
    super(ui,m);}*/
  public void crearPantalla()
  {
    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Consulta Horarios (P-8)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Origen (Ciudad o Codigo):"));

    campo = new PanelComboBox(panel, "origen" , "Aeropuerto");
    campos.addElement(campo);
    panel.add(new JLabel("Destino (Ciudad o Codigo):"));
    campo = new PanelComboBox(panel, "destino" , "Aeropuerto");
    campos.addElement(campo);
    paneles.addElement(panel);    

    panel = new JPanel();
    panel.add(new JLabel("PREFERENCIAS"));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Aerolinea:"));
    campo = new PanelTexto(panel,"aerolinea", 10);
    campos.addElement(campo);

    panel.add(new JLabel("Horario:"));
    campo = new PanelTexto(panel,"horario", 20);
    campos.addElement(campo);

    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Checkbox("Solo Directo", null, false));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Consultar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
