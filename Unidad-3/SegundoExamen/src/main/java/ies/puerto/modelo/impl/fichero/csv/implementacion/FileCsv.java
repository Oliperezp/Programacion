package ies.puerto.modelo.impl.fichero.csv.implementacion;

import ies.puerto.modelo.impl.abstractas.Producto;
import ies.puerto.modelo.impl.Alimento;
import ies.puerto.modelo.impl.Aparato;
import ies.puerto.modelo.impl.CuidadoPersonal;
import ies.puerto.modelo.impl.fichero.interfaces.IFileInterface;
import ies.puerto.modelo.impl.fichero.abstractas.FicheroAbstract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsv extends FicheroAbstract implements IFileInterface {

    public FileCsv() {
        FICHERO_ALIMENTOS = "src/main/resources/alimentos.csv";
        FICHERO_APARATOS = "src/main/resources/aparatos.csv";
        FICHERO_SOUVENIRS = "src/main/resources/souvenirs.csv";
        FICHERO_CUIDADO_PERSONAL = "src/main/resources/cuidado-personal.csv";

    }

    public List<Producto> obtenerAlimentos(){
        return lectura(FICHERO_ALIMENTOS,"alimento");
    }

    public List<Producto> obtenerAparatos(){
        return lectura(FICHERO_APARATOS,"aparato");
    }
    public List<Producto> obtenerSouvenirs(){
        return lectura(FICHERO_SOUVENIRS,"souvernir");
    }

    public List<Producto> obtenerCuidados(){
        return lectura(FICHERO_CUIDADO_PERSONAL,"cuidado");
    }

    @Override
    public List<Producto> lectura(String path, String articulo) {
        List<Producto> productos = new ArrayList<>();
        if (existeFichero(path)) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linea;
                int i = 0;
                while ((linea = br.readLine()) != null) {
                    if (i>0) {
                        String[] arrayElemento = linea.split(",");
                        switch (articulo) {
                            case "alimento":
                                productos.add(splitToAlimento(arrayElemento));
                                break;
                            case "cuidado":
                                productos.add(splitToCuidadoPersonal(arrayElemento));
                                break;
                            default:
                               productos.add(splitToDefault(arrayElemento)) ;
                                break;
                        }
                    }
                    i++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El fichero no existe o no es un fichero válido.");
        }
        return productos;
    }

    @Override
    public boolean escritura(String path, String contenido) {
        return almacenarEnFichero(path, contenido);
    }

    @Override
    public boolean actualizar(String path, Producto producto, String contenido) {
        return false;
    }



    public boolean borrar(String path, Producto producto) {
        return borrarProducto(path,producto);
    }


    private Alimento splitToAlimento(String[] splitArray){
        Alimento alimento = new Alimento(splitArray[0],
                Float.parseFloat(splitArray[1]),splitArray[2],
                splitArray[3], splitArray[4]);
        return alimento;
    }
    private Aparato splitToDefault(String[] splitArray) {
        Aparato aparato = new Aparato(splitArray[0],
                Float.parseFloat(splitArray[1]),splitArray[2], splitArray[3]);
        return aparato;
    }
    private CuidadoPersonal splitToCuidadoPersonal(String[] splitArray) {
        CuidadoPersonal cuidadoPersonal = new CuidadoPersonal(splitArray[0],
                Float.parseFloat(splitArray[1]), splitArray[2],
                splitArray[3], Integer.parseInt(splitArray[4]));
        return cuidadoPersonal;
    }
}
