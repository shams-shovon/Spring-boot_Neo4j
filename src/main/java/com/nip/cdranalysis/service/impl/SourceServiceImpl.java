package com.nip.cdranalysis.service.impl;

import org.springframework.stereotype.Service;

import com.nip.cdranalysis.model.Source;
import com.nip.cdranalysis.repository.SourceRepository;
import com.nip.cdranalysis.service.SourceService;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {

    private SourceRepository sourceRepository;

    public SourceServiceImpl(SourceRepository sourceRepository) {
        super();
        this.sourceRepository = sourceRepository;
    }

    @Override
    public Iterable<Source> findAll() {

        // TODO Auto-generated method stub
        return sourceRepository.findAll();
    }

    @Override
    public Source getSourceByName(String name) {
        // TODO Auto-generated method stub
        return sourceRepository.getSourceByName(name);
    }

    @Override
    public List<Source> getAllSources() {
        return sourceRepository.getAllSources();
    }

}
