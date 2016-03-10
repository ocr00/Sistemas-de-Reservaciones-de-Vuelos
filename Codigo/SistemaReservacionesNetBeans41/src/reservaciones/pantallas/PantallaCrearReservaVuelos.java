package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import javax.swing.*;
import java.awt.*;

public class PantallaCrearReservaVuelos extends PantallaFrame {

/*  public PantallaCrearReservaVuelos(InterfaceUsuario ui,Manejador m) {
    super(ui,m);
  }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Crear Reserva (P-15)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Apellido:"));
    panel.add(new TextField(10));
    panel.add(new JLabel("Nombre:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Numero de Viajero Frecuente:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Aerolinea:"));
    panel.add(new TextField(10));
    panel.add(new JLabel("Vuelo:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Sale de:"));
    panel.add(new TextField(10));
    panel.add(new JLabel("Llega a:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

/*    cbox = new JCheckBox();
    cbox.setLayout(new GridLayout(1,1));
    cbox.setText("Solicitar Asiento");
    paneles.addElement(cbox);
*/
    panel = new JPanel();
    panel.add(new JLabel("Fecha:"));
    panel.add(new TextField(10));
    panel.add(new JLabel("Clase:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    ButtonGroup grupo1 = new ButtonGroup();
    panel.add(new JLabel("Asiento:"));
    JRadioButton rb1 = new JRadioButton("Ventana",false);
    grupo1.add(rb1);
    panel.add(rb1);
    JRadioButton rb2 = new JRadioButton("Pasillo", true);
    grupo1.add(rb2);
    panel.add(rb2);
    ButtonGroup grupo2 = new ButtonGroup();
    panel.add(new JLabel("Comida:"));
    rb1 = new JRadioButton("Vegetal", false);
    grupo1.add(rb1);
    panel.add(rb1);
    rb2 = new JRadioButton("Carne", true);
    grupo1.add(rb2);
    panel.add(rb2);
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Agregar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Borrar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("+");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("-");
    botones.addElement(boton);
    panel.add(boton);
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Reservar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
