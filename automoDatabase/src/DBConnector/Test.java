package DBConnector;

import javax.swing.JFrame;

public class Test {

    public static void main(String[] args) {

        MasterFrame mFrame = MasterFrame.getInstance();
        JFrame testFrame = new CarSearchFrame();
        DBQuery queryMaker = new DBQuery();

        testFrame.setTitle("Getting There");
        testFrame.setVisible(true);

    }

}
