package program02;

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
        this.view.addSubmitListener(new SubmitListener());
        this.view.addSearchListener(new SearchListener());
        this.view.addLoginListener(new LoginListener());
    }

    class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.addNewUser(view.getUserNameSignUp(), view.getPassOne(), view.getPassTwo(), view.getMail(), view.getPhone(), view.getGender())) {
                    view.Message("Done");
                } else {
                    view.Message("Failed");
                }
            } catch (IOException ex) {
                view.Message("Error !!!");
            }
        }
    }

    class SearchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.searchUser(view.getUserNameSearch())) {
                    view.Message("User Found");
                } else {
                    view.Message("User Not Found");
                }
            } catch (IOException ex) {
                view.Message("Error !!!");
            }
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.searchUser(view.getUserNameLogin()) && model.checkPass(view.getPassLogin())) {
                    view.Message("You Are Loged In");
                } else {
                    view.Message("Login Failed");
                }
            } catch (IOException ex) {
                view.Message("Error !!!");
            }
        }
    }

}
