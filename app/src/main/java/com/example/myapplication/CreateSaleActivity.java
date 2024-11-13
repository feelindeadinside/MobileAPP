package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CreateSaleActivity extends AppCompatActivity {

    private EditText customerName, saleQuantity, salePrice, saleDate;
    private Button addSaleButton;
    private ListView saleList;
    private ArrayList<String> sales;
    private ArrayAdapter<String> saleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sale);

        customerName = findViewById(R.id.customerName);
        saleQuantity = findViewById(R.id.saleQuantity);
        salePrice = findViewById(R.id.salePrice);
        saleDate = findViewById(R.id.saleDate);
        addSaleButton = findViewById(R.id.addSaleButton);
        saleList = findViewById(R.id.saleList);

        sales = new ArrayList<>();
        saleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sales);
        saleList.setAdapter(saleAdapter);

        // Добавление продажи в список
        addSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = customerName.getText().toString();
                String quantity = saleQuantity.getText().toString();
                String price = salePrice.getText().toString();
                String date = saleDate.getText().toString();

                if (!name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !date.isEmpty()) {
                    String sale = "Покупатель: " + name + ", Количество: " + quantity + ", Цена: " + price + ", Дата: " + date;
                    sales.add(sale);
                    saleAdapter.notifyDataSetChanged();
                    customerName.setText("");
                    saleQuantity.setText("");
                    salePrice.setText("");
                    saleDate.setText("");
                }
            }
        });
    }
}