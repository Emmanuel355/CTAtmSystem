import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FinalFiles {
    static final String dataBaseDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    static final String WindowsDatabaseURL = "jdbc:ucanaccess://.\\Datamodel\\AtmDatabase.accdb";
    static final String LinuxDatabaseURL = "jdbc:ucanaccess://Datamodel/AtmDatabase.accdb";

    //To be deleted, Test Account Number -- for production only
    static String testAcc = "ACC97716146626";

    //authorization Signature
    static final String AUTHSIG = "Authorization Granted";
    static final String AUTHSIGFAIL = "Authorization Not Granted";

    //Get the current date
    public static String date(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        return date;
    }

    public static String time(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        return time;
    }
    static final String Date = date();

}
