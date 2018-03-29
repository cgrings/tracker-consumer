package io.cgrings.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import io.cgrings.consumer.model.PageView;

public interface PageViewRepository extends CrudRepository<PageView, String>, PageViewCustomRepository {

}
