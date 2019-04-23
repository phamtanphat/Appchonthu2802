package khoapham.ptp.phamtanphat.ungdungchonthu2802;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ChonhinhActivity extends AppCompatActivity {

    TableLayout tableLayout;
    int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonhinh);
        tableLayout = findViewById(R.id.tableLayout);

        String[] mang = getResources().getStringArray(R.array.Arraythucung);
        int dong = 6;
        int cot = 3;

        for (int i = 1 ; i <= dong ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 1 ; y<= cot ; y++){
                int index = cot * (i - 1) + y ;
                ImageView imageView = new ImageView(this);
                if(index  > mang.length){
                    imageView.setImageResource(android.R.color.transparent);
                }else{
                    int idhinh = getResources().getIdentifier(mang[index - 1],"drawable",getPackageName());
                    imageView.setImageResource(idhinh);
                }
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }

    }
}
