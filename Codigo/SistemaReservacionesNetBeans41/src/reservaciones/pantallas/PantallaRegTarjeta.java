package reservaciones.pantallas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import javax.swing.*;
import java.awt.*;

public class PantallaRegTarjeta extends PantallaFrame {

/*  public PantallaRegTarjeta(InterfaceUsuario ui,Manejador m) {
    super (ui,m); }*/
  public void crearPantalla() {
    panel = new JPanel();
    panel.add(new Label("Nombre:", Label.LEFT));
    campo = new PanelTexto(panel,"nombre", 40);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Numero de Tarjeta (requerido para pagos):"));
    campo = new PanelTexto(panel,"numero", 20);
    campos.addElement(campo);
    paneles.addElement(panel);

    panel = new JPanel();
    panel.add(new Label("Tipo"));
    campo = new PanelTexto(panel,"tipo", 20);
    campos.addElement(campo);

    panel.add(new Label("Fecha Vencimiento"));
    campo = new PanelTexto(panel,"fecha", 20);
    campos.addElement(campo);
    paneles.addElement(panel);
  }
}
