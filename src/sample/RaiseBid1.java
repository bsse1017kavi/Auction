package sample;

import auctionPackage.Auction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RaiseBid1
{
    @FXML
    TextField tf1;

    @FXML
    Button button;

    int bid;

    public void confirm(ActionEvent e)throws Exception
    {
        if(!tf1.getText().isEmpty())
        {
            bid = Integer.parseInt(tf1.getText());
            Auction.raiseBid(bid);
        }

        Parent root = FXMLLoader.load(getClass().getResource("bidder.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
