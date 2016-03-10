package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaObtenerRegTarjeta extends PantallaRegTarjeta {

/*  public PantallaObtenerRegTarjeta(InterfaceUsuario ui,Manejador m) {
    super (ui,m);
  }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new Label("SISTEMA DE RESERVACIONES DE VUELO", Label.CENTER));
    panel.add(new Label("Pantalla Obtener Registro Tarjeta (P-6)", Label.CENTER));
    paneles.addElement(panel);

    super.crearPantalla();

    panel = new JPanel();
    boton = new JButton("Eliminar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Actualizar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
