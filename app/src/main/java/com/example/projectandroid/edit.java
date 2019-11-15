package com.example.projectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class edit extends AppCompatActivity {
    public static final String ITEM_CREATED = "new_item";
    final MyItem item = new MyItem();
    EditText lastname, lastsurname, lastcontact, lastmail;
    Button lastbutton;
    MyItem give = new MyItem();
    ImageView lastphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent j = getIntent();
        give = (MyItem) j.getSerializableExtra("good");
        setContentView(R.layout.activity_edit);
        lastname = findViewById(R.id.lastname);
        lastsurname = findViewById(R.id.lastsurname);
        lastcontact = findViewById(R.id.lastcontact);
        lastmail = findViewById(R.id.lastmail);
        lastbutton = findViewById(R.id.lastbutton);
        lastphoto = findViewById(R.id.lastphoto);
        lastname.setText(give.getNom());
        lastsurname.setText(give.getPrenom());
        lastcontact.setText(give.getContact());
        lastmail.setText(give.getEmail());
        lastphoto.setImageResource(give.getImageid());
        lastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastname.getText().toString().isEmpty() || lastsurname.getText().toString().isEmpty() || lastcontact.getText().toString().isEmpty() || lastmail.getText().toString().isEmpty() ||lastcontact.getText().toString().length()<8) {
                    Toast.makeText(edit.this, "Entrer les valeurs", Toast.LENGTH_SHORT).show();

                } else {
                    String mot1, mot2, mot3, mot4;
                    mot1 = lastname.getText().toString();
                    mot2 = lastsurname.getText().toString();
                    mot3 = lastcontact.getText().toString();
                    mot4 = lastmail.getText().toString();
                    String[] table = {mot1, mot2, mot3, mot4};
                    Intent result = new Intent();
                    result.putExtra("moi", table);
                    setResult(RESULT_OK, result);
                    finish();

                }

            }
        });

    }
}
