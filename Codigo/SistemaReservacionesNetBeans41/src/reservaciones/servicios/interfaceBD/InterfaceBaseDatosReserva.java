package reservaciones.servicios.interfaceBD;

import reservaciones.servicios.consultas.estado.*;
import reservaciones.servicios.consultas.horarios.*;
import reservaciones.servicios.consultas.tarifas.*;
import reservaciones.servicios.dominio.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.dominio.*;

import reservaciones.registro.interfaceBD.*;

import java.sql.*;
import java.util.*;
import java.awt.*;

public class InterfaceBaseDatosReserva extends InterfaceReserva
{       
        private String nombreBD = "reservaciones";
        private String logBD = "alfredo";
        private String pwdBD = "ITAM";
 
    public InterfaceBaseDatosReserva()
    {
    }

    private boolean leerRecordSetRegistro(String query,DatosMultiples dm,Datos d)
    {
	boolean fg = false;
        String name = null;
        Datos datos;
        Class c = d.getClass();
        
        if (dm == null) {
            System.out.println("Datos nulos");
            return false;
        }
        try {
	    abrir(nombreBD,logBD, pwdBD);
            rs = stmt.executeQuery (query);
            // Obtiene el objeto resultado ResultSetMetaData.
            // Este puede ser utilizado para desplegar los nombres de los campos
            ResultSetMetaData rsmd = rs.getMetaData ();
            int numCols = rsmd.getColumnCount ();
            System.out.println("Cargando registro");
            while  (rs != null && rs.next()) {
                datos = (Datos) c.newInstance();
                if (datos != null)
                    dm.agregarDatos(datos);
                for (int i = 1; i <= numCols; i++) {  // datos.size()
                    String name0 = rsmd.getColumnLabel(i);
                    String str = rs.getString(i);
                    for (int j = 0; name0.equals(name) == false && j < datos.numeroAtributos(); j++) {
                        name = datos.leerNombre(j);
                        if (name0.equals(name) == true) {
                            datos.escribirValor(j,str);
                            System.out.println(name+": "+str);
                        }
                    }                 
                }
                datos.actualizarAtributos(); // actualizar valores no leidos
                fg = true;
            }        
        }
	catch (SQLException ex) {
            System.out.println ("\n*** Error de SQL interceptado ***\n");
	      	while (ex != null) {
                  System.out.println ("SQLState: " + ex.getSQLState ());
                  System.out.println ("Mensaje:  " + ex.getMessage ());
                  System.out.println ("Error:   " + ex.getErrorCode ());
                  ex = ex.getNextException ();
                  System.out.println ("");
                }
	}
	catch (Exception ex) {
		ex.printStackTrace ();
	}

	cerrar();
        
        return fg;
    }

   // Contrato 1: Consultar Informacion
   public boolean consultarHorario(Datos dc, DatosMultiples drm, Datos dr){
       String origen = dc.leerValor("origen");
       String destino = dc.leerValor("destino");
       if (origen.equals(destino) == true)
           return false;
       // displayRecordSet("SELECT * FROM Consulta_horarios_origen_destino WHERE (Aeropuerto_origen_id="+origen+") AND (Aeropuerto_destino_id="+destino+")");
        String querysql = "SELECT * FROM Consulta_horarios_origen_destino WHERE (Aeropuerto_origen_id="+origen+") AND (Aeropuerto_destino_id="+destino+")";
        if (fg = leerRecordSetRegistro(querysql,drm, dr) == true)
            System.out.println("Se hizo la consulta de horarios " + origen + " a " + destino);
        else
            System.out.println("No se hizo la consulta de horarios " + origen + " a " + destino);

        return fg;
   }
   public boolean consultarTarifas(/*ConsultaTarifa s*/){
       return true;
   }
   public boolean consultarInformacion(/*ConsultaEstado s*/){
       return true;
   }
   public boolean consultarAeropuertos(DatosMultiples drm, Datos dr){
        String regname = getClassName(dr);
        String querysql = "SELECT * FROM " + regname;
        if (fg = leerRecordSetRegistro(querysql,drm, dr) == true)
            System.out.println("Se hizo la consulta de aeropuertos");
        else
            System.out.println("No se hizo la consulta de aeropuertos");

        return fg;
   }
   // Contrato 2: Hacer Reservacion
   public boolean crearReserva(/*Reservacion r*/) {
       return true;
   }
   public boolean obtenerReserva(/*Reservacion r*/) {
       return true;
   }
   public boolean actualizarReserva(/*Reservacion r*/) {
       return true;
   }
   public boolean eliminarReserva(/*Reservacion r*/) {
       return true;
   }
   // Contrato 3: Pagar Reservacion
   public boolean pagarReserva(/*Reservacion r*/ RegistroTarjeta rt) {
       return true;
   }
   public boolean eliminarReserva(/*Reservacion r*/ RegistroTarjeta rt) {
       return true;
   }
}
