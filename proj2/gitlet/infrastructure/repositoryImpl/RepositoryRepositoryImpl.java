package gitlet.infrastructure.repositoryImpl;

import gitlet.domain.model.Commit;
import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.enums.ErrorMessage;

import java.io.File;

import static gitlet.infrastructure.Utils.Utils.exitWithError;
import static gitlet.infrastructure.Utils.Utils.join;


public class RepositoryRepositoryImpl implements RepositoryRepository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");


    /**
     * Called only when the repository is initialized.
     * <p>
     * Creates a new Gitlet version-control system in the current directory.
     * This system will automatically start with one commit:
     * a commit that contains no files and has the commit message initial commit (just like that, with no punctuation).
     * It will have a single branch: master,
     * which initially points to this initial commit,
     * and master will be the current branch.
     * The timestamp for this initial commit will be 00:00:00 UTC,
     * Thursday, 1 January 1970 in whatever format you choose for dates
     * <p>
     * In order for Gitlet to work, it will need a place to store old copies of files and other metadata.
     * All of this stuff must be stored in a directory called .gitlet,
     * just as this information is stored in directory .git for the real git system.
     * Most Gitlet commands (except for the init command) only need to work when used from a directory
     * where a Gitlet system has been initialized i.e. a directory that has a .gitlet directory.
     * The files that aren’t in your .gitlet directory
     * (which are copies of files from the repository that you are using and editing,
     * as well as files you plan to add to the repository) are referred to as the files in your working directory.
     */
    public static void setupPersistence() {
//        TODO: implement
        if (repoExists()) {
            exitWithError(ErrorMessage.INIT_REPEATED.getMessage());
        }
        String[] dirs = {"staging", "commits", "branches", "heads", "blobs"};
        for (String dir : dirs) {
            if (!join(GITLET_DIR, dir).mkdir()) {
                exitWithError(ErrorMessage.INIT_FAILED.getMessage());
            }
        }
        Commit initialCommit = new Commit("initial commit");
        initialCommit.save();
    }

    public static boolean repoExists() {
        return GITLET_DIR.exists();
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
}
