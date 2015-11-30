package tsuberi.app.pest2.Recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import tsuberi.app.pest2.Events.PhoneCallEvent;
import tsuberi.app.pest2.Pest2;

public class PhoneCallReceiver extends BroadcastReceiver {
    public PhoneCallReceiver() {
    }

    @Inject
    Bus bus;

    @Override
    public void onReceive(Context context, Intent intent) {
        Pest2.getApplicationComponent(context).inject(this);
        bus.post(new PhoneCallEvent("0584450670"));
    }
}
