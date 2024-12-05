package gitlet.enums;

public enum ErrorMessage {
    NO_COMMAND("Please enter a command."),
    UNKNOWN_COMMAND("No command with that name exists."),
    NOT_INITIALIZED("Not in an initialized Gitlet directory."),
    INCORRECT_OPERANDS("Incorrect operands."),
    INIT_REPEATED("A Gitlet version-control system already exists in the current directory."),
    INIT_FAILED("Failed to initialize Gitlet directory."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}