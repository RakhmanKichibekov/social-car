package com.example.diplom2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.diplom2.adapters.SimpleImageListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyPhotos extends AppCompatActivity {
    //Для заполнения списка
    ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] listData = {
            "https://firebasestorage.googleapis.com/v0/b/cars-5fe3d.appspot.com/o/images%2F3b78b141-417c-418d-9985-ecab223ddde4?alt=media&token=78cf00b5-fe15-448b-86ac-f473b7256cc6",
            "https://firebasestorage.googleapis.com/v0/b/cars-5fe3d.appspot.com/o/images%2F3b78b141-417c-418d-9985-ecab223ddde4?alt=media&token=78cf00b5-fe15-448b-86ac-f473b7256cc6"

    };
    ImageView imageView;

    //Создание переменных для БД
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    //Переменная для картинки
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_photos);
        listView = findViewById(R.id.listImages);
        //imageView = findViewById(R.id.image1);

        //Для заполнения списка
        //listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.image_item, R.id.user_name, listData);
        listView.setAdapter(adapter);
        //listView.setAdapter(new SimpleImageListAdapter(MyPhotos.this, listData));


        //Вход в БД
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("users");

        //Взятие картинки из БД
        image = String.valueOf(db.getReference("image"));
        System.out.println("картинка" + image);

        //Попытка вывести картинку из БД
        String url = "https://firebasestorage.googleapis.com/v0/b/cars-5fe3d.appspot.com/o/images%2F3b78b141-417c-418d-9985-ecab223ddde4?alt=media&token=78cf00b5-fe15-448b-86ac-f473b7256cc6";
        //Отображение картинки
        Glide.with(getApplicationContext()).load(url).into(imageView);

    }


    public void goHome(View view) {
        Intent intent = new Intent(this, Number.class);
        startActivity(intent);
    }
}