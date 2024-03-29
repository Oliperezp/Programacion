package ies.puerto.app;

import ies.puerto.implementacion.*;

import java.util.Scanner;

public class AppTienda {


    static Tienda tienda;

    public static void main(String[] args) {

        tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("#################");
            System.out.println("MENU DE LA TIENDA");
            System.out.println("#################");


            System.out.println("1.Añadir producto");
            System.out.println("2.Mostrar producto");
            System.out.println("3.Eliminar Producto");
            System.out.println("4.Modificar Producto");
            System.out.println("5.Salir de la tienda");
            System.out.println();

            System.out.println("Elija su opcion: ");
            opcion = sc.nextInt();


            switch (opcion) {

                case 1:
                    addProducto();
                    break;
                case 2:
                    mostrarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    modificarProducto();
                    break;
                case 5:
                    opcion=5;
                    System.out.println("Hasta luego....");
                    break;
                default:
                    System.out.println("No es una opcion valida");
                    break;

            }


        } while (opcion != 5);


    }

    public static void menu() {


        System.out.println("¿ Que tipo de Producto?: ");

        System.out.println("1.Alimento");
        System.out.println("2.Aparato");
        System.out.println("3.Cuidado Personal");
        System.out.println("4.Souvenir");
        System.out.println();

    }

    public  static void addProducto() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String nombre;
        float precio;
        String fechaEntrada;
        String id;
        String fechaCaducidad;


        System.out.println("Agregue su producto; ");

        menu();

        System.out.println("Elija su opcion: ");
        opcion = sc.nextInt();

        System.out.println("Nombre: ");
        nombre = sc.nextLine();sc.nextLine();
        System.out.println("Precio");
        precio = sc.nextFloat();
        System.out.println("Fecha Entrada");
        fechaEntrada = sc.nextLine();sc.nextLine();
        System.out.println("Id");
        id = sc.nextLine();


        switch (opcion) {

            case 1:
                System.out.println("Fecha Caducidad");
                fechaCaducidad = sc.nextLine();

                Alimento alimento = new Alimento(nombre, precio, fechaEntrada, id, fechaCaducidad);
                tienda.addAlimentos(alimento);
                break;
            case 2:
                Aparato aparato = new Aparato(nombre, precio, fechaEntrada, id);
                tienda.addAparatos(aparato);
                break;
            case 3:
                System.out.println("¿Popularidad?: ");
                int popularidad=sc.nextInt();

                CuidadoPersonal cuidadoPersonal = new CuidadoPersonal(nombre, precio, fechaEntrada,id,popularidad);
                tienda.addCuidadoPersonal(cuidadoPersonal);
                break;
            case 4:
                Souvenir souvenir = new Souvenir(nombre, precio, fechaEntrada, id);
                tienda.addSouvenirs(souvenir);
                break;
            default:
                System.out.println("No es una opcion valida");
                break;

        }

    }

    public static void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String id;

        menu();

        System.out.println("Elija su opcion: ");
        opcion = sc.nextInt();

        System.out.println("¿Id del producto?: ");
        id = sc.nextLine();

        switch (opcion) {

            case 1:
                Alimento alimentoAEliminar = tienda.obtenerAlimento(id);
                tienda.removeAlimentos(alimentoAEliminar);
                break;
            case 2:
                Aparato aparatoAEliminar = tienda.obtenerAparato(id);
                tienda.removeAparatos(aparatoAEliminar);
                break;
            case 3:
                CuidadoPersonal cuidadoPersonalAEliminar = tienda.obtenerCuidadoPersonal(id);
                tienda.removeCuidadoPersonal(cuidadoPersonalAEliminar);
                break;
            case 4:
                Souvenir souvenirAEliminar = tienda.obtenerSouvenir(id);
                tienda.removeSouvenirs(souvenirAEliminar);
                break;
            default:
                System.out.println("No es una opcion valida");
                break;
        }

    }

    public static void mostrarProducto() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String id;

        menu();

        System.out.println("Elija su opcion: ");
        opcion = sc.nextInt();sc.nextLine();

        System.out.println("¿Id del producto?: ");
        id = sc.nextLine();

        switch (opcion) {
            case 1:
                tienda.obtenerAlimento(id);
                break;
            case 2:
                tienda.obtenerAparato(id);
                break;
            case 3:
                tienda.obtenerCuidadoPersonal(id);
                break;
            case 4:
                tienda.obtenerSouvenir(id);
                break;
            default:
                System.out.println("No es una opcion valida");
                break;

        }


    }

    public static void modificarProducto() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String id;
        String nombre;
        float precio;
        String fechaEntrada;
        String fechaCaducidad;

        menu();

        System.out.println("Elija su opcion: ");
        opcion = sc.nextInt();

        System.out.println("¿Id del producto?: ");
        id = sc.nextLine();

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Precio");
        precio = sc.nextFloat();
        System.out.println("Fecha Entrada");
        fechaEntrada = sc.nextLine();


        switch (opcion) {
            case 1:
                System.out.println("Fecha Caducidad");
                fechaCaducidad = sc.nextLine();

                Alimento alimentoAModificar = tienda.obtenerAlimento(id);
                alimentoAModificar.setNombre(nombre);
                alimentoAModificar.setPrecio(precio);
                alimentoAModificar.setFechaEntrada(fechaEntrada);
                alimentoAModificar.setFechaCaducidad(fechaCaducidad);
                break;
            case 2:
                Aparato aparatoAModificar = tienda.obtenerAparato(id);
                aparatoAModificar.setNombre(nombre);
                aparatoAModificar.setPrecio(precio);
                aparatoAModificar.setFechaEntrada(fechaEntrada);
                break;
            case 3:
                System.out.println("¿Popularidad?: ");
                int popularidad=sc.nextInt();

                CuidadoPersonal cuidadoPersonalAModificar = tienda.obtenerCuidadoPersonal(id);
                cuidadoPersonalAModificar.setNombre(nombre);
                cuidadoPersonalAModificar.setPrecio(precio);
                cuidadoPersonalAModificar.setFechaEntrada(fechaEntrada);
                cuidadoPersonalAModificar.setPopularidad(popularidad);
                break;
            case 4:
                Souvenir souvenirAModificar = tienda.obtenerSouvenir(id);
                souvenirAModificar.setNombre(nombre);
                souvenirAModificar.setPrecio(precio);
                souvenirAModificar.setFechaEntrada(fechaEntrada);

                break;
            default:
                System.out.println("No es una opcion valida");
                break;


        }


    }
}
