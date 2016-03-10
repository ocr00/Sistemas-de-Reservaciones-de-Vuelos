package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaConsultas extends PantallaFrame {

/*  public PantallaConsultas (InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Consultas (P-7)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Para consulta de horarios, tarifas o estado de vuelos oprima uno de los siguientes botones:"));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Horarios");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Tarifas");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Estado");
    botones.addElement(boton);
    panel.add(boton);
    paneles.addElement(panel);

    panel = new JPanel();
    agregarBotonesServiciosSalir(panel);
  }
}
