import java.sql.*;

public class database {
  public static Connection Connect( String args[] ) {
      Connection c = null;
      
      try{
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:library.db");
      }catch( Exception e ){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }finally{
      System.out.println("Opened database successfully");
      }

      return c;
   }
}
