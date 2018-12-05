package a111milrosario.proyectocomunaalvear;

public class ClasePrueba {

    String nom,apellido,edad,pass;

    ClasePrueba(String nom,String apellido,String edad,String pass){

        this.nom=nom;
        this.apellido=apellido;
        this.edad=edad;
        this.pass=pass;

    }

    @Override
    public String toString() {
        return nom+" "+apellido+" "+edad+" "+pass;
    }
}
