package gitlet.domain.service;

import gitlet.application.service.MainApplicationService;
import gitlet.domain.model.Commit;
import gitlet.domain.model.Repository;
import gitlet.enums.ErrorMessage;
import gitlet.enums.RepositoryDirectory;
import gitlet.infrastructure.Utils.Utils;

import java.nio.file.Files;
import java.nio.file.Path;

public interface RepositoryDomainService {

    /**
     * Creates all necessary directories for the repository.
     */
    private void createDirectories() {
        try {
            if (!Repository.GITLET_DIR.mkdir()) {
                throw new RuntimeException();
            }

            for (RepositoryDirectory dir : RepositoryDirectory.values()) {
                Path dirPath = Utils.join(Repository.GITLET_DIR, dir.getDirName()).toPath();
                Files.createDirectory(dirPath);
            }
        } catch (Exception e) {
            MainApplicationService.exitWithError(ErrorMessage.INIT_FAILED.getMessage());
        }
    }

    /**
     * @return true if the repository exists, false otherwise.
     */
    default boolean repoExists() {
        return Repository.GITLET_DIR.exists();
    }

    /**
     * Creates the .gitlet directory and other necessary subdirectories.
     * The program will exit with an error message if the directory already exists.
     */
    default void setupPersistence() {
        if (repoExists()) {
            MainApplicationService.exitWithError(ErrorMessage.INIT_REPEATED.getMessage());
        }
        createDirectories();
        Commit initialCommit = new Commit("initial commit");
    }
}
