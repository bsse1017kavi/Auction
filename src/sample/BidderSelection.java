package sample;

import auctionPackage.Auction;
import auctionPackage.IObserver;
import auctionPackage.NormalBidder;
import auctionPackage.OnlineBidder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BidderSelection
{
    @FXML
    Button button1;

    @FXML Button button2;

    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private void openWindow(IObserver observer)throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bidder.fxml"));

        Stage stage = new Stage();
        Parent root = loader.load();


        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);

        BidderController bidderController = loader.getController();
        bidderController.setObserver(observer);


        stage.setScene(scene);

        Auction.stages.add(stage);

        stage.show();
    }

    public void addOnlineBidder(ActionEvent e)throws Exception
    {
        OnlineBidder onlineBidder = new OnlineBidder();
        Auction.subscribe(onlineBidder);
        openWindow(onlineBidder);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void addNormalBidder(ActionEvent e)throws Exception
    {
        NormalBidder normalBidder = new NormalBidder();
        Auction.subscribe(normalBidder);
        openWindow(normalBidder);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
