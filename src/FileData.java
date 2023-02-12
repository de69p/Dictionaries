public class FileData {
    String path;
    String name;
    int fileSize;
    public FileData(String path, String name, int fileSize) {
        this.path = path;
        this.name = name;
        this.fileSize = fileSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }


}
