package gitlet.application.service;

import gitlet.enums.ErrorMessage;
import gitlet.infrastructure.Utils.Utils;

public class MainApplicationService {

    public static void exitWithError(String message) {
        Utils.exitWithError(ErrorMessage.NO_COMMAND.getMessage());
    }

}
