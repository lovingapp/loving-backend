package com.lovingapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lovingapp.model.dto.RitualFilterDTO;
import com.lovingapp.model.entity.Ritual;

public interface RitualRepositoryCustom {
    Page<Ritual> search(RitualFilterDTO filter, Pageable pageable);
}
