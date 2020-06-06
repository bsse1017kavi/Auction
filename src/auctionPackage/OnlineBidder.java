package auctionPackage;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.BidderController;

public class OnlineBidder implements IObserver
{
    @Override
    public void getNotification()
    {
        System.out.println("Current bid is: "+Auction.currentBid );
    }

}
