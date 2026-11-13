package com.example.daa;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    CheckBox checkBox;
    Spinner spinner;
    Button button;
    ListView listView;
    ArrayAdapter<Wolne> arrayAdapter;
    ArrayList<Wolne> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        datePicker = findViewById(R.id.datePicker);
        checkBox = findViewById(R.id.checkBox);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
listView.setAdapter(arrayAdapter);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String opis = editText.getText().toString();
                        Integer rok = datePicker.getYear();
                        Integer miesiac = datePicker.getMonth();
                        Integer dzien = datePicker.getDayOfMonth();
                        if(!checkBox.isChecked()){
                            spinner = null;
                        }else{
                            String swieto = spinner.getSelectedItem().toString();

                        }


                        arrayList.add(new Wolne(opis, checkBox.isChecked(),rok+":"+miesiac+":"+dzien,swieto));
arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                        if(!checkBox.isChecked()){
                            spinner.setVisibility(View.INVISIBLE);
                        }else{
                            spinner.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        return false;

                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                    }
                }
        );





    }
}