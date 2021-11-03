package Phase1.States;

import Phase1.UserActions.Actions;
import Phase1.UserActions.Back;


/**
 * Represents the state where the User can view and edit their profile.
 */
public class SelfProfile extends State{

    public SelfProfile(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String a){
        if (a.equals(BACK)){
            return new LoggedIn();
        }
        return this;
    }
}
