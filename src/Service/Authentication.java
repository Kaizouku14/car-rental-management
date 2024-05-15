package Service;

import java.sql.*;

public class Authentication{
    
    private String email;
    private String username;
    private String role;
    private final Database db;

    public Authentication() {
        db = new Database();
    }

    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }
    
     public String getRole() {
        return role;
    }
     
  public boolean authentication(String sqlQuery, String email, String password) {
    try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
         PreparedStatement statement = con.prepareStatement(sqlQuery);
         ResultSet result = statement.executeQuery()) {

        while (result.next()) {
            if (email.equals(result.getString("EMAIL")) &&
                password.equals(result.getString("PASSWORD"))) {

                 this.email = email;
                 this.username = result.getString("USERNAME");
                 this.role = result.getString("ROLE");
                   
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; 
  }
  
   public boolean checkEmail(String email){
        String sqlQuery = "SELECT * FROM ACCOUNTS WHERE EMAIL = ?";
        
        try(Connection con = DriverManager.getConnection(db.getUrl() ,db.getUser() ,db.getPass());
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery()){
            
            while(result.next()){
               return email.equals(result.getString("EMAIL"));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
}
