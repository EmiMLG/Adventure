package es.telefonica.talentum.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton helpButton;
    TextView mainText;
    ImageButton northButton;
    ImageButton southButton;
    ImageButton eastButton;
    ImageButton westButton;
    ImageButton lookButton;
    ImageButton inventoryButton;
    ImageButton dropButton;
    ImageButton takeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.activity_main_scene_text);
        helpButton = (ImageButton) findViewById(R.id.activity_main_scene_help);
        northButton = (ImageButton) findViewById(R.id.activity_main_north_button);
        southButton = (ImageButton) findViewById(R.id.activity_main_south_button);
        eastButton = (ImageButton) findViewById(R.id.activity_main_east_button);
        westButton = (ImageButton) findViewById(R.id.activity_main_west_button);
        lookButton = (ImageButton) findViewById(R.id.activity_main_look_button);
        inventoryButton = (ImageButton) findViewById(R.id.activity_main_scene_inventory);
        dropButton = (ImageButton) findViewById(R.id.activity_main_scene_drop);
        takeButton = (ImageButton) findViewById(R.id.activity_main_scene_take);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(i);
            }
        });

        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomNorth();
                repaintScene();
            }
        });

        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomSouth();
                repaintScene();
            }
        });

        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomEast();
                repaintScene();
            }
        });

        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomWest();
                repaintScene();
            }
        });

        lookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        initGame();
        repaintScene();
    }

    Inventory inventory = new Inventory();
    Room currentRoom;

    private void initGame() {

        Item sword = new Item("Sword", " A shine blade");
        Item pieceOfPaper = new Item("Piece of Paper", "A blank piece of paper");
        Item rubberChicken = new Item("Pollo de Goma", "Un 'inútil' pollo de goma");

        inventory.add(sword);
        inventory.add(pieceOfPaper);
        inventory.add(rubberChicken);

        MapGenerator.generate();

        currentRoom = MapGenerator.initialRoom;
    }

    private void repaintScene(){
        //write room description on screen
        mainText.setText(currentRoom.getDescription());

        if (currentRoom.getRoomNorth() != null) {
            //there's room pointing north
            northButton.setVisibility(View.VISIBLE);
        } else {
            northButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomSouth() != null) {
            //there's room pointing north
            southButton.setVisibility(View.VISIBLE);
        } else {
            southButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomEast() != null) {
            //there's room pointing north
            eastButton.setVisibility(View.VISIBLE);
        } else {
            eastButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomWest() != null) {
            //there's room pointing north
            westButton.setVisibility(View.VISIBLE);
        } else {
            westButton.setVisibility(View.INVISIBLE);
        }




    }

}


