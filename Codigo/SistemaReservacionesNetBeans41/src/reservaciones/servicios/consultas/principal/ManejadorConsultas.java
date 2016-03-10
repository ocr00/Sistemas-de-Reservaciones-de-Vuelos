package reservaciones.servicios.consultas.principal;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.consultas.horarios.*;
import reservaciones.servicios.consultas.tarifas.*;
import reservaciones.servicios.consultas.estado.*;
import reservaciones.servicios.*;

public class ManejadorConsultas extends Manejador {
  private ManejadorConsultaHorarios mch;
  private ManejadorConsultaTarifas mct;
  private ManejadorConsultaEstado mce;
  private Pantalla pantallaConsultas;

  public ManejadorConsultas(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
  }
  // Contrato 1: Manejar Evento
  public void manejarEvento(String str) {
    if (str.equals("Horarios"))
      consultarHorarios();
    else if (str.equals("Tarifas"))
      consultarTarifas();
    else if (str.equals("Estado"))
      consultarEstado();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Consultar
  public void consultar() {
    pantallaConsultas = crearPantalla("PantallaConsultas");
    desplegarPantalla(pantallaConsultas); // new PantallaConsultas(interfaceUsuario,this)
  }
  // Responsabilidades Privadas
  private void consultarHorarios() {
    if (mch == null)
      mch = new ManejadorConsultaHorarios(this,interfaceUsuario);
    mch.consultar();
  }
  private void consultarTarifas() {
    if (mct == null)
      mct = new ManejadorConsultaTarifas(this,interfaceUsuario);
    mct.consultar();
  }
  private void consultarEstado() {
    if (mce == null)
      mce = new ManejadorConsultaEstado(this,interfaceUsuario);
    mce.consultar();
  }
}



