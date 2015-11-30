package tsuberi.app.pest2;

import android.app.Application;
import android.content.Context;

import tsuberi.app.pest2.DI.Components.ApplicationComponent;
import tsuberi.app.pest2.DI.Components.DaggerApplicationComponent;
import tsuberi.app.pest2.DI.Modules.ApplicationModule;

public class Pest2 extends Application {

    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this)).build();

    }

    public static ApplicationComponent getApplicationComponent(Context context){
        return ((Pest2)context.getApplicationContext()).applicationComponent;
    }
}
