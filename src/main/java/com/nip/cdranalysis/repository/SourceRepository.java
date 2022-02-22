package com.nip.cdranalysis.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.nip.cdranalysis.model.Source;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SourceRepository extends Neo4jRepository<Source, Long> {
	Source getSourceByName(String name);

	@Query("match(s:Source)-[m:Call]->(l:Target) return s,m,l")
	List<Source> getAllSources();
}
