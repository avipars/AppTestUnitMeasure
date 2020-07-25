package com.eliorcohen.apptest.PagesPackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eliorcohen.apptest.R;
import com.eliorcohen.apptest.ModelsPackage.RVModel;
import com.eliorcohen.apptest.AdaptersPackage.RVAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RVModel> rvArrModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initArrRV();
        initRV();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);

        rvArrModel = new ArrayList<>();
    }

    private void initArrRV() {
        rvArrModel.clear();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> defValues = new HashSet<>(Arrays.asList(getResources().getStringArray(R.array.empty_array)));
        Set<String> values = prefs.getStringSet("show", defValues);

        String[] allVal = getResources().getStringArray(R.array.hideShowVal);

        if (values == null)
            return;

        for (String value : allVal) {
            if (values.contains(value)) {
                rvArrModel.add(new RVModel(value, "https://i.imgur.com/RRUe0Mo.png"));
            }
        }
    }

    private void initRV() {
        RVAdapter RVAdapter = new RVAdapter(this, rvArrModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(RVAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nearByMe) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
