package com.example.petagram.Adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.petagram.Fragments.FragmentView;
import com.example.petagram.Fragments.FragmentViewPerfil;


public class PageAdapter extends FragmentStateAdapter {


    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fr = null;
        switch (position){
            case 0:
                fr = new FragmentView();
                break;
            case 1:
                fr = new FragmentViewPerfil();
                break;
        }
        return fr;
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}


