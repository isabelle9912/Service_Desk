package entites;

import java.util.Objects;

public class Cliente extends Pessoa {
	private int codPlanoAtend;
	private String comoConheceuEmpresa;

	public Cliente(int codPessoa, String nomeCompleto, String endereco, String email, String telefone, int codPlanoAtend, String comoConheceuEmpresa) {
		super(codPessoa, nomeCompleto, endereco, email, telefone);
		
	}

	public int getCodPlanoAtend() {
		return codPlanoAtend;
	}

	public void setCodPlanoAtend(int codPlanoAtend) {
		this.codPlanoAtend = codPlanoAtend;
	}

	public String getComoConheceuEmpresa() {
		return comoConheceuEmpresa;
	}

	public void setComoConheceuEmpresa(String comoConheceuEmpresa) {
		this.comoConheceuEmpresa = comoConheceuEmpresa;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + "Código do plano de atendimeto=" + getCodPlanoAtend() + ", como conheceu a empresa=" + getComoConheceuEmpresa() + "]";
	}
}
