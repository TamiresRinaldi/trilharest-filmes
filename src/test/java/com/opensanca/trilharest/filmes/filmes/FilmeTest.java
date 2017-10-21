package com.opensanca.trilharest.filmes.filmes;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class FilmeTest {

	@Test
	public void foraDeExibicaoSeDatasNulas(){
		//preparação
		Filme filme = new Filme();
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertFalse(resultado);
	}

	@Test
	public void emExibicaoSeDentroDeIntervaloDeDatas(){
		//preparação
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertTrue(resultado);
	}

	@Test
	public void foraDeExibicaoSeForaDeIntervaloDeDatas(){
		//preparação
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2016, 10, 1), LocalDate.of(2016, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertFalse(resultado);
	}

	@Test
	public void foraDeExibicaoSeInicioExibicaoNulo(){
		//preparação
		Filme filme = new Filme(null, null, null, null, null, LocalDate.of(2016, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertFalse(resultado);
	}

	@Test
	public void foraDeExibicaoSeFimExibicaoNulo(){
		//preparação
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2016, 10, 1), null);
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertFalse(resultado);
	}

	@Test
	public void emExibicaoSeInicioExtamenteHoje(){
		//preparação
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 21),  LocalDate.of(2017, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertTrue(resultado);
	}

	@Test
	public void emExibicaoSeFimExtamenteHoje(){
		//preparação
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 10),  LocalDate.of(2017, 10, 21));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verificação
		Assert.assertTrue(resultado);
	}
}
