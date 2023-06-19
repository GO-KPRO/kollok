package bar.hse.kollok.objects;

public class Task {

    private Integer id;
    private String name;
    private String description;
    private String date;
    private String status;

    public Task(int id, String name, String description, String date, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public void putAll(int id, String name, String description, String date, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
