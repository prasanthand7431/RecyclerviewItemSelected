package comre.example.velmurugan.recyclerviewdemo;

import android.view.View;

/**
 * Created by velmurugan on 19/2/16.
 */
public interface ClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
