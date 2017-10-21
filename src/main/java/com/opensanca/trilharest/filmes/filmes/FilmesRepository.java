package com.opensanca.trilharest.filmes.filmes;

import java.time.LocalDate;
import java.util.UUID;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;

public interface FilmesRepository {

	Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao, LocalDate dataReferencia);

	/**
	 * @throws IllegalArgumentException se não encontrar pelo Id
	 */
	Filme buscarPorId( UUID id );
}
