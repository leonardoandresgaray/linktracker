package com.fierastudio.linktracker.controller;

import com.fierastudio.linktracker.entity.Link;
import com.fierastudio.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestParam(name = "url") String url, @RequestParam(name = "password") String password) {
        Link link = linkService.create(url, password);
        if(link != null){
            return ResponseEntity.ok(link);
        }
        return ResponseEntity.badRequest().body("There URL is malformed");

    }

    @GetMapping("/l/{sLink}")
    void redirect(@PathVariable String sLink, HttpServletResponse response) throws IOException {
        Link link = linkService.hit(sLink);
        if(link != null)
            response.sendRedirect(link.getTarget());
        response.setStatus(404);
    }

    @GetMapping("/stats/{sLink}")
    ResponseEntity<String> stats(@PathVariable String sLink) {
        return ResponseEntity.ok("Stats For: " + sLink);
    }

    @PutMapping("/l/{sLink}")
    ResponseEntity<?> invalidate(@PathVariable String sLink) {
        Link link = linkService.invalidate(sLink);
        if(link != null)
            return ResponseEntity.ok(link);
        return ResponseEntity.badRequest().body("Link does not exist");
    }
}