package reservaciones.servicios.consultas.tarifas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.consultas.*;

public class ManejadorConsultaTarifas extends Manejador {
  private Pantalla pantallaConsultaTarifas;
  private Pantalla pantallaResultadoTarifas;
  public ManejadorConsultaTarifas(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
  }
  // Contrato 1
  public void manejarEvento(String str) {
    if (str.equals("Consultar"))
      consultarTarifas();
    else if (str.equals("+"))
		   ;
    else if (str.equals("-"))
		   ;
    else if (str.equals("Nueva Consulta"))
      consultar();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Consultar
  public void consultar() {
    pantallaConsultaTarifas = crearPantalla("PantallaConsultaTarifas");
    desplegarPantalla(pantallaConsultaTarifas);
  }
  // Responsabildiades Privadas
  private void consultarTarifas() {
    pantallaResultadoTarifas = crearPantalla("PantallaResultadoTarifas");
    desplegarPantalla(pantallaResultadoTarifas);
  }
}

