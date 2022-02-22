package com.nip.cdranalysis.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Source")
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties
public class Source {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double degree;
    private double betweenness;

    @Relationship(type = "Call", direction = Relationship.Direction.OUTGOING)
    private List<CallEdge> callEdges;


}