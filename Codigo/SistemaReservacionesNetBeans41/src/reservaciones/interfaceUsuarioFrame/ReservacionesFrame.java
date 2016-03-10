package reservaciones.interfaceUsuarioFrame;

import reservaciones.interfaceUsuario.*;
import reservaciones.pantallas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservacionesFrame extends JFrame implements ActionListener
{
  private InterfaceUsuarioFrame interfaceUsuario;
  public ReservacionesFrame(InterfaceUsuarioFrame iu) {
    setSize(800,600);
    setBackground(Color.lightGray);
//    addWindowListener(this);
//    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    interfaceUsuario = iu;
  }
  public void actionPerformed(ActionEvent event) {
    System.out.println("ReservacionesFrame Action: "+event.getActionCommand());
    if (interfaceUsuario != null)
      interfaceUsuario.enviarEvento(event.getActionCommand());
  }

  public void desplegarPantalla(Pantalla p) {
    if (p != null) {
        p.borrarPantalla(); 
        p.refrescarPantalla();
/*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });*/
	setVisible(true);
    }
    else
        System.out.println("Pantalla Nula");
  }
}
