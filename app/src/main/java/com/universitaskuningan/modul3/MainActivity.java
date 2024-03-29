package com.universitaskuningan.modul3;

import static android.widget.Toast.LENGTH_LONG;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdatafak = {"Fakultas Ekonomi", "Fakultas Kehutanan", "Fakultas Ilmu Komputer", "Fakultas Hukum", "Fakultas Keguruan dan Ilmu Pendidikan"};
    EditText lv;
    private String lifeCycle = "androidlifecycle";
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
                ac.addTextChangedListener(this);
                ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    public void pilihfakultas (View v) { lv = (EditText)
            findViewById(R.id.datalistview);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Data Fakultas Universitas Kuningan");
            builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) { }

    public void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start nih  nih", LENGTH_LONG).show();

    }

    public void onStop() {

        super.onStop();
        Toast.makeText(this, "Posisi lagi stop  nih", LENGTH_LONG).show();
    }

    public void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi Resume  nih", LENGTH_LONG).show();
        TextView txt1 = findViewById(R.id.txt1);
        txt1.setText("POSISI LAGI RESUME");
        Log.i(lifeCycle, "onResume() called");

    }

    public void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause  nih", LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
//        Log.i(lifeCycle, "onPause() called");
        // Ubah warna latar belakang LinearLayout
        linearLayout.setBackgroundColor(getResources().getColor(R.color.purple));
//        TextView txt1 = findViewById(R.id.txt1);
//        txt1.setText("POSISI LAGI PAUSE");
//        txt1.setTextColor(getColor(R.color.black));


    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Posisi udah hancur  nih", LENGTH_LONG).show();

    }
}