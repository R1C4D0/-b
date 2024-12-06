package gitlet.domain.service;

import gitlet.domain.model.Repository;
import gitlet.infrastructure.Exception.GitletException;

public interface RepositoryDomainService {

    /**
     * @return true if the repository exists, false otherwise.
     */
    default boolean repoExists() {
        return Repository.GITLET_DIR.exists();
    }

    /**
     * Initializes a new repository in the current directory CWD.
     * Creates the .gitlet directory and other necessary subdirectories.
     *
     * @return the newly created repository.
     * @throws GitletException if the repository Initialization fails or if the repository already exists.
     */
    Repository initRepository() throws GitletException;
}
