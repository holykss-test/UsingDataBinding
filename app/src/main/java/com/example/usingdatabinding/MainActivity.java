package com.example.usingdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.usingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initializeModel();

        initializeButtons();
    }

    private void initializeModel() {
        Customer customer = loadCustomerFromDb();
        b.setModel(customer);
    }

    @NonNull
    private Customer loadCustomerFromDb() {
        Customer customer = new Customer();
        customer.name.set("김sj");
        customer.age = 19;
        customer.earlyBird = true;

        return customer;
    }

    private void initializeButtons() {
        b.setPresenter(new DbActions() {
            @Override
            public void save(/*Customer customer*/) {
                Customer customer = new Customer();
                customer.name.set(b.editName.getText().toString());
                customer.age = Integer.parseInt(b.editAge.getText().toString());
                customer.earlyBird = b.checkEarlyBird.isChecked();

                saveCustomerToDb(customer);
            }
        });

        b.buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.getModel().name.set("TEST NAME");
            }
        });
    }

    private void saveCustomerToDb(Customer customer) {
        Toast.makeText(this, "Customer " + customer.name.get() + " is saved!\n" + customer.toString(), Toast.LENGTH_SHORT).show();
    }


}
