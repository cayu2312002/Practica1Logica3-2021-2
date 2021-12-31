package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/*
Esta clase se encarga de controlar lo relacionado con la vista del juego en ejecución
y recibir las acciones del usuario en la interfaz
 */
public class juegoController {

    //se establece una relación con los componentes de la vista
    @FXML
    private Pane panelPrincipal;   //contenedor de los botones
    @FXML
    private Button cerrar_id;      //botón de cerrar
    @FXML
    private Button abrir_id;       //botón de abrir tablero
    @FXML
    private AnchorPane rootPane;   //contenedor principal (ventana)
    @FXML
    private Label label_id;

    //se definen valores generales para el tamaño de los botones y del panel principal
    public double hPanel, wPanel, hBoton, wBoton;

    //se definen variables para filas, columnas, # de tripletas y # de casillas desbloqueadas por el jugador
    public static int filas, columnas, contador;

    /*
    Este método se encarga de crear los botones en el panel principal del juego
    los crea en forma de cuadrícula y el tamaño de cada uno se calcula deaecuerdo al
    número de filas y columnas de la matriz
     */
    public void comenzar_action() {
        //se desactiva el botón que genera los elementos de la cuadrícula
        abrir_id.setVisible(false);

        //se hacen calculos para el tamaño ideal de los botones según las dimensiones de la matriz
        hPanel = panelPrincipal.getHeight();
        wPanel = panelPrincipal.getWidth();
        hBoton = Math.floor(hPanel / filas);
        wBoton = Math.floor(wPanel / columnas);

        //dos ciclos crean y sitúan cada botón en la posición correcta del panel principal
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Button b = new Button();   //se crea un botón nuevo
                b.setMinSize(0, 0);   //su tamaño mínimo se define en cero
                b.setLayoutY(i * hBoton);  //se define su posición y tamaño deacuerdo a los
                b.setLayoutX(j * wBoton);  //valores hallados anteriormente
                b.setPrefWidth(wBoton);
                b.setPrefHeight(hBoton);
                //se define un estilo(color de fondo y borde)
                b.setStyle("-fx-background-color: #87cefa;" +
                        "-fx-border-color: black");

                panelPrincipal.getChildren().add(b); //se agrega al panel principal del juego
                int id = panelPrincipal.getChildren().indexOf(b); //se obtien el id del elemento
                click(id, b); //se llama la función click, tomando el id y el botón mismo
            }
        }
    }
    //recibe y define los valores de filas, columnas y tripletas
    public static void setValores(int f, int c) {
        filas = f;
        columnas = c;
        contador = f * c;
    }

    /*
    este método es llamado al hacer click sobre uno de los botones(casillas) del juego
    tomando dicho botón y su id se realizan cálculos para mostrar un resultado diferente
    dependiendo del valor que a este le corresponda en la matriz dispersa que controla
    el juego
     */
    public void click(int id, Button b) {
        int f = id / columnas + 1; //se calcula la fila del botón según su id
        int c = id % columnas + 1; //se calcula la columna del botón según su id

        //se obtiene el dato correspondiente en la matriz dispersa según la fila y columna del botón
        int d = Implementacion.datoCasilla(f, c);
        b.setText(d + "");    //asigna al texto del botón el número correspondiente (cantidad de tripletas al rededor)
        disenoBotonNumero(b); //asigna un diseño específico a este tipo de elemento en el juego

    }

    //cambia el estilo del botón para el caso de número
    public void disenoBotonNumero(Button b) {
        contador--;            //se resta en 1 el contador de casillas abiertas
        b.setDisable(true);    //se descativa el botón para prevenir pulsarlo más de una vez
        String htext = (int) Math.floor(hBoton / 2) + ""; //se calcula la altura correcta del texto interior

        //se le da un color verde claro en el fondo, bordes y texto negros y una fuente gruesa para ver mejor el número
        String style = "-fx-background-color: #9cff81; -fx-font-family: 'Segoe UI Black'; -fx-border-color: #000000; -fx-text-fill: black; -fx-font-size: " + htext;
        b.setStyle(style);
    }
    //cambia el estilo del botón pulsado para el caso de cero
    
    /*
    Este método se encarga de tomar la acción sobre el botón cerrar y cargar nuevamente la vista principal
    en la misma ventana
     */
    public void cerrar_action() throws IOException {
        //obtiene el archivo de la vista principal (sample.fxml) y lo carga en un panel
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../View/sample.fxml"));
        rootPane.getChildren().setAll(pane); //muestra la vista sobre el contenedor principal de la ventana
    }

    //este método obtiene el índice de un botón deacuerdo a sus fila y columna
    public int indiceDe(int f, int c) {
        return ((f - 1) * columnas) + (c - 1);
    }
}