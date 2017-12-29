package com.example.t420.applocksreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {
    Button btnNext, btnNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNo = (Button) view.findViewById(R.id.btnNo);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new FragmentOne())
                        .commit();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager().findFragmentById(R.id.content) != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction().
                            remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.content)).commit();
                }
            }
        });
        return view;
    }

}
