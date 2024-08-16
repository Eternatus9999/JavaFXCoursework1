package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import model.Customer;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Addcustomerform implements Initializable {

    @FXML
    private JFXTextField address;

    @FXML
    private DatePicker bday;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXComboBox<String> title;

    @FXML
    void btnActionadd(ActionEvent event) {
        List<Customer> connection = DBConnection.getInstance().getDBConnection();


        if(!name.getText().equals("")&&!address.getText().equals("")&&!phone.getText().equals("")&&!(title.getValue()==null)&&!(bday.getValue()==null)) {
            connection.add(new Customer(id.getText(), title.getValue() + "", name.getText(), address.getText(), phone.getText(), bday.getValue()));
            id.setText("00"+generate());
            name.setText("");
            address.setText("");
            phone.setText("");
            title.setValue(null);
            bday.setValue(null);
            JOptionPane.showMessageDialog(null, "Customer Added Successfully","Successfull", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Fill all attributes","Unsuccessfull", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setItems(FXCollections.observableArrayList(new String[]{"Mr.", "Miss", "Mrs."}));
        id.setText("00"+generate());
    }

    public int generate(){
        List<Customer> templist = DBConnection.getInstance().getDBConnection();
        int index = 000;
        if(templist.size()==0){
            index = 000;
        }
        else {
            index = Integer.parseInt(templist.get(templist.size()-1).getId());
        }
        return ++index;
    }
}