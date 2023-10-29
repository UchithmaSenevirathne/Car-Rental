package lk.ijse.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    private PieChart piechart;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private AnchorPane rootNode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Defender", 50),
                        new PieChart.Data("Jeep", 25),
                        new PieChart.Data("Benz", 10),
                        new PieChart.Data("Double Cab", 2)
                );

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        piechart.getData().addAll(pieChartData);

        XYChart.Series series1 = new XYChart.Series();

        series1.setName("2022");
        series1.getData().add(new XYChart.Data("1 Star", 354));
        series1.getData().add(new XYChart.Data("2 Star", 764));
        series1.getData().add(new XYChart.Data("3 Star", 1004));
        series1.getData().add(new XYChart.Data("4 Star", 3050));
        series1.getData().add(new XYChart.Data("5 Star", 2034));

        XYChart.Series series2 = new XYChart.Series();

        series2.setName("2023");
        series2.getData().add(new XYChart.Data("1 Star", 134));
        series2.getData().add(new XYChart.Data("2 Star", 454));
        series2.getData().add(new XYChart.Data("3 Star", 564));
        series2.getData().add(new XYChart.Data("4 Star", 3750));
        series2.getData().add(new XYChart.Data("5 Star", 4034));

        barChart.getData().addAll(series1,series2);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/CustomerManageForm.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Customer Manage Form");
        stage.setScene(scene);
    }
}