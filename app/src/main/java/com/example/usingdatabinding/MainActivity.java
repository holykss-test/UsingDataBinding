package com.example.usingdatabinding;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeModel();

        initializeButtons();
    }

    private void initializeModel() {
        Customer customer = loadCustomerFromDb();

        EditText editName = (EditText)findViewById(R.id.editName);
        EditText editAge = (EditText)findViewById(R.id.editAge);
        CheckBox checkEarlyBird = (CheckBox)findViewById(R.id.checkEarlyBird);

        editName.setText(customer.name);
        editAge.setText("" + customer.age);
        checkEarlyBird.setChecked(customer.earlyBird);
    }

    @NonNull
    private Customer loadCustomerFromDb() {
        Customer customer = new Customer();
        customer.name = "김sj";
        customer.age = 19;
        customer.earlyBird = true;

        return customer;
    }

    private void initializeButtons() {
        Button buttonSave = (Button)findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = (EditText)findViewById(R.id.editName);
                EditText editAge = (EditText)findViewById(R.id.editAge);
                CheckBox checkEarlyBird = (CheckBox)findViewById(R.id.checkEarlyBird);

                Customer customer = new Customer();
                customer.name = editName.getText().toString();
                customer.age = Integer.parseInt(editAge.getText().toString());
                customer.earlyBird = checkEarlyBird.isChecked();

                saveCustomerToDb(customer);
            }
        });
    }

    private void saveCustomerToDb(Customer customer) {
        Toast.makeText(this, "Customer " + customer.name + " is saved!\n" + customer.toString(), Toast.LENGTH_SHORT).show();
    }


}
