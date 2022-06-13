package com.example.wiki_recent_changes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recent_changes {
    @SequenceGenerator(
            name = "changes_id_sequence",
            sequenceName = "changes_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "changes_id_sequence"
    )
    @Id
    private Long id;

    private String address;


}
