package concurrency.parallel.example01;


public class ProbeResult {
    public final String name;
    public final String description;
    public final ProbeStatus status;

    private ProbeResult(String name, String description, ProbeStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public static ProbeResult success(String name, String description) {
        return new ProbeResult(name, description, ProbeStatus.OK);
    }

    public static ProbeResult failure(String name, String description) {
        return new ProbeResult(name, description, ProbeStatus.FAIL);
    }

    public static ProbeResult warn(String name, String description) {
        return new ProbeResult(name, description, ProbeStatus.WARN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProbeResult that = (ProbeResult) o;

        if (!name.equals(that.name)) return false;
        if (!description.equals(that.description)) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
