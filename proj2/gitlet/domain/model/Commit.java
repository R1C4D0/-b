package gitlet.domain.model;

import java.util.Date;
import java.util.Map;

/**
 * Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author R1C4RD0
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * The message of this Commit.
     */
    private String message;
    /**
     * The timestamp of this Commit.
     */
    private Date timestamp;
    /**
     * The parent of this Commit.
     */
    private Commit parent;
    /**
     * The hash of this Commit.
     */
    private String hash;
    /* the file names and references to these blobs contained in this commit */
    private Map<String, Blob> blobs;

    public Commit(String message, Commit parent) {
        this.message = message;
        this.parent = parent;
    }

    /**
     * The INITIAL commit contains no files and has the commit message "initial commit" (just
     * like that, with no punctuation).
     * It will have a single branch: master, which initially points to this initial commit,
     * and master will be the current branch.
     * The timestamp for this initial commit will be 00:00:00 UTC, Thursday, 1 January 1970.
     *
     * @return the INITIAL commit
     */
    public static Commit createInitialCommit() {
        Commit initialCommit = new Commit("initial commit", null);
        initialCommit.setTimestamp(new Date(0));
        return initialCommit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Commit getParent() {
        return parent;
    }

    public void setParent(Commit parent) {
        this.parent = parent;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Map<String, Blob> getBlobs() {
        return blobs;
    }

    public void setBlobs(Map<String, Blob> blobs) {
        this.blobs = blobs;
    }

}
