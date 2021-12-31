package Controller;

import matricesDispersas.MatrizEnTripleta;
import matricesDispersas.Tripleta;

public class Implementacion {

    //se define un parámetro estático de tipo Matriz en tripletas para interactuar con él desde otras clases
    public static MatrizEnTripleta m, a, b;

    //se crean parámentros para filas, columnas y número de numerodetripletas
    public static int numerodetripletas, filas, columnas, max, numerodetripletas1, filas1, columnas1, numerodetripletas2, filas2, columnas2;
    public static String matrizEnString, matrizEnStringA, matrizEnStringB;


    /*todo que recibe y define valores de fila, columna y numerodetripletas, además
    invoca el método principal creando la matriz para el juego
     */
    public static void setValoresGrafica(int numerofilas, int numerocolumnas, int tripletas, String matriz) {
        filas = numerofilas;
        columnas = numerocolumnas;
        numerodetripletas = tripletas;
        matrizEnString=matriz;
        //se define la tripleta principal para crear la matriz tomando los valores de filas y columnas
        Tripleta t = new Tripleta(filas, columnas, 0);
        m = new MatrizEnTripleta(t);
        //un ciclo se repite tantas veces como numerodetripletas hay que generar
        for (int i = 1; i <= numerodetripletas; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = Integer.parseInt(matrizEnString.split("/")[i].split(",")[0]);
            int c = Integer.parseInt(matrizEnString.split("/")[i].split(",")[1]);
            int d = Integer.parseInt(matrizEnString.split("/")[i].split(",")[2]);
            //se crea una tripleta con los valores de fila, columna y dato obtenidos
            Tripleta tx = new Tripleta(f, c, d);
            //se inserta la tripleta en la matriz
            m.insertaTripleta(tx);
        }
        //se muestra la matriz en consola (en caso de querer verificar similitud
        //con la que se muestra en la interfaz gráfica)
        m.mostrarMatrizCuadricula();
    }

    public static void setValoresIdentidad(int numerofilas, int numerocolumnas) {
        filas = numerofilas;
        columnas = numerocolumnas;
        //se define la tripleta principal para crear la matriz tomando los valores de filas y columnas
        Tripleta t = new Tripleta(filas, columnas, 0);
        m = new MatrizEnTripleta(t);
        //un ciclo se repite tantas veces como numerodetripletas hay que generar
        max = Math.min(filas, columnas);

        for (int i = 1; i <= max; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = i;
            int c = i;
            int d = 1;
            //se crea una tripleta con los valores de fila, columna y dato obtenidos
            Tripleta tx = new Tripleta(f, c, d);
            //se inserta la tripleta en la matriz
            m.insertaTripleta(tx);
        }
        //se muestra la matriz en consola (en caso de querer verificar similitud
        //con la que se muestra en la interfaz gráfica)
        m.mostrarMatrizCuadricula();
    }

    public static void setValoresSuma(int numerofilas1, int numerocolumnas1, int tripletas1, String matriz1, int numerofilas2, int numerocolumnas2, int tripletas2, String matriz2){
        filas1 = numerofilas1;
        columnas1 = numerocolumnas1;
        numerodetripletas1 = tripletas1;
        matrizEnStringA=matriz1;
        //se define la tripleta principal para crear la matriz tomando los valores de filas y columnas
        Tripleta r = new Tripleta(filas1, columnas1, 0);
        a = new MatrizEnTripleta(r);
        //un ciclo se repite tantas veces como numerodetripletas hay que generar
        for (int i = 1; i <= numerodetripletas1; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[0]);
            int c = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[1]);
            int d = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[2]);
            //se crea una tripleta con los valores de fila, columna y dato obtenidos
            Tripleta tx = new Tripleta(f, c, d);
            //se inserta la tripleta en la matriz
            a.insertaTripleta(tx);
        }
        //se muestra la matriz en consola (en caso de querer verificar similitud
        //con la que se muestra en la interfaz gráfica)
        System.out.println("La matriz a es:");
        a.mostrarMatrizCuadricula();


        filas2 = numerofilas2;
        columnas2 = numerocolumnas2;
        numerodetripletas2 = tripletas2;
        matrizEnStringB=matriz2;
        //se define la tripleta principal para crear la matriz tomando los valores de filas y columnas
        Tripleta s = new Tripleta(filas1, columnas1, 0);
        b = new MatrizEnTripleta(s);
        //un ciclo se repite tantas veces como numerodetripletas hay que generar
        for (int i = 1; i <= numerodetripletas2; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[0]);
            int c = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[1]);
            int d = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[2]);
            //se crea una tripleta con los valores de fila, columna y dato obtenidos
            Tripleta tx = new Tripleta(f, c, d);
            //se inserta la tripleta en la matriz
            b.insertaTripleta(tx);
        }
        //se muestra la matriz en consola (en caso de querer verificar similitud
        //con la que se muestra en la interfaz gráfica)
        System.out.println("La matriz B es:");
        b.mostrarMatrizCuadricula();


        filas = numerofilas1;
        columnas = numerocolumnas1;
        //se define la tripleta principal para crear la matriz tomando los valores de filas y columnas
        Tripleta t = new Tripleta(filas, columnas, 0);
        m = new MatrizEnTripleta(t);
        //un ciclo se repite tantas veces como numerodetripletas hay que generar

        for (int i = 1; i <= numerodetripletas1; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[0]);
            int c = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[1]);
            int d = Integer.parseInt(matrizEnStringA.split("/")[i].split(",")[2]);
            if(b.existe(f, c)){
                d=a.getDato(f,c)+b.getDato(f,c);
            }
            //se crea una tripleta con los valores de fila, columna y dato obtenidos
            Tripleta tx = new Tripleta(f, c, d);
            //se inserta la tripleta en la matriz
            m.insertaTripleta(tx);
        }

        for (int i = 1; i <= numerodetripletas2; i++) {
            //se establece el rango para obtener las coordenadas según el número de filas y columnas ingresadas
            int f = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[0]);
            int c = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[1]);
            int d = Integer.parseInt(matrizEnStringB.split("/")[i].split(",")[2]);
            if(!a.existe(f, c)){
                //se crea una tripleta con los valores de fila, columna y dato obtenidos
                Tripleta tx = new Tripleta(f, c, d);
                //se inserta la tripleta en la matriz
                m.insertaTripleta(tx);
            }
        }
        //se muestra la matriz en consola (en caso de querer verificar similitud
        //con la que se muestra en la interfaz gráfica)
        System.out.println("La matriz resultado:");
        m.mostrarMatrizCuadricula();
    }


    //obtiene el dato de una casilla al pasarle las correspondientes fila y columna (con modificación en el retorno)
    public static int datoCasilla(int f, int c) {
        return m.getDato(f, c);
    }
}