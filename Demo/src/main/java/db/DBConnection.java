package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    static DBConnection database;
    List<Customer> conection = new ArrayList<>();
    private DBConnection(){}

    public static DBConnection getInstance() {
        if(null==database){
            database = new DBConnection();
        }
        return database;
    }
    public List<Customer> getDBConnection(){return this.conection;}
}
