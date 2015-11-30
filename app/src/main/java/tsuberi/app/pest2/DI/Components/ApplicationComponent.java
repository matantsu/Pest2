package tsuberi.app.pest2.DI.Components;

import javax.inject.Singleton;

import dagger.Component;
import tsuberi.app.pest2.DI.Modules.ApplicationModule;
import tsuberi.app.pest2.MainActivity;
import tsuberi.app.pest2.Recievers.PhoneCallReceiver;

@Singleton
@Component(
        modules = ApplicationModule.class
)
public interface ApplicationComponent {
    void inject(MainActivity activity);
    void inject(PhoneCallReceiver broadcastReceiver);
}
