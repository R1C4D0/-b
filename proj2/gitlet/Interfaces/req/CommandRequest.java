package gitlet.Interfaces.req;

import gitlet.application.service.MainApplicationService;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.enums.CommandType;
import gitlet.enums.ErrorMessage;
import gitlet.infrastructure.repositoryImpl.RepositoryRepositoryImpl;

public class CommandRequest {
    private final String[] commandAndOperands;
    private final CommandType commandType;

    /**
     * Creates a VALID command request, containing valid command and correct number of operands.
     * The program will exit with an error message if the command is invalid or operands are incorrect.
     *
     * @param args Like <COMMAND> <OPERAND1> <OPERAND2> ...
     */
    public CommandRequest(String[] args) {
        validateArgs(args);
        this.commandAndOperands = args;
        commandType = CommandType.fromString(args[0]);
        validateCommandType(commandType);
    }

    /**
     * @return the command and its operands.
     */
    public String[] getCommandAndOperands() {
        return commandAndOperands;
    }

    /**
     * @return the operands of the command.
     * If the command has no operands, it will return null.
     */
    public String[] getOperands() {
        if (commandAndOperands.length <= 1) {
            return null;
        }
        String[] operands = new String[commandAndOperands.length - 1];
        System.arraycopy(commandAndOperands, 1, operands, 0, operands.length);
        return operands;
    }

    /**
     * @return the length of the command.
     */
    public int length() {
        return commandAndOperands.length;
    }

    /**
     * @return the command type.
     */
    public CommandType getCommandType() {
        return commandType;
    }

    /**
     * Validates the command arguments。
     * The program will exit with an error message if the command is null or empty.
     */
    private void validateArgs(String[] args) {
        if (args == null || args.length == 0) {
            MainApplicationService.exitWithError(ErrorMessage.NO_COMMAND.getMessage());
        }
    }

    /**
     * Validates the command.
     * The program will exit with an error message if the command is invalid or the number of operands is incorrect.
     */
    private void validateCommandType(CommandType commandType) {
        RepositoryRepository repoRepository = new RepositoryRepositoryImpl();

        if (this.commandType == null) {
            MainApplicationService.exitWithError(ErrorMessage.UNKNOWN_COMMAND.getMessage());
        }
        if (!this.commandType.equals(CommandType.INIT) && !repoRepository.repoExists()) {
            MainApplicationService.exitWithError(ErrorMessage.NOT_INITIALIZED.getMessage());
        }
        if (this.commandType.equals(CommandType.INIT) && repoRepository.repoExists()) {
            MainApplicationService.exitWithError(ErrorMessage.INIT_REPEATED.getMessage());
        }
        commandType.validateOperands(getOperands());
    }
}
