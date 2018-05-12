package com.example.android.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity=0;
    public void submitOrder(View view) {
        EditText nameField=(EditText)findViewById(R.id.name_field);
                String name=nameField.getText().toString();
        Log.v("MainActivity","Name: "+ name);

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        Log.v("MainActivity","Has whipped cream:" + hasWhippedCream);
        int price = calculatePrice();
        String priceMassege=createOrderSummary(name,price,hasWhippedCream);
        displayMessage(priceMassege);

    }

    private int calculatePrice(){return quantity*5;}

    private String createOrderSummary(String name,int price,boolean addWhippedCream){
        String priceMessage ="Name: "+ name;
        priceMessage +="\nAdd whipped cream?" + addWhippedCream;
        priceMessage +="\nQunatity:"+quantity;
        priceMessage +="\nTotal: $" +price;
        priceMessage +="\nThank you!";

        return priceMessage;
    }

    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity==0){
            display(quantity);
        }
        else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.zro);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}