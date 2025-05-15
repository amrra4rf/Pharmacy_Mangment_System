/*package main;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package main;

import java.time.LocalDate;
import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 *
 * @author moham
 */

public class test extends Application {

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    private void item_add_stage() {
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Add Item");
        stage.setResizable(false);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(20);
        gp.setHgap(20);
        VBox vb = new VBox(15);
        vb.setAlignment(Pos.CENTER);
        Label l = new Label("Add an item");
        l.setFont(Font.font("System", FontWeight.BOLD, 20));
        l.setTextFill(Color.BLACK);
        Label item_name = new Label("Name:");
        Label item_count = new Label("Item count:");
        Label item_price = new Label("Item price:");
        Label item_year = new Label("Expire after:");
        TextField name_field = new TextField();
        TextField count_field = new TextField();
        TextField price_field = new TextField();
        TextField year_field = new TextField();
        RadioButton liquid = new RadioButton("Liquid");
        RadioButton tablet = new RadioButton("Tablet");
        Button submit = new Button("Next");
        ToggleGroup type = new ToggleGroup();
        liquid.setToggleGroup(type);
        tablet.setToggleGroup(type);
        
        submit.disableProperty().bind(
                                        name_field.textProperty().isEmpty()
                .or(count_field.textProperty().isEmpty())
                        .or(price_field.textProperty().isEmpty())
                        .or(year_field.textProperty().isEmpty())
                            .or(type.selectedToggleProperty().isNull())
                    );        
        gp.add(item_name,0,0);
        gp.add(item_count,0,1);
        gp.add(item_price,0,2);
        gp.add(item_year,0,3);
        gp.add(name_field,1,0);
        gp.add(count_field,1,1);
        gp.add(price_field,1,2);
        gp.add(year_field,1,3);
        gp.add(liquid,2,1);
        gp.add(tablet,2,2);
        gp.add(submit,2,3);
        vb.getChildren().addAll(l,gp);
        Scene scene = new Scene(vb,500,550);
        stage.setScene(scene);
        
        VBox vb_liq = new VBox();
        VBox vb_tab = new VBox();
        vb_liq.setAlignment(Pos.CENTER);
        vb_tab.setAlignment(Pos.CENTER);
        
        Button liq_ok = new Button("Add");
        Button tab_ok = new Button("Add");
        
        
        Scene liquid_scene = new Scene(vb_liq,300,350);
        Scene tablet_scene = new Scene(vb_tab,300,350);
        
        Label vol = new Label("Volume:");
        Label cap = new Label ("number of capsules:");
        TextField vol_field = new TextField();
        TextField cap_field = new TextField();
        
        liq_ok.disableProperty().bind(vol_field.textProperty().isEmpty());
        tab_ok.disableProperty().bind(cap_field.textProperty().isEmpty());
        
        vb_liq.getChildren().addAll(vol,vol_field,liq_ok);
        vb_tab.getChildren().addAll(cap,cap_field,tab_ok);
        
        vb_liq.getChildren().addAll();
        
        submit.setOnAction(e->{
         Toggle selectedToggle = type.getSelectedToggle();  
        RadioButton select = (RadioButton)selectedToggle;
        char ge = select.getText().charAt(0);
        Doctor doc = (Doctor)phar.person[Pharmacy.index];
        
         //doc.add_item(name_field.getText(),Integer.parseInt(count_field.getText()),LocalDate.of(Integer.parseInt(year_field.getText()),1,1),Double.parseDouble(price_field.getText()),ge);
       if(ge=='L'){
           stage.setScene(liquid_scene);
           liq_ok.setOnAction(ee->{
               
    phar.items[Pharmacy.item_count_in_pharmacy++] = new Liquid(name_field.getText(), Integer.parseInt(count_field.getText()), LocalDate.of(Integer.parseInt(year_field.getText()),1,1), Double.parseDouble(vol_field.getText()), Double.parseDouble(price_field.getText()));
           
           stage.close();
           });
       
       
       }
       else if(ge=='T'){
           stage.setScene(tablet_scene);
           tab_ok.setOnAction(eee->{
               
               phar.items[Pharmacy.item_count_in_pharmacy++] = new Tablet(name_field.getText(), Integer.parseInt(count_field.getText()),LocalDate.of(Integer.parseInt(year_field.getText()),1,1), Integer.parseInt(cap_field.getText()), Double.parseDouble(price_field.getText()));
               stage.close();
           
           
           });
           
       
       }
        
        });

      
        
        
        stage.show();
        
    }
   
    private void item_remove() {
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Remove item");
        Label l = new Label("Remove item");
        l.setFont(Font.font("System", FontWeight.BOLD, 20));
        l.setTextFill(Color.BLACK);
        Label item_name = new Label("Item name: ");
        Label item_count = new Label("Number of items to remove");
        TextField name_field = new TextField();
        TextField count_field = new TextField();
        Button remove = new Button("Remove");
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);
        gp.add(item_name,0,0);
        gp.add(item_count,0,1);
        gp.add(name_field,1,0);
        gp.add(count_field,1,1);
        gp.add(remove,2,2);
        VBox vb = new VBox(15);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(l,gp);
        Scene scene = new Scene(vb,400,450);
        stage.setScene(scene);
        remove.disableProperty().bind(name_field.textProperty().isEmpty().or(count_field.textProperty().isEmpty()));
        stage.show();
        remove.setOnAction(e->{
            try{
            Doctor doc = (Doctor)phar.person[phar.index];
            doc.remove_item_by_name(name_field.getText(),Integer.parseInt(count_field.getText()));
            
            
            stage.close();
            }
            catch(Capabilities.removeException ex){
                showError("Invalid input","make sure you enter a positive integer number less than or equal the number of items");
            }
            
            
        
        });
        
        
    }
  

    private void doctor_show_stage() {
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage doctor_show = new Stage();
        doctor_show.getIcons().add(icon);
        doctor_show.setResizable(false);
        doctor_show.setTitle("Your informations");
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 450);
        doctor_show.setScene(scene);
       
        root.getChildren().addAll(Person.get_TextArea());
        doctor_show.show();

    }
    private void users_show_stage(){
        Image icon = new Image("file:C:/users/moham/onedrive/desktop/icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("All users");
        Pane root = new Pane();
        Scene scene = new Scene(root,300,350);
        stage.setScene(scene);
        
        Doctor.sb.setEditable(false);
      
       root.getChildren().add(Doctor.sb);
       
        stage.show();
        
        
    
    
    }

    private void user_find_stage() {
        Image icon = new Image("file:C:/users/moham/onedrive/desktop/icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Find user by name");
        stage.setResizable(false);
        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb,500,550);
        Label label = new Label("Find user by name");
        Label l2 = new Label ("Type a username or its initial to view all corresponding users");
        label.setFont(Font.font("System", FontWeight.BOLD, 20));
        label.setTextFill(Color.BLACK);
        TextField tf = new TextField();
        Button search = new Button("Search");
        vb.getChildren().addAll(label,l2,tf,search);
        
       Pane root = new Pane();
       
       Scene user_found = new Scene(root,350,300);
       
      root.getChildren().addAll(Person.get_TextArea());           //stoped here
       
        
        search.setOnAction(e->{
           
            try{                Doctor doc = (Doctor)phar.person[phar.index];
            doc.find_person_by_name(tf.getText());
            stage.setScene(user_found);
            }
           catch(Doctor.notFoundException ex){showError("No such user was found!","Please try again");}
            
            
            
            
            
            
            
        });
        
        
        
        stage.setScene(scene);
        stage.show();
       
    }
    private void item_show_stage(){
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Display items");
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,300,350);
        Button sort = new Button("Sort items");
        root.getChildren().addAll(Person.getTextArea_m(),sort);
        Person.getTextArea_m().setEditable(false);
        stage.setScene(scene);
        Pane pane = new Pane();
        
        Scene sort_item = new Scene(pane,300,350);
        
        sort.setOnAction(e->{
            if (Pharmacy.item_count_in_pharmacy < 1)
                            System.out.println("There is No item in The Pharmacy right now");
                        else {
                            Item[] temp = new Item[Pharmacy.item_count_in_pharmacy]; // deep copy
                            for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
                                temp[i] = new Item(phar.items[i].get_name(), phar.items[i].get_count(),
                                        phar.items[i].get_expiry_date(), phar.items[i].get_price());
                                        temp[i].set_id(phar.items[i].get_id());
                            }
                            Arrays.sort(temp);
                            for (Item i : temp) {
                                i.Displayinfo();
                            }
                        }
            
            
           
       pane.getChildren().add(Item.ab);
        stage.setScene(sort_item);
        
        });
        
        
        
        
        
        
        
        
        stage.show();

    }
    private void item_find_name(){
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage= new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Find item by name");
        stage.setResizable(false);
        VBox vb = new VBox(15);
        vb.setAlignment(Pos.CENTER);
        Label l = new Label("Find item by name");
        l.setFont(Font.font("System", FontWeight.BOLD, 20));
        l.setTextFill(Color.BLACK);
        Label l2= new Label ("Enter item name you want to search for");
        TextField tf = new TextField();
        Button search = new Button("Search");
        vb.getChildren().addAll(l,l2,tf,search);
        search.disableProperty().bind(tf.textProperty().isEmpty());
        
        Scene scene = new Scene(vb,300,350);
        Pane root = new Pane();
        Scene item_found = new Scene(root,300,350);
        root.getChildren().add(Item.ab);
        Item.ab.setEditable(false);
        stage.setScene(scene);
        search.setOnAction(e->{
            try{
                Doctor doc = (Doctor)phar.person[phar.index];
                doc.find_item_by_name(tf.getText());
                
                stage.setScene(item_found);
                
            
            }
            catch(Doctor.itemNotFoundException er){showError("No such item was found","please try again");}
            
        
        
        });
        
        
    stage.show();
    }
    private void item_find_id(){
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.getIcons().add(icon);
        stage.setTitle("Find item ny ID");
        stage.setResizable(false);
        Label l = new Label("Find item by ID");
        l.setFont(Font.font("System", FontWeight.BOLD, 20));
        l.setTextFill(Color.BLACK);
        Label ll = new Label ("Enter item ID");
        TextField tf = new TextField();
        Button search = new Button("Search");
        VBox vb = new VBox(15);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(l,ll,tf,search);
        Scene scene = new Scene(vb,500,550);
        stage.setScene(scene);
        search.disableProperty().bind(tf.textProperty().isEmpty());
        Pane root = new Pane();
        Scene item_found = new Scene(root,300,350);
        
        search.setOnAction(e->{
            Item.ab.clear();
            Doctor doc = (Doctor)phar.person[phar.index];
            doc.find_item_by_id(tf.getText());
 
            stage.setScene(item_found);
            root.getChildren().add(Item.ab);
        });
        
        stage.show();
        
    
    }
    private void customer_show(){
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Your informations");
        stage.getIcons().add(icon);
        Pane root = new Pane();
        Scene scene = new Scene(root);
        root.getChildren().addAll(Person.get_TextArea());
        stage.setScene(scene);
        stage.show();
        
        
        
    
    
    }
    
    private void customer_items(){
         Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage= new Stage();
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.setTitle("Available items");
        Pane root = new Pane();
        Scene scene = new Scene(root,300,350);
        root.getChildren().add(Item.ab);
        stage.setScene(scene);
        stage.show();
    
    
    }
    private void buy(){
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Stage stage = new Stage();
        stage.setTitle("But item");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        VBox vb =new VBox(15);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb,400,450);
        Label l = new Label("Buy item");
        l.setFont(Font.font("System", FontWeight.BOLD, 20));
        l.setTextFill(Color.BLACK);
        Label name = new Label("Item name:");
        Label count = new Label("amount: ");
        TextField name_field = new TextField();
        TextField count_field = new TextField();
        Button buy = new Button("buy");
        root.add(name,0,0);
        root.add(count,0,1);
        root.add(name_field,1,0);
        root.add(count_field,1,1);
        root.add(buy,1,2);
        vb.getChildren().addAll(l,root);
        
        stage.setScene(scene);
        stage.show();
       // 
        buy.setOnAction(e->{
            try{
            Customer c = (Customer)phar.person[phar.index];
            c.make_order(c.get_name(),name_field.getText(),Integer.parseInt(count_field.getText()));
            stage.close();
            }
            catch(IllegalArgumentException exe){
                showError("invalid input","invalid input");
            }
            catch(Customer.itemBuyError exc){
                showError(exc.getMessage(),exc.getMessage());
            }
            
        
        
        });
        buy.disableProperty().bind(name_field.textProperty().isEmpty().or(count_field.textProperty().isEmpty()));
    
    
    }
    private void customer_cart_stage(){
        Stage stage = new Stage();
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("My orders");
        stage.setResizable(false);
        Pane root = new Pane();
        Scene scene = new Scene(root,300,350);
        stage.setScene(scene);
        root.getChildren().add(Order.t);
        stage.show();
        
    }
    // flages
    private String user_flage;
    private int item_count = 0;
    private static int x=0;
    private static String doctor_name,doctor_pass;
    private static int doctor_age;
    private static double doctor_salary;
    
    
    private void ship_order(){
        Stage stage = new Stage();
         Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
         stage.getIcons().add(icon);
         stage.setTitle("Ship order");
         stage.setResizable(false);
        
         VBox vb = new VBox();
         vb.setAlignment(Pos.CENTER);
         Scene scene = new Scene(vb,300,350);
         Button ship = new Button("Ship");
        
         stage.setScene(scene);
         ComboBox<String> cb = new ComboBox<>();
          vb.getChildren().addAll(Order.t,cb,ship);
         for(int i=0;i<Pharmacy.orders_count_in_pharamcy;i++)
         {
             cb.getItems().add(phar.orders[i].get_order_number());
         }
         if(Pharmacy.orders_count_in_pharamcy==0)Order.t.appendText("Nor orders yet");
         
         Order.t.setEditable(false);
         stage.show();
         ship.setOnAction(e->{
             boolean found=false;
             for(int i=0;i<Pharmacy.orders_count_in_pharamcy;i++)
             {
                 if(cb.getValue().equals(phar.orders[i].get_order_number()))
                 {
                     phar.orders[i].ship_order();
                     cb.getItems().remove(phar.orders[i].get_order_number());
                     stage.close();
                     found=true;
                     break;
                 }
                 
                 
             }
             if(!found)
             showError("somthing went wrong","make sure to choose order");
            
            
             
             
         
         
         });
         
    }
    
    Pharmacy phar = Pharmacy.getInstance();
    //geters
        public static int get_x(){return x;}
        public static String get_doctor_name(){return doctor_name;}
        public static String get_doctor_pass(){return doctor_pass;}
        public static int get_doctor_age(){return doctor_age;}
        public static double get_doctor_salary(){return doctor_salary;}
    
   
    
    @Override
    public void start(Stage stage) {

        stage.setTitle("Pharmacy mangment system");
        Image icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\icon.jpg");
        Image bg = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\bg.png");
        Image male_icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\me.png");
        Image female_icon = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\female.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Image bg2 = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\bgg2.jpg");
        BackgroundImage backgroundImage2 = new BackgroundImage(
                bg2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        GridPane doctor_info_scene = new GridPane();
        // v.setBackground(new Background(backgroundImage));
        doctor_info_scene.setAlignment(Pos.CENTER);
        doctor_info_scene.setPadding(new Insets(10)); // v is the info scene pane
        doctor_info_scene.setHgap(5);
        doctor_info_scene.setVgap(5);
        VBox vv = new VBox();
        vv.setAlignment(Pos.CENTER);
        // vv.setSpacing();

        stage.setResizable(false);
        stage.getIcons().add(icon);
        VBox vb = new VBox(); // vb and hb are the login scene pane
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        // doctor pane
        GridPane dv = new GridPane();
        dv.setAlignment(Pos.CENTER);
        dv.setPadding(new Insets(20));
        dv.setHgap(300);
        dv.setVgap(300);
        dv.setBackground(new Background(backgroundImage2));
        GridPane ev = new GridPane();
        ev.setBackground(new Background(backgroundImage2));
        ev.setAlignment(Pos.CENTER);
        ev.setPadding(new Insets(20));
        ev.setHgap(300);
        ev.setVgap(300);

        GridPane cv = new GridPane();
        cv.setAlignment(Pos.CENTER);
        cv.setPadding(new Insets(20));
        cv.setHgap(300);
        cv.setVgap(300);
        cv.setBackground(new Background(backgroundImage2));

        // customer_info_scene
        GridPane customer_info = new GridPane();
        customer_info.setAlignment(Pos.CENTER);
        customer_info.setPadding(new Insets(10));
        customer_info.setHgap(5);
        customer_info.setVgap(5);
        VBox customer_vb = new VBox();
        customer_vb.setAlignment(Pos.CENTER);
        Label customer_info_label = new Label("Enter your informations");
        customer_info_label.setFont(Font.font("System", FontWeight.BOLD, 20));
        customer_info_label.setTextFill(Color.DARKBLUE);
        Label customer_name = new Label("Name:");
        TextField customer_name_field = new TextField();
        Label customer_age = new Label("Age:");
        TextField customer_age_field = new TextField();
        Label balance = new Label("Balance:");
        TextField customer_balance_field = new TextField();
        Label customer_pass = new Label("Password:");
        PasswordField customer_pass_field = new PasswordField();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup gender = new ToggleGroup();
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        Button customer_submit = new Button("Submit");
        customer_submit.disableProperty().bind( // enable/disable button depending on textfield
                customer_name_field.textProperty().isEmpty()
                        .or(customer_age_field.textProperty().isEmpty())
                        .or(customer_pass_field.textProperty().isEmpty())
                        .or(customer_balance_field.textProperty().isEmpty())
                        .or(gender.selectedToggleProperty().isNull()));
        customer_info.add(male, 2, 1);
        customer_info.add(female, 2, 2);
        customer_info.add(customer_name, 0, 0);
        customer_info.add(customer_name_field, 1, 0);
        customer_info.add(customer_age, 0, 1);
        customer_info.add(customer_age_field, 1, 1);
        customer_info.add(balance, 0, 2);
        customer_info.add(customer_balance_field, 1, 2);
        customer_info.add(customer_pass, 0, 3);
        customer_info.add(customer_pass_field, 1, 3);
        customer_info.add(customer_submit, 1, 4);
        customer_vb.getChildren().addAll(customer_info_label, customer_info);

        Scene customer_info_page = new Scene(customer_vb, 626, 412);
        customer_vb.setBackground(new Background(backgroundImage));
        
        GridPane doctor_relogin = new GridPane();
        doctor_relogin.setVgap(15);
        doctor_relogin.setAlignment(Pos.CENTER);
        VBox relogin_d_vb = new VBox(15);
        relogin_d_vb.setAlignment(Pos.CENTER);
        Scene doctor_re_login = new Scene(relogin_d_vb,626,412);
        relogin_d_vb.setBackground(new Background(backgroundImage));
        
        GridPane customer_re_login = new GridPane();
        customer_re_login.setVgap(15);
        customer_re_login.setAlignment(Pos.CENTER);
        VBox customer_relogin = new VBox(15);
        customer_relogin.setAlignment(Pos.CENTER);
        Scene customer_relogin_scene = new Scene(customer_relogin,626,412);
       customer_relogin.setBackground(new Background(backgroundImage));

        // doctor menu
        MenuBar doctor_menu = new MenuBar();
        Menu add = new Menu("Add");
        Menu remove = new Menu("Remove");
        Menu show = new Menu("Display");
        Menu find = new Menu("Find");
        Menu order = new Menu("Orders");

        MenuItem add_item = new MenuItem("Item");
        add_item.setOnAction(e->{
            
            
        
            item_add_stage();
        });
        

        MenuItem remove_item = new MenuItem("Item");
        remove_item.setOnAction(e->{
            item_remove();
        
        
        });
        
        

        MenuItem show_item = new MenuItem("Items");
       show_item.setOnAction(e->{
           Person.getTextArea_m().clear();
           Doctor doc = (Doctor)phar.person[phar.index];
           doc.display_items();
           
           item_show_stage();
       });

        MenuItem show_self = new MenuItem("My info");
        show_self.setOnAction(e -> {
                    Person.get_TextArea().clear();
                    phar.person[phar.index].display_self();
                    doctor_show_stage();
      
                
                });

        MenuItem show_users = new MenuItem("users");
        show_users.setOnAction(e -> {
            Doctor.sb.clear();
            Doctor doc = (Doctor)phar.person[phar.index];
            doc.Display_Persons();
            users_show_stage();
            
            
        
        });

        MenuItem find_name = new MenuItem("User by name");
        find_name.setOnAction(e->{
            Person.get_TextArea().clear();
            user_find_stage();
            
                
                
                });
        
        //ComboBox<String> items_box = new ComboBox<>();

        MenuItem find_item_name = new MenuItem("Item by name");
        find_item_name.setOnAction(e->{
            Item.ab.clear();
            item_find_name();
            
        
        
        
        });
        

        MenuItem find_item_id = new MenuItem("Item by ID");
        find_item_id.setOnAction(e->{
            Item.ab.clear();
            item_find_id();
        
        
        
        });
    
    
    
        
        
        
        
        
        

        MenuItem ship = new MenuItem("Ship order");
        ship.setOnAction(e->{
            Order.t.clear();
            
            Doctor doc = (Doctor)phar.person[phar.index];
         try{ 
             doc.ship_item();
            ship_order();}
         catch(Capabilities.noItemsToShip er){showError(er.getMessage(),er.getMessage());}
        });

        add.getItems().addAll(add_item);
        remove.getItems().addAll(remove_item);
        show.getItems().addAll(show_users, show_self, show_item);
        doctor_menu.getMenus().addAll(add, remove, show, find, order);
        find.getItems().addAll(find_name, find_item_name, find_item_id);
        order.getItems().addAll(ship);
        BorderPane doctor_pane = new BorderPane();
        doctor_pane.setTop(doctor_menu);
        doctor_pane.setCenter(dv);
        
        
        
        
  
        // customer menu
        MenuBar customer_menu = new MenuBar();
        Menu items = new Menu("items");
        Menu cart = new Menu("My orders");
        MenuItem items_av = new MenuItem("Available items");
        items_av.setOnAction(e->{
            Item.ab.clear();
            if(Pharmacy.item_count_in_pharmacy==0)Item.ab.appendText("No items available!");
            
            else{
     
            for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
                        phar.items[i].Displayinfo();
                    }
            
            
            }
        customer_items();
        Item.ab.setEditable(false);
        
        });
    

        
        
        items.getItems().addAll(items_av);
        MenuItem my_cart = new MenuItem("My cart");
        
        my_cart.setOnAction(e->{
            Order.t.clear();
            customer_cart_stage();
            if(Pharmacy.orders_count_in_pharamcy==0)Order.t.appendText("No orders made yet!");
            else{
            for (int i = 0; i < Pharmacy.orders_count_in_pharamcy; i++) {
                    if (phar.orders[i].get_order_owner().equals(phar.person[phar.index].get_name())) {
                        phar.orders[i].display_order_info();
                    }
                    
                }
            }
        });
        
        
        
        
        MenuItem buy = new MenuItem("buy");
        buy.setOnAction(e->{
            buy();
        
        
        });
        
        cart.getItems().addAll(my_cart, buy);
        customer_menu.getMenus().addAll(items, cart);
        BorderPane customer_pane = new BorderPane();
        customer_pane.setTop(customer_menu);
        customer_pane.setCenter(cv);

        Image cartt = new Image("file:F:\\college\\Junior\\spring 2025\\Prog\\project_pharmacy\\cart.png");
        ImageView mcartt = new ImageView(cartt);
        mcartt.setFitWidth(20);
        mcartt.setFitHeight(20);
       // Label my_balance = new Label();
        //my_balance.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
       
       //my_balance.setText(String.valueOf(());
        //my_balance.setFont(Font.font("System", FontWeight.BOLD, 20));
        //my_balance.setTextFill(Color.BLACK);
        HBox cart_icon = new HBox(5);
       // cart_icon.getChildren().addAll(mcartt, mycart);

        // customer icon
        ImageView male_prof = new ImageView(male_icon);
        male_prof.setFitHeight(30);
        male_prof.setFitWidth(30);
        male_prof.setOnMouseEntered(e -> {

            male_prof.setScaleX(1.1);
            male_prof.setScaleY(1.1);
        });
        male_prof.setOnMouseExited(e -> {

            male_prof.setScaleX(1.0);
            male_prof.setScaleY(1.0);
        });
       /* mcartt.setOnMouseEntered(e -> {

            mcartt.setScaleX(1.4);
            mcartt.setScaleY(1.4);
        });
        mcartt.setOnMouseExited(e -> {

            mcartt.setScaleX(1.0);
            mcartt.setScaleY(1.0);

        });
*/
        male_prof.setOnMouseClicked(e->{
            Person.get_TextArea().clear();
            Customer c =(Customer)phar.person[phar.index];
            c.display_self();
            customer_show();
            
        
        
        });

        Label log = new Label("Login in:");
        ComboBox<String> cb = new ComboBox<>();
        Button signin = new Button("Login");
        hb.getChildren().addAll(log, cb,signin);
                     signin.disableProperty().bind(Bindings.isEmpty(cb.getItems()));
        
        signin.setOnAction(e->{
            String a=cb.getValue();
            if(a.startsWith("D"))stage.setScene(doctor_re_login);
            else if (a.startsWith("C"))stage.setScene(customer_relogin_scene);
            
                    
                    
                    
                    });
        
        
        

        vb.setBackground(new Background(backgroundImage));
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(15);
        Scene login = new Scene(vb, 626, 412);
        Scene doctor_info = new Scene(vv, 626, 412); // docotr_info scene

        Scene doctor_page = new Scene(doctor_pane, 626, 412); // doctor page scene

        // Scene emp_page=new Scene(emp_pane,626,412);
        Scene customer_page = new Scene(customer_pane, 626, 412);
        Label welcome = new Label("Sign in as:");
        welcome.setFont(Font.font("System", FontWeight.BOLD, 20));
        welcome.setTextFill(Color.DARKBLUE);
        Button doctor = new Button("Doctor");
        doctor.setPrefSize(100, 10);

        // Button emp = new Button("Employee");
        // emp.setPrefSize(100, 10);

        Button customer = new Button("Customer");
        customer.setPrefSize(100, 10);
        
        

        vb.getChildren().addAll(welcome, doctor, customer, hb);
        // doctot_info scene code
        Label info_label = new Label("Enter your informations");
        info_label.setFont(Font.font("System", FontWeight.BOLD, 20));
        info_label.setTextFill(Color.DARKBLUE);
        Label name = new Label("Name:");
        Label age = new Label("Age:");
        Label pass = new Label("Password:");
        Label salary = new Label("Salary:");
        TextField salary_field = new TextField();
        PasswordField pass_field = new PasswordField();
        TextField name_field = new TextField();
        TextField age_field = new TextField();
        Button submit = new Button("Submit");

        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        doctor_info_scene.add(name, 0, 0);
        doctor_info_scene.add(name_field, 1, 0);
        doctor_info_scene.add(age, 0, 1);
        doctor_info_scene.add(age_field, 1, 1);
        doctor_info_scene.add(submit, 1, 4);
        doctor_info_scene.add(pass, 0, 2);
        doctor_info_scene.add(pass_field, 1, 2);
        doctor_info_scene.add(salary, 0, 3);
        doctor_info_scene.add(salary_field, 1, 3);

        vv.getChildren().addAll(info_label, doctor_info_scene);
        vv.setBackground(new Background(backgroundImage));

        // doctor page scene
        Label hello = new Label();
        hello.setFont(Font.font("System", FontWeight.BOLD, 15));
        hello.setTextFill(Color.BLACK);

      
        Label user_customer = new Label();
        user_customer.setFont(Font.font("System", FontWeight.BOLD, 15));
        user_customer.setTextFill(Color.BLACK);
        user_customer.setFont(Font.font("System", FontWeight.BOLD, 15));
        user_customer.setTextFill(Color.BLACK);

         
        // BUTTONS ACTION
        doctor.setOnAction(doctorEvent -> {
            stage.setScene(doctor_info);
            user_flage = "doctor";

            System.out.println(user_flage);
            submit.setOnAction(submitEvent -> {
                String agetext = age_field.getText().trim();
                String salarytext = salary_field.getText().trim();
                try {
                    int agee = Integer.parseInt(agetext);
                    int salaryee = Integer.parseInt(salarytext);
                    if (agee <= 0) {
                        showError("Invalid age", "Enter a valid age");
                        return;
                    }
                    if (salaryee < 0) {
                        showError("Invalid salary", "Enter a valid salary");
                        return;
                    }
cb.getItems().add("Doctor: "+name_field.getText());

                         phar.person[Pharmacy.persons_count_in_pharamcy++] = new Doctor(name_field.getText(), Integer.parseInt(age_field.getText()), Double.parseDouble(salary_field.getText()), pass_field.getText());
                    phar.index = Pharmacy.persons_count_in_pharamcy-1;
                    stage.setScene(doctor_page);
                    hello.setText("Hello DR/" + phar.person[phar.index].get_name());
                    
                    name_field.clear();
                    age_field.clear();
                    pass_field.clear();
                    salary_field.clear();
                    
                   
                    
                   
      
                } catch (NumberFormatException ex) {
                    showError("Invalid age/salary", "Enter a valid age/salary");
                }

            });
        });

        customer.setOnAction(e -> {
            stage.setScene(customer_info_page);
            user_flage = "customer";
        

            System.out.println(user_flage);

            customer_submit.setOnAction(submitEvent -> {
                                    String agetext2 = customer_age_field.getText().trim();
                String balancetext2 = customer_balance_field.getText().trim();
                try {
                    int agee = Integer.parseInt(agetext2);
                    int balancee = Integer.parseInt(balancetext2);
                    if (agee <= 0) {
                        showError("Invalid age", "Enter a valid age");
                        return;
                    }
                    if (balancee < 0) {
                        showError("Invalid Balance", "Enter a valid Balance value");
                        return;
                    }

                    stage.setScene(customer_page);
                     Toggle selectedToggle = gender.getSelectedToggle();  
        RadioButton select = (RadioButton)selectedToggle;
        char ge = select.getText().charAt(0);
        
                              phar.person[Pharmacy.persons_count_in_pharamcy++] = new Customer(customer_name_field.getText(), Integer.parseInt(customer_age_field.getText()), ge,                    Double.parseDouble(customer_balance_field.getText()),customer_pass_field.getText());
                    phar.index=Pharmacy.persons_count_in_pharamcy-1;
                    cb.getItems().add("Customer: "+customer_name_field.getText());
                    user_customer.setText("welcome " + phar.person[phar.index].get_name());
                    customer_name_field.clear();
                    customer_age_field.clear();
                    customer_pass_field.clear();
                    customer_balance_field.clear();
                    System.out.println(ge);
                    

                } catch (NumberFormatException ex) {
                    showError("Invalid age/balance", "Enter a valid age/balance");
                }

            });
        });
        //re_login page
        //doctor
        Label relogin_doctor = new Label("welcome back");
        relogin_doctor.setFont(Font.font("System", FontWeight.BOLD, 20));
        relogin_doctor.setTextFill(Color.DARKBLUE);
        Label id = new Label("ID:");
        Label passs= new Label("Password:");
        TextField id_field = new TextField();
        TextField passs_field = new TextField();
        Button doctor_relogin_ok = new Button("Submit");
        doctor_relogin.add(id,0,0);
        doctor_relogin.add(id_field,1,0);
        doctor_relogin.add(passs,0,1);
        doctor_relogin.add(passs_field,1,1);
        relogin_d_vb.getChildren().addAll(relogin_doctor,doctor_relogin,doctor_relogin_ok);
       
        doctor_relogin_ok.setOnAction(e->{
             
                
                boolean found=false;
                for (int i = 0; i < Pharmacy.persons_count_in_pharamcy; i++) {
                    if (phar.person[i] instanceof Doctor) {
                        Doctor d = (Doctor) phar.person[i];
                        if (d.get_id().equals(id_field.getText()) && d.check_pass(passs_field.getText())) {
                           // d.main_menu();
                           System.out.println("pass"+d.get_name());
                           stage.setScene(doctor_page);
                           //name_field.setText(d.get_name());
                           hello.setText("Welcome back DR/ "+d.get_name());
                            found=true;
                            phar.index=i;
                            break;
                        }
                    }
                }
                if(!found){
                System.out.println("Invalid Id or Password.");
                
                showError("Invalid ID or password !", "Please try again");
                
                }
                
            
        
        
        });
        
        
        //customer
        Label relogin_customer = new Label("welcome");
        relogin_customer.setFont(Font.font("System", FontWeight.BOLD, 20));
        relogin_customer.setTextFill(Color.DARKBLUE);
        Label enter_name = new Label ("Name:");
        Label enter_pass = new Label ("Password:");
        TextField re_name_field = new TextField();
        TextField re_pass_field = new TextField();
        Button re_submit = new Button("Submit");
        
        customer_re_login.add(enter_name,0,0);
        customer_re_login.add(re_name_field,1,0);
        customer_re_login.add(enter_pass,0,1);
        customer_re_login.add(re_pass_field,1,1);
        customer_relogin.getChildren().addAll(relogin_customer,customer_re_login,re_submit);
        
        re_submit.setOnAction(e->{
             
        if (Customer.get_number_of_customers() <= 0) {
            System.out.println("There is No Customers in The Pharmacy currently");
        } else {
            
                boolean found=false;
                for (int i = 0; i < Pharmacy.persons_count_in_pharamcy; i++) {
                    if (phar.person[i] instanceof Customer) {
                        Customer temp_customer = (Customer) phar.person[i];
                        if (temp_customer.get_name().equals(re_name_field.getText()) && temp_customer.check_pass(re_pass_field.getText())) {
                            //customer.main_menu();
                            System.out.println("pass");
                            //customer_name_field.setText(temp_customer.get_name());
                            user_customer.setText("Welcome back "+temp_customer.get_name());
                            stage.setScene(customer_page);
                            found=true;
                            phar.index=i;
                            System.out.println(phar.person[phar.index].get_name());
                            break;
                           
                        }

                    }

                }
                
                if(!found){
                    System.out.println("Invalid Name or Password.");
                    
                    showError("Invalid Name or password !", "Please try again");
                }

               
            
        }
        
        });
        
        
        // logout button
        Button log_out_doctor = new Button("Log out");
        log_out_doctor.setOnAction(e -> stage.setScene(login));
        Button log_out_emp = new Button("Log out");
        log_out_emp.setOnAction(e -> stage.setScene(login));
        Button log_out_customer = new Button("Log out");
        log_out_customer.setOnAction(e -> stage.setScene(login));

        submit.disableProperty().bind( // enable/disable button depending on textfield
                name_field.textProperty().isEmpty()
                        .or(age_field.textProperty().isEmpty()).or(pass_field.textProperty().isEmpty())
                        .or(salary_field.textProperty().isEmpty()));

        // doctor stuff

        dv.add(hello, 0, 0);
        dv.add(log_out_doctor, 1, 1);
        
        

        // customer stuff
        HBox icon_hb = new HBox(5);

        icon_hb.getChildren().addAll(male_prof, user_customer);

        cv.add(log_out_customer, 1, 1);
        cv.add(cart_icon, 1, 0);
        cv.add(icon_hb, 0, 0);

        stage.setScene(login);
        stage.show();
        
    }
   
    
    
    
    

    public static void main(String[] args) {

        // Pharmacy phar = Pharmacy.getInstance();
        // phar.menu();
        launch(args);
    }

}
