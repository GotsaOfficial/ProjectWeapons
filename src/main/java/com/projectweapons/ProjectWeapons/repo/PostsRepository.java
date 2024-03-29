package com.projectweapons.ProjectWeapons.repo;

import com.projectweapons.ProjectWeapons.models.PostsModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<PostsModel, Long> {
    Iterable<PostsModel> findAll(Sort by);
}
