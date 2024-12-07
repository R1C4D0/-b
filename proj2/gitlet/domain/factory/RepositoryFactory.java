package gitlet.domain.factory;

import gitlet.domain.model.Branch;
import gitlet.domain.model.Repository;

public class RepositoryFactory {

    /**
     * @return the INITIAL repository, which contains an INITIAL branch.
     */
    public static Repository createInitialRepository() {
        Branch master = Branch.createInitialBranch();
        Repository repository = new Repository(master);
        return repository;
    }
}
