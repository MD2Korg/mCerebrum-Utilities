package org.md2k.utilities.Report;

/**
 * Created by smhssain on 4/27/2015.
 */
public class Log {
    public static final boolean DEBUG=true;
    public static void d(String TAG,String logMessage){
        if(DEBUG) android.util.Log.d("[MD2K]"+TAG,logMessage);
    }
    public static void w(String TAG,String logMessage){
        android.util.Log.w("[MD2K]"+TAG,logMessage);
    }
    public static void e(String TAG,String logMessage){
        android.util.Log.e("[MD2K]"+TAG,logMessage);
    }

}
