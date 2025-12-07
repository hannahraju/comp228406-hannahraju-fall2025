package com.exercise1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgreSQLManager {

    private final String connectionURL;

    public PostgreSQLManager(String connectionURL){
        this.connectionURL = connectionURL;
    }

    public Connection connect() throws SQLException{
        return DriverManager.getConnection(connectionURL);
    }

}