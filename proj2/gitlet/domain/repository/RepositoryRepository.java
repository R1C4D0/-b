package gitlet.domain.repository;

import gitlet.domain.model.Repository;

public interface RepositoryRepository {
    void save(Repository repository);
    Repository find();
    void delete();
}
