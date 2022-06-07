package com.hunseong.corespringsecurity.service;

import com.hunseong.corespringsecurity.domain.Resources;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/07
 */
public interface ResourcesService {
    Resources getResources(long id);
    List<Resources> getAllResources();
    void createResources(Resources resources);
    void deleteResources(long id);
}
