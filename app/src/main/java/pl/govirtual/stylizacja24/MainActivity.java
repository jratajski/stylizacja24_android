package pl.govirtual.stylizacja24;

/**
 * Created by Admin on 28.04.16.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.govirtual.stylizacja24.POJO.ImageResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences loginPreferences =
                getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, Context.CONTEXT_IGNORE_SECURITY);

        Stylizacja24API stylizacjaService = ServiceGenerator.
                createService(Stylizacja24API.class, loginPreferences.getString(LoginActivity.API_TOKEN_KEY, ""));
        Call<List<ImageResponse>> call = stylizacjaService.getDressingList();
        call.enqueue(new Callback<List<ImageResponse>>() {

            @Override
            public void onResponse(Call<List<ImageResponse>> call, Response<List<ImageResponse>> response) {
                Toast.makeText(MainActivity.this, response.body().size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<ImageResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DressingListFragment(), "Moje Stylizacje");
        adapter.addFragment(new DressingListFragment(), "Moje Wizaże");
        adapter.addFragment(new DressingListFragment(), "Dodaj Zdjęcie");
        adapter.addFragment(new DressingListFragment(), "Muszę Mieć");
        adapter.addFragment(new DressingListFragment(), "Moje Konto");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
