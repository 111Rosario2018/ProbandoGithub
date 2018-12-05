package a111milrosario.proyectocomunaalvear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //hay que anexar los elementos que están en la XML en java, para eso hay que crear objetos del mismo objeto que en el XML
    EditText edt_nombre;
    EditText edt_apellido;
    EditText edt_edad;
    EditText edt_pass;
    Button btn_login;
    Button btn_compartir;
    Button btn_tomarfoto;
    TextView txt_mostrarnombre;
    TextView txt_mostrarapellido;
    TextView txt_mostraredad;
    TextView txt_mostrarpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre=findViewById(R.id.edt_nombre);//estoy creando un objeto de tipo EditText que lo relaciono con el objeto EditText del XML.
        edt_apellido=findViewById(R.id.edt_apellido);//les pongo el mismo nombre por comodidad
        edt_edad=findViewById(R.id.edt_edad);//fijensé que con esto (R.id.edt_edad) estoy referenciando el edt_edad del MainActivity.java con el edt_edad del activity_main.xml
        edt_pass=findViewById(R.id.edt_pass);
        btn_login=findViewById(R.id.btn_login);//se hace lo mismo con los botones
        btn_compartir=findViewById(R.id.btn_compartir);
        btn_tomarfoto=findViewById(R.id.btn_tomarfoto);
        txt_mostrarnombre=findViewById(R.id.txt_mostrarnombre);
        txt_mostrarapellido=findViewById(R.id.txt_mostrarapellido);
        txt_mostraredad=findViewById(R.id.txt_mostraredad);
        txt_mostrarpass=findViewById(R.id.txt_mostrarpass);
    }


    public void onClick(View view){//este método se lo asigno al boton btn_login poniendo en el xml android:onClick="onClick"

        Toast.makeText(this,"Este es el cartelito Toast",Toast.LENGTH_SHORT).show();//esto muestra un cartelito que lo van a reconocer LENGHT determina la cantidad de tiempo del cartel en pantalla
        txt_mostrarnombre.setVisibility(View.VISIBLE);
        txt_mostrarnombre.setText(edt_nombre.getText());
        txt_mostrarapellido.setText((edt_apellido.getText()));
        txt_mostraredad.setText(edt_edad.getText());
        txt_mostrarpass.setVisibility(View.VISIBLE);//primero hago visible el elemento txt_mostrarpass del xml
        txt_mostrarpass.setText(edt_pass.getText());
        btn_compartir.setVisibility(View.VISIBLE);

    }

    public void Compartir(View view){//este metodo es para poder compartir, en este caso el objeto persona, a otras aplicaciones como redes sociales o whatsapp

        //tomo los textos de los EditText y los convierto en String para instanciar el objeto persona
        String nom=edt_nombre.getText().toString();
        String ape=edt_apellido.getText().toString();
        String edad=edt_edad.getText().toString();
        String pass=edt_pass.getText().toString();

        ClasePrueba persona=new ClasePrueba(nom,ape,edad,pass);

        //con este algoritmo pueden compartir lo que quieran en otra aplicación
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,persona.toString() );
        startActivity(Intent.createChooser(intent,"Share with"));

        /*
        Si quieren especificar en qué aplicacion desean compartir, se puede hacer de esta manera
        intent.setPackage("com.facebook"); facebook en este caso
        startActivity(intent);
        supuestamente hay que pedir permisos para poder usar esto. para eso tienen que ir al AndroidManifest.xml y poner esto
        <uses-permission android:name="android.permission.INTERNET" />
        */


    }
    public void cambiarActivity(View view){//de esta manera se cambia de un activity a otro
        Intent cambiandoAct=new Intent(MainActivity.this,FotoActivity.class);//una vez creado el intent hay que poner el contexto en el que se está, en este caso Main Activity y al que se quiere ir FotoActivity
        startActivity(cambiandoAct);//empieza el activity al que se quiere ir
    }

}
