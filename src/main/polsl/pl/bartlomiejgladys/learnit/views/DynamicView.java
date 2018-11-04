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
 * Class for handling dynamic data in tables
 *
 * @author Bartlomiej Gladys
 * @Date 03/11/2018
 * @version 1.0
 */

public class DynamicView<T> {
    /**
     * Table in calling controller
     */
    private TableView<T> tableView;
    /**
     * Observable list to refresh data on
     */
    private ObservableList<T> observableList;
    /**
     * Model indicating data types
     */
    private Base<T> base;

    /**
     * tableView builder method
     *
     * @param tableView
     * @return dynamicView object
     */
    public DynamicView<T> setTableView(TableView<T> tableView) {
        this.tableView = tableView;
        return this;
    }

    /**
     * tableView builder method
     *
     * @param observableList
     * @return dynamicView object
     */
    public DynamicView<T> setObservableList(ObservableList<T> observableList) {
        this.observableList = observableList;
        return this;
    }

    /**
     * tableView builder method
     *
     * @param base
     * @return dynamicView object
     */
    public DynamicView<T> setBase(Base<T> base) {
        this.base = base;
        return this;
    }

    /**
     * Main dynamicView's method for adding buttons.
     *
     * @param text     for button
     * @param consumer callback after user's action
     */
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
