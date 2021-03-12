package filesapi.domain;

import java.util.List;

public class Code {
    private List<Integer> rgba;
    private String hex;

    public List<Integer> getRgba() {
        return rgba;
    }

    public void setRgba(List<Integer> rgba) {
        this.rgba = rgba;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
