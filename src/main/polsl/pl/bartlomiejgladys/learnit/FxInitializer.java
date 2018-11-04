package polsl.pl.bartlomiejgladys.learnit;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @Author Bartłomiej Gładys
 * @Date 03/11/2018
 * @Version 1.0
 */

public class FxInitializer extends Application {
    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LearnIt");
        new Router(primaryStage);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }
}

//        new CategoryListController(primaryStage);
//        Label header = new Label("LearnIt!");
//        TextField categoryName = new TextField();
//        Button addCategoryButton = new Button("Add category!");
//        addCategoryButton.setOnAction(e -> System.out.print("qwe"));
//        addCategoryButton.fire();
//        addCategoryButton.setOnAction(this);
//        VBox layout =  new VBox(20);
//        layout.getChildren().addAll(header, categoryName, addCategoryButton);
//        CategoryList = new Scene(layout, 800, 600);
//
//        Button backButton = new Button("Back!");
//        addCategoryButton.setOnAction(e -> window.setScene(CategoryList));
//
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().addAll(backButton);
//        EditCategory = new Scene(layout2, 800, 600);

//        window.setScene(CategoryList);
