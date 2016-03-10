package reservaciones.servicios.principal;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.consultas.principal.*;
import reservaciones.servicios.reservas.*;
import reservaciones.registro.usuario.*;

public class ManejadorServicio extends Manejador {
  private ManejadorConsultas mc;
  private ManejadorReservas mrs;
  private Pantalla pantallaServicio;

  public ManejadorServicio(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
    ms = this;
  }
  // Contrato 1: Manejar Evento
  public void manejarEvento(String str) {
    if (str.equals("Consultar Informacion"))
      manejarEventoConsultar();
    else if (str.equals("Hacer Reservacion"))
      manejarEventoReservar();
    else if (str.equals("Obtener Registro"))
      manejarEventoRegistrar();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Ofrecer Servicio
  public void ofrecerServicio() {
      pantallaServicio = crearPantalla("PantallaServicio");
      desplegarPantalla(pantallaServicio);
  }
  // Responsabilidades Privadas
  private void manejarEventoConsultar() {
      if (mc == null)
        mc = new ManejadorConsultas(this,interfaceUsuario);
      mc.consultar();
  }
  private void manejarEventoReservar() {
      if (mrs == null)
        mrs = new ManejadorReservas(this,interfaceUsuario);
      mrs.reservar();
  }
  private void manejarEventoRegistrar() {
      if (mru == null)
        mru = new ManejadorRegistroUsuario(this,interfaceUsuario);
      mru.obtenerRegistroUsuario();
  }
}


