package quejas.sugerencias;
import java.sql.*;
public class ConexionBD {
    Connection cn;
    Statement st;
    public Connection conexion()
    {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/gandhidb","root","");
            System.out.println("Conexión establecida");
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       return cn; 
    }
}
