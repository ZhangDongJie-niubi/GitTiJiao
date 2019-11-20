package com.example.mvp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvp.base.BaseActivity;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.ui.fragment.AboutFragment;
import com.example.mvp.ui.fragment.CollectFragment;
import com.example.mvp.ui.fragment.GanHuoFragment;
import com.example.mvp.ui.fragment.JingXuanFragment;
import com.example.mvp.ui.fragment.RiBaoFragment;
import com.example.mvp.ui.fragment.SettingFragment;
import com.example.mvp.ui.fragment.V2ExFragment;
import com.example.mvp.ui.fragment.XiTuFragment;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.design_navigation_view)
    NavigationView designNavigationView;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.searchview)
    MaterialSearchView searchview;
    private FragmentManager mManager;

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        setStatus();
        initToolBar();
        initDrawerLayout();
        initNavigationView();
        mManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, new RiBaoFragment(),
                RiBaoFragment.class.getSimpleName()).commit();

    }


    public MaterialSearchView getSearchView() {
        if (searchview != null) {
            return searchview;
        }
        return null;
    }


    private void initNavigationView() {
        designNavigationView.setCheckedItem(R.id.item_ribao);
        designNavigationView.setItemIconTintList(null);
        designNavigationView.setNavigationItemSelectedListener(this);
        View childAt = designNavigationView.getChildAt(0);
        if (childAt instanceof NavigationMenuView) {
            childAt.setVerticalScrollBarEnabled(false);
        }
    }


    private void setStatus() {
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerlayout, homeToolbar,
                        R.string.nav_open, R.string.nav_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    private void initToolBar() {
        homeToolbar.setTitle("知乎日报");
        setSupportActionBar(homeToolbar);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.item_ribao:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new RiBaoFragment());
                break;

            case R.id.item_jingxuan:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new JingXuanFragment());
                break;

            case R.id.item_ganhuo:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new GanHuoFragment());
                break;

            case R.id.item_xitu:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new XiTuFragment());
                break;
            case R.id.item_v2ex:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new V2ExFragment());
                break;

            case R.id.item_collect:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new CollectFragment());
                break;
            case R.id.item_setting:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new SettingFragment());
                break;

            case R.id.item_about:
                setTitle(menuItem);
                startFragment(fragmentTransaction, new AboutFragment());
                break;

        }
        fragmentTransaction.commit();
        if (drawerlayout.isDrawerOpen(GravityCompat.START))
            drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setTitle(MenuItem item) {
        if (homeToolbar != null)
            homeToolbar.setTitle(item.getTitle());
    }


    private void startFragment(FragmentTransaction transaction, BaseFragment fragment) {
        transaction.replace(R.id.ll_container, fragment,
                fragment.getClass().getSimpleName());
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout != null && drawerlayout.isDrawerOpen(GravityCompat.START))
            drawerlayout.closeDrawer(GravityCompat.START);
        else
            //退出程序
            super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

