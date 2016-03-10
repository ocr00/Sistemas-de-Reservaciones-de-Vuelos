package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaReembolsarRegTarjeta extends PantallaFrame {

/*  public PantallaReembolsarRegTarjeta(InterfaceUsuario ui,Manejador m) {
    super(ui,m);
  }*/
  public void crearPantalla() {
    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Reembolsar Tarjeta (P-18)", JLabel.CENTER));
    paneles.addElement(panel);

    super.crearPantalla();

    panel = new JPanel();
    panel.add(new JLabel("Tarifa:", JLabel.LEFT));
    panel.add(new JTextField (40));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Reembolsar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
