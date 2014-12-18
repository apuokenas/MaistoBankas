package eu.tumenas.maistobankas;

import android.app.Application;

import eu.tumenas.maistobankas.api.ItemInfoProviders;
import eu.tumenas.maistobankas.api.MainService;
import eu.tumenas.maistobankas.util.Utils;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * @since 2014-03-29 11:58
 */
public class MainApplication extends Application {
    public static MainService mainService;

    public MainApplication() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ItemInfoProviders.getServicesEndpoint())
                .setConverter(new GsonConverter(Utils.getGson()))
                .setLogLevel(RestAdapter.LogLevel.FULL).build();

        mainService = restAdapter.create(MainService.class);
    }
}
