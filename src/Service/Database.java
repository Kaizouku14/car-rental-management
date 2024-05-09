package Service;

public class Database {
    
    private final String url = "jdbc:MySQL://localhost:3306/car_rental";
    private final String user = "root";
    private final String pass = "V(zAc7_335ViAPXc";
    
    public String getUrl(){
        return this.url;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public String getPass(){
        return this.pass;
    }
    
}
