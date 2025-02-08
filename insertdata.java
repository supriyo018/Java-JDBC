import java.sql.*;

public class insertdata {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/JOBPORTAL";
        String username = "root";
        String password = "supriyo.sarkar";
        String query = "INSERT INTO employer VALUES('Supriyo Employer','sup_emp','ss4606@srmist.edu.in','SS Enterprise','Chennai','8918907805');";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully");
            Statement stmt= con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);

            if(rowsaffected>0){
                System.out.println("Insertion successfull "+ rowsaffected + " row(s) affected");
            }
            else{
                System.out.println("Insertion Failed");
            }

            con.close();
            stmt.close();

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
