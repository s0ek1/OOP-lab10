package com.example.ooplab10;


import functions.CalcProcessor;
import functions.ICalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import result.Result;

public class HelloController {
    @FXML
    private TextField countIntervalField;
    @FXML
    private TextField threadsField;
    @FXML
    private Label infoIntegralLabel;
    @FXML
    private Label infoTimeLabel;
    public void Integrate() {
        ICalc calc = new CalcProcessor();
        Result res = calc.calcIntegral(Integer.parseInt(countIntervalField.getText()), Integer.parseInt(threadsField.getText()));
        infoIntegralLabel.setText("Значення iнтегралу: "+(res.integral()));
        infoTimeLabel.setText("Витрачено часу: "+(res.time()));
    }
}