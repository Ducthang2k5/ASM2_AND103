package com.example.asm_ph56058__and103.Home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.asm_ph56058__and103.R;
import com.example.asm_ph56058__and103.databinding.ActivityHomeBinding;
import com.example.asm_ph56058__and103.Cart.FragmentCart;
import com.example.asm_ph56058__and103.Favorite.FragmentFavorite;
import com.example.asm_ph56058__and103.Home.Fragment.FragmentProduct;
import com.example.asm_ph56058__and103.Notification.FragmentNotification;


public class ActivityHome extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_container, new FragmentProduct())
                .commit();

        binding.bottomNavigation.setOnItemSelectedListener( item -> {
            Fragment selectedFragment =  null;
            if (item.getItemId() == R.id.navHome) {
                selectedFragment = new FragmentProduct();
            } else if (item.getItemId() == R.id.navCart) {
                selectedFragment = new FragmentCart();
            } else if (item.getItemId() == R.id.navFavorite) {
                selectedFragment = new FragmentFavorite();
            } else {
                selectedFragment = new FragmentNotification();
            }
            return loadFragment(selectedFragment);
        });

    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fr_container, fragment);
            transaction.commit();
            return true;
        }
        return false;
    }
}