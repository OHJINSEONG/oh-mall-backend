package com.example.ohmall.models.vo.User;

import com.example.ohmall.exceptions.InvalidName;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class UserName {
    private String value;

    public UserName() {
    }

    public UserName(String value) {
        if (!isValidName(value)) {
            throw new InvalidName(value);
        }
        this.value = value;
    }

    private boolean isValidName(String value) {
        return value.length() < 10 && value.length() > 3;
    }

    public String value() {
        return value;
    }

    public void delete() {
        this.value = null;
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object other) {
        return other != null &&
                other.getClass().equals(UserName.class) &&
                ((UserName) other).value.equals(this.value);
    }

    @Override
    public String toString() {
        return "UserName value: " + value;
    }
}
