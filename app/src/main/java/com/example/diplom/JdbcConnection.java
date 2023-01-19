package com.example.diplom;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

//@RequiresApi(api = Build.VERSION_CODES.N)
public class JdbcConnection {

    private static final Logger LOGGER =
            Logger.getLogger(JdbcConnection.class.getName());
    private static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection() {
        String url = "jdbc:postgresql://localhost:5432/users";
        String user = "postgres";
        String password = "12345";
        try {
            connection = Optional.ofNullable(
                    DriverManager.getConnection(url, user, password));
            System.out.println("успешно");
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}