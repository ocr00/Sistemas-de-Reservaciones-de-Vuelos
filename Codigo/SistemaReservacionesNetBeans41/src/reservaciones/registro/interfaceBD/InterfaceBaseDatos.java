package reservaciones.registro.interfaceBD;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.tarjeta.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public abstract class InterfaceBaseDatos
{
        protected boolean fg;
        protected Connection con;
        protected Statement stmt;
        protected ResultSet rs;
        protected boolean checkDriver = false;
        
        private String nombreBD = "reservaciones";
        private String logBD = "alfredo";
        private String pwdBD = "ITAM";

        
        public InterfaceBaseDatos()
        {
            int fg1 = revisarDriverSun();
            int fg2 = revisarDriverMS();
            if (fg1 == 0 || fg2 == 0)
              checkDriver = true; // abrirConexion("jdbc:odbc:reservaciones", "alfredo", "ITAM");  // nombre debe corresponder
        }
        private int revisarDriverMS()
        {
            int fg = 0;
            try {
                Class.forName ("com.ms.jdbc.odbc.JdbcOdbcDriver");
                System.out.println ("\n*** Utilizando driver de Microsoft ***\n");
            }
            catch (ClassNotFoundException ex) {
   //         System.out.println ("\n*** MS ClassNotFoundException interceptado ***\n");
                fg = 1;
            }
            return fg;
        }
        private int revisarDriverSun()
        {
            int fg = 0;
            try {
                Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
                System.out.println ("\n*** Utilizando driver de Sun ***\n");
            }
            catch (ClassNotFoundException ex) {
   //         System.out.println ("\n*** Sun ClassNotFoundException interceptado ***\n");
                fg = 1;
            }
            return fg;
        }
        public String getClassName(Datos reg){
            String regname;
            Class regclass = reg.getClass();
            String fullname = regclass.getName();
            int index = fullname.lastIndexOf('.');
            if (index > 0)
                regname = fullname.substring(index+1);
            else
                regname = fullname;
            return regname;
        }
        protected void abrir(String nombreBD,String logBD,String pwdBD) {
	    System.out.println ("\n*** Abriendo Conexion ***\n");
            abrirConexion("jdbc:odbc:"+nombreBD, logBD, pwdBD);  // nombre debe corresponder	
        }
        protected void abrirConexion(String url,String log,String pass)
        {
        try {
          // DriverManager.setLogStream(System.out);
          // Intenta conectarse al Driver. Cada uno de
          // los drivers registrados ser n cargados hasta
          // que se encuentre el que pueda procesar la url
          // especificada
          con = DriverManager.getConnection (url, log, pass);
          // Si no es posible conectarse, se generar  un error
          // que podr¡a ser identificada. De lo contrario, si obtiene
          // la URL se conectar  satisfactoriamente.
          // Checa y despliega los mensajes generados por la conexi¢n
          checkForWarning (con.getWarnings ());
          // Obtiene el objeto DatabaseMetaData y despliega
          // Informaci¢n acerca de la conexi¢n.
          DatabaseMetaData dma = con.getMetaData ();
          System.out.println("\nConectado a " + dma.getURL());
          System.out.println("Driver       " + dma.getDriverName());
          System.out.println("Versi¢n      " + dma.getDriverVersion());
          System.out.println("");
          // Crea el objeto Statement para poder introducir
          // instrucciones de SQL al driver
          stmt = con.createStatement ();
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
            System.out.println ("\n*** Exception interceptado ***\n");
            ex.printStackTrace ();
        }
        }
        
        protected void cerrar() {
	    System.out.println ("\n*** Cerrando Conexion ***\n");
        try {
          if (con != null)
            con.close();
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
        }
//-------------------------------------------------------------------
// checkForWarning
// Verifica y despliega mensajes de advertencia. Regresa Verdadero
// si existe el mensaje de advertencia
//-------------------------------------------------------------------

    private static boolean checkForWarning (SQLWarning warn)
      throws SQLException  {
        boolean rc = false;

    // Si es dado un objeto de SQLWarning, despliega los
    // mensajes de advertencia. Note que pueden existir m£ltiples
    // mensajes que podr¡an estar encadenados

        if (warn != null) {
            System.out.println ("\n *** Advertencia ***\n");
            rc = true;
            while (warn != null) {
                System.out.println ("SQLState: " + warn.getSQLState ());
                System.out.println ("Mensaje:  " + warn.getMessage ());
                System.out.println ("Error:   " + warn.getErrorCode ());
                System.out.println ("");
                warn = warn.getNextWarning ();
            }
        }
        return rc;
    }
    protected void displayRecordSet (String query)
    {
        
        try {
            abrir(nombreBD,logBD, pwdBD);
            if (stmt != null) {
                rs = stmt.executeQuery (query);
                dispResultSet(rs);
            }
            else
                return;
        }
        catch (SQLException ex) {
            // Una excepci¢n de SQL fu‚ generada. La obtiene y
            // despliega el mensaje de error. Note que puede haber
            // m£ltiples errores que podr¡an encadenarse.
            System.out.println ("\n*** Error de SQL interceptado ***\n");
            while (ex != null) {
                  System.out.println ("SQLState: " + ex.getSQLState ());
                  System.out.println ("Mensaje:  " + ex.getMessage ());
                  System.out.println ("Error:   " + ex.getErrorCode ());
                  ex = ex.getNextException ();
                  System.out.println ("");
            }
        }
        catch (java.lang.Exception ex) {
            // Si existe alg£n otro error, lo despliega del stack
            ex.printStackTrace ();
        }
    }
    //-------------------------------------------------------------------
    // dispResultSet
    // Despliega todas las l¡neas y columnas resultado de la selecci¢n
    //-------------------------------------------------------------------

    protected void dispResultSet (ResultSet rs)
	throws SQLException
    {
	int i;

    // Obtiene el objeto resultado ResultSetMetaData.
    // Este puede ser utilizado para desplegar los nombres
    // de los campos

	ResultSetMetaData rsmd = rs.getMetaData ();

    // Obtiene el n£mero de columnas resultado
	int numCols = rsmd.getColumnCount ();

    // Despliega los nombres de los campos
	for (i=1; i<=numCols; i++) {
		if (i > 1) System.out.print(",");
		System.out.print(rsmd.getColumnLabel(i));
	}
	System.out.println("");

    // Despliega informaci¢n hasta que no existan m s registros
	boolean more = rs.next ();
	while (more) {
    // Hace un ciclo por cada columna y la despliega en pantalla
		for (i=1; i<=numCols; i++) {
			if (i > 1) System.out.print(",");
			System.out.print(rs.getString(i));
		}
		System.out.println("");

      // Avanza al siguiente registro
		more = rs.next ();
	}
        cerrar();
    }
}

