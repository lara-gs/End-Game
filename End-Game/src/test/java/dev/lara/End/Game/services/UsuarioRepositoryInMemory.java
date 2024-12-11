package dev.lara.End.Game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;

public class UsuarioRepositoryInMemory implements UsuarioRepository {

    private final Map<Integer, Usuario> usuarios = new ConcurrentHashMap<>();
    private int currentId = 1;

    @Override
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return usuarios.values().stream()
                .filter(usuario -> usuario.getNombreUsuario().equals(nombreUsuario))
                .findFirst();
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return usuarios.values().stream()
                .filter(usuario -> usuario.getCorreo().equals(correo))
                .findFirst();
    }

    @SuppressWarnings("null")
    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Usuario> findById(Integer id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    @SuppressWarnings({ "null", "unchecked" })
    @Override
    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == 0) {
            usuario.setIdUsuario(currentId++);
        }
        usuarios.put(usuario.getIdUsuario(), usuario);
        return usuario;
    }

    @Override
    public void deleteById(@SuppressWarnings("null") Integer id) {
        usuarios.remove(id);
    }

    @Override
    public boolean existsById(@SuppressWarnings("null") Integer id) {
        return usuarios.containsKey(id);
    }

    @Override
    public long count() {
        return usuarios.size();
    }

    @Override
    public void delete(@SuppressWarnings("null") Usuario entity) {
        usuarios.remove(entity.getIdUsuario());
    }

    @Override
    public void deleteAll() {
        usuarios.clear();
    }

    @Override
    public void deleteAll(@SuppressWarnings("null") Iterable<? extends Usuario> entities) {
        entities.forEach(entity -> usuarios.remove(entity.getIdUsuario()));
    }

    @Override
    public void deleteAllById(@SuppressWarnings("null") Iterable<? extends Integer> ids) {
        ids.forEach(usuarios::remove);
    }

    @SuppressWarnings("null")
    @Override
    public List<Usuario> findAllById(Iterable<Integer> ids) {
        List<Usuario> result = new ArrayList<>();
        ids.forEach(id -> {
            if (usuarios.containsKey(id)) {
                result.add(usuarios.get(id));
            }
        });
        return result;
    }

    @Override
    public void flush() {
          
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> S saveAndFlush(S entity) {
          
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
          
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch(@SuppressWarnings("null") Iterable<Usuario> entities) {
          
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
    public Usuario getOne(@SuppressWarnings("") Integer id) {
          
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @SuppressWarnings("null")
    @Override
    public Usuario getById(Integer id) {
          
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @SuppressWarnings("null")
    @Override
    public Usuario getReferenceById(Integer id) {
          
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> List<S> findAll(@SuppressWarnings("") Example<S> example) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> List<S> saveAll(@SuppressWarnings("") Iterable<S> entities) {
          
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Usuario> findAll(Sort sort) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public Page<Usuario> findAll(Pageable pageable) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> Optional<S> findOne(Example<S> example) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Usuario> long count(@SuppressWarnings("null") Example<S> example) {
          
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends Usuario> boolean exists(@SuppressWarnings("null") Example<S> example) {
          
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Usuario, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
          
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }
}

