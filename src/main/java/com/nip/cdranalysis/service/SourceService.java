package com.nip.cdranalysis.service;

import com.nip.cdranalysis.model.Source;

import java.util.List;

public interface SourceService {
	Iterable<Source> findAll();

	Source getSourceByName(String name);

	List<Source> getAllSources();

}
