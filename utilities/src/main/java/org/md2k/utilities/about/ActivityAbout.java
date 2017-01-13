package org.md2k.utilities.about;

import android.graphics.Color;

//import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
//import com.danielstone.materialaboutlibrary.model.MaterialAboutActionItem;
//import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
//import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
//import com.danielstone.materialaboutlibrary.model.MaterialAboutTitleItem;
//import com.mikepenz.fontawesome_typeface_library.FontAwesome;
//import com.mikepenz.google_material_typeface_library.GoogleMaterial;
//import com.mikepenz.iconics.IconicsDrawable;
//
//import org.md2k.utilities.R;
//import org.md2k.utilities.icon.Icon;
//import org.md2k.utilities.info.PackageInfo;
//
//public class ActivityAbout extends MaterialAboutActivity {
//
//    @Override
//    protected MaterialAboutList getMaterialAboutList() {
//
//        MaterialAboutCard.Builder appCardBuilder = new MaterialAboutCard.Builder();
//
//        // Add items to card
//
//        appCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
//                .text(PackageInfo.getName(this))
//                .icon(PackageInfo.getLauncherIcon(this))
//                .build());
//        IconicsDrawable icon = new IconicsDrawable(this)
//                .icon(GoogleMaterial.Icon.gmd_person)
//                .color(Color.BLACK)
//                .sizePx(12);
//        appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("Description")
//                .subText(PackageInfo.getDescription(this))
//                .icon(icon)
////                .icon(Icon.get(this, Icon.Id.DESCRIPTION, Color.DKGRAY, Icon.Size.EXTRA_SMALL))
//                .build());
//
//        appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("Version: "+PackageInfo.getVersionName(this)+" ("+PackageInfo.getVersionCode(this)+")")
////                .subText(PackageInfo.getVersionName(this)+" ("+PackageInfo.getVersionCode(this)+")")
//                .icon(Icon.get(this, Icon.Id.ABOUT, Color.DKGRAY, Icon.Size.EXTRA_SMALL))
//                .build());
//        appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("Licenses")
//                .icon(Icon.get(this, Icon.Id.COPYRIGHT, Color.DKGRAY, Icon.Size.EXTRA_SMALL))
//                .setOnClickListener(new MaterialAboutActionItem.OnClickListener() {
//                    @Override
//                    public void onClick() {
////                        Toast.makeText(ExampleMaterialAboutActivity.this, "Licenses Tapped", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .build());
//
//        MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
//        authorCardBuilder.title("Author");
//
//        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("Syed Monowar Hossain")
//                .subText("United Kingdom")
//                .icon(Icon.get(this, Icon.Id.USER,getResources().getColor(R.color.teal_500), Icon.Size.EXTRA_SMALL))
//                .build());
//
//
//        MaterialAboutCard.Builder supportCardBuilder = new MaterialAboutCard.Builder();
//        supportCardBuilder.title("Support Development");
//        supportCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("Report Bugs")
//                .subText("Report bugs or request new features.")
//                .icon(Icon.get(this, Icon.Id.BUG, Color.RED,Icon.Size.EXTRA_SMALL))
//                .setOnClickListener(new MaterialAboutActionItem.OnClickListener() {
//                    @Override
//                    public void onClick() {
////                        Toast.makeText(ExampleMaterialAboutActivity.this, "Bug report tapped", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .build());
//        supportCardBuilder.addItem(new MaterialAboutActionItem.Builder()
//                .text("GitHub Link")
//                .icon(Icon.get(this, Icon.Id.GITHUB,Color.RED, Icon.Size.EXTRA_SMALL))
//                .setOnClickListener(new MaterialAboutActionItem.OnClickListener() {
//                    @Override
//                    public void onClick() {
////                        Intent i = new Intent(Intent.ACTION_VIEW);
////                        i.setData(Uri.parse("https://github.com/daniel-stoneuk"));
////                        startActivity(i);
//                    }
//                })
//                .build());
//
//        return new MaterialAboutList(appCardBuilder.build(), authorCardBuilder.build(), supportCardBuilder.build());
//    }
//
//    @Override
//    protected CharSequence getActivityTitle() {
//        return getString(R.string.mal_title_about);
//    }
//}
