package com.ahmadfariz.crudgreendao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListMember extends AppCompatActivity {
    RecyclerView listView;
    Repository repository;
    MyAdapter adapter;
    List<User> list;
    Button input;
    DaoSession daoSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoSession = ((MyApp) getApplication()).getDaoSession();
        listView = findViewById(R.id.listUser);
        input = findViewById(R.id.inputButton);

        repository = new Repository();

        list = new ArrayList<>();

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = getLayoutInflater();

                View mView = LayoutInflater.from(ListMember.this).inflate(R.layout.activity_input_dialog,null);

                AlertDialog builder = new AlertDialog.Builder(ListMember.this)
                        .setView(mView).show();
                Toast.makeText(getApplicationContext(),"Input Data",Toast.LENGTH_SHORT).show();


                EditText nama = mView.findViewById(R.id.txtNama);
                EditText alamat = mView.findViewById(R.id.txtAlamat);
                EditText telp = mView.findViewById(R.id.txtTelp);
                Button btnSimpan = mView.findViewById(R.id.btnUpdate);

                btnSimpan.setOnClickListener(v -> {
                    UserDao userDao = daoSession.getUserDao();
                    User user = new User();
                    user.setName(nama.getText().toString());
                    user.setAddress(alamat.getText().toString());
                    user.setTelp(telp.getText().toString());
                    userDao.insert(user);
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                    builder.dismiss();
                });

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        //clear previous data in list
        list.clear();

        //get data user from database
        list.addAll(repository.getAllData());

        adapter = new MyAdapter(list, this);

        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(adapter);

        //renew list
        adapter.notifyDataSetChanged();

    }
}