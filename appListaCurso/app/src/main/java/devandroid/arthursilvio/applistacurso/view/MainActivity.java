package devandroid.arthursilvio.applistacurso.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.arthursilvio.applistacurso.R;
import devandroid.arthursilvio.applistacurso.model.Person;
import devandroid.arthursilvio.applistacurso.model.Products;

public class MainActivity extends AppCompatActivity {

    Products products;

    Person person;
    Person outerPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        person = new Person();
        person.setFirstName("Arthur");
        person.setSurname("Vitor");
        person.setCurse("A.D.S");
        person.setTell("(44)99999-9999");

        outerPerson = new Person();
        outerPerson.setFirstName("Lucas");
        outerPerson.setSurname("Wills");
        outerPerson.setCurse("Agro");
        outerPerson.setTell("(11)11111-1111");

        products = new Products();
        products.setNameProduct("Maça");
        products.setPrice(14);
        products.setBrand("Natureza");

    }
}