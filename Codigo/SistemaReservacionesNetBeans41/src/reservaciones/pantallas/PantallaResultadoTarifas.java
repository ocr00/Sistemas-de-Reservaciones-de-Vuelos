package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaResultadoTarifas extends PantallaFrame {

/*  public PantallaResultadoTarifas(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Resultado Tarifas (P-11)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Fecha de Consulta"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel(); 
//    String[] nombreColumnas = {"Aerolínea", "Vuelo", "Días", "Horario", "Clase", "Tarifa O/W", "Tarifa R/T", "Restricciones"};
    campo = new PanelTabla(panel, "resultadoTarifas", 700, 110);
    campo.setPanelIndex(paneles,paneles.size());
    campos.addElement(campo);
    paneles.addElement(panel);
 
    panel = new JPanel();
    boton = new JButton("+");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("-");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Nueva Consulta");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
