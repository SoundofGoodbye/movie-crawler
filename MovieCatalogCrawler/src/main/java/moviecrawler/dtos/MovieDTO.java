package moviecrawler.dtos;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private String title;

    public MovieDTO() {
    }

    public MovieDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
