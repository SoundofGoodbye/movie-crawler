package application.models.users;

import java.util.Objects;

public class UserDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(getUsername(), userDTO.getUsername()) &&
                Objects.equals(getPassword(), userDTO.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername(), getPassword());
    }
}
