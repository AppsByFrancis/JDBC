import java.sql.*;

public class DemoJdbc{
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/jdbc"; // Driver, database in use, where db is running, port, db name
        String uname = "postgres";
        String password = "postgres";
        String query = "select * from student";
        try {
            Class.forName("org.postgresql.Driver"); // Load jdbc Driver
            Connection con = DriverManager.getConnection(url, uname, password); // Connection establishment
            System.out.println("Established connection");
            Statement st = con.createStatement(); // create statement
            ResultSet res = st.executeQuery(query); // execute statement
            // res.next(); //  returns true if there is a next row, because it starts on the
                        /*
 line where the names of the columns are - Signal of query execution
            System.out.println(res.getString("sname")); // gets the value of a column
            // System.out.println(res.getString(1)); // gets the value of a column of index 1
            System.out.println(res);
            con.close(); // closes connection with DB
*/
            while(res.next()){ // it will check if there is a next row
                System.out.print(res.getInt(1) + " - ");
                System.out.print(res.getString(2) + " - ");
                System.out.println(res.getInt(3));
            }
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}