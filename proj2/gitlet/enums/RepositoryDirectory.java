package gitlet.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Enum representing the directories in the .gitlet directory.
 */
public enum RepositoryDirectory {
    STAGING("staging"),
    COMMITS("commits"),
    BRANCHES("branches"),
    HEADS("heads"),
    BLOBS("blobs");

    private final String dirName;

    RepositoryDirectory(String dirName) {
        this.dirName = dirName;
    }

    public static List<String> getAllDirectoryNames() {
        return Arrays.stream(values())
                .map(RepositoryDirectory::getDirName)
                .collect(Collectors.toList());
    }

    public String getDirName() {
        return dirName;
    }
}
