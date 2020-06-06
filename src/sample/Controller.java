package sample;

import auctionPackage.Auction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    Text t;

    @FXML
    Button button;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t.setText(Integer.toString(Auction.currentBid));
    }

    public void raiseBid(ActionEvent e)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("raiseBid.fxml"));

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void subscribe(ActionEvent e)throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bidderSelection.fxml"));
        Parent root = loader.load();

        BidderSelection bidderSelection = loader.getController();
        bidderSelection.setController(this);

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void update()
    {
        t.setText(Integer.toString(Auction.currentBid));
    }
}
