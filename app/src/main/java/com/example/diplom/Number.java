package com.example.diplom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class Number extends AppCompatActivity {
    private TextView resultTextView;
    private EditText userNameFileld;
    Database db = new Database();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        resultTextView = findViewById(R.id.resultTextView);
        userNameFileld = findViewById(R.id.userNameField);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
    }

    public void goAdd(View view) {
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void goPhotos(View view) {
        Intent intent = new Intent(this, MyPhotos.class);
        startActivity(intent);
    }

    public void goChats(View view) {
        Intent intent = new Intent(this, Chats.class);
        startActivity(intent);
    }

    //@RequiresApi(api = Build.VERSION_CODES.N)
    public void goNumber(View view) throws SQLException {
        Optional<Connection> connection = JdbcConnection.getConnection();
        Statement statement = connection.get().createStatement();
//        Connection connection = db.getExtraConnection();
//        Statement statement = connection.createStatement();
        String userName = userNameFileld.getText().toString();
        String number = numberById(Integer.parseInt(userName), statement);
        resultTextView.setText(String.valueOf(number));
    }

    public static String numberById(int id, Statement statement) throws SQLException {
        String insertTableSQL = "select autonumber from table_users where id = " + id;
        ResultSet result = statement.executeQuery(insertTableSQL);
        while (result.next()) {
            return result.getString(1);
        }
        return insertTableSQL;
    }
}