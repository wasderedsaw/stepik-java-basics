public class IllegalPackageException extends RuntimeException {
    public IllegalPackageException(String message) {
        super(message);
    }
    public IllegalPackageException() {
        super("");
    }
}
