package project.infrastructure.utils;

import jakarta.inject.Named;

@Named
public class Encryption {

    public String encode(CharSequence rawPassword) {
        return "encrypted string";
    }
}
