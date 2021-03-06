package org.pursuit.group_portfolio_hw_codigo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class LuisActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolBar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luis);

        applyImage();

        navView = findViewById(R.id.luis_nav_view);
        navView.setItemTextAppearance(R.style.nav_menu_text);

        drawerLayout = findViewById(R.id.main);
        toolBar = findViewById(R.id.include);
        setSupportActionBar(toolBar);


        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_up_action);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        setupNavDrawer();



    }
    private void applyImage() {
        ImageView imageView = findViewById(R.id.luis_pic);
        imageView.setImageResource(R.drawable.luispic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.story_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github_action:
                Toast.makeText(this, "GitHub", Toast.LENGTH_SHORT).show();
                dialogish().show();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    public AlertDialog dialogish() {
        AlertDialog.Builder gitDialog = new AlertDialog.Builder(LuisActivity.this);
        gitDialog.setTitle(R.string.git_dialog_title)
                .setItems(R.array.luis_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Uri uri = Uri.parse("https://github.com/LJmnz27/MSDOS-game.git");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                break;
                            case 1:
                                Uri uri2 = Uri.parse("https://github.com/LJmnz27/Bank_Teller.git");
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                                startActivity(intent2);
                                break;
                            case 2:
                                Uri uri3 = Uri.parse("https://github.com/michvarg/el_codigo.git");
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                                startActivity(intent3);
                                break;
                        }
                    }
                });
        return gitDialog.create();
    }
    public void setupNavDrawer() {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.option_Geo:
                        Intent intentGeo = new Intent(LuisActivity.this, GeoActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentGeo);
                        break;
                    case R.id.option_Jessica:
                        Intent intentJess = new Intent(LuisActivity.this, JessActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentJess);
                        break;
                    case R.id.option_Luis:
                        Intent intentLuis = new Intent(LuisActivity.this, LuisActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentLuis);
                        break;
                    default:
                        Toast.makeText(LuisActivity.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START, true);
                        break;
                }
                return true;
            }
        });
    }


}
