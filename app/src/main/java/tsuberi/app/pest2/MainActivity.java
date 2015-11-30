package tsuberi.app.pest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

import java.util.Random;

import javax.inject.Inject;

import butterknife.ButterKnife;
import tsuberi.app.pest2.Events.PhoneCallEvent;

public class MainActivity extends AppCompatActivity {

    @Inject
    Bus bus;

    @Inject
    PestPreferences prefs;

    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pest2.getApplicationComponent(getApplicationContext()).inject(this);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        bus.register(this);

        Toast.makeText(this,prefs.username(),Toast.LENGTH_SHORT).show();
        //prefs.username(""+rand.nextInt());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
        ButterKnife.unbind(this);
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

    @Subscribe
    public void onPhoneCallEvent(PhoneCallEvent event) {
        Toast.makeText(this,"onPhoneCallEvent: "+event.getPhoneNumber(),Toast.LENGTH_LONG).show();
    }

    @Produce
    public PhoneCallEvent producePhoneCallEvent(){
        return PhoneCallEvent.DEFAULT;
    }
}
