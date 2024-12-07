package gitlet.domain.model;

public class Branch {
    private String name;
    private Commit head;

    private Branch(String name, Commit head) {
        this.name = name;
        this.head = head;
    }

    /**
     * @return the INITIAL branch, which has the name "master" and the INITIAL commit
     */
    public static Branch createInitialBranch() {
        return new Branch("master", Commit.createInitialCommit());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getHead() {
        return head;
    }

    public void setHead(Commit head) {
        this.head = head;
    }
}
