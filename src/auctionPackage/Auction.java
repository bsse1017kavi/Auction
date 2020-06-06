package auctionPackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Auction
{
    public static int  currentBid = 200;

    public static ArrayList<IObserver> observers = new ArrayList<>();

    public static ArrayList<Stage> stages = new ArrayList<>();

    public static void subscribe(IObserver observer)
    {
        observers.add(observer);
    }

    public static void unsubscribe(IObserver observer)
    {
        observers.remove(observer);
    }

    public static void raiseBid(int newBid)
    {
        if(newBid>currentBid) currentBid = newBid;
        notifyBidders();
    }

    public static void notifyBidders()
    {
        for(IObserver observer: observers)
        {
            observer.getNotification();
        }

        for(Stage stage: stages)
        {
            Text text = (Text)stage.getScene().lookup("#t");
            if(text!=null)text.setText(Integer.toString(currentBid));
        }
    }

}
