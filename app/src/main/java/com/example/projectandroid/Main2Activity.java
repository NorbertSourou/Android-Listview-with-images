package com.example.projectandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView nom, prenom, contact, email;
    ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.mail);
        view = findViewById(R.id.photo);
        String t = (String) getIntent().getSerializableExtra("nom");
        String t1 = (String) getIntent().getSerializableExtra("prenom");
        String t2 = (String) getIntent().getSerializableExtra("contact");
        String t3 = (String) getIntent().getSerializableExtra("email");
        int t4 = (int) getIntent().getSerializableExtra("image");
        nom.setText(t);
        prenom.setText(t1);
        contact.setText(t2);
        email.setText(t3);
        view.setImageResource(t4);
        final String appel = contact.getText().toString();
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:" + appel);
                Intent call = new Intent(Intent.ACTION_CALL, uri);
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    requestPermissions(permissions, 1000);
                    return;
                }
                startActivity(call);
            }
        });
    }
}
