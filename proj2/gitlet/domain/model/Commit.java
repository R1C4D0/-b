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

    public Commit(String message) {
        this.message = message;
    }

}
