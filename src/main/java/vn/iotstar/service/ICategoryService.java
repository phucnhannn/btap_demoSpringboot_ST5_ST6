package vn.iotstar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.entity.CategoryEntity;

public interface ICategoryService {
    CategoryEntity save(CategoryEntity entity);
    List<CategoryEntity> findAll();
    Page<CategoryEntity> findAll(Pageable pageable);
    Optional<CategoryEntity> findById(Long id);
    void deleteById(Long id);
    List<CategoryEntity> findByNameContaining(String name);
    Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);
    long count();
}