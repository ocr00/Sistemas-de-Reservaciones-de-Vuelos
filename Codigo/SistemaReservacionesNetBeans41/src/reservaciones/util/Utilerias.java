package reservaciones.util;

import java.util.*;
import java.io.*;

public class Utilerias
{
        public static String getClassPath(Object object){
            String name;
            Class objclass = object.getClass();
            String fullname = objclass.getName();
            int index = fullname.lastIndexOf('.');
            if (index > 0)
                name = fullname.substring(0,index);
            else
                name = fullname;
            return name;
        }
        public static String getClassName(Object object){
            String name;
            Class objclass = object.getClass();
            String fullname = objclass.getName();
            int index = fullname.lastIndexOf('.');
            if (index > 0)
                name = fullname.substring(index+1);
            else
                name = fullname;
            return name;
        }

/**
 * Insert the method's description here.
 * Creation date: (10/23/2002 6:51:54 PM)
 */

  public static Object instanciarClase(String classname){
    Object object = null;
    try {
      Class c = Class.forName(classname);
      object = c.newInstance();
      System.out.println ("Creando objetos de clase: " + classname);
    }
    catch (Exception ex){
      System.out.println("Creación Nula de clase:  " + classname);
      ex.printStackTrace();
    }

    return object;
  }
}

