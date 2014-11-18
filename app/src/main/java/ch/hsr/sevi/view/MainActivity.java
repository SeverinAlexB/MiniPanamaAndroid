package ch.hsr.sevi.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ch.hsr.sevi.library.Callback;
import ch.hsr.sevi.library.LibraryService;

public class MainActivity extends Activity {

    //sku exapmple to use library


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("test");

        Callback<Boolean> registerCallback = new Callback<Boolean>() {
            @Override
            public void notfiy(Boolean input) {

                System.out.println("Registred" + input);
            }
        };
        LibraryService.register("test@hsr.ch", "password", "name", "studentNumber", registerCallback);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
