package reservaciones.registro.interfaceBD;

import reservaciones.dominio.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.tarjeta.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

public class InterfaceBaseDatosRegistro extends InterfaceRegistro
{
        private String nombreBD = "reservaciones";
        private String logBD = "alfredo";
        private String pwdBD = "ITAM";
        
    public InterfaceBaseDatosRegistro() {
    }

    private boolean actualizarRecordSetRegistro(String query)
    {
	    boolean fg = false;
	    
        try {
	    abrir(nombreBD,logBD, pwdBD);
            int n = stmt.executeUpdate (query);
            if (n > 0)
            	fg = true;
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
    public boolean actualizarRegistro(Datos reg)
    {
        String log = reg.leerValor(0);
        System.out.println("log: " + log);
        String regname = getClassName(reg);
        String textsql = reg.serializarSQL();
        String str = "UPDATE " + regname + " SET " + textsql + " WHERE Login = '" + log + "';";
        System.out.println("sql: " + str);
        if (fg = actualizarRecordSetRegistro(str) == true)
            System.out.println("Se actualizo en " + regname + " record de " + log);
        else
            System.out.println("No se pudo actualizar en " + regname + " record de " + log);

        return fg;
    }


    // Contrato 1: Registrar
    public boolean crearRegistro(Datos reg)
    {
        String log = reg.leerValor(0);
        System.out.println("log: " + log);
        String regname = getClassName(reg);
        String textsql = reg.serializarSQLinsert();
        String querysql = "INSERT INTO " + regname + " " + textsql;
        System.out.println("sql: " + querysql);
        if (fg = actualizarRecordSetRegistro(querysql) == true)
            System.out.println("Se inserto en " + regname + " record de " + log);
        else
            System.out.println("No se pudo insertar en " + regname + " record de " + log);

        return fg;
    }

    public boolean eliminarRegistro(Datos reg)
    {
        String log = reg.leerValor(0);
        System.out.println("log: " + log);
        String regname = getClassName(reg);
        String str = "DELETE FROM " + regname + " WHERE Login = '" + log + "';";
        if (fg = actualizarRecordSetRegistro(str) == true)
            System.out.println("Se elimino en " + regname + " record de " + log);
        else
            System.out.println("No se pudo eliminar en " + regname + " record de " + log);

        return fg;
    }
    // Responsabilidades Privadas
    private boolean leerRecordSetRegistro(String query,Datos datos)
    {
	    boolean fg = false;
        if (datos == null) {
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
            if  (rs != null && rs.next()) {
                for (int i = 1; i <= numCols; i++) {  // datos.size()
                    if (i > 1)
                       System.out.print(",");
                    String str = rs.getString(i);
                    System.out.print(str);
                    datos.escribirValor(i-1,str);
                }
                datos.actualizarAtributos(); // actualizar valores no leidos
                fg = true;
            }
            
            System.out.println("");
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
    public boolean obtenerRegistro(Datos reg,String log)
    {
        System.out.println("Login: "+log);
        String regname = getClassName(reg);
        String querysql = "SELECT * FROM " + regname + " WHERE (login = '" + log + "')";
        System.out.println("sql: " + querysql);
        if (fg = leerRecordSetRegistro(querysql,reg) == true)
            System.out.println("Se valido registro " + regname + ": " + log);
        else
            System.out.println("No se valido registro " + regname + ": " + log);

        return fg;
    }

    public boolean validarRegistro(Datos reg,String log, String pass) {
        System.out.println("Login: "+log);
        System.out.println("Password: "+pass);
        String regname = getClassName(reg);
        String querysql = "SELECT * FROM " + regname + " WHERE (login = '" + log + "') AND (password = '" + pass + "')";
        if (fg = leerRecordSetRegistro(querysql,reg) == true)
            System.out.println("Se valido registro: " + log + "," + pass);
        else
            System.out.println("No se valido registro: " + log + "," + pass);

        return fg;
    }
}
