package global;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Global {

    public static void changeFragment(Fragment first , Fragment destination , Activity activity ,  Context context){

    }


    public static void  toast( Context context , String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
