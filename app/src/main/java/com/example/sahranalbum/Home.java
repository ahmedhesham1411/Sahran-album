package com.example.sahranalbum;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class Home extends AppCompatActivity {
    ArrayList<MyModel> myModels;

    SubCatAdapter subCatAdapter;
    RecyclerView recyclerView;
    private DrawerLayout drawer;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);

        recyclerView = findViewById(R.id.rec);

        myModels = new ArrayList<>();
        myModels.add(new MyModel("زى ما انتى ",true,"zymante"));
        myModels.add(new MyModel("قدام مرايتها",false,"odam"));
        myModels.add(new MyModel("سهران",false,"sahran"));
        myModels.add(new MyModel("مكانك فى قلبى",true,"mkanfalby"));
        myModels.add(new MyModel("هيعيش يفتكرنى",false,"yftkrne"));
        myModels.add(new MyModel("يوم تلات ",true,"yomtalat"));
        myModels.add(new MyModel("بالضحكة دى",false,"blghkad"));
        myModels.add(new MyModel("بحبه",false,"bhbo"));
        myModels.add(new MyModel("اول يوم",true,"awlyom"));
        myModels.add(new MyModel("عم الطبيب",false,"ameltaib"));
        myModels.add(new MyModel("يا روقانك ",true,"yarawaank"));
        myModels.add(new MyModel("حلوة البدايات",false,"helwaelbdayat"));
        myModels.add(new MyModel("روح",false,"roh"));
        myModels.add(new MyModel("جميلة",true,"gamila"));
        myModels.add(new MyModel("جامدة بس",false,"gamdabs"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        subCatAdapter = new SubCatAdapter(myModels,this);
        recyclerView.setAdapter(subCatAdapter);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            showSuccessDialog();
        }
    }


    private void showSuccessDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.success_dialog1, viewGroup, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        imageView = dialogView.findViewById(R.id.aaaaaaaaaaaaaaaa);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
    }


}
