package reservaciones.pantallas;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import javax.swing.*;
import java.awt.*;

public class PantallaRegUsuario extends PantallaFrame {
/*  public PantallaRegUsuario(InterfaceUsuario ui,Manejador m) {
    super(ui,m); }*/
  public void crearPantalla() {
    panel = new JPanel();
    panel.add(new Label("Nombre:"));
    campo = new PanelTexto(panel,"nombre", 20);
    campos.addElement(campo);

    panel.add(new Label("Apellido:"));
    campo = new PanelTexto(panel,"apellido", 20);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Direccion:"));
    campo = new PanelTexto(panel,"direccion", 20);
    campos.addElement(campo);

    panel.add(new Label("Colonia:"));
    campo = new PanelTexto(panel,"colonia", 20);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Ciudad:"));
    campo = new PanelTexto(panel,"ciudad", 20);
    campos.addElement(campo);

    panel.add(new Label("Pais:"));
    campo = new PanelTexto(panel,"pais", 20);
    campos.addElement(campo);

    panel.add(new Label("Codigo Postal:"));
    campo = new PanelTexto(panel,"CP", 5);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Tel Casa:"));
    campo = new PanelTexto(panel,"telCasa", 20);
    campos.addElement(campo);

    panel.add(new Label("Tel Of.:"));
    campo = new PanelTexto(panel,"telOficina", 20);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Fax:"));
    campo = new PanelTexto(panel,"fax", 20);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Login:"));
    campo = new PanelTexto(panel,"login", 20);
    campos.addElement(campo);

    panel.add(new Label("Email:"));
    campo = new PanelTexto(panel,"email", 40);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Password"));
    campo = new PanelTexto(panel,"password", 20);
    campos.addElement(campo);
//    texto.setEchoChar('#');

    panel.add(new Label("Repetir Password"));
    panel.add(new Label(" Repetir Password"));
    campo = new PanelTexto(panel,"rpassword", 20);
    campos.addElement(campo);
//    texto.setEchoChar('#');
    paneles.addElement(panel);
  }
}
