package com.example.projectandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    public final static int CHOOSE = 0;
    public final static int CHOIX = 1;
    SharedPreferences sharedpreferences;
    ListView mainactivity;
    ArrayList<MyItem> myitems = new ArrayList<>();
    String[] prenom = {"Alexis", "Quentin", " Valentin", "Bastien", "Antoine", "Geoffrey", "Jordan", "Tristan", "Steven", "Jason", "Jimmy", "Lucas", "Théo", "Baptiste", "Axel", "Jessy", "Arthur", "Simon", "Louis", "Gaétan", "Florent", "Michael", "Christophe", "Benoît", "Jérôme", "Stéphane", "Arnaud", "Frédéric", "Laurent", "Ludovic", "Aurélien", "Cédric", "Jean", "Marc", "Gregory", "Olivier", "Fabien", "Loïcé", "Yannick", "Damien"};
    String[] names = {"Martin", "Bernard", "Thomas", "Petit", "Robert", "Richard", "Durand ", "Dubois", "Moreau", "Laurent", "Simon", "Michel", "Lefebvre", "Leroy", "Roux", "David", "Bertrand", "Morel", "Fournier", "Girard", "Bonnet", "Dupont", "Lambert", "Fontaine", "Rousseau", "Vincent", "Muller", "Lefevre", "Faure", "Andre", "Mercier", "Blanc", "Guerin", "Boyer", "Garnier", "Chevalier", "Francois", "Legrand", "Gauthier", "Garcia"};
    String[] contact = {"94498351", "61253292", "94498351", "61434213", "65448341", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41"};
    String[] email = {"email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com"};
    int[] photo = {R.drawable.an, R.drawable.ana, R.drawable.arc, R.drawable.che, R.drawable.chi,};
    int[] vrai_image = new int[40];
    MyItem recuper;
      MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 40; i++) {
            int random;
            random = (int) (Math.random() * 5);
            vrai_image[i] = photo[random];
        }

        mainactivity = findViewById(R.id.list_view);
        for (int i = 0; i < 40; i++) {
            myitems.add(new MyItem(vrai_image[i], names[i], prenom[i], contact[i], email[i]));
        }

      adapter = new MyAdapter(MainActivity.this, myitems);
        //adapter.notifyDataSetChanged();
        mainactivity.setAdapter(adapter);

        mainactivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("poste", position);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("donner", myitems.get(position));
                startActivityForResult(intent, CHOOSE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CHOOSE) {
            if (resultCode == RESULT_OK) {
                String[] tab = data.getStringArrayExtra("toi");
                int coul = sharedpreferences.getInt("poste", -1);
                recuper = myitems.get(coul);
                recuper.setNom(tab[0]);
                recuper.setPrenom(tab[1]);
                recuper.setContact(tab[2]);
                recuper.setEmail(tab[3]);
               adapter.notifyDataSetChanged();
            }
        }
      /*  if (requestCode == CHOIX) {
            if (resultCode == RESULT_OK) {
                String[] cadre = data.getStringArrayExtra("pro");
                myitems.add(new MyItem(cadre[0], cadre[1], cadre[2], table[(int) (Math.random() * (table.length - var))]));

            }
        }*/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
