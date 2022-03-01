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
    public List<Source> getSourceByName(String name) {
        // TODO Auto-generated method stub
        return sourceRepository.getSourceByName(name);
    }

    @Override
    public List<Source> getTargetByName(String val) {
        return sourceRepository.getTargetByName(val);
    }

    @Override
    public List<Source> getAllDatas() {
        return sourceRepository.getAllDatas();
    }

    @Override
    public String savaDataMoc() {
        return sourceRepository.savaDataMoc();
    }

    @Override
    public String savaDataMTC() {
        return sourceRepository.savaDataMTC();
    }

    @Override
    public int graphCreate() {
        return sourceRepository.graphCreate();
    }

    @Override
    public double degreeCreate() {
        return sourceRepository.degreeCreate();
    }

    @Override
    public double betweennessCreate() {
        return sourceRepository.betweennessCreate();
    }

    @Override
    public void deleteDetach() {
        sourceRepository.deleteDetach();
    }

    @Override
    public void deleteGraph() {
        sourceRepository.deleteGraph();
    }


}
