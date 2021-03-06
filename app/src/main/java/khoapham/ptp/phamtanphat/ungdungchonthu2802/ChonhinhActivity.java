package khoapham.ptp.phamtanphat.ungdungchonthu2802;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Observer;

public class ChonhinhActivity extends AppCompatActivity {

    TableLayout tableLayout;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonhinh);
        tableLayout = findViewById(R.id.tableLayout);

        final String[] mang = getResources().getStringArray(R.array.Arraythucung);
        Collections.shuffle(Arrays.asList(mang));
        int dong = 6;
        int cot = 3;

        for (int i = 1 ; i <= dong ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 1 ; y<= cot ; y++){
                final int index = cot * (i - 1) + y ;
                ImageView imageView = new ImageView(this);
                if(index  > mang.length){
                    imageView.setImageResource(android.R.color.transparent);
                }else{
                    final int idhinh = getResources().getIdentifier(mang[index - 1],"drawable",getPackageName());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(300 , 300);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(idhinh);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ChonhinhActivity.this,MainActivity.class);
                            intent.putExtra("idhinh",idhinh);
                            setResult(RESULT_OK,intent);
                            finish();
                        }
                    });
                }

                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }
    }

}
