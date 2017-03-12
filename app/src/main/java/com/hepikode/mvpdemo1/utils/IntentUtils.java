package com.hepikode.mvpdemo1.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by DhytoDev on 3/12/17.
 */

public class IntentUtils {

    public static Intent setIntent(Context context, Class destination) {

        Intent intent = new Intent(context, destination);
        context.startActivity(intent);

        return intent ;
    }
}
