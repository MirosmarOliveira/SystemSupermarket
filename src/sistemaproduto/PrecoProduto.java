package sistemaproduto;

public abstract class PrecoProduto {
	private int unidade;
	private float preco, maiorPreco = 0, menorPreco = 0;
	protected String nomeMaiorPreco, nomeMenorPreco;

	public abstract void novoPrecoProduto(String nome, float preco);

	public int getUnidade() {
		return this.unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getMaiorPreco() {
		return this.maiorPreco;
	}

	public void setMaiorPreco(float maiorPreco) {
		this.maiorPreco = maiorPreco;
	}

	public float getMenorPreco() {
		return this.menorPreco;
	}

	public void setMenorPreco(float menorPreco) {
		this.menorPreco = menorPreco;
	}

	public String getNomeMaiorPreco() {
		return this.nomeMaiorPreco;
	}

	public void setNomeMaiorPreco(String nomeMaiorPreco) {
		this.nomeMaiorPreco = nomeMaiorPreco;
	}

	public String getNomeMenorPreco() {
		return this.nomeMenorPreco;
	}

	public void setNomeMenorPreco(String nomeMenorPreco) {
		this.nomeMenorPreco = nomeMenorPreco;
	}
}
