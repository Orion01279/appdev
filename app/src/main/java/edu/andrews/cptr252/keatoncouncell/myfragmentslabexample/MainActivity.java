package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Fragment_class_example_1 fragment1 = new Fragment_class_example_1();
        Fragment_class_example_2 fragment2 = new Fragment_class_example_2();
        Fragment_class_3 fragment3 = new Fragment_class_3();
        Fragment_class_4 fragment4 = new Fragment_class_4();

        Button btnFragment1 = findViewById(R.id.btnfragment_1);
        Button btnFragment2 = findViewById(R.id.btnfragment_2);
        Button btnFragment3 = findViewById(R.id.btnfragment_3);
        Button btnFragment4 = findViewById(R.id.btnfragment_4);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frameLayout, fragment4);
        transaction.commit();

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.frameLayout, fragment1);
                transaction.commit();

            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.frameLayout, fragment2);
                transaction.commit();
            }
        });

        btnFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.frameLayout, fragment3);
                transaction.commit();
            }
        });

        btnFragment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.frameLayout, fragment4);
                transaction.commit();
            }
        });


    }
}