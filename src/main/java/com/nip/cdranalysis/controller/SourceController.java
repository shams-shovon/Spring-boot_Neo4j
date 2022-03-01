package com.nip.cdranalysis.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.nip.cdranalysis.model.Source;
import com.nip.cdranalysis.service.impl.SourceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/data")
public class SourceController {

    private SourceServiceImpl sourceServiceImpl;

    public SourceController(SourceServiceImpl sourceServiceImpl) {
        super();
        this.sourceServiceImpl = sourceServiceImpl;
    }

    @GetMapping("/all")
    public List<Source> findAll() {
        return sourceServiceImpl.getAllDatas();
    }

    @GetMapping("/getsource/{name}")
    public List<Source> getSourceByName(@PathVariable String name) {
        return sourceServiceImpl.getSourceByName(name);
    }

    @GetMapping("/gettarget/{val}")
    public List<Source> getTargetByName(@PathVariable String val) {
        return sourceServiceImpl.getTargetByName(val);
    }

    @PostMapping("/create")
    @Transactional
    public String saveEmployee(){
        //sourceServiceImpl.savaDataMoc();
        //sourceServiceImpl.savaDataMTC();
        //sourceServiceImpl.graphCreate();
        //sourceServiceImpl.degreeCreate();
        sourceServiceImpl.betweennessCreate();

        //sourceServiceImpl.deleteDetach();
        //sourceServiceImpl.deleteGraph();
        return "Create";
    }
}
