package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AddMedicineActivity extends AppCompatActivity {

    private EditText medicineName, medicinePrice, medicineExpiry;
    private Button addMedicineButton;
    private ListView medicineList;
    private ArrayList<String> medicines;
    private ArrayAdapter<String> medicineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        medicineName = findViewById(R.id.medicineName);
        medicinePrice = findViewById(R.id.medicinePrice);
        medicineExpiry = findViewById(R.id.medicineExpiry);
        addMedicineButton = findViewById(R.id.addMedicineButton);
        medicineList = findViewById(R.id.medicineList);

        medicines = new ArrayList<>();
        medicineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicines);
        medicineList.setAdapter(medicineAdapter);

        // Добавление лекарства в список
        addMedicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = medicineName.getText().toString();
                String price = medicinePrice.getText().toString();
                String expiry = medicineExpiry.getText().toString();

                if (!name.isEmpty() && !price.isEmpty() && !expiry.isEmpty()) {
                    String medicine = "Название: " + name + ", Цена: " + price + ", Годен до: " + expiry;
                    medicines.add(medicine);
                    medicineAdapter.notifyDataSetChanged();
                    medicineName.setText("");
                    medicinePrice.setText("");
                    medicineExpiry.setText("");
                }
            }
        });
    }
}