package reservaciones.servicios.interfaceBD;

import reservaciones.interfaceUsuario.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.dominio.*;
import reservaciones.registro.interfaceBD.*;
import reservaciones.servicios.interfaceBD.*;

public abstract class InterfaceReserva extends InterfaceBaseDatos
{
    // Contrato1 : Consultar Informacion
   public abstract boolean consultarHorario(Datos dc,DatosMultiples drm,Datos dr);
   public abstract boolean consultarTarifas(/*ConsultaTarifa s*/);
   public abstract boolean consultarInformacion(/*ConsultaEstado s*/);
   public abstract boolean consultarAeropuertos(DatosMultiples am,Datos a);
   // Contrato 2: Hacer Reservacion
   public abstract boolean crearReserva(/*Reservacion r*/) ;
   public abstract boolean obtenerReserva(/*Reservacion r*/) ;
   public abstract boolean actualizarReserva(/*Reservacion r*/) ;
   public abstract boolean eliminarReserva(/*Reservacion r*/) ;
   // Contrato 3: Pagar Reservacion
   public abstract boolean pagarReserva(/*Reservacion r,*/ RegistroTarjeta rt) ;
   public abstract boolean eliminarReserva(/*Reservacion r,*/ RegistroTarjeta rt) ;
}

