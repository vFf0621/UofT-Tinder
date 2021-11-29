package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.ProfileView;
import phase2.presenters.RegistrationView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.ProfileCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ProfileController {

    DataAccessInterface db;
    Stage stage;
    int id;
    Map<String, TextInputControl> inputs;
    EventHandler<ActionEvent> event;
    final public static String[] VALID_MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"};

    public ProfileController(DataAccessInterface db, Stage stage,
                             int id){
        this.db = db;
        this.stage = stage;
        this.id = id;
    }

    public Map<String, String> getUserInfo(){
        Map<String, String> info = new HashMap<>();
        info.put("firstNameL", db.getFirstName(id));
        info.put("lastNameL", db.getLastName(id));
        info.put("birthdayL", db.getBirthday(id));
        info.put("imgPathL", db.getImgPath(id));
        info.put("genderL", db.getGender(id));
        info.put("genderPrefL", db.getGenderPreference(id));
        info.put("usernameL", db.getUsername(id));
        info.put("bioL", db.getBio(id));
        info.put("passwordL", db.getPassword(id));
        return info;
    }

    public EventHandler<ActionEvent> back(){
        event = e -> {
            View view = new SwipeView(db, stage, id, null);
            view.build();
        };
        return event;
    }

    public EventHandler<ActionEvent> save(Map<String, TextInputControl> inputs){
        event = e -> {
            this.inputs = inputs;
            boolean[] errors = {false, false};
            String[] info = new String[9];
            info[0] = inputs.get("firstNameT").getText();
            info[1] = inputs.get("lastNameT").getText();
            info[2] = inputs.get("birthdayT").getText();
            info[3] = inputs.get("imgPathT").getText();
            info[4] = inputs.get("genderT").getText();
            info[5] = inputs.get("genderPrefT").getText();
            info[6] = inputs.get("usernameT").getText();
            info[7] = inputs.get("bioT").getText();
            info[8] = inputs.get("passwordT").getText();
            ProfileCase profileCase = new ProfileCase(db);
            if(!profileCase.checkValidDate(info[2])){
                errors[0] = true;
            }
            try{
                new FileInputStream(info[3]);
            }
            catch(FileNotFoundException io){
                errors[1] = true;
            }
            if(errors[0] || errors[1]){
                View view = new ProfileView(db, stage, id, errors);
                view.build();
            }
            else{
                profileCase.updateUser(id, info);
                View view = new SwipeView(db, stage, id, null);
                view.build();
            }
        };
        return event;
    }




}
