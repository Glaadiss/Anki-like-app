package polsl.pl.bartlomiejgladys.learnit.views;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import polsl.pl.bartlomiejgladys.learnit.models.Base;

import java.util.function.Consumer;

/**
 * @Author Bartłomiej Gładys
 * @Date 03/11/2018
 * @Version 1.0
 */

public class DynamicView<T> {
    private TableView<T> tableView;
    private ObservableList<T> observableList;
    private Base<T> base;

    public DynamicView(TableView table, ObservableList list, Base model) {
        tableView = table;
        observableList = list;
        base = model;
    }


    public void addButtonToTable(String text, Consumer<T> consumer) {
        TableColumn<T, Void> colBtn = new TableColumn();

        Callback<TableColumn<T, Void>, TableCell<T, Void>> cellFactory = new Callback<TableColumn<T, Void>, TableCell<T, Void>>() {
            @Override
            public TableCell<T, Void> call(final TableColumn<T, Void> param) {
                final TableCell<T, Void> cell = new TableCell<T, Void>() {

                    private final Button btn = new Button(text);

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            T data = getTableView().getItems().get(getIndex());
                            Consumer<T> action = x -> observableList.setAll(base.getAll());
                            consumer.andThen(action).accept(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        tableView.getColumns().add(colBtn);
    }
}
