package org.md2k.utilities.UI;

import android.content.Context;
import android.content.Intent;

/**
 * Created by smh on 6/29/2015.
 */
public class UIShow {

    public static void ErrorDialog(Context context, String title,String message){
        if(context==null) return;
        Intent intent=new Intent(context,ActivityError.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public static void InfoDialog(Context context, String title,String message){
        if(context==null) return;
        Intent intent=new Intent(context,ActivityError.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
