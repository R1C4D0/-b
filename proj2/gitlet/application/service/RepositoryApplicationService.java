package gitlet.application.service;

import gitlet.Interfaces.req.CommandRequest;
import gitlet.domain.model.Repository;
import gitlet.domain.service.Impl.RepositoryDomainServiceImpl;
import gitlet.domain.service.RepositoryDomainService;
import gitlet.enums.ErrorMessage;
import gitlet.infrastructure.Utils.Utils;

public class RepositoryApplicationService {

    private final RepositoryDomainService repositoryDomainService = new RepositoryDomainServiceImpl();

    /**
     * Initializes a new repository.
     * if a repository already exists, it will exit with an error message.
     *
     * @param commandRequest the command line arguments.
     */
    public void initRepository(CommandRequest commandRequest) {
        if (repositoryDomainService.repoExists()) {
            MainApplicationService.exitWithError(ErrorMessage.INIT_REPEATED.getMessage());
        }
        repositoryDomainService.setupPersistence();
    }

    public void addFile(String[] args) {
        // TODO: handle the `add [filename]` command
    }
}
