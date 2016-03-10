package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaPagarRegTarjeta extends PantallaRegTarjeta {

/*  public PantallaPagarRegTarjeta(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new JLabel("SISTEMA DE RESERVACIONES DE VUELO", JLabel.CENTER));
    panel.add(new JLabel("Pantalla Pagar Tarjeta (P-17)", JLabel.CENTER));
    paneles.addElement(panel);

    super.crearPantalla();

    panel = new JPanel();
    panel.add(new JLabel("Tarifa:", JLabel.LEFT));
    panel.add(new TextField (40));
    paneles.addElement(panel);

    panel = new JPanel();
    boton = new JButton("Pagar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
