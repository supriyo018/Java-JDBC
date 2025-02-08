import java.sql.*;

public class retrivedata {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/JOBPORTAL";
        String username = "root";
        String password = "supriyo.sarkar";
        String query = "select * from employer;";

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
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String name=rs.getString("name");
                String username1=rs.getString("username");
                String email=rs.getString("email");
                String company_name=rs.getString("company_name");
                String company_address=rs.getString("company_address");
                String company_contact=rs.getString("company_contact");

                System.out.println();
                System.out.println("=========================================");
                System.out.println("Name: "+name);
                System.out.println("Username: "+username1);
                System.out.println("Email Address: "+email);
                System.out.println("Company Name: "+company_name);
                System.out.println("Company Address: "+ company_address);
                System.out.println("Company Contact: "+company_contact);
            }
            con.close();
            stmt.close();
            rs.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
