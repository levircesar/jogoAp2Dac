package ui;


import dao.JogoDao;
import entidades.Jogo;

public class Principal {
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.setV1(1);
		jogo.setV2(2);
		jogo.setV3(3);
		jogo.setV4(4);
		jogo.setV5(5);
		JogoDao.salvar(jogo);
		}
}
