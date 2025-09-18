package vn.iotstar.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		
	}
	@Override
	public <S extends CategoryEntity> S save(S entity) {
		if (entity.getCategoryId == null) {
			return categoryRepository.save(entity);
		}
		else {
			Optional<CategoryEntity> opt = findById(entity.getCategoryId);
		if (opt.isPresent(){
			if (StringUtils.isEmpty(entity.getName())) {
				entity.setName(opt.get().getName());
			}
			else {
				entity.setName(entity.getName());
			}
		}
		return categoryRepository.save(entity);
		}
	}
	
	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return categoryRepository.findById(id);
	}
	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}
	@Override
	public List<CategoryEntity> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}
	@Override
	public Page<CategoryEntity> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}
	@Override
	public long count() {
		return categoryRepository.count();
	}
	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	@Override
	public Page<CategoryEntity> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
	@Override
	public List<CategoryEntity> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}
	@Override
	public List<CategoryEntity> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}
	@Override
	public <S extends CategoryEntity> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}
}
