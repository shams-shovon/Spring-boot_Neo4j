package com.nip.cdranalysis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nip.cdranalysis.model.Source;
import com.nip.cdranalysis.service.impl.SourceServiceImpl;

@RestController
@RequestMapping("/sources")
public class SourceController {

    private SourceServiceImpl sourceServiceImpl;

    public SourceController(SourceServiceImpl sourceServiceImpl) {
        super();
        this.sourceServiceImpl = sourceServiceImpl;
    }

    @GetMapping
    public Iterable<Source> findAll() {
        return sourceServiceImpl.getAllSources();
    }


    @GetMapping("/{name}")
    public Source getSourceByName(@PathVariable String name) {
        return sourceServiceImpl.getSourceByName(name);
    }
}
