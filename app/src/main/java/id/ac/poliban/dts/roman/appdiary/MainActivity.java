package id.ac.poliban.dts.roman.appdiary;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("App Diary");

        listView = findViewById(R.id.listview);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, InsertAndViewActivity.class);
            Map<String, Object> data = (Map<String, Object>) parent.getAdapter().getItem(position);
            intent.putExtra("filename", data.get("name").toString());
            Toast.makeText(this, "you click " +
                    data.get("name").toString(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Map<String, Object> data = (Map<String, Object>) parent.getAdapter().getItem(position);
            showConfirmDeleteDialog(data.get("name").toString());
            return true;
        });
    }

    private void showConfirmDeleteDialog(String name) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23)
            if(periksaIzinPenyimpanan())
                listFilesInFolder();
        else listFilesInFolder();
    }

    private boolean periksaIzinPenyimpanan() {
    }

    private void listFilesInFolder() {
    }
}
