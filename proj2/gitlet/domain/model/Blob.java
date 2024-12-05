package gitlet.domain.model;

import gitlet.infrastructure.Utils.Utils;

import java.io.File;

public class Blob {
    /* file */
    private File file;
    /* hash */
    private String hash;
    /* version */
    private Integer version;

    public Blob(File file, Integer version) {
        this.file = file;
        this.version = version;
        this.hash = Utils.sha1(Utils.readContents(file), version);
    }

    public File getFile() {
        return file;
    }

    public String getHash() {
        return hash;
    }

    public Integer getVersion() {
        return version;
    }
}
