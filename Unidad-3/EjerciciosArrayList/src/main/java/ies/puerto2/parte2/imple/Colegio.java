package ies.puerto2.parte2.imple;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Colegio {

    private String nombreColegio;
    private String direccion;
    private String ubicacion;
    private List<Aula> aulas;


    public Colegio() {
    }

    public Colegio(String nombreColegio, String direccion, String ubicacion) {
        this.nombreColegio = nombreColegio;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
    }

    public Colegio(List<Aula> aulas) {
        this.aulas = new ArrayList<>();
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Colegio{" +
                "nombreColegio='" + nombreColegio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", aulas=" + aulas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colegio colegio = (Colegio) o;
        return Objects.equals(nombreColegio, colegio.nombreColegio) && Objects.equals(direccion, colegio.direccion) && Objects.equals(ubicacion, colegio.ubicacion) && Objects.equals(aulas, colegio.aulas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreColegio, direccion, ubicacion, aulas);
    }



    public float calcularPromedioCalificacionesColegio() {
        if (aulas.isEmpty()) {
            return 0;
        }

        float sumaTotal = 0;
        for (Aula notaAulas : aulas) {
            sumaTotal += notaAulas.calcularPromedioCalificacionesAula();

        }
        return sumaTotal / aulas.size();
    }

    public float salarioMinimo() {

        float resultado = 0f;
        if(aulas.isEmpty()){
            return resultado;
        }

        for (Aula profesoresAula: aulas) {


            if(profesoresAula.getProfesor().getSalario()<resultado){
                resultado=profesoresAula.getProfesor().getSalario();
            }
        }

      return resultado;
    }

    public float salarioMaximo() {

        float resultado = 0f;
        if(aulas.isEmpty()){
            return resultado;
        }

        for (Aula profesoresAula: aulas) {


            if(profesoresAula.getProfesor().getSalario()>resultado){
                resultado=profesoresAula.getProfesor().getSalario();
            }
        }

        return resultado;
    }

    public float salarioMedio() {

        float resultado = 0f;
        float suma=0f;

        if(aulas.isEmpty()){
            return resultado;
        }

        for (Aula profesoresAula: aulas) {

            suma+=profesoresAula.getProfesor().getSalario();

        }

        return suma/aulas.size();
    }

    public int edadMediaProfesores() throws Exception {

        int suma=0;
        if(aulas.isEmpty()){
            return suma;
        }

        for (Aula edadProfesores: aulas) {

         suma+=edadProfesores.getProfesor().anios(edadProfesores.getProfesor().getFechaNacimiento());

        }

      return suma/aulas.size();
    }


}




