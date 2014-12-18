package eu.tumenas.maistobankas.util;

import android.support.v4.app.FragmentActivity;

import eu.tumenas.maistobankas.IntentIntegrator;
import eu.tumenas.maistobankas.R;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @author M. Tumėnas mantas@tumenas.eu
 * @since 2014-02-08 16:30
 */
public class ScanUtil {

    public static void initiateScan(FragmentActivity activity) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setMessage(activity.getString(R.string.barcode_scan_message));
        integrator.initiateScan();
    }

}
