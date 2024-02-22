package ies.puerto.modelo.entity.interfaces;

import java.text.ParseException;

public interface ISaludable {

    public int diasAntesCaducidad(String fechaCaducidad,String fechaEntrada) throws ParseException;
    public boolean caducado(String fechaCaducidad,String fechaEntrada) throws ParseException;
}
