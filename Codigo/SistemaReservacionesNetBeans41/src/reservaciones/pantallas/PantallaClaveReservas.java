package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import javax.swing.*;
import java.awt.*;

public class PantallaClaveReservas extends PantallaFrame {

/* public PantallaClaveReservas(InterfaceUsuario ui,Manejador m) {
    super(ui,m);
  }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Clave Reserva (P-14)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Inserte la Clave de la Reserva si ya existe:", JLabel.LEFT));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Clave:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton ("Crear");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton ("Obtener");
    botones.addElement(boton);
    panel.add(boton);
    paneles.addElement(panel);

    panel = new JPanel();
    agregarBotonesServiciosSalir(panel);
  }
}

