package Phase1.States;

import static Phase1.UserActions.Actions.*;


/**
 * Represents the state where the User can register an account in our database.
 */
public class Registration implements State {

    public Registration(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String a){
        if (a.equals(LOGIN)){
            return new LoggedIn();
        }
        return this;
    }
}
