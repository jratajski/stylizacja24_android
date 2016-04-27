package pl.govirtual.stylizacja24;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 27.04.16.
 */
public class DressingListFragment extends ListFragment {
    public static final String ARG_OBJECT = "MojeStylizacjeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.dressing_list_layout, container, false);
        return rootView;
    }
}
