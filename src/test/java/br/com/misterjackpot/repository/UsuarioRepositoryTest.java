package br.com.misterjackpot.repository;

import br.com.misterjackpot.model.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UsuarioRepositoryTest {

    private static Long USER_ID = 1L;

    @InjectMock
    UsuarioRepository usuarioRepository;

    @Test
    public void deveRetornarUsuarioPeloId(){
        dadoQueRetorneUsuario();

        Optional<Usuario> usuario = usuarioRepository.findByIdOptional(USER_ID);

        Assertions.assertSame(usuario.get().getId(), USER_ID);
    }

    private void dadoQueRetorneUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(USER_ID);
        Mockito.when(usuarioRepository.findByIdOptional(USER_ID))
                .thenReturn(Optional.of(usuario));
    }
}
