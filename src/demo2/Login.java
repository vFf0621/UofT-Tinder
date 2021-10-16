package demo2;

import java.util.Scanner;

public class Login {

    Database database;
    Scanner scanner;


    public Login(Database database) {
        this.database = database;
        scanner = new Scanner(System.in);
    }

    /**
     * #TODO finalize this implementation. Should this have sout  and scan (as it is now) or will we have an input/output class?
     * this method prompts the user for information then creates a User for them.
     */
    public void run(){

        String input;

        System.out.println("Would you like to Sign In or Create Account?");
        input = scanner.nextLine();
        CurrentUser loginUser;

        //determine whether they want to sign in or create account.
        if (input == "Create Account") {

            CreateAccount newAcc = new CreateAccount(database.generateUniqueID());
            String username, password;

            //Prompt for username and password.
            System.out.println("Username:");
            username = scanner.nextLine();
            System.out.println("Password");
            password = scanner.nextLine();

            //create the User for to make the CurrentUser.
            //This may be illegal since we are kind of accessing a User object here.
            newAcc.addPassword(password);
            newAcc.addUsername(username);
            loginUser = new CurrentUser(newAcc.generateUser());
        } else {
            //#TODO create a login feature. Probably using information from a Database.
        }

        //Once the user is logged in, we pass them to the ProfileView.(this is red-underlined because the else hasn't been filled in)
        ProfileView profileView = new ProfileView(loginUser);
        profileView.run();

    }

}
