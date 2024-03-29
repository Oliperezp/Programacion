package ies.puerto.modelo.impl;

import ies.puerto.modelo.impl.abstractas.Producto;

public class Souvenir extends Producto {


    public Souvenir(){}

    public Souvenir(String nombre, float precio, String fechaEntrada, String id) {
        super(nombre, precio, fechaEntrada, id);
    }

    @Override
    public float precioMaximo() {
        return getPrecio()*1.3f;
    }

    @Override
    public int cantidadDisponible() {
        return 5;
    }
}
