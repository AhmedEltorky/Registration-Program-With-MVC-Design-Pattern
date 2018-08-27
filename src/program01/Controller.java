package program01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Ahmed El-Torky
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addSignUpListener(new SignupListener());
        this.view.addLoginListener(new LoginListener());
        this.view.addSearchListener(new SearchListener());
    }

    class SignupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.addNewUser(view.getUserName(), view.getFirstPass(), view.getSecondPass())) {
                    view.showMessage("Done");
                } else {
                    view.showMessage("Registration Failed !!!");
                }
            } catch (IOException ex) {
                view.showMessage("Error !!!");
            }
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.searchUser(view.getUserName()) && model.checkPass(view.getFirstPass())) {
                    view.showMessage("You are Logged in");
                } else {
                    view.showMessage("Login Failed");
                }
            } catch (IOException ex) {
                view.showMessage("Error !!!");
            }
        }
    }

    class SearchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.searchUser(view.getUserName())) {
                    view.showMessage("User Found");
                } else {
                    view.showMessage("User Not Found");
                }
            } catch (IOException ex) {
                System.out.println("Error !!!");
            }
        }
    }

}
