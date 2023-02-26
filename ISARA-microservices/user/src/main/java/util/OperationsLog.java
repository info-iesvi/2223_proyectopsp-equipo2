package util;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class OperationsLog {

    /**
     * Method to keep a record of the users who access the app, which will be saved in a log file.
     * One line is generated for each access.
     *
     * @param opUser    User name
     * @param resource  Requested resource
     * @param operation Operation
     * @param isError   True if it's an error, False if it's not
     * @author Isa & Sara
     */
    public static void generateLogFile(String opUser, String resource, String operation, boolean isError) {
        try {
            // Query the file exists, otherwise create one with the name access.log
            if (!new File("resources/access.log").exists()) {
                FileWriter file = new FileWriter("access.log", true);
                Calendar actualDate = Calendar.getInstance(); // To be able to use the Calendar package

                // Start writing to the file
                file.write("USER: " + opUser
                        + " - DATE: " + actualDate.get(Calendar.DAY_OF_MONTH)
                        + "/" + (actualDate.get(Calendar.MONTH) + 1)
                        + "/" + actualDate.get(Calendar.YEAR)
                        + " - TIME: " + actualDate.get(Calendar.HOUR_OF_DAY)
                        + ":" + actualDate.get(Calendar.MINUTE)
                        + ":" + actualDate.get(Calendar.SECOND)
                        + " - REQUESTED RESOURCE: " + resource
                        + " - OPERATION: " + operation
                        + "\r\n");

                // Close de file
                file.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
