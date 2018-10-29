package id.ac.akakom.delvio.delvioicho96gmailcom;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.ac.akakom.delvio.delvioicho96gmailcom.adapter.AdapterMain;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewMain = (RecyclerView) findViewById(R.id.recycler_view_main);

        //  Pada contoh kali ini kita akan membuat 10 item di dalam RecyclerView
        ArrayList<Integer> listViewType = new ArrayList<>();
        listViewType.add(AdapterMain.TYPE_1);
        listViewType.add(AdapterMain.TYPE_2);
        listViewType.add(AdapterMain.TYPE_3);
        listViewType.add(AdapterMain.TYPE_2);
        listViewType.add(AdapterMain.TYPE_3);
        listViewType.add(AdapterMain.TYPE_1);
        listViewType.add(AdapterMain.TYPE_1);
        listViewType.add(AdapterMain.TYPE_3);
        listViewType.add(AdapterMain.TYPE_2);

        //  Buat objek AdapterMain untuk recyclerViewMain
        AdapterMain adapterMain = new AdapterMain(listViewType, this);  //  this adalah mengarah ke Context (MainActivity.this)

        //  Set layout manager recyclerViewMain
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(layoutManager);

        //  Set adapter recyclerViewMain
        recyclerViewMain.setAdapter(adapterMain);
    }
    //Method ini digunakan untuk menampilkan daftar menu yang sudah kita buat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }




    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah anda ingin keluar?")
                .setCancelable(false)//tidak bisa tekan tombol back
                //jika pilih yess
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                //jika pilih no
                .setNegativeButton("tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    //Menthod ini digunakan untuk menangani kejadian saat OptionMenu diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                setContentView(R.layout.item_tipe_pertama);
                break;

            case R.id.menu2:
                setContentView(R.layout.item_tipe_kedua);
                break;
            case R.id.menu3:
                setContentView(R.layout.item_tipe_ketiga);
                break;
            case R.id.menu4:
                exit();//Pergi ke method exit

        }
        return true;
    }


}

