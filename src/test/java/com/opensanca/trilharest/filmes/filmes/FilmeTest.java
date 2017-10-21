package com.opensanca.trilharest.filmes.filmes;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class FilmeTest {

	@Test
	public void foraDeExibicaoSeDatasNulas(){
		//prepara��o
		Filme filme = new Filme();
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertFalse(resultado);
	}

	@Test
	public void emExibicaoSeDentroDeIntervaloDeDatas(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertTrue(resultado);
	}

	@Test
	public void foraDeExibicaoSeForaDeIntervaloDeDatas(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2016, 10, 1), LocalDate.of(2016, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertFalse(resultado);
	}

	@Test
	public void foraDeExibicaoSeInicioExibicaoNulo(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, null, LocalDate.of(2016, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertFalse(resultado);
	}

	@Test
	public void foraDeExibicaoSeFimExibicaoNulo(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2016, 10, 1), null);
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertFalse(resultado);
	}

	@Test
	public void emExibicaoSeInicioExtamenteHoje(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 21),  LocalDate.of(2017, 10, 30));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertTrue(resultado);
	}

	@Test
	public void emExibicaoSeFimExtamenteHoje(){
		//prepara��o
		Filme filme = new Filme(null, null, null, null, LocalDate.of(2017, 10, 10),  LocalDate.of(2017, 10, 21));
		LocalDate dataReferencia = LocalDate.of(2017, 10, 21);
		// processamento
		boolean resultado = filme.emExibicao(dataReferencia);
		// verifica��o
		Assert.assertTrue(resultado);
	}
}
