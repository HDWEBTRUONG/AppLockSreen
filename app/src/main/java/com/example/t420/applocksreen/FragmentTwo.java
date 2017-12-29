package com.example.t420.applocksreen;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    Button btn;
    Remove remove;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        remove= (Remove) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        remove= (Remove) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_two, container, false);
        btn=(Button)view.findViewById(R.id.btnRemove);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove.remove();
            }
        });
        return view;
    }

    interface Remove{
        void remove();
    }
}
