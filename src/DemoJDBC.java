/*
Steps :-
1. Import the JDBC package
2. Load and register JDBC drivers
3. Create connection
4. Create statement
5. Execute Statement
6. Process the result
7. Close the connection/resources
 */

//step 1
import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {

        //step 2 - optional in JDBC4 +
        //Class.forName("org.postgresql.Driver");

        //step 3
        String url = System.getenv("db_url");
        String user = System.getenv("db_user");
        String password = System.getenv("db_password");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Established");

        //step 4
        Statement st = con.createStatement();

        //step 5
        String sqlQuery = "select * from student";
        ResultSet rs = st.executeQuery(sqlQuery);

        //step 6
        while(rs.next()){
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2)+ " " +
                    rs.getInt(3)
            );
        }

        //step 7
        con.close();
        System.out.println("Connection Closed");

    }
}
