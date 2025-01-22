package entites;

import java.util.Objects;

public abstract class Pessoa {
	private final int codPessoa;
	private String nomeCompleto;
	private String endereco;
	private String email;
	private String telefone;
	
	public Pessoa(int codPessoa, String nomeCompleto, String endereco, String email, String telefone) {
		this.codPessoa = codPessoa;
		setNomeCompleto(nomeCompleto);
		setEndereco(endereco);
		setEmail(email);
		setTelefone(telefone);
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	@Override
	public boolean equals(Object obj) {
		if(obj == null || getClass() != obj.getClass()) return false;
		Pessoa pessoa = (Pessoa) obj;
		return Objects.equals(this, pessoa.codPessoa);
	}


	@Override
	public String toString() {
		return "Código pessoa=" + getCodPessoa() + ", Nome completo=" + getCodPessoa() + ", Endereco=" + getEndereco()
				+ ", Email=" + getEmail() + ", Telefone=" + getTelefone();
	}
}
