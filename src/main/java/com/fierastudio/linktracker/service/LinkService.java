package com.fierastudio.linktracker.service;

import com.fierastudio.linktracker.entity.Link;
import com.fierastudio.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface LinkService {
    public Link create(String url, String password);

    public Link hit(String sLink);

    public Link invalidate(String sLink);
}
