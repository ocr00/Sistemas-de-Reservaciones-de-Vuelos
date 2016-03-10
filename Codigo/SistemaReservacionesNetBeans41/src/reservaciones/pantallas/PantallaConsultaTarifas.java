package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaConsultaTarifas extends PantallaFrame {

/*  public PantallaConsultaTarifas(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Consulta Tarifas (P-10)", JLabel.CENTER));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Origen (Ciudad o Codigo):"));
    panel.add(new JTextField(15));
    panel.add(new JLabel("Destino (Ciudad o Codigo):"));
    panel.add(new JTextField(15));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("PREFERENCIAS"));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new JLabel("Fecha de Salida:"));
    panel.add(new TextField(10));
    panel.add(new Label("Fecha de Regreso:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Aerolinea:"));
    panel.add(new TextField(10));
    panel.add(new Label("Clase:"));
    panel.add(new TextField(10));
    paneles.addElement(panel);

    panel = new JPanel();
//  CheckboxGroup grupo = new CheckboxGroup();
    panel.add(new Checkbox("Menor Tarifa", null, false));
    panel.add(new Checkbox("Solo Directo", null, false));
    panel.add(new Checkbox("Redondo", null, false));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Consultar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
