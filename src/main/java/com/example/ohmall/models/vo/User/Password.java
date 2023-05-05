package com.example.ohmall.models.vo.User;

import com.example.ohmall.exceptions.InvalidName;
import com.example.ohmall.exceptions.InvalidPassword;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Password {
    private String value;

    public Password() {
    }

    public Password(String value) {
        if (!isValidPassWord(value)) {
            throw new InvalidPassword(value);
        }
        this.value = value;
    }

    private boolean isValidPassWord(String value) {
        return value.length() < 10 && value.length() > 0;
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
                other.getClass().equals(Password.class) &&
                ((Password) other).value.equals(this.value);
    }

    @Override
    public String toString() {
        return "Password value: " + value;
    }
}
