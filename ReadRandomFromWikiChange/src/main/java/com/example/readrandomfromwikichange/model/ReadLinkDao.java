package com.example.readrandomfromwikichange.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadLinkDao extends JpaRepository<Link, Long> {
}
