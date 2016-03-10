package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import javax.swing.*;
import java.awt.*;

public class PantallaObtenerRegUsuario extends PantallaRegUsuario {

/*  public PantallaObtenerRegUsuario(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new Label("SISTEMA DE RESERVACIONES DE VUELO", Label.CENTER));
    panel.add(new Label("Pantalla Obtener Registro Usuario (P-4)", Label.CENTER));
    paneles.addElement(panel);

    super.crearPantalla();

    panel = new JPanel();
    boton = new JButton("Eliminar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Actualizar");
    botones.addElement(boton);
    panel.add(boton);

    boton = new JButton("Registrar Tarjeta");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesServiciosSalir(panel);
  }
}
