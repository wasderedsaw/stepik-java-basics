public class StolenPackageException extends RuntimeException{
    public StolenPackageException(String message) {
        super(message);
    }
    public StolenPackageException() {
        super("");
    }
}
