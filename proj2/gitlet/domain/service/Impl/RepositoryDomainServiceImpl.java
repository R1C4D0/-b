package gitlet.domain.service.Impl;

import gitlet.domain.factory.RepositoryFactory;
import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.domain.service.RepositoryDomainService;
import gitlet.enums.ErrorMessage;
import gitlet.infrastructure.Exception.GitletException;
import gitlet.infrastructure.Utils.Utils;
import gitlet.infrastructure.repositoryImpl.RepositoryRepositoryImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RepositoryDomainServiceImpl implements RepositoryDomainService {

    private final RepositoryRepository repositoryRepository = new RepositoryRepositoryImpl();

    @Override
    public Repository initRepository() throws GitletException {
        if (repoExists()) {
            throw new GitletException(ErrorMessage.INIT_REPEATED);
        }
        try {
            createRepoDirectories();
        } catch (IOException e) {
            throw new GitletException(ErrorMessage.INIT_FAILED);
        }

        return RepositoryFactory.createInitialRepository();
    }

    /**
     * Creates all necessary directories for the repository.
     *
     * @throws IOException if the directories cannot be created.
     */
    private void createRepoDirectories() throws IOException {
        try {
            if (!repositoryRepository.getGitletDir().mkdir()) {
                throw new IOException();
            }
            for (File dir : new RepositoryRepositoryImpl().getRepoSubdirectories()) {
                Path dirPath = Utils.join(repositoryRepository.getGitletDir(), dir.getName()).toPath();
                Files.createDirectory(dirPath);
            }
        } catch (Exception e) {
            throw new IOException(ErrorMessage.INIT_FAILED.getMessage());
        }
    }


}