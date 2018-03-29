package io.cgrings.consumer.repository;

import java.util.stream.Stream;

import io.cgrings.consumer.model.PageView;

public interface PageViewCustomRepository {

    Stream<PageView> findBySessionAndUserExists(final String session, final Boolean exists);

}
