public class Inspector implements MailService {

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) {
            return mail;
        }
        MailPackage copy = (MailPackage) mail;
        if (copy.getContent().getContent().contains("stones")) {
            throw new StolenPackageException("");
        }
        if (copy.getContent().getContent().contains(WEAPONS) || copy.getContent().getContent().contains(BANNED_SUBSTANCE)) {
            throw new IllegalPackageException("");
        }
        return mail;
    }
}
