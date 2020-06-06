package sample;

import auctionPackage.Auction;
import auctionPackage.IObserver;
import auctionPackage.NormalBidder;
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

public class BidderController implements Initializable
{
    @FXML
    Text t;

    @FXML
    Button button;

    IObserver observer;


    public void setObserver(IObserver observer) {
        this.observer = observer;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t.setText(Integer.toString(Auction.currentBid));
    }

    public void raiseBid(ActionEvent e)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("raiseBid1.fxml"));

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void unsubscribe(ActionEvent e)throws Exception
    {
        Auction.unsubscribe(this.observer);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.close();
    }

    public IObserver getObserver() {
        return observer;
    }

    public void update()
    {
        t.setText(Integer.toString(Auction.currentBid));
    }
}
