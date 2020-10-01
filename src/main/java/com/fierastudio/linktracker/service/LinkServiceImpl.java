package com.fierastudio.linktracker.service;

import com.fierastudio.linktracker.dto.ReportDTO;
import com.fierastudio.linktracker.entity.Link;
import com.fierastudio.linktracker.entity.LinkAccess;
import com.fierastudio.linktracker.helper.ShortenURL;
import com.fierastudio.linktracker.repository.LinkAccessRepository;
import com.fierastudio.linktracker.repository.LinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService{
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private LinkAccessRepository linkAccessRepository;

    @Autowired
    private ShortenURL shortenURL;

    @Override
    public Link create(String url, String password) {
        UrlValidator urlValidator = new UrlValidator();
        Link link = null;

        if(urlValidator.isValid(url)){
            link = new Link(url, password, shortenURL.generate());
            linkRepository.save(link);
        }

        return link;
    }

    @Override
    public Link hit(String sLink){
        Link link = linkRepository.findByLink(sLink);
        if(link != null){
            linkAccessRepository.save(new LinkAccess(link));
        }
        return link;
    }

    @Override
    public List<ReportDTO> report(String sLink){
        Link link = linkRepository.findByLink(sLink);
        if(link != null){
            return linkAccessRepository.findAllByLinkGroupByDate(link);
        }
        return new ArrayList<>();
    }

    @Override
    public Link invalidate(String sLink){
        Link link = linkRepository.findByLink(sLink);
        if(link != null){
            link.setValid(Boolean.FALSE);
            linkRepository.save(link);
        }
        return link;
    }
}
