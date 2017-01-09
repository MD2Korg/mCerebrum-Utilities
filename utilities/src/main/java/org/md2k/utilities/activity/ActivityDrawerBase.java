package org.md2k.utilities.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialize.util.UIUtils;

import org.md2k.utilities.icon.Icon;
import org.md2k.utilities.info.PackageInfo;

public abstract class ActivityDrawerBase extends ActivityBase {

    //save our header or result
    public AccountHeader headerResult = null;
    public Drawer result = null;
    public Toolbar toolbar;

    public abstract int getLayoutId();

    public abstract int getDrawableHeaderId();

    public abstract int getToolbarId();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(getToolbarId());
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(PackageInfo.getName(this));
//        toolbar.setTitleTextColor();

        // Create a few sample profile
        final IProfile profile = new ProfileDrawerItem().withName(PackageInfo.getName(this)).withIcon(PackageInfo.getLauncherIcon(this)).withEnabled(false);

        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(getDrawableHeaderId())
                .addProfiles(
                        profile
                )
                .withSavedInstance(savedInstanceState)
                .build();

        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Play").withIcon(FontAwesome.Icon.faw_gamepad),
                        new PrimaryDrawerItem().withName("Custom").withIcon(FontAwesome.Icon.faw_eye).withIdentifier(5),
                        new SectionDrawerItem().withName("Section header"),
                        new SecondaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName("Help").withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
                        new SecondaryDrawerItem().withName("Open_source").withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName("Contact").withIcon(FontAwesome.Icon.faw_bullhorn)
                )
                .withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                    @Override
                    public boolean onNavigationClickListener(View clickedView) {
                        //this method is only called if the Arrow icon is shown. The hamburger is automatically managed by the MaterialDrawer
                        //if the back arrow is shown. close the activity
                        ActivityDrawerBase.this.finish();
                        //return true if we have consumed the event
                        return true;
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem.getIdentifier() == 1) {
//                            startSupportActionMode(new ActionBarCallBack());
//                           gfindViewById(R.id.action_mode_bar).setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(CompactHeaderDrawerActivity.this, R.attr.colorPrimary, R.color.material_drawer_primary));
                        }

                        if (drawerItem instanceof Nameable) {
//                            toolbar.setTitle(((Nameable) drawerItem).getName().getText(ActivityDrawerBase.this));
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
