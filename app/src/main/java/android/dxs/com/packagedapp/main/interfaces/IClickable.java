package android.dxs.com.packagedapp.main.interfaces;

import android.view.View;

/**
 * Created by Deepak Sharma on 1/28/2016.
 * This is a common interface to handle all the initializations and clicks for adapter items in activities and fragments.
 */
public interface IClickable<T> {
    public void init(View view);
    public void execute(View view, T object);
}
