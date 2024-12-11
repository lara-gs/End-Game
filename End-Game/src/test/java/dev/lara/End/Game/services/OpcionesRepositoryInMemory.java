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

import dev.lara.End.Game.models.Opciones;
import dev.lara.End.Game.repositories.OpcionesRepository;

public class OpcionesRepositoryInMemory implements OpcionesRepository {

    private final Map<Long, Opciones> database = new HashMap<>();

    @SuppressWarnings("null")
    @Override
    public List<Opciones> findAll() {
        return new ArrayList<>(database.values());
    }


    @SuppressWarnings("null")
    @Override
    public List<Opciones> findAll(@SuppressWarnings("") Sort sort) {
        
        return findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Page<Opciones> findAll(Pageable pageable) {
        
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> S save(@SuppressWarnings("") S entity) {
        database.put((long) entity.getIdOpcion(), entity);
        return entity;
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> List<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            save(entity);
            savedEntities.add(entity);
        }
        return savedEntities;
    }

    @Override
    @SuppressWarnings({ "null", "unlikely-arg-type" })

    public void delete(Opciones entity) {
        database.remove(entity.getIdOpcion());
    }

    @Override
    public void deleteAll(@SuppressWarnings("null") Iterable<? extends Opciones> entities) {
        for (Opciones entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    @Override
    public long count() {
        return database.size();
    }

    

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> Optional<S> findOne(@SuppressWarnings("") Example<S> example) {
    
        return Optional.empty();
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> Page<S> findAll(Example<S> example, Pageable pageable) {

        return null;
    }

    @Override
    public <S extends Opciones> long count(@SuppressWarnings("null") Example<S> example) {

        return 0;
    }

    @Override
    public <S extends Opciones> boolean exists(@SuppressWarnings("null") Example<S> example) {

        return false;
    }


    @Override
    public void flush() {
     
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> S saveAndFlush(@SuppressWarnings("") S entity) {
    
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> List<S> saveAllAndFlush(@SuppressWarnings("") Iterable<S> entities) {
    
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch(@SuppressWarnings("null") Iterable<Opciones> entities) {

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
    public Opciones getOne(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @SuppressWarnings("null")
    @Override
    public Opciones getById(@SuppressWarnings("") Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @SuppressWarnings("null")
    @Override
    public Opciones getReferenceById(@SuppressWarnings("") Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> List<S> findAll(Example<S> example) {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones> List<S> findAll(Example<S> example, Sort sort) {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Opciones> findAllById(@SuppressWarnings("") Iterable<Integer> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Opciones> findById(@SuppressWarnings("") Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsById(@SuppressWarnings("null") Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public void deleteById(@SuppressWarnings("null") Integer id) {
   
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void deleteAllById(@SuppressWarnings("null") Iterable<? extends Integer> ids) {
       
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Opciones, R> R findBy(@SuppressWarnings("") Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }
}