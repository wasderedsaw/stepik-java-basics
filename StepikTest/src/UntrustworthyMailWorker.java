public class UntrustworthyMailWorker implements MailService {

    private MailService[] mailServices;
    private RealMailService realMailService;

    public UntrustworthyMailWorker(MailService[] mailServices){
        realMailService = new RealMailService();
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (int i = 0; i < mailServices.length; i++) {
            mail = mailServices[i].processMail(mail);
        }
        return getRealMailService().processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
