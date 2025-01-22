package entites;

public class Atendente extends Pessoa {
	private int areaAtendSuporte;
	private String servAtendimento;
	
	public Atendente(int codPessoa, String nomeCompleto, String endereco, String email, String telefone,
			int areaAtendSuporte, String servAtendimento) {
		super(codPessoa, nomeCompleto, endereco, email, telefone);
		setAreaAtendSuporte(areaAtendSuporte);
		setServAtendimento(servAtendimento);
	}
	public int getAreaAtendSuporte() {
		return areaAtendSuporte;
	}
	public void setAreaAtendSuporte(int areaAtendSuporte) {
		this.areaAtendSuporte = areaAtendSuporte;
	}
	public String getServAtendimento() {
		return servAtendimento;
	}
	public void setServAtendimento(String servAtendimento) {
		this.servAtendimento = servAtendimento;
	}
	@Override
	public String toString() {
		return "Atendente [" + super.toString() + " Área de atendmento de suporte=" + getAreaAtendSuporte() + ", Serviço atendimento=" + getAreaAtendSuporte() + "]";
	}
}
