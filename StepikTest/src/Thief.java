public class Thief implements MailService {

    private int threshold;

    private static int stolenValue = 0;

    public Thief(int threshold) {
        this.threshold = threshold;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) {
            return mail;
        }
        MailPackage copy = (MailPackage) mail;
        if (copy.getContent().getPrice() >= threshold) {
            Package doppel = new Package("stones instead of " + copy.getContent().getContent(), 0);
            MailPackage fixed = new MailPackage(copy.getFrom(), copy.getTo(), doppel);
            stolenValue += copy.getContent().getPrice();
            return (Sendable) fixed;
        }
        return mail;
    }
}
