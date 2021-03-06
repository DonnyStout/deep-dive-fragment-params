package edu.cnm.deepdive.fragmentparams;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//    fab.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
//      }
//    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();
    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    getSupportFragmentManager().beginTransaction()
                               .replace(R.id.fragment_container, new ParameterizedFragment())
                               .commit();
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();
    // Store some values that the fragment will access from onCreate().
    // Bundle instances store key/value pairs. I recommend defining the
    // keys as public constants in the fragment class.
    Bundle bundle = new Bundle();
    ParameterizedFragment frag = new ParameterizedFragment();
    switch (item.getItemId()) {
      case R.id.nav_camera:
        bundle.putString(ParameterizedFragment.TEXT_ARG_KEY, "Camera");
        break;
      case R.id.nav_gallery:
        bundle.putString(ParameterizedFragment.TEXT_ARG_KEY, "Gallery");
        bundle.putInt(ParameterizedFragment.COLOR_ARG_KEY, Color.DKGRAY);
        break;
      case R.id.nav_slideshow:
        bundle.putString(ParameterizedFragment.TEXT_ARG_KEY, "Awesome Slide Show");
        bundle.putInt(ParameterizedFragment.COLOR_ARG_KEY, Color.WHITE);
        break;
      case R.id.nav_manage:
        bundle.putString(ParameterizedFragment.TEXT_ARG_KEY, "Do management stuff");
        bundle.putInt(ParameterizedFragment.COLOR_ARG_KEY, Color.MAGENTA);
        break;
    }
    frag.setArguments(bundle); // Put the bundle into the arguments of the fragment.
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

}


