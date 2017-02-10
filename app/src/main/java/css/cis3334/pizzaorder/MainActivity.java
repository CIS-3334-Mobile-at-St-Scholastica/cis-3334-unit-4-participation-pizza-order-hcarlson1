package css.cis3334.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements updateViewInterface {

    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    CheckBox chkbxCheese;
    CheckBox chkbxDelivery;
    Spinner spinToppings;
    TextView txtTotal;
    TextView txtStatus;
    PizzaOrderInterface pizzaOrderSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);

        spinToppings = (Spinner) findViewById(R.id.spinnerToppings);

        chkbxCheese = (CheckBox) findViewById(R.id.checkBoxCheese);
        chkbxDelivery = (CheckBox) findViewById(R.id.checkBoxDeluvery);

        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);

        pizzaOrderSystem = new PizzaOrder(this); //constructor for PizzaOrder. This refers to the entire object of pizzaOrderSystem
    }

    @Override
    public void updateView(String orderStatus) {
        txtStatus.setText("Order Status" + orderStatus);
    }

    public void onClickOrder(View view) {
        String orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni","Large", false);
        Double totalPrice = 0.0;
        String topping = spinToppings.getSelectedItem().toString();

        if (topping.equalsIgnoreCase("Cheese")) {
            if (rbSmall.isChecked())
            {
                orderDescription = pizzaOrderSystem.OrderPizza("Cheese","Small", false);
                totalPrice = pizzaOrderSystem.getSmallPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Cheese","Small", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else if (rbMedium.isChecked()){
                orderDescription = pizzaOrderSystem.OrderPizza("Cheese","Medium", false);
                totalPrice = pizzaOrderSystem.getMediumPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Cheese","Medium", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else {
                orderDescription = pizzaOrderSystem.OrderPizza("Cheese", "Large", false);
                totalPrice = pizzaOrderSystem.getLargePrize();
                if (chkbxCheese.isChecked()) {
                    orderDescription = pizzaOrderSystem.OrderPizza("Cheese", "Large", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }
            }
        } else if (topping.equalsIgnoreCase("Pepperoni")) {
            if (rbSmall.isChecked())
            {
                orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni","Small", false);
                totalPrice = pizzaOrderSystem.getSmallPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni","Small", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else if (rbMedium.isChecked()){
                orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni","Medium", false);
                totalPrice = pizzaOrderSystem.getMediumPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni","Medium", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else {
                orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni", "Large", false);
                totalPrice = pizzaOrderSystem.getLargePrize();
                if (chkbxCheese.isChecked()) {
                    orderDescription = pizzaOrderSystem.OrderPizza("Pepperoni", "Large", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }
            }

        } else if (topping.equalsIgnoreCase("Sausage")) {
            if (rbSmall.isChecked())
            {
                orderDescription = pizzaOrderSystem.OrderPizza("Sausage","Small", false);
                totalPrice = pizzaOrderSystem.getSmallPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Sausage","Small", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else if (rbMedium.isChecked()){
                orderDescription = pizzaOrderSystem.OrderPizza("Sausage","Medium", false);
                totalPrice = pizzaOrderSystem.getMediumPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Sausage","Medium", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else {
                orderDescription = pizzaOrderSystem.OrderPizza("Sausage", "Large", false);
                totalPrice = pizzaOrderSystem.getLargePrize();
                if (chkbxCheese.isChecked()) {
                    orderDescription = pizzaOrderSystem.OrderPizza("Sausage", "Large", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }
            }
        } else {
            if (rbSmall.isChecked())
            {
                orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian","Small", false);
                totalPrice = pizzaOrderSystem.getSmallPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian","Small", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else if (rbMedium.isChecked()){
                orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian","Medium", false);
                totalPrice = pizzaOrderSystem.getMediumPrice();
                if(chkbxCheese.isChecked())
                {
                    orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian","Medium", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }

            } else {
                orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian", "Large", false);
                totalPrice = pizzaOrderSystem.getLargePrize();
                if (chkbxCheese.isChecked()) {
                    orderDescription = pizzaOrderSystem.OrderPizza("Hawaiian", "Large", true);
                    totalPrice = totalPrice + pizzaOrderSystem.getExtraCheesePrice();
                }
            }


        }

        //display a pop up message for a long period of time
        Toast.makeText(getApplicationContext(), "You have ordered a "+orderDescription , Toast.LENGTH_LONG).show();
        txtTotal.setText("Total Due: " + pizzaOrderSystem.getTotalBill().toString());
    }
}
