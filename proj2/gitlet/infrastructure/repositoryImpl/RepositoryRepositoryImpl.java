package gitlet.infrastructure.repositoryImpl;

import gitlet.domain.factory.RepositoryFactory;
import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.enums.ErrorMessage;
import gitlet.infrastructure.Exception.GitletException;
import gitlet.infrastructure.Utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static gitlet.infrastructure.Utils.Utils.join;


public class RepositoryRepositoryImpl implements RepositoryRepository {
    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    private static final File GITLET_DIR = join(CWD, ".gitlet");

    private static final File REPOSITORY_DIR = join(GITLET_DIR, "repository");


    @Override
    public File getGitletDir() {
        return GITLET_DIR;
    }

    @Override
    public Collection<File> getRepoSubdirectories() {
        return Arrays.stream(RepositoryDirectory.values())
                .map(dir -> new File(String.join(getRepositoryDirectory().getAbsolutePath(), dir.getDirName())))
                .collect(Collectors.toList());

    }

    @Override
    public Repository getPersistedRepo() {
        return Utils.readObject(getRepositoryFile(), Repository.class);
    }

    private File getRepositoryFile() {
        return REPOSITORY_DIR;
    }

    @Override
    public void save(Repository repository) {
        Utils.writeObject(getRepositoryFile(), repository);
    }

    @Override
    public void delete() {
        Utils.restrictedDelete(getGitletDir());
    }

    @Override
    public File getRepositoryDirectory() {
        return null;
    }


    @Override
    public void initRepository() throws GitletException {
        if (repoExists()) {
            throw new GitletException(ErrorMessage.INIT_REPEATED);
        }
        try {
            createRepoDirectories();
        } catch (IOException e) {
            throw new GitletException(ErrorMessage.INIT_FAILED);
        }

        Repository initialRepository = RepositoryFactory.createInitialRepository();
        save(initialRepository);
    }

    /**
     * Creates all necessary directories for the repository.
     *
     * @throws IOException if the directories cannot be created.
     */
    private void createRepoDirectories() throws IOException {
        try {
            if (!getGitletDir().mkdir()) {
                throw new IOException();
            }
            for (File dir : new RepositoryRepositoryImpl().getRepoSubdirectories()) {
                Path dirPath = Utils.join(getGitletDir(), dir.getName()).toPath();
                Files.createDirectory(dirPath);
            }
        } catch (Exception e) {
            throw new IOException(ErrorMessage.INIT_FAILED.getMessage());
        }
    }
}
