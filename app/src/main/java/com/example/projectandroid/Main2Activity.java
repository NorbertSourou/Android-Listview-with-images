package com.example.projectandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    public final static int CHOOSE_BUTTON_REQUEST = 0;
    MyItem item = new MyItem();
    TextView nom, prenom, contact, email;
    ImageView view;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.mail);
        view = findViewById(R.id.photo);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        item = (MyItem) i.getSerializableExtra("donner");
        nom.setText(item.getNom());
        prenom.setText(item.getPrenom());
        contact.setText(item.getContact());
        email.setText(item.getEmail());
        view.setImageResource(item.getImageid());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mot1 = nom.getText().toString();
                String mot2 = prenom.getText().toString();
                String mot3 = contact.getText().toString();
                String mot4 = email.getText().toString();
                String[] table = {mot1, mot2, mot3, mot4};
                Intent result = new Intent();
                result.putExtra("toi", table);
                setResult(RESULT_OK, result);
                onBackPressed();
            }
        });
        final String appel = contact.getText().toString();
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:" + appel);
                Intent call = new Intent(Intent.ACTION_CALL, uri);
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    requestPermissions(permissions, 10);
                    return;
                }
                startActivity(call);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item2) {
        switch (item2.getItemId()) {
            case R.id.bingo:
                Intent intent = new Intent(this, edit.class);
                intent.putExtra("good", item);
                startActivityForResult(intent, CHOOSE_BUTTON_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_BUTTON_REQUEST) {
            if (resultCode == RESULT_OK) {
                String[] tab = data.getStringArrayExtra("moi");
                nom.setText(tab[0]);
                prenom.setText(tab[1]);
                contact.setText(tab[2]);
                email.setText(tab[3]);
            }
        }
    }
}
