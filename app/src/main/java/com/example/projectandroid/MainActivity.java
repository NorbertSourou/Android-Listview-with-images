package com.example.projectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mainactivity;
    ArrayList<MyItem> myitems = new ArrayList<>();
    String[] prenom = {"Alexis", "Quentin", " Valentin", "Bastien", "Antoine", "Geoffrey", "Jordan", "Tristan", "Steven", "Jason", "Jimmy", "Lucas", "Théo", "Baptiste", "Axel", "Jessy", "Arthur", "Simon", "Louis", "Gaétan", "Florent", "Michael", "Christophe", "Benoît", "Jérôme", "Stéphane", "Arnaud", "Frédéric", "Laurent", "Ludovic", "Aurélien", "Cédric", "Jean", "Marc", "Gregory", "Olivier", "Fabien", "Loïcé", "Yannick", "Damien"};
    String[] names = {"Martin", "Bernard", "Thomas", "Petit", "Robert", "Richard", "Durand ", "Dubois", "Moreau", "Laurent", "Simon", "Michel",
            "Lefebvre",
            "Leroy",
            "Roux",
            "David",
            "Bertrand",
            "Morel",
            "Fournier",
            "Girard",
            "Bonnet",
            "Dupont",
            "Lambert",
            "Fontaine",
            "Rousseau",
            "Vincent",
            "Muller",
            "Lefevre",
            "Faure",
            "Andre",
            "Mercier",
            "Blanc",
            "Guerin",
            "Boyer", "Garnier",
            "Chevalier",
            "Francois",
            "Legrand",
            "Gauthier",
            "Garcia"};
    String[] contact = {"94498351", "61253292", "94498351", "61434213", "65448341", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41", "94 49 83 51", "61 25 32 92", "94 49 83 51", "61434213", "65 44 83 41"};
    String[] email = {"email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com", "email@gmail.com", "justice@gmail.com", "android@gmail.com", "mobile@gmail.com", "cc@gmail.com"};
    int[] photo = {R.drawable.an, R.drawable.ana, R.drawable.arc, R.drawable.che, R.drawable.chi,};
    int[] vrai_image = new int[40];

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
        MyAdapter adapter = new MyAdapter(MainActivity.this, myitems);
        mainactivity.setAdapter(adapter);
        mainactivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("nom", names[position]);
                intent.putExtra("prenom", prenom[position]);
                intent.putExtra("contact", contact[position]);
                intent.putExtra("email", email[position]);
                intent.putExtra("image", vrai_image[position]);
                startActivity(intent);
            }
        });

    }


}
