package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import java.io.IOException;

/*
Esta clase controla lo relacionado a la ventana principal, recibe los datos del usuario
para determinar el modo y carga la vista del resultado en la misma ventana.
 */
public class Controller {

    int filas, columnas, Tripletas; //se definen variables para filas, columnas y tripletas
    String matriz, matriz1, matriz2;
    int filas1, columnas1, Tripletas1, filas2, columnas2, Tripletas2;
    //se establece la conexión con los componentes de la interfaz gráfica
    @FXML
    private TextField matriz_id;          //campo de texto para matriz
    @FXML
    private TextField matrizA_id;          //campo de texto para matriz A
    @FXML
    private TextField matrizB_id;          //campo de texto para matriz B
    @FXML
    private AnchorPane rootPane;        //contenedor principal(ventana)
    @FXML
    private HBox HabilitarMatriz;
    @FXML
    private HBox HabilitarSuma;

    //método que detecta acción sobre el botón ingresar matriz y hace visible las opciones
    public void matriz_action(){
        HabilitarMatriz.setDisable(!true);
        HabilitarMatriz.setVisible(true);
        HabilitarSuma.setDisable(true);
        HabilitarSuma.setVisible(false);
    }
    //método que detecta acción sobre el botón sumar matriz y hace visibles las opciones
    public void suma_action(){
        HabilitarSuma.setDisable(!true);
        HabilitarSuma.setVisible(true);
        HabilitarMatriz.setDisable(true);
        HabilitarMatriz.setVisible(false);
    }
    //método que detecta acción sobre botón graficar matriz
    public void graficar_action() throws IOException {
        //con un try - catch se controla que los valores de fila, columna y tripletas ingresados sean numéricos
        matriz=(matriz_id.getText());
        System.out.println(matriz);
        try {
            filas=Integer.parseInt((matriz_id.getText()).split(",")[0]);
            System.out.println(filas);
            columnas=Integer.parseInt((matriz_id.getText()).split(",")[1]);
            System.out.println(columnas);
            Tripletas =Integer.parseInt((matriz_id.getText()).split("/")[0].split(",")[2]);
            System.out.println(Tripletas);
        } catch (NumberFormatException e) {
            //si se detecta un formato diferente se muestra un mensaje de información
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los valores ingresados deben ser numéricos.");
            alert.setHeaderText("Formato de dato incorrecto");
            alert.show();
        }
        //se establecen valores mínimos y máximos de filas, columnas y tripletas para asegurar una buena jugabilidad
        if (filas < 1 || columnas < 1 || filas > 20 || columnas > 20 || Tripletas < 1) {
            //si se sobrepasan dichos límites se muestra un mensaje informativo
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los datos deben estar dentro de los siguientes límites:" +
                    "\nFilas: entre 1 y 20\nColumnas: entre 1 y 20\ntripletas: mínimo 1");
            alert.show();
        } else {
            //si no hay problema con las condiciones establecidas se lanza el juego
                //se carga en un nuevo panel el archivo de vista del juego (juego.fxml)
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../View/juego.fxml"));

                //se muestra el panel recién creado en el contenedor principal de la ventana
                rootPane.getChildren().setAll(pane);

                //se carga en la clase encargada de crear la matriz los valores de filas, columnas y numero de tripletas
                System.out.println(matriz);
                Implementacion.setValoresGrafica(filas, columnas, Tripletas, matriz);

                //se carga en la clase que controla el juego los valores de filas, columnas
                juegoController.setValores(filas, columnas);

        }
    }
    //metodo que detecta accion sobre el botón Matriz identidad
    public void identidad_action() throws IOException{
        try {
            filas=Integer.parseInt((matriz_id.getText()).split(",")[0]);
            System.out.println(filas);
            columnas=Integer.parseInt((matriz_id.getText()).split(",")[1]);
            System.out.println(columnas);
            Tripletas =Integer.parseInt((matriz_id.getText()).split("/")[0].split(",")[2]);
            System.out.println(Tripletas);
        } catch (NumberFormatException e) {
            //si se detecta un formato diferente se muestra un mensaje de información
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los valores ingresados deben ser numéricos.");
            alert.setHeaderText("Formato de dato incorrecto");
            alert.show();
        }
        //se establecen valores mínimos y máximos de filas, columnas y tripletas para asegurar una buena jugabilidad
        if (filas < 1 || columnas < 1 || filas > 20 || columnas > 20 || Tripletas < 1) {
            //si se sobrepasan dichos límites se muestra un mensaje informativo
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los datos deben estar dentro de los siguientes límites:" +
                    "\nFilas: entre 1 y 20\nColumnas: entre 1 y 32\ntripletas: mínimo 1");
            alert.show();
        } else {
            //si no hay problema con las condiciones establecidas se lanza el juego
                //se carga en un nuevo panel el archivo de vista del juego (juego.fxml)
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../View/juego.fxml"));

                //se muestra el panel recién creado en el contenedor principal de la ventana
                rootPane.getChildren().setAll(pane);

                //se carga en la clase encargada de crear la matriz los valores de filas, columnas
                System.out.println(matriz);
                Implementacion.setValoresIdentidad(filas, columnas);
                //se carga en la clase que controla el juego los valores de filas, columnas
                juegoController.setValores(filas, columnas);
        }
    }
    public void sumar_action() throws IOException{
        matriz1=(matrizA_id.getText());
        System.out.println(matriz1);
        matriz2=(matrizB_id.getText());
        System.out.println(matriz2);
        try {
            filas1=Integer.parseInt((matrizA_id.getText()).split(",")[0]);
            System.out.println(filas);
            columnas1=Integer.parseInt((matrizA_id.getText()).split(",")[1]);
            System.out.println(columnas);
            Tripletas1 =Integer.parseInt((matrizA_id.getText()).split("/")[0].split(",")[2]);
            System.out.println(Tripletas);

            filas2=Integer.parseInt((matrizB_id.getText()).split(",")[0]);
            System.out.println(filas);
            columnas2=Integer.parseInt((matrizB_id.getText()).split(",")[1]);
            System.out.println(columnas);
            Tripletas2 =Integer.parseInt((matrizB_id.getText()).split("/")[0].split(",")[2]);
            System.out.println(Tripletas);

        }
        catch (NumberFormatException e) {
            //si se detecta un formato diferente se muestra un mensaje de información
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los valores ingresados deben ser numéricos.");
            alert.setHeaderText("Formato de dato incorrecto");
            alert.show();
        }
        //se establecen valores mínimos y máximos de filas, columnas y tripletas para asegurar una buena jugabilidad
        if (filas1 < 1 || columnas1 < 1 || filas1 > 20 || columnas1 > 20 || Tripletas1 < 1 || filas2 < 1 || columnas2 < 1 || filas2 > 20 || columnas2 > 20 || Tripletas2 < 1 ) {
            //si se sobrepasan dichos límites se muestra un mensaje informativo
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los datos deben estar dentro de los siguientes límites:" +
                    "\nFilas: entre 1 y 20\nColumnas: entre 1 y 32\ntripletas: mínimo 1");
            alert.show();
        } else {
                  if (Tripletas1 > (filas1 * columnas1) - 1 || Tripletas2 > (filas2 * columnas2) - 1 ) { //si la cantidad de tripletas sobrepasa el límite
                    int valor = (filas * columnas) - 1;
                    //se muestra un mensaje de alerta con el valor máximo posible para las dimensiones especificadas
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El valor máximo de tripletas para las dimensiones\n" +
                            "ingresadas es de " + valor);
                    alert.show();
                } else { //si no hay problema con las condiciones establecidas se lanza el juego
                    //se carga en un nuevo panel el archivo de vista del juego (juego.fxml)
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("../View/juego.fxml"));
                    //se muestra el panel recién creado en el contenedor principal de la ventana
                    rootPane.getChildren().setAll(pane);
                    //se carga en la clase encargada de crear la matriz los valores de filas, columnas, tripletas y matrices
                    System.out.println(matriz);
                    Implementacion.setValoresSuma(filas1, columnas1, Tripletas1, matriz1, filas2, columnas2, Tripletas2, matriz2);
                    //se carga en la clase que controla el juego los valores de filas, columnas
                    juegoController.setValores(filas1, columnas1);
                }
        }
    }

}