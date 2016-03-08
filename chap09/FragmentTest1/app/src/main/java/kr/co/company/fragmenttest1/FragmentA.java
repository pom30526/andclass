package kr.co.company.fragmenttest1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // 프래그먼트의 레이아웃을 팽창한다. 
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}