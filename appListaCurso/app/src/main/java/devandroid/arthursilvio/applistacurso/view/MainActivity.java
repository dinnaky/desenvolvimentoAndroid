package devandroid.arthursilvio.applistacurso.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.arthursilvio.applistacurso.R;
import devandroid.arthursilvio.applistacurso.controller.PersonController;
import devandroid.arthursilvio.applistacurso.model.Person;


// Declaring variables
public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    PersonController controller;
    EditText editFirstName;
    EditText editSurname;
    EditText editCurse;
    EditText editTell;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;
    Person person;

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
      
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();
        controller = new PersonController();
        //SETTS
        person = new Person();
        person.setFirstName("Arthur");
        person.setSurname("Vitor");
        person.setCurse("A.D.S");
        person.setTell("(44)99999-9999");


// ASSOCIATE JAVA WITH THE LAYOUT USING FINDVIEWBYID
        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editCurse = findViewById(R.id.editCurse);
        editTell = findViewById(R.id.editTell);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        editFirstName.setText(person.getFirstName());
        editSurname.setText(person.getSurname());
        editCurse.setText(person.getCurse());
        editTell.setText(person.getTell());

// HERE I ADDED A CLICK LISTENER ON THE CLEAR BUTTON.
        buttonClean.setOnClickListener(v -> {
            editFirstName.setText("");
            editSurname.setText("");
            editCurse.setText("");
            editTell.setText("");
        });

// HERE I ADDED A CLICK LISTENER ON THE FINISH BUTTON.
        buttonFinish.setOnClickListener(v -> {
            //TOAST = DISPLAY A MESSAGE ON THE SCREEN
            Toast.makeText(MainActivity.this, "Sucesso ao mandar as informações", Toast.LENGTH_LONG).show();
            //SHUTDOWN IN THE APP
            finish();
        });

// HERE I ADDED A LISTENER BY CLICKING THE SAVE BUTTON.
        buttonSave.setOnClickListener(v -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setCurse(editCurse.getText().toString());
            person.setTell(editTell.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            editFirstName.setText("");
            editSurname.setText("");
            editCurse.setText("");
            editTell.setText("");
          
            listaVip.putString("primeiroNome", person.getFirstName());
            listaVip.putString("surname", person.getSurname());
            listaVip.putString("curse", person.getCurse());
            listaVip.putString("tell", person.getTell());
            listaVip.apply();
            controller = new PersonController();
            controller.save(person);
        });
    }
}