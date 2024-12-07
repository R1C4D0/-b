package gitlet.domain.repository;

import gitlet.domain.model.Repository;
import gitlet.infrastructure.Exception.GitletException;

import java.io.File;
import java.util.Collection;

public interface RepositoryRepository {

    /**
     * @return the GITLET_DIR
     */
    File getGitletDir();

    /**
     * @return a collection of all the subdirectories in the .gitlet directory.
     */
    Collection<File> getRepoSubdirectories();

    /**
     * @return the persisted repository
     */
    Repository getPersistedRepo();

    void save(Repository repository);

    Repository find();

    void delete();

    /**
     * @return the repository directory
     */
    File getRepositoryDirectory();

    /**
     * @return true if the repository exists, false otherwise.
     */
    default boolean repoExists() {
        return getGitletDir().exists();
    }


    /**
     * Initializes a new repository in the current directory CWD.
     * Creates the .gitlet directory and other necessary subdirectories.
     *
     * @return the newly created repository.
     * @throws GitletException if the repository Initialization fails or if the repository already exists.
     */
    Repository initRepository() throws GitletException;

    /**
     * Enum representing the directories in the .gitlet directory.
     */
    enum RepositoryDirectory {
        STAGING("staging"),
        COMMITS("commits"),
        BRANCHES("branches"),
        HEADS("heads"),
        BLOBS("blobs");

        private final String dirName;

        RepositoryDirectory(String dirName) {
            this.dirName = dirName;
        }

        public String getDirName() {
            return dirName;
        }
    }
}
