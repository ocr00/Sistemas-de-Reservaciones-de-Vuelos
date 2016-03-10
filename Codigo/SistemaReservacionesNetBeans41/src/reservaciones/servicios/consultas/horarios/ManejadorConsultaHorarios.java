package reservaciones.servicios.consultas.horarios;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.consultas.*;
import reservaciones.servicios.interfaceBD.*;
import reservaciones.registro.interfaceBD.*;
import reservaciones.servicios.dominio.*;
import reservaciones.dominio.*;

public class ManejadorConsultaHorarios extends Manejador {
    
        private Pantalla pantallaConsultaHorarios;
        private Pantalla pantallaResultadoHorarios;
        private InterfaceReserva interfaceBD;
        private ConsultaHorario consultaHorario;
        private DatosMultiples resultadoHorarioMultiple;
        private ResultadoHorario resultadoHorario;
        private Aeropuertos aeropuerto;
        private DatosMultiples aeropuertoMultiple;
        
        public ManejadorConsultaHorarios(Manejador m,InterfaceUsuario ui) {
                super(m,ui);
    		if (interfaceBD == null) {
                    if (db_flag == true) {
                        System.out.println("Usando Base de Datos");
                        interfaceBD = new InterfaceBaseDatosReserva();
                    }
                    else {
                        System.out.println("Usando Archivos");
                        interfaceBD = new InterfaceBaseDatosReserva();
                    }
                }
  }
  // Contrato 1: Manejar Evento
  public void manejarEvento(String str) {
    if (str.equals("Consultar"))
      consultarHorarios();
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
      pantallaConsultaHorarios = crearPantalla("PantallaConsultaHorarios");
      aeropuerto = new Aeropuertos();
      aeropuertoMultiple = new DatosMultiples("origen");
      if (interfaceBD != null)
            interfaceBD.consultarAeropuertos(aeropuertoMultiple,aeropuerto);
      escribirElementos(pantallaConsultaHorarios,aeropuertoMultiple);
      aeropuerto = new Aeropuertos();
      aeropuertoMultiple = new DatosMultiples("destino");
      if (interfaceBD != null)
            interfaceBD.consultarAeropuertos(aeropuertoMultiple,aeropuerto);
      escribirElementos(pantallaConsultaHorarios,aeropuertoMultiple);
      desplegarPantalla(pantallaConsultaHorarios);
  }
  // Responsabildiades Privadas
  private void consultarHorarios() {
      pantallaResultadoHorarios = crearPantalla("PantallaResultadoHorarios");
      consultaHorario = new ConsultaHorario();
      leerElementos(pantalla,consultaHorario);
      resultadoHorarioMultiple = new DatosMultiples("resultadoHorario");
      resultadoHorario = new ResultadoHorario();
      if (interfaceBD != null)
            interfaceBD.consultarHorario(consultaHorario,resultadoHorarioMultiple,resultadoHorario);
      escribirElementos(pantallaResultadoHorarios,resultadoHorarioMultiple);
      desplegarPantalla(pantallaResultadoHorarios);
  }
}


