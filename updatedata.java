import java.sql.*;

public class updatedata {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/JOBPORTAL";
        String username = "root";
        String password = "supriyo.sarkar";
        String query = "UPDATE employer SET company_address='Balurghat' where username='sup_emp';";

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
                System.out.println("Updation successfull "+ rowsaffected + " row(s) affected");
            }
            else{
                System.out.println("Updation Failed");
            }

            con.close();
            stmt.close();

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

