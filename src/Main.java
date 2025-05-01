package projectpharmacy;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;

public class Main extends Application
{
    public static void main(String []args)
    {
        launch(args);
        Item []n={new Liquids("a","b",5,12.4,"cc"),new Tablets("t","3ee",67,78)};
        for(Item i :n){
            i.Display_Info();
            System.out.println(i.is_av());
        }
        
    }
    @Override
    public void start(Stage stage){
    stage.setTitle("Pharmacy mangment system");
  
    }
}
