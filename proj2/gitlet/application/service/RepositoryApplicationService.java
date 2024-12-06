package gitlet.application.service;

import gitlet.Interfaces.req.CommandRequest;
import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.domain.service.Impl.RepositoryDomainServiceImpl;
import gitlet.domain.service.RepositoryDomainService;
import gitlet.infrastructure.Exception.GitletException;
import gitlet.infrastructure.repositoryImpl.RepositoryRepositoryImpl;

public class RepositoryApplicationService {

    private final RepositoryDomainService repositoryDomainService = new RepositoryDomainServiceImpl();
    private final RepositoryRepository repositoryRepository = new RepositoryRepositoryImpl();

    /**
     * Initializes a new repository, creating the .gitlet directory and the initial commit.
     *
     * @param commandRequest the command line arguments.
     * @throws GitletException if the repository Initialization fails or if the repository already exists.
     */
    public void initRepository(CommandRequest commandRequest) throws GitletException {
        Repository initialRepo = repositoryDomainService.initRepository();
        repositoryRepository.save(initialRepo);
    }

    public void addFile(String[] args) {
        // TODO: handle the `add [filename]` command
    }
}
