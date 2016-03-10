package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends PantallaFrame {

/*  public PantallaPrincipal (InterfaceUsuario ui,Manejador m) {
    super(ui,m);
  }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Principal (P-1)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4,1));//5 fila, 1 cols
    panel.add(new JLabel("Servicios Ofrecidos:", JLabel.CENTER));
    panel.add(new JLabel("* Consulta de Vuelos, Tarifas y Horarios", JLabel.CENTER));
    panel.add(new JLabel("* Reserva de Vuelos", JLabel.CENTER));
    panel.add(new JLabel("* Compra de Boletos", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    panel.add(new JLabel("Para registrarse por primera vez oprima:", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton ("Registrarse por Primera Vez");
    botones.addElement(boton);
    panel.add(boton);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    panel.add(new JLabel("Para accesar todos los servicios de vuelo (consulta, reserva, compra) o modificar su registro, oprima:", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Login:", JLabel.LEFT));
    campo = new PanelTexto(panel,"login", 20);
    campos.addElement(campo);

    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Password:"));
    campo = new PanelTexto(panel,"password", 20);
    campos.addElement(campo);
 //   texto.setEchoChar('#');
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("OK");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Salir");
    botones.addElement(boton);
    panel.add(boton);
    paneles.addElement(panel);
  }

/**
 * Insert the method's description here.
 * Creation date: (10/24/2002 1:03:45 PM)
 */
public PantallaPrincipal() {}
}

