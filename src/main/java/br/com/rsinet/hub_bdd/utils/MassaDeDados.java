package br.com.rsinet.hub_bdd.utils;

public class MassaDeDados {
	public static final String sheet_DadosParaTeste = "CenariosDeTeste";

	public static final String usuario() throws Exception {
		return ExcelUtils.getCellData(1, 2);
	}

	public static final String senha() throws Exception {
		return ExcelUtils.getCellData(1, 3);
	}

	public static final String email() throws Exception {
		return ExcelUtils.getCellData(1, 4);
	}

	public static final String nome() throws Exception {
		return ExcelUtils.getCellData(1, 5);
	}

	public static final String sobrenome() throws Exception {
		return ExcelUtils.getCellData(1, 6);
	}

	public static final String telefone() throws Exception {
		return ExcelUtils.getCellData(1, 7);
	}

	public static final String nacionalidade() throws Exception {
		return ExcelUtils.getCellData(1, 8);
	}

	public static final String cidade() throws Exception {
		return ExcelUtils.getCellData(1, 9);
	}

	public static final String endereco() throws Exception {
		return ExcelUtils.getCellData(1, 10);
	}

	public static final String estado() throws Exception {
		return ExcelUtils.getCellData(1, 11);
	}

	public static final String cep() throws Exception {
		return ExcelUtils.getCellData(1, 12);
	}

	public static String produtoExistente() throws Exception {
		return ExcelUtils.getCellData(4, 3);
	}

	public static String produtoInexistente() throws Exception {
		return ExcelUtils.getCellData(5, 3);
	}

	public static String produtoCorrespondente() throws Exception {
		return ExcelUtils.getCellData(6, 3);
	}

	public static String produtoNaoCorrespondente() throws Exception {
		return ExcelUtils.getCellData(7, 3);
	}
}
