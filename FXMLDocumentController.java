/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitcovertor;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author saranya
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button Convert;
    @FXML
    private RadioButton rbtemp;
    @FXML
    private RadioButton rbweight;
    @FXML
    private RadioButton rbheight;
    @FXML
    private TextField textField1;
    @FXML
    private ToggleGroup unitconversion;
    @FXML
    private ToggleGroup group;
    @FXML
    private TextField textField2;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField textField3;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Button btnclear;
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        
       Alert dg= new Alert(Alert.AlertType.INFORMATION);
       dg.setTitle("Error");
            if(rbtemp.isSelected())
            {
                try
                {    
                    if (textField1.getText().equals("") && textField2.getText() != null )

                    {
                                    double fahrenheit;
                                    fahrenheit = Double.parseDouble(textField2.getText());
                                    textField1.setText( Double.toString((fahrenheit-32)*(0.5556)));

                    }
                    else if (textField2.getText().equals("") && textField1.getText() != null  )
                    {
                                    double Celsius;
                                    Celsius = Double.parseDouble(textField1.getText());
                                    textField2.setText( Double.toString((Celsius+32)/(0.5556)));

                    }
                }    
               
                catch(NumberFormatException e ) 
                {
                    if ((textField1.getText().trim().isEmpty()) && (textField2.getText().trim().isEmpty()))                    
                    {                       
                       dg.setTitle("Error");
                       dg.setContentText("Enter the value to be converted");
                       dg.show();
                    }
                    else 
                         dg.setContentText("Enter only nuumbers");
                    dg.show();
                }
            }
            if(rbweight.isSelected())
            {
                try 
                {   
                   
                    if (textField1.getText().equals("") )
                    {
                                    double kilogram=0.0;
                                    double ounces=0.0;
                                    int pounds=0;
                                    kilogram = Double.parseDouble(textField2.getText());
                                    pounds=(int)(kilogram*2.2046); 
                                    ounces= ((kilogram*2.2046)%1)*16;                                    
                                    textField1.setText(Integer.toString(pounds));
                                    textField3.setText(Double.toString(ounces));
                    }
                    else if ((textField2.getText().equals("") ) && (textField3.getText() != null))
                    {

                                    double lbs=0.0,oz=0.0,kg=0.0;
                                    lbs = Double.parseDouble(textField1.getText());
                                    if (textField3.getText().equals(""))
                                        oz=0.0;
                                    else
                                        oz=(Double.parseDouble(textField3.getText()))/16;
                                    kg=(lbs+oz)/2.2046;                                
                                    textField2.setText( Double.toString(kg));                              

                    }
                    
                    
                }
                catch(NumberFormatException e)
                {    
                    if ((textField1.getText().trim().isEmpty()) && (textField2.getText().trim().isEmpty()) && (textField3.getText().trim().isEmpty()))
                    {
                          dg.setTitle("Error");
                          dg.setContentText("Enter the value to be converted");
                          dg.show();

                    }
                  
                }
            }   
 
            if(rbheight.isSelected())
             {                
               try
                {    
                    if (textField1.getText().equals("") )
                    {
                                    double meter;
                                    double inches;
                                    int foot;

                                    meter = Double.parseDouble(textField2.getText());

                                    foot=(int)(meter*3.28084); 
                                   inches= ((meter*3.28084)%1)*12;

                                    //textField1.setText( Double.toString(kilogram*2.20462));
                                    textField1.setText(Integer.toString(foot));
                                    textField3.setText(Double.toString(inches));
                    }
                    else if (textField2.getText().equals("") )
                    {
                                    double ft,inch,m;
                                    ft = Double.parseDouble(textField1.getText());
                                    if (textField3.getText().equals(""))
                                        inch=0.0;
                                    else                                    
                                         inch=(Double.parseDouble(textField3.getText()))/12;
                                    m=(ft+inch)/3.28084;                                
                                    textField2.setText( Double.toString(m));

                    }
                }
                 catch(NumberFormatException e)
                {    
                    if ((textField1.getText().trim().isEmpty()) && (textField2.getText().trim().isEmpty()))                    
                       {

                          dg.setTitle("Error");
                          dg.setContentText("Enter the value to be converted");
                          dg.show();

                       }
                    else 
                        dg.setContentText("Enter only nuumbers");
                        dg.show();
                }
             } 
    }
    
   // @Override
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void handleTemperatureRb(ActionEvent event) {
        if(rbtemp.isSelected())
        {
            
            textField1.setText("");
            textField2.setText("");
            textField3.setVisible(false) ;
            rbweight.setSelected(false);
            rbheight.setSelected(false);
            label1.setText("Celsius");
            label2.setText("Farenheit");
            label3.setVisible(false);
            
        }
   
    }

    @FXML
    private void handleWeightRb(ActionEvent event) {
        
        if(rbweight.isSelected())
        {
            textField1.setText("");
            textField2.setText("");
            textField3.setVisible(true) ;
            textField3.setText("");
            rbtemp.setSelected(false);
            rbheight.setSelected(false);
            label1.setText("Pounds");
            label2.setText("Kilograms");
            label3.setVisible(true);
            label3.setText("oz");
           
        }
        
    }

    @FXML
    private void handleHeightRb(ActionEvent event) {
        
             if(rbheight.isSelected())
             {
                textField1.setText("");
                textField2.setText("");
                textField3.setVisible(true) ;
                textField3.setText("");
                rbtemp.setSelected(false);
                rbweight.setSelected(false);
                label1.setText("Feet");
                label2.setText("Meters");
                label3.setVisible(true);
                label3.setText("inches");
                
             }
    }

    @FXML
    private void handleButtonClear(ActionEvent event) 
    {
                textField1.clear();
                textField2.clear();
                textField3.clear();                
        
    }

    
}
