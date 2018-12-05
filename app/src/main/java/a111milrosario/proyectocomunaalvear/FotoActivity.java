package a111milrosario.proyectocomunaalvear;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView img_imagenfoto;
    Button btn_sacarfoto;
    Bitmap mapadebits;//esto es un mapa de bits, esto es para usar imagenes, en este caso va a ser una foto

    Intent intentfoto;

    final static int cons =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        chequearpermisoscamara();//chequeamos si se tienen permisos para usar la cámara
        img_imagenfoto=findViewById(R.id.img_imagenfoto);
        btn_sacarfoto=findViewById(R.id.btn_sacarfoto);
    }


    private void chequearpermisoscamara() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para la camara");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 225);
        } else {
            Log.i("Mensaje", "Tienes permiso para usar la camara.");
        }
    }

    public void sacarfoto(View view){

        int id;
        id=view.getId();
        switch(id){
            case R.id.btn_sacarfoto:
                intentfoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentfoto,cons);
            break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//en este método lo que sucede es que la imagen que obtenida de la camara se asigna al ImageView que creamos en el XML
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK){
            Bundle  ext=data.getExtras();
            mapadebits=(Bitmap)ext.get("data");
            img_imagenfoto.setImageBitmap(mapadebits);//al imageview se le asigna un archivo de imagen de tipo Bitmap o mapadebits
        }

    }



    //Aclaro que el algoritmo para usar la camara de fotos lo saqué de esta pagina:  https://www.androfast.com/2017/08/como-utilizar-la-camara-del-celular-en.html
}
