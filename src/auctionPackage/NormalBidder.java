package auctionPackage;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.BidderController;
import sample.Controller;

public class NormalBidder implements IObserver
{

    @Override
    public void getNotification()
    {
        System.out.println("Current bid is: "+Auction.currentBid );
    }

}
