package com.nip.cdranalysis.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.nip.cdranalysis.model.Source;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SourceRepository extends Neo4jRepository<Source, Long> {

	@Query("match(s:Source)-[m:Call]->(l:Target{name:$name}) return s,m,l")
	List<Source> getSourceByName(String name);

	@Query("match(s:Source{name:$val})-[m:Call]->(l:Target) return s,m,l")
	List<Source> getTargetByName(String val);

	@Query("match(s:Source)-[m:Call]->(l:Target) return s,m,l")
	List<Source> getAllDatas();


	@Query("call apoc.load.json(\"file:///F:/Office/neo4j/callDataset.json\")\n" +
			"YIELD value\n" +
			"where value._source.usage_type = 'MOC'\n" +
			"merge(a:Source{name:value._source.party_a}) \n" +
			"with value,a\n" +
			"merge(b:Target{name:value._source.party_b})\n" +
			"merge (a)-[:Call{Lat:value._source.bts.latitude, Lon:value._source.bts.longitude,Time_stamp: value._source.time_stamp, usage_type: value._source.usage_type, Score:value._score}]->(b)")
	String savaDataMoc();

	@Query("call apoc.load.json(\"file:///F:/Office/neo4j/callDataset.json\")\n" +
			"YIELD value\n" +
			"where value._source.usage_type = 'MTC'\n" +
			"merge(a:Source{name:value._source.party_b}) \n" +
			"with value,a\n" +
			"merge(b:Target{name:value._source.party_a})\n" +
			"merge (a)-[:Call{Lat:value._source.bts.latitude, Lon:value._source.bts.longitude,Time_stamp: value._source.time_stamp, usage_type: value._source.usage_type, Score:value._score}]->(b)\n")
	String savaDataMTC();

	@Query("CALL gds.graph.create(\n" +
			"  'cdr',    \n" +
			"  ['Source', 'Target'],   \n" +
			"  ['Call']     \n" +
			")\n" +
			"YIELD\n" +
			"  graphName AS graph, nodeProjection, nodeCount AS nodes, relationshipCount AS rels\n" +
			"  return nodes")
	int graphCreate();


	@Query("CALL gds.degree.write('cdr', { writeProperty: 'degree' })\n" +
			"YIELD centralityDistribution, nodePropertiesWritten\n" +
			"RETURN centralityDistribution.min AS minimumScore")
	double degreeCreate();


	@Query("CALL gds.betweenness.write('cdr', { writeProperty: 'betweenness' })\n" +
			"YIELD centralityDistribution, nodePropertiesWritten\n" +
			"RETURN centralityDistribution.min AS minimumScore")
	double betweennessCreate();


	@Query("MATCH (n) DETACH DELETE n")
	void deleteDetach();

	@Query("CALL gds.graph.drop('cdr')")
	void deleteGraph();
}
