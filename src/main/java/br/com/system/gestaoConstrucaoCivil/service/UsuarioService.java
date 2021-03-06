package br.com.system.gestaoConstrucaoCivil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.system.gestaoConstrucaoCivil.entity.Usuario;
import br.com.system.gestaoConstrucaoCivil.repository.UsuarioRepository;


@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario buscarUsuarioPorNome(String nomeUsuario)
	{
		 return usuarioRepository.findByNome(nomeUsuario);
	}
	
	@Transactional(readOnly = false)
	public void salvarOuEditar(Usuario usuario)
	{
		usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuarioPorId(Long id){
		return usuarioRepository.findOne(id);
	}
	
	public List<Usuario> buscarTodos(){
			
		return usuarioRepository.findAll();
	}
}
