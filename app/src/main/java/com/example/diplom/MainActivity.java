package com.example.diplom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goNumber(View view) throws SQLException {
        Intent intent = new Intent(this, Number.class);
        startActivity(intent);

    }
    public static void reviewsAboutTheCar(int idCar, Statement statement) throws SQLException {
        String insertTableSQL = "SELECT DISTINCT comment \n" +
                "FROM table_comment JOIN table_users\n" +
                "ON table_comment.idrecipient = " + idCar;


        //statement.executeUpdate(insertTableSQL);
        ResultSet result = statement.executeQuery(insertTableSQL);
        while (result.next()) {
            System.out.println(result.getString(1));
        }
    }

    public void goBlog(View view) {
        Intent intent = new Intent(this, WebBlog.class);
        startActivity(intent);
    }
}