package model;

public class Status extends Entidade{
    private int status;

    public Status(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
