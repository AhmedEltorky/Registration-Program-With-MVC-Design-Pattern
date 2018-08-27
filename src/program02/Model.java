package program02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Ahmed El-Torky
 */
public class Model {

    private boolean checkPass(String passOne, String passTwo) {
        if (passOne.equals("newpass") || passTwo.equals("newpass")) {
            return false;
        } else {
            return (passOne.equals(passTwo));
        }
    }

    public boolean addNewUser(String userName, String passOne, String passTwo) throws IOException {
        if (!userName.equals("User Name") && !this.searchUser(userName)) {
            if (this.checkPass(passOne, passTwo)) {
                this.addData(userName, passOne);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addNewUser(String userName, String passOne, String passTwo, String mail, String phone, String gender) throws IOException {
        if (!userName.equals("User Name") && !this.searchUser(userName)) {
            if (this.checkPass(passOne, passTwo)) {
                this.addData(userName, passOne, mail, phone, gender);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void addData(String userName, String pass) throws FileNotFoundException, IOException {
        File file = new File("program02.txt");
        if (!file.exists()) {
            Formatter f = new Formatter("program02.txt");
        }
        FileWriter fw = new FileWriter("program02.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(userName);
        pw.println(pass);
        pw.close();
    }

    public boolean searchUser(String userName) throws IOException {
        File f = new File("program02.txt");
        if (!f.exists()) {
            return false;
        } else {
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                if (read.nextLine().equals(userName)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean checkPass(String pass) throws FileNotFoundException {
        File f = new File("program02.txt");
        if (!f.exists()) {
            return false;
        } else {
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                if (read.nextLine().equals(pass)) {
                    return true;
                }
            }
            return false;
        }
    }

    private void addData(String userName, String pass, String mail, String phone, String gender) throws FileNotFoundException, IOException {
        File file = new File("program02.txt");
        if (!file.exists()) {
            Formatter f = new Formatter("program02.txt");
        }
        FileWriter fw = new FileWriter("program02.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(userName);
        pw.println(pass);
        pw.println(mail);
        pw.println(phone);
        pw.println(gender);
        pw.close();
    }

}
