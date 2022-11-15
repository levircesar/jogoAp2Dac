package bean;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.JogoDao;
import entidades.Jogo;
@ManagedBean
public class JogoBean {
	private Jogo jogo  = new Jogo();
	private Integer maior;
	private List<Jogo> lista;
	public String salvar(){
		try {
			JogoDao.salvar(jogo);
			addInfoMessage("Sucesso", "Jogo salvo!");
			
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar ou processar seu jogo.");
		}
		jogo = new Jogo();
		
		return null;
	}
	
	public String maior(Jogo j) {
		maior = 10;
		try {
			int[] numeros = {j.getV1(),j.getV2(),j.getV3(),j.getV4(),j.getV5()};
	        int max = Arrays.stream(numeros).max().getAsInt();
	        maior = max;
			addInfoMessage("","Maior número: "+ max + " !");
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar ao processar sua jogada.");
		}
		return null;
	}
	
	public String excluir(Jogo c) {
		try {
			JogoDao.excluir(c);
			
			addInfoMessage("Sucesso", "Deletado com sucesso");
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar ao processar sua jogada.");
		}
		lista = JogoDao.listar();
		return null;
	}
	
	public String editar(Jogo c) {
		try {
			JogoDao.editar(c);
			
			addInfoMessage("Sucesso", "Editado com sucesso");
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar ao processar sua jogada.");
		}
		lista = JogoDao.listar();
		return null;
	}
	
	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDao.listar();
		}
		return lista;
	}
	
	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Integer getMaior() {
		return maior;
	}

	public void setMaior(Integer maior) {
		this.maior = maior;
	}
	
	
}
