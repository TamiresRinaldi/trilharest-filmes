package com.opensanca.trilharest.filmes.filmes;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;

@RestController
@RequestMapping("/filmes") // Controlador que contem todos os /filmes
public class FilmesAPI {

	@Autowired // Injeção de dependencia- delegar a chamada para o dominio
	private FilmesRepository filmesRepository; // Injeção de dependencia- dessa forma eliminamos a Api de comunicar com o repositorio (assim usamos o dominio)

	@RequestMapping(path="/em-exibicao", method=RequestMethod.GET ) //action está no caminho /filmes/em-exibicao (forma mais complexa de escrever)
	public Pagina<Filme> getEmExibicao( ParametrosDePaginacao parametrosDePaginacao){
		if( parametrosDePaginacao == null){
			parametrosDePaginacao = new ParametrosDePaginacao();
		}
		return this.filmesRepository.buscarPaginaEmExibicao(parametrosDePaginacao, LocalDate.now());
	}

	@GetMapping("/{id}")//action está no caminho /filmes/id (forma mais simples de escrever) quando coloco entre chaves mostra que é um parametro da action
	public Filme getPorId(@PathVariable UUID id){ // @PathVariable mostrs que o parametro virá da URL
		return this.filmesRepository.buscarPorId(id);
	}

}
