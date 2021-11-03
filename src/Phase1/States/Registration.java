package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.LogIn;


/**
 * Represents the state where the User can register an account in our database.
 */
public class Registration extends State{

    public Registration(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(Action a){
        if (a instanceof LogIn){
            return new LoggedIn();
        }
        return this;
    }
}
