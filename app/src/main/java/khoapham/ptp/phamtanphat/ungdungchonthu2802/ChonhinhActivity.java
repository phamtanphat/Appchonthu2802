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
                ImageView imageView = new ImageView(this);
                Log.d("BBB", cot * (i - 1) + y - 1 + "" );
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }

    }
}
