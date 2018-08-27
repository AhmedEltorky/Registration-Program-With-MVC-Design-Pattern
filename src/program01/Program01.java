package program01;

import java.io.IOException;

/**
 *
 * @author Ahmed El-Torky
 */
public class Program01 {

    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        view.setVisible(true);

        //check the error
//        System.out.println(model.addNewUser("Ahmed Adel", "123", "123"));
//        System.out.println(model.addNewUser("Adel Farghaly", "456", "456"));
//        System.out.println(view.getUserName());
//        System.out.println(view.getFirstPass());
//        System.out.println(view.getSecondPass());
//        System.out.println(view.getFirstPass() == view.getSecondPass());
//        System.out.println(view.getFirstPass().equals(view.getSecondPass()));
//        System.out.println(model.searchUser("samir"));
    }

}
