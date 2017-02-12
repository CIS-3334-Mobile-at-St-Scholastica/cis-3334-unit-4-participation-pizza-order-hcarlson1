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
        String orderDescription;
        String topping = spinToppings.getSelectedItem().toString();
        String size;
        String toppingName;
        boolean xCheese = false;

        if (chkbxDelivery.isChecked()){pizzaOrderSystem.setDelivery(true); }

        if (topping.equalsIgnoreCase("Cheese")) {
            if (rbSmall.isChecked())
            {
                size = "small";
                toppingName = "cheese";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else if (rbMedium.isChecked()){
                size = "medium";
                toppingName = "cheese";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else {
                size = "Large";
                toppingName = "cheese";
                if (chkbxCheese.isChecked())
                {
                    xCheese = true;
                }
            }
        } else if (topping.equalsIgnoreCase("Pepperoni")) {
            if (rbSmall.isChecked())
            {
                size = "small";
                toppingName = "Pepperoni";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else if (rbMedium.isChecked()){
                size = "medium";
                toppingName = "Pepperoni";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else {
                size = "Large";
                toppingName = "Pepperoni";
                if (chkbxCheese.isChecked())
                {
                    xCheese = true;
                }
            }

        } else if (topping.equalsIgnoreCase("Sausage")) {
            if (rbSmall.isChecked())
            {
                size = "small";
                toppingName = "Sausage";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else if (rbMedium.isChecked()){
                size = "medium";
                toppingName = "Sausage";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else {
                size = "Large";
                toppingName = "Sausage";
                if (chkbxCheese.isChecked())
                {
                    xCheese = true;
                }
            }
        } else {
            if (rbSmall.isChecked())
            {
                size = "small";
                toppingName = "Hawaiian";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else if (rbMedium.isChecked()){
                size = "medium";
                toppingName = "Hawaiian";
                if(chkbxCheese.isChecked())
                {
                    xCheese = true;
                }

            } else {
                size = "Large";
                toppingName = "Hawaiian";
                if (chkbxCheese.isChecked()) {
                    xCheese = true;
                }
            }
        }

        orderDescription = pizzaOrderSystem.OrderPizza(toppingName,size,xCheese);

        //display a pop up message for a long period of time
        Toast.makeText(getApplicationContext(), "You have ordered a "+orderDescription , Toast.LENGTH_LONG).show();
        txtTotal.setText("Total Due: " + pizzaOrderSystem.getTotalBill().toString());
    }
    public void onClickNewOrder(View view) {
        pizzaOrderSystem.setNewOrder(true);
        rbSmall.setChecked(false);
        rbMedium.setChecked(false);
        rbLarge.setChecked(false);
        chkbxCheese.setChecked(false);
        chkbxDelivery.setChecked(false);

        Toast.makeText(getApplicationContext(), "Ready for a new order", Toast.LENGTH_LONG).show();
        txtTotal.setText("Total Due: " + pizzaOrderSystem.getTotalBill().toString());

    }
}
