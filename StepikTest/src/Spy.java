import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {

    public static final String AUSTIN_POWERS = "Austin Powers";

    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailMessage)) {
            return mail;
        }
        MailMessage copy = (MailMessage) mail;
        if (copy.getTo().equals(AUSTIN_POWERS) || copy.getFrom().equals(AUSTIN_POWERS)) { //Detected target mail correspondence: from {from} to {to} "{message}"
            logger.log(Level.WARNING, "Detected target mail correspondence: from " + copy.getFrom() + " to " + copy.getTo() + " \"" + copy.getMessage() + "\"");
        } else { //Usual correspondence: from {from} to {to}
            logger.log(Level.INFO, "Usual correspondence: from " + copy.getFrom() + " to " + copy.getTo());
        }
        return mail;
    }
}
