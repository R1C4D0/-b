package gitlet.domain.model;

import java.io.Serializable;
import java.util.Set;


/**
 * Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author R1C4RD0
 */
public class Repository implements Serializable {
    /**
     * The heads of all the branches in the repository.
     */
    private Set<Branch> heads;
    /**
     * The current branch.
     */
    private Branch currentBranch;

    public Repository(Branch currentBranch) {
        this.currentBranch = currentBranch;
        this.heads = Set.of(currentBranch);
    }

    public Set<Branch> getHeads() {
        return heads;
    }

    public void setHeads(Set<Branch> heads) {
        this.heads = heads;
    }

    public Branch getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(Branch currentBranch) {
        this.currentBranch = currentBranch;
    }
}
