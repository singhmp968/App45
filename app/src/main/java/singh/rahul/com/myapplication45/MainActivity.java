package singh.rahul.com.myapplication45;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOpenUdemy;
    Button btnOpenGoogle;
    Button btnCall;
    Button btnAccessDailCall;

    private static final int CALL = 1;
    private static  String[] PERMISSION = {
            Manifest.permission.CALL_PHONE
    };

    public static void verifyThatWECallSomeOne(Activity activity){
        int permission = ActivityCompat.checkSelfPermission(activity,Manifest.permission.CALL_PHONE);
        if (permission!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSION,
                    CALL
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    verifyThatWECallSomeOne(MainActivity.this);

    btnOpenUdemy = (Button) findViewById(R.id.LetsOpenUdemy);
    btnOpenGoogle = (Button)findViewById(R.id.LetsOpenGoogle);
    btnAccessDailCall =(Button) findViewById(R.id.LetsAccessDeal);
    btnCall =(Button) findViewById(R.id.LetsCallSomeOne);

    btnOpenUdemy.setOnClickListener(MainActivity.this);
    btnAccessDailCall.setOnClickListener(MainActivity.this);
    btnOpenGoogle.setOnClickListener(MainActivity.this);
    btnCall.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.LetsOpenUdemy:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent);
                break;

            case R.id.LetsOpenGoogle:

            Intent intent2 = new Intent(Intent.ACTION_WEB_SEARCH);
            intent2.setData(Uri.parse("http://google.com"));
            startActivity(intent2);
            break;
            case R.id.LetsAccessDeal:
Intent intent4 = new Intent(Intent.ACTION_DIAL);
startActivity(intent4);

                break;
            case R.id.LetsCallSomeOne:
if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
{
    ActivityCompat.requestPermissions(MainActivity.this,new String[] { Manifest.permission.CALL_PHONE },CALL);

} else
            {
                Intent intent3 = new Intent(Intent.ACTION_CALL);
                intent3.setData(Uri.parse("tel:344545465653232"));
                startActivity(intent3);
            }
                break;
        }
    }
}
