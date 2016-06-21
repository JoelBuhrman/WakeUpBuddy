package com.example.joelbuhrman.wakeupbuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView buddiesList;
    String[] buddiesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();
    }

    private void init() {
        buddiesNames= new String[]{"Joel", "Marcus", "Ludvig", "Martin","Joel", "Marcus", "Ludvig", "Martin"};

        buddiesList= (ListView) findViewById(R.id.invitationListView);
        buddiesList.setAdapter(new BuddiesAdapter(getApplicationContext(), buddiesNames));
    }
}
