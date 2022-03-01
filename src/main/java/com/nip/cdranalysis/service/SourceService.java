package com.nip.cdranalysis.service;

import com.nip.cdranalysis.model.Source;

import java.util.List;

public interface SourceService {
	List<Source> getSourceByName(String name);
	List<Source> getTargetByName(String val);
	List<Source> getAllDatas();

	String savaDataMoc();
	String savaDataMTC();
	int graphCreate();
	double degreeCreate();
	double betweennessCreate();

	void deleteDetach();
	void deleteGraph();



}
