package khoapham.ptp.phamtanphat.ungdungchonthu2802;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinhGoc,imgHinhChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgHinhChon = findViewById(R.id.imageviewHinhchon);
        imgHinhGoc = findViewById(R.id.imageviewHinhgoc);

        String[] mang = getResources().getStringArray(R.array.Arraythucung);
        int hinh = getResources().getIdentifier(mang[0],"drawable",getPackageName());
        imgHinhGoc.setImageResource(hinh);
    }
}
