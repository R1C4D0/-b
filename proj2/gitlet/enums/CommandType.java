package gitlet.enums;

import gitlet.application.service.MainApplicationService;

public enum CommandType {
    INIT("init", 0),
    ADD("add", 1),
    COMMIT("commit", 1),
    RM("rm", 1),
    LOG("log", 0),
    GLOBAL_LOG("global-log", 0),
    FIND("find", 1),
    STATUS("status", 0),
    CHECKOUT("checkout", -1) {
        @Override
        public void validateOperands(String[] operands) {
            if (operands == null || operands.length < 1 || operands.length > 3) {
                MainApplicationService.exitWithError(ErrorMessage.INCORRECT_OPERANDS.getMessage());
            }
        }
    },
    BRANCH("branch", 1),
    RM_BRANCH("rm-branch", 1),
    RESET("reset", 1),
    MERGE("merge", 1),
    ADD_REMOTE("add-remote", 2),
    RM_REMOTE("rm-remote", 1),
    PUSH("push", 2),
    PULL("pull", 2),
    FETCH("fetch", 2),
    CLONE("clone", 1),
    HELP("help", 0),
    QUIT("quit", 0);

    private final String command;
    /**
     * The number of operands required for the command. -1 mean
     */
    private final int requiredOperands;

    CommandType(String command, int requiredOperands) {
        this.command = command;
        this.requiredOperands = requiredOperands;
    }

    /**
     * @param command the command to be converted to CommandType.
     * @return the CommandType of the command, or null if the command is invalid.
     */
    public static CommandType fromString(String command) {
        if (command == null) {
            return null;
        }
        for (CommandType c : CommandType.values()) {
            if (c.getCommand().equals(command)) {
                return c;
            }
        }
        return null;
    }

    public String getCommand() {
        return command;
    }

    /**
     * validate the number of operands for the command.
     * default implementation only validates the number of operands, special commands can override this method.
     *
     * @param operands the operands of the command.
     */
    public void validateOperands(String[] operands) {
        int actualOperands = (operands == null) ? 0 : operands.length;
        if (requiredOperands != -1 && actualOperands != requiredOperands) {
            MainApplicationService.exitWithError(ErrorMessage.INCORRECT_OPERANDS.getMessage());
        }
    }
}
