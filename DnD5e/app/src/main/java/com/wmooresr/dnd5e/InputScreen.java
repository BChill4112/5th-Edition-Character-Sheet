package com.wmooresr.dnd5e;

//import all the stuff
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class InputScreen extends AppCompatActivity {

    //uicontrols
    Spinner selectRace;
    Spinner selectClass;
    Button btnsubmit;

    //
    String sRace;
    String sClass;

    //Define the list objects
    String myRaceTypes[] = {"Dwarf", "Elf", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"};
    ArrayAdapter<String> adapterMyRaceTypes;
    String myClassTypes[] = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Socerer", "Warlock", "Wizard"};
    ArrayAdapter<String> adapterMyClassTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);

        //Assign spinner from Layout
        selectClass = (Spinner) findViewById(R.id.selectClass);
        selectRace = (Spinner) findViewById(R.id.selectRace);

        //Ooooo Buttons
        btnsubmit=(Button)findViewById(R.id.submit);
        btnsubmit.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });

        // Intialize the lists to the spinner objects
        adapterMyRaceTypes = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, myRaceTypes);
        adapterMyRaceTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRace.setAdapter(adapterMyRaceTypes);
        adapterMyClassTypes = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, myClassTypes);
        adapterMyClassTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectClass.setAdapter(adapterMyClassTypes);

        //Do stuff when race selected
        selectRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                sRace = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getApplicationContext(),
                        "Race Selected: " + sRace, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO

            }
        });

        //Do stuff when class selected
        selectClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                sClass = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getApplicationContext(),
                        "Class Selected: " + sClass, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO

            }
        });
    }
}
