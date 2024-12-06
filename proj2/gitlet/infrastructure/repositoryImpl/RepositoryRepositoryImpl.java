package gitlet.infrastructure.repositoryImpl;

import gitlet.domain.model.Commit;
import gitlet.domain.model.Repository;
import gitlet.domain.repository.RepositoryRepository;
import gitlet.enums.ErrorMessage;

import java.io.File;

import static gitlet.infrastructure.Utils.Utils.exitWithError;
import static gitlet.infrastructure.Utils.Utils.join;


public class RepositoryRepositoryImpl implements RepositoryRepository {


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
