package tsuberi.app.pest2.DI.Modules;

import android.app.Application;

import com.squareup.otto.Bus;

import net.orange_box.storebox.StoreBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tsuberi.app.pest2.PestPreferences;

@Module
public class ApplicationModule {

    Application app;
    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    PestPreferences provideSharedPreferences(){
        return StoreBox.create(app, PestPreferences.class);
    }
}
