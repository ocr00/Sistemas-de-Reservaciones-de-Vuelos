package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaResultadoEstado extends PantallaFrame {
/*  public PantallaResultadoEstado(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Resultado Estado (P-13)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Fecha de Consulta:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Hora:"));
    panel.add(new JTextField(10));
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
    panel.add(new JLabel("Horario de Salida:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Horario Llegada:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Disponibilidad:"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Comentario:"));
    panel.add(new JTextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Nueva Consulta");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
