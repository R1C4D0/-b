package gitlet.domain.model;

import java.io.File;
import java.util.Set;

import static gitlet.infrastructure.Utils.Utils.join;


/**
 * Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author R1C4RD0
 */
public class Repository {
    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /**
     * The heads of all the branches in the repository.
     */
    private Set<Branch> heads;


    public Set<Branch> getHeads() {
        return heads;
    }

    public void setHeads(Set<Branch> heads) {
        this.heads = heads;
    }

}
