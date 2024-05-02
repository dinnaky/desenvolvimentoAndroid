package devandroid.arthursilvio.applistacurso.view;

import android.annotation.SuppressLint;
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
public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    PersonController controller;
    EditText editFirstName;
    EditText editSurname;
    EditText editCourse;
    EditText editTell;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;
    Person person;

    @SuppressLint("MissingInflatedId")
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


        person = new Person();
        person.setFirstName(preferences.getString("firstName", ""));
        person.setSurname(preferences.getString("surname", ""));
        person.setCourse(preferences.getString("course", ""));
        person.setTell(preferences.getString("tell", ""));

        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editCourse = findViewById(R.id.editCourse);
        editTell = findViewById(R.id.editTell);

        editFirstName.setText(person.getFirstName());
        editSurname.setText(person.getSurname());
        editCourse.setText(person.getCourse());
        editTell.setText(person.getTell());

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        buttonClean.setOnClickListener(v -> {
            editFirstName.setText("");
            editSurname.setText("");
            editCourse.setText("");
            editTell.setText("");
        });

        buttonFinish.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Sucesso ao mandar as informações", Toast.LENGTH_LONG).show();
            finish();
        });

        buttonSave.setOnClickListener(v -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setCourse(editCourse.getText().toString());
            person.setTell(editTell.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            editFirstName.setText("");
            editSurname.setText("");
            editCourse.setText("");
            editTell.setText("");
          
            listaVip.putString("firstName", person.getFirstName());
            listaVip.putString("surname", person.getSurname());
            listaVip.putString("course", person.getCourse());
            listaVip.putString("tell", person.getTell());
            listaVip.apply();

            controller = new PersonController();
            controller.save(person);
        });
    }
}