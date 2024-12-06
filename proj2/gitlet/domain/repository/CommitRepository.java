package gitlet.domain.repository;

import gitlet.domain.model.Commit;

public interface CommitRepository {
    /**
     * Save the initial commit to the repository
     * @param initialCommit
     */
    void saveCommit(Commit initialCommit);
}
