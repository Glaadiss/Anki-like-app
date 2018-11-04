package polsl.pl.bartlomiejgladys.learnit;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Create instance of FX Application
 *
 * @author Bartlomiej Gladys
 * @Date 03/11/2018
 * @version 1.0
 */

public class FxInitializer extends Application {
    /**
     * Launch FX
     *
     * @param args passed during process's start
     */
    public static void run(String[] args) {
        launch(args);
    }

    /**
     * main FX application method for setting interaction
     *
     * @param primaryStage passed by FX
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LearnIt");
        new Router(primaryStage);
        primaryStage.show();
    }
}
