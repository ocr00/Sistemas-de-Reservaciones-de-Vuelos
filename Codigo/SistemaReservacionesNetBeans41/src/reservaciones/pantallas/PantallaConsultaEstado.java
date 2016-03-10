package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaConsultaEstado extends PantallaFrame {

/*  public PantallaConsultaEstado(InterfaceUsuario ui,Manejador m) {
    super(ui,m);
  }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Consulta Estado (P-12)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Origen (Ciudad o Codigo):"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Destino (Ciudad o Codigo):"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Aerolinea:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Vuelo:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Fecha Vuelo:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Consultar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
