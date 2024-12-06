package gitlet.domain.repository;

import gitlet.domain.model.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static gitlet.infrastructure.Utils.Utils.join;

public interface RepositoryRepository {

    /**
     * @return a collection of all the subdirectories in the .gitlet directory.
     */
    default Collection<File> getRepoSubdirectories() {
        return Arrays.stream(RepositoryDirectory.values())
                .map(dir -> new File(String.join(getRepositoryDirectory().getAbsolutePath(), dir.getDirName())))
                .collect(Collectors.toList());
    }

    /**
     * @return the location where the repository is persisted.
     */
    default File getRepoLocation() {
        return join(Repository.GITLET_DIR, "repository");
    }

    void save(Repository repository);

    Repository find();

    void delete();

    default File getRepositoryDirectory() {
        return new File(".gitlet");
    }

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
