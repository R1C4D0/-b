package gitlet.domain.service.Impl;

import gitlet.domain.model.Repository;
import gitlet.domain.service.RepositoryDomainService;

public class RepositoryDomainServiceImpl implements RepositoryDomainService {
    @Override
    public boolean repoExists() {
//        check if the repository exists:
        return Repository.GITLET_DIR.exists();
    }

    @Override
    public void setupPersistence() {
//        create the .gitlet directory and the initial commit:
        Repository.GITLET_DIR.mkdir();
        Repository.INITIAL_COMMIT.save();
    }
}
