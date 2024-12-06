package gitlet.domain.factory;

import gitlet.domain.model.Branch;
import gitlet.domain.model.Commit;
import gitlet.domain.model.Repository;

import java.util.HashSet;
import java.util.Set;

public class RepositoryFactory {

    /**
     * @return the INITIAL repository, which contains an INITIAL branch.
     */
    public static Repository createInitialRepository() {
        Branch master = Branch.createInitialBranch();
        Set<Branch> initialMaster = new HashSet<>();
        initialMaster.add(master);
        Repository repository = new Repository();
        repository.setHeads(initialMaster);
        return repository;
    }
}
