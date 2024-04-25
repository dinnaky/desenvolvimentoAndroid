package devandroid.arthursilvio.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.arthursilvio.applistacurso.R;
import devandroid.arthursilvio.applistacurso.model.Person;

public class MainActivity extends AppCompatActivity {

 //Declarando Classes
    EditText editFirstName;
    EditText editSurname;
    EditText editCurse;
    EditText editTell;

    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;


    Person outerPerson;
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

        //MÉTODO SETTS
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

// ASSOCIAR JAVA AO LAYOUT USANDO FINDVIEWBYID
        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editCurse = findViewById(R.id.editCurse);
        editTell = findViewById(R.id.editTell);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        editFirstName.setText(outerPerson.getFirstName());
        editSurname.setText(outerPerson.getSurname());
        editCurse.setText(outerPerson.getCurse());
        editTell.setText(outerPerson.getTell());




// Maneira mais fácil de concatenar
/*        Log.i("POOAndroid", "Dados adquiridos: " +person.toString());
        Log.i("POOAndroid", "Dados adquiridos: " +outerPerson.toString());*/
// MÉTODO GETTS (concatenação)
/*
        String personalData;

        personalData = "Primeiro Nome: ";
        personalData += person.getFirstName();
        personalData += ".";
        personalData += " Sobrenome: ";
        personalData += person.getSurname();
        personalData += ".";
        personalData += " Curso: ";
        personalData += person.getCurse();
        personalData += ".";
        personalData += " Telefone: ";
        personalData += person.getTell();
        personalData += ".";
*/

    }
}