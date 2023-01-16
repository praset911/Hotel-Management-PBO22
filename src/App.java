import GUI.HomePageFrame;
import model.KamarModel;
import model.StaffModel;

public class App {
    public static void main(String[] args) {
        StaffModel.initialStaff();
        KamarModel.initialKamar();
//        new LoginController().toView();
        new HomePageFrame();
    }
}