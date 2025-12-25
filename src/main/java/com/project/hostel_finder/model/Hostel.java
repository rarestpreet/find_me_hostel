package com.project.hostel_finder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String price;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.ALL)
    private List<HostelImages> images;

    @ManyToMany
    @JoinTable(name = "hostel_amenities",
            joinColumns = @JoinColumn(name = "hostel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenities> amenities;

    @OneToOne(mappedBy = "hostel")
    private HostelManager hostelManager;
}
