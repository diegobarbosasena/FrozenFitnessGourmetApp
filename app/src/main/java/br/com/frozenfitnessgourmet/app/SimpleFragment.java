package br.com.frozenfitnessgourmet.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 15160046 on 25/10/2016.
 */
public class SimpleFragment extends Fragment {

    private int position;

    public SimpleFragment(){}

    public SimpleFragment(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        TextView textView = (TextView) rootView.findViewById(R.id.item);

        textView.setText("Tab" + position);

        return rootView;
    }
}
