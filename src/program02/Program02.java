package program02;

/**
 *
 * @author Ahmed El-Torky
 */
public class Program02 {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controllerTwo = new Controller(model, view);
        view.setVisible(true);
    }

}
