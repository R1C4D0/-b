package gitlet;

import gitlet.Interfaces.req.CommandRequest;
import gitlet.application.service.MainApplicationService;
import gitlet.application.service.RepositoryApplicationService;
import gitlet.enums.CommandType;
import gitlet.enums.ErrorMessage;

/**
 * Driver class for Gitlet, a subset of the Git version-control system.
 *
 * @author R1C4RD0
 */
public class Main {

    private static final RepositoryApplicationService repositoryApplicationService = new RepositoryApplicationService();

    /**
     * Usage: java gitlet.Main ARGS, where ARGS contains
     * <COMMAND> <OPERAND1> <OPERAND2> ...
     */
    public static void main(String[] args) {
        CommandRequest commandRequest = new CommandRequest(args);
        CommandType commandType = commandRequest.getCommandType();

        switch (commandType) {
            case INIT:
                mapToInit(commandRequest);
                break;
            case ADD:
                mapToAdd(commandRequest);
                break;
            case COMMIT:
                // TODO: FILL THE REST IN
                break;
            case RM:
                // TODO: FILL THE REST IN
                break;
            case LOG:
                break;
            case GLOBAL_LOG:
                break;
            case FIND:
                break;
            case STATUS:
                break;
            case CHECKOUT:
                break;
            case BRANCH:
                break;
            case RM_BRANCH:
                break;
            case RESET:
                break;
            case MERGE:
                break;
            default:
                MainApplicationService.exitWithError(ErrorMessage.UNKNOWN_COMMAND.getMessage());
        }
    }

    private static void mapToInit(CommandRequest commandRequest) {
        repositoryApplicationService.initRepository(commandRequest);
    }

    private static void mapToAdd(CommandRequest command) {
        repositoryApplicationService.addFile(command);
    }
}
