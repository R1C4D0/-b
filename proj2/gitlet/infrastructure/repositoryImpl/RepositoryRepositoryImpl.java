package gitlet.infrastructure.repositoryImpl;

import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.infrastructure.Utils.Utils;

import java.io.File;
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


    @Override
    public File getGitletDir() {
        return null;
    }

    @Override
    public Collection<File> getRepoSubdirectories() {
        return Arrays.stream(RepositoryDirectory.values())
                .map(dir -> new File(String.join(getRepositoryDirectory().getAbsolutePath(), dir.getDirName())))
                .collect(Collectors.toList());

    }

    @Override
    public Repository getPersistedRepo() {
        return Utils.readObject(join(getRepositoryDirectory(), "repository"), Repository.class);
    }

    @Override
    public void save(Repository repository) {

    }

    @Override
    public Repository find() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public File getRepositoryDirectory() {
        return null;
    }
}
