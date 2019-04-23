package khoapham.ptp.phamtanphat.ungdungchonthu2802;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinhGoc,imgHinhChon;
    int hinhgoc = 0;
    int Request_Code = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinhChon = findViewById(R.id.imageviewHinhchon);
        imgHinhGoc = findViewById(R.id.imageviewHinhgoc);


        getRandomImage();
        imgHinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChonhinhActivity.class);
                startActivityForResult(intent , Request_Code);
            }
        });
    }

    private void getRandomImage() {
        String[] mang = getResources().getStringArray(R.array.Arraythucung);
        Collections.shuffle(Arrays.asList(mang));
        hinhgoc = getResources().getIdentifier(mang[0],"drawable",getPackageName());
        imgHinhGoc.setImageResource(hinhgoc);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Request_Code && resultCode == RESULT_OK && data != null){
//            int idhinh = (int) data.getExtras().get("idhinh"); lay du lieu dang bundle
            int idhinh = data.getIntExtra("idhinh",-1);
            imgHinhChon.setImageResource(idhinh);
            if (idhinh == hinhgoc){
                Toast.makeText(this, "Chinh xac", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getRandomImage();
                    }
                },2000);
            }else{
                Toast.makeText(this, "Sai roi!!", Toast.LENGTH_SHORT).show();
            }
//            Log.d("BBB" , idhinh + "");
        }
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Thua roi!!", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
