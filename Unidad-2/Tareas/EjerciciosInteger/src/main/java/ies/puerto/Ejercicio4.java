package ies.puerto;

public class Ejercicio4 {

    public static void main(String[] args) {

        //Implementa un programa que calcule y muestre la suma de los dígitos de un número entero.


         int numero1= 30;
         int numero2= 45;

         int resultado=suma(numero1,numero2);

        System.out.println("El resultado de la suma es :" + resultado);

    }

    /**
     * Funcion que suma dos numeros con el metodo sum de Integer
     * @param numero1
     * @param numero2
     * @return la suma de los dos numeros
     */
    public static int suma(int numero1,int numero2){

        int resultado=Integer.sum(numero1,numero2);

        return resultado;
    }




}
