package com.fierastudio.linktracker.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class ShortenURL {
    public String generate(){
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
