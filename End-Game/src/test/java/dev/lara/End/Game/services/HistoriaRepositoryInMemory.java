package dev.lara.End.Game.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.repositories.HistoriaRepository;

public class HistoriaRepositoryInMemory implements HistoriaRepository  {

private final Map<Long, dev.lara.End.Game.models.Historia> database = new HashMap<>();

@SuppressWarnings("null")
@Override
public List<dev.lara.End.Game.models.Historia> findAll() {
    return new ArrayList<>(database.values());
}

@SuppressWarnings({ "null", "unchecked" })
public Historia save(dev.lara.End.Game.models.Historia historia) {
    return database.put((long) historia.getIdHistoria(), historia);
}

@SuppressWarnings("null")
@Override
public Optional<Historia> findById(Integer id) {
    return Optional.ofNullable(database.get(id.longValue()));
}

@Override
public void flush() {

    throw new UnsupportedOperationException("Unimplemented method 'flush'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> S saveAndFlush(S entity) {

    throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> List<S> saveAllAndFlush(@SuppressWarnings("") Iterable<S> entities) {

    throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
}

@Override
public void deleteAllInBatch(@SuppressWarnings("null") Iterable<Historia> entities) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
}

@Override
public void deleteAllByIdInBatch(@SuppressWarnings("null") Iterable<Integer> ids) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
}

@Override
public void deleteAllInBatch() {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
}

@SuppressWarnings("null")
@Override
public Historia getOne(@SuppressWarnings("") Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
}

@SuppressWarnings("null")
@Override
public Historia getById(@SuppressWarnings("") Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
}

@SuppressWarnings("null")
@Override
public Historia getReferenceById(Integer id) {

    throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> List<S> findAll(Example<S> example) {

    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> List<S> findAll(@SuppressWarnings("") Example<S> example, Sort sort) {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> List<S> saveAll(@SuppressWarnings("") Iterable<S> entities) {
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
}

@SuppressWarnings("null")
@Override
public List<Historia> findAllById(@SuppressWarnings("") Iterable<Integer> ids) {
    throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
}

@Override
public boolean existsById(@SuppressWarnings({ "", "null" }) Integer id) {
    throw new UnsupportedOperationException("Unimplemented method 'existsById'");
}

@Override
public long count() {

    throw new UnsupportedOperationException("Unimplemented method 'count'");
}

@Override
public void deleteById(@SuppressWarnings("null") Integer id) {

    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
}

@Override
public void delete(@SuppressWarnings("null") Historia entity) {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
}

@Override
public void deleteAllById(@SuppressWarnings("null") Iterable<? extends Integer> ids) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
}

@Override
public void deleteAll(@SuppressWarnings("null") Iterable<? extends Historia> entities) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
}

@Override
public void deleteAll() {
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
}

@SuppressWarnings("null")
@Override
public List<Historia> findAll(Sort sort) {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}

@SuppressWarnings("null")
@Override
public Page<Historia> findAll(Pageable pageable) {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> Optional<S> findOne(Example<S> example) {
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia> Page<S> findAll(Example<S> example, Pageable pageable) {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
}

@Override
public <S extends Historia> long count(@SuppressWarnings("null") Example<S> example) {
    throw new UnsupportedOperationException("Unimplemented method 'count'");
}

@Override
public <S extends Historia> boolean exists(@SuppressWarnings("null") Example<S> example) {
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
}

@SuppressWarnings("null")
@Override
public <S extends Historia, R> R findBy(@SuppressWarnings("") Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
}
}