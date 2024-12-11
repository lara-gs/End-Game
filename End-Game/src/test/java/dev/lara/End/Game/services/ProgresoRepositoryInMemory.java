package dev.lara.End.Game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.repositories.ProgresoRepository;

public class ProgresoRepositoryInMemory implements ProgresoRepository {

    private final List<Progreso> dataStore = new ArrayList<>();

    @SuppressWarnings("null")
    @Override
    public List<Progreso> findAll() {
        return new ArrayList<>(dataStore);
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Progreso> findById(Integer id) {
        return dataStore.stream()
                .filter(progreso -> progreso.getIdProgreso() == id)
                                .findFirst();
                    }
                
                    @SuppressWarnings({ "null", "unchecked" })
                    @Override
    public Progreso save(Progreso progreso) {
        dataStore.removeIf(p -> p.getIdProgreso() == progreso.getIdProgreso());
        dataStore.add(progreso);
        return progreso;
    }

    @Override
    public void deleteById(@SuppressWarnings("null") Integer id) {
        dataStore.removeIf(progreso -> progreso.getIdProgreso() == id);
    }

    @Override
    public void delete(@SuppressWarnings("null") Progreso progreso) {
        dataStore.remove(progreso);
    }

    @Override
    public long count() {
        return dataStore.size();
    }

    @Override
    public Progreso findByUsuario_IdUsuario(Integer usuarioId) {
        return dataStore.stream()
                .filter(progreso -> progreso.getUsuario() != null && progreso.getUsuario().getIdUsuario() == usuarioId)
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings({ "unchecked", "null" })
    @Override
    public <S extends Progreso> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::save);
        return (List<S>) new ArrayList<Progreso>();
    }

    @Override
    public boolean existsById(@SuppressWarnings("null") Integer id) {
        return dataStore.stream().anyMatch(progreso -> progreso.getIdProgreso() == id);
    }

    @Override
    public void deleteAll(@SuppressWarnings("null") Iterable<? extends Progreso> entities) {
        entities.forEach(dataStore::remove);
    }

    @Override
    public void deleteAll() {
        dataStore.clear();
    }

    @SuppressWarnings("null")
    @Override
    public List<Progreso> findAllById(Iterable<Integer> ids) {
        List<Integer> idList = new ArrayList<>();
        ids.forEach(idList::add);
        return dataStore.stream()
                .filter(progreso -> idList.contains(progreso.getIdProgreso()))
                .collect(Collectors.toList());
    }

    @Override
    public void flush() {
    
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> S saveAndFlush(S entity) {
    
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch( @SuppressWarnings("null") Iterable<Progreso> entities) {
   
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
    public Progreso getOne(Integer id) {
         
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @SuppressWarnings("null")
    @Override
    public Progreso getById(Integer id) {
         
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @SuppressWarnings("null")
    @Override
    public Progreso getReferenceById(Integer id) {
         
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> List<S> findAll(@SuppressWarnings("") Example<S> example) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> List<S> findAll(Example<S> example, Sort sort) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void deleteAllById(@SuppressWarnings("null") Iterable<? extends Integer> ids) {
         
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Progreso> findAll(Sort sort) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public Page<Progreso> findAll(Pageable pageable) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> Optional<S> findOne(@SuppressWarnings("") Example<S> example) {
    
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso> Page<S> findAll(Example<S> example, Pageable pageable) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Progreso> long count(@SuppressWarnings("null") Example<S> example) {
         
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends Progreso> boolean exists(@SuppressWarnings("null") Example<S> example) {
         
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Progreso, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
         
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }
}
