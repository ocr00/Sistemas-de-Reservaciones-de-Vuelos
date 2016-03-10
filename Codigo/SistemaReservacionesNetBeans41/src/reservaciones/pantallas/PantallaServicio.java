package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaServicio extends PantallaFrame {

/*  public PantallaServicio(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Servicios (P-2)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Presione el tipo de servicio deseado:", JLabel.LEFT));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton ("Consultar Informacion");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton ("Hacer Reservacion");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton ("Obtener Registro");
    panel.add(boton);
    botones.addElement(boton);
    paneles.addElement(panel);

    panel = new JPanel();
    agregarBotonesSalir(panel);
  }
}

