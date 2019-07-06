package avaj_launcher;

public class AvajException extends Exception {
    private String errorMessage;

    @Override
    public String getMessage() {
        return "ERROR: " + errorMessage;
    }

    public AvajException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
