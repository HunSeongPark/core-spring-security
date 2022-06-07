package com.hunseong.corespringsecurity.service.impl;

import com.hunseong.corespringsecurity.domain.Resources;
import com.hunseong.corespringsecurity.repository.ResourcesRepository;
import com.hunseong.corespringsecurity.service.ResourcesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/07
 */
@Transactional
@RequiredArgsConstructor
@Service
public class ResourcesServiceImpl implements ResourcesService {

    private final ResourcesRepository resourcesRepository;

    @Transactional(readOnly = true)
    @Override
    public Resources getResources(long id) {
        return resourcesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resources not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Resources> getAllResources() {
        return resourcesRepository.findAll();
    }

    @Override
    public void createResources(Resources resources) {
        resourcesRepository.save(resources);
    }

    @Override
    public void deleteResources(long id) {
        resourcesRepository.deleteById(id);
    }
}
