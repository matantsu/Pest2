package tsuberi.app.pest2;

import net.orange_box.storebox.annotations.method.DefaultValue;
import net.orange_box.storebox.annotations.method.KeyByResource;
import net.orange_box.storebox.annotations.method.KeyByString;
import net.orange_box.storebox.annotations.method.RemoveMethod;

public interface PestPreferences {
    @KeyByResource(R.string.prefs_user_name)
    @DefaultValue(R.string.prefs_user_name_default)
    String username();

    @KeyByResource(R.string.prefs_user_name)
    void username(String val);

    @KeyByResource(R.string.prefs_user_name)
    @RemoveMethod
    void removeUsername();
}
