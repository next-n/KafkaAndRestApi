package com.example.readrandomfromwikichange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Link {
    @Id
    @SequenceGenerator(name = "read_id_sequence", sequenceName = "read_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "read_id_sequence")
    private Long id;
    private String link;
}
