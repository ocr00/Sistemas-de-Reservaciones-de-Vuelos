package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaCrearRegUsuario extends PantallaRegUsuario {

/*  public PantallaCrearRegUsuario(InterfaceUsuario ui,Manejador m) {
    super (ui,m); }*/
  public void crearPantalla() {
    panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    panel.add(new Label("SISTEMA DE RESERVACIONES DE VUELO", Label.CENTER));
    panel.add(new Label("Pantalla Crear Registro Usuario (P-3)", Label.CENTER));
    paneles.addElement(panel);

    super.crearPantalla();

    panel = new JPanel();
    boton = new JButton("Registrar");
    botones.addElement(boton);
    panel.add(boton);

    agregarBotonesSalir(panel);
  }
}
