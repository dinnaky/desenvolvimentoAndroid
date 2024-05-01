package devandroid.arthursilvio.applistacurso.view;

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

    //Declarando Classes

    PersonController controller;

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

        controller = new PersonController();

        //MÉTODO SETTS

        person = new Person();
//        person.setFirstName("Arthur");
//        person.setSurname("Vitor");
//        person.setCurse("A.D.S");
//        person.setTell("(44)99999-9999");
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
// AQUI ADICIONEI UM LISTENER DE CLICK NO BOTÃO LIMPAR.
        buttonClean.setOnClickListener(v -> {
            editFirstName.setText("");
            editSurname.setText("");
            editCurse.setText("");
            editTell.setText("");
        });
// AQUI ADICIONEI UM LISTENER DE CLICK NO BOTÃO FINALIZAR.
        buttonFinish.setOnClickListener(v -> {
            //TOAST = EXIBI UMA MENSAGEM NA TELA
            Toast.makeText(MainActivity.this, "Sucesso ao mandar as informações", Toast.LENGTH_LONG).show();
            //SHOTDOWN NO APLICATIVO
            finish();
        });
// AQUI ADICIONEI UM LISTENER DE CLICK NO BOTÃO SALVAR.
        buttonSave.setOnClickListener(v -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setCurse(editCurse.getText().toString());
            person.setTell(editTell.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo com sucesso " +person.toString(), Toast.LENGTH_LONG).show();
            editFirstName.setText("");
            editSurname.setText("");
            editCurse.setText("");
            editTell.setText("");

            controller.save(person);
        });

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