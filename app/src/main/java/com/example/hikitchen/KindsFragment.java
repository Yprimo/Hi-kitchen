package com.example.hikitchen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KindsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KindsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
    public class KindsFragment extends Fragment {
    //private String content;
    public static KindsFragment newInstance() {
        KindsFragment newFragment = new KindsFragment();
       // Bundle bundle = new Bundle();
       // bundle.putString("content", content);
       // newFragment.setArguments(bundle);
        return newFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kinds,container,false);
        //TextView txt_content = (TextView) view.findViewById(R.id.fg_kinds);
        //txt_content.setText(content);
        return view;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bundle args = getArguments();
        //if (args != null) {
           // content= args.getString("content");
       // }
    }
}
