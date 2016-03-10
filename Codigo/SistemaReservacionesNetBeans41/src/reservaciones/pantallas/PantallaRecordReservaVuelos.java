package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import javax.swing.*;
import java.awt.*;

public class PantallaRecordReservaVuelos extends PantallaFrame {

/*  public PantallaRecordReservaVuelos(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Record Reserva (P-16)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Apellido:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Nombre:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Clave:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Numero de Viajero Frecuente:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Aerolinea:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Vuelo:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Límite:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Sale de:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Llega a:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Status:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Fecha:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Hora Salida:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Hora Llegada:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Asiento:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("No. Comida:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Comida:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Clase:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Tarifa:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Estado de Pago:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Eliminar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Actualizar");
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
    boton = new JButton("Nueva Reserva");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Pagar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Reembolsar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
