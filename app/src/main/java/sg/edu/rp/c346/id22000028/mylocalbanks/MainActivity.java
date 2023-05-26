package sg.edu.rp.c346.id22000028.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    Button DBSbutton1;
    Button OCBSbutton2;
    Button UOBbutton3;
    String wordClicked; // Identifier for the button clicked
    Button ButtonTranslatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBSbutton1 = findViewById(R.id.buttonDBS);
        registerForContextMenu(DBSbutton1);

        OCBSbutton2 = findViewById(R.id.buttonOCBC);
        registerForContextMenu(OCBSbutton2);

        UOBbutton3 = findViewById(R.id.buttonUOB);
        registerForContextMenu(UOBbutton3);

        ButtonTranslatedText = findViewById(R.id.buttonDBS);
        registerForContextMenu(ButtonTranslatedText);

        ButtonTranslatedText = findViewById(R.id.buttonOCBC);
        registerForContextMenu(ButtonTranslatedText);

        ButtonTranslatedText = findViewById(R.id.buttonUOB);
        registerForContextMenu(ButtonTranslatedText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        BreakIterator tvTranslatedText;
        if (id == R.id.EnglishSelection) {
            ButtonTranslatedText.setText("DBS");
            ButtonTranslatedText.setText("OCBC");
            ButtonTranslatedText.setText("UOB");
            return true;
        } else if (id == R.id.italianSelection) {
            ButtonTranslatedText.setText("星展银行");
            ButtonTranslatedText.setText("华侨银行");
            ButtonTranslatedText.setText("大华银行");
            return true;
        } else {
            ButtonTranslatedText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        wordClicked = "";

        if (v == DBSbutton1) {
            wordClicked = "DBS";
        } else if (v == OCBSbutton2) {
            wordClicked = "OCBC";
        } else if (v == UOBbutton3) {
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equals("DBS")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.dbs.com.sg";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting DBS", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.ocbc.com";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting OCBC", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.uob.com.sg";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting UOB", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}
