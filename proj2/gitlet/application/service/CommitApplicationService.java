package gitlet.application.service;

import gitlet.domain.service.CommitDomainService;
import gitlet.domain.service.Impl.CommitDomainServiceImpl;

public class CommitApplicationService {

    private final CommitDomainService commitDomainService = new CommitDomainServiceImpl();

}
