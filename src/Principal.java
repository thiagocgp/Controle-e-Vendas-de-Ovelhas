import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {

	static ListaOvelhas ovelhas = new ListaOvelhas();
	static boolean programaAtivo = true;
	
	public static void main(String[] args) {
		
		while(programaAtivo) {
			try {
				telaPrincipal();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}		

	}
	
	public static void telaPrincipal() throws ParseException {
		String entrada = JOptionPane.showInputDialog("Digite a opção desejada:\n" + "1 - Cadastro de ovelhas\n" +
				"2 - Cadastro de compradores\n" + "3 - Vendas\n" + "4 - Relatórios de animais\n" + "5 - Relatórios gerenciais\n" +
				"6 - Sair\n");
		int opcao = Integer.parseInt(entrada);
		
		switch (opcao) {
		case 1:
			telaCadastroOvelha();
			break;
			
		case 2:
			
			break;
			
		case 3:
	
			break;
		
		case 4:
			telaRelatorioAnimais();
			break;
			
		case 5:
			
			break;
			
		case 6:
			programaAtivo = false;
			break;

		default:
						
			break;
		}
	}
	
	public static void telaCadastroOvelha() throws ParseException {
		String entrada = JOptionPane.showInputDialog("Digite a opção desejada:\n" + "1 - Adicionar macho\n" +
				"2 - Adicionar fêmea\n" + "3 - Adicionar borrego\n" + "4 - Voltar\n");
		int opcao = Integer.parseInt(entrada);
		
		switch (opcao) {
		case 1:
			telaCadastroMacho();
			break;
			
		case 2:
			telaCadastroFemea();
			break;
			
		case 3:
			telaCadastroBorrego();
			break;
				
		default:		
			break;
		}
	}
	
	public static void telaCadastroMacho() throws ParseException {
		String id = JOptionPane.showInputDialog("Digite o ID do animal:\n");
		String nome = JOptionPane.showInputDialog("Digite o NOME:\n");
		String raca = JOptionPane.showInputDialog("Digite a RAÇA:\n");
		String nascimento = JOptionPane.showInputDialog("Digite a DATA DE NASCIMENTO(dd/mm/aaaa):\n");
		String peso = JOptionPane.showInputDialog("Digite o PESO:\n");
		String categoria = JOptionPane.showInputDialog("Digite a CATEGORIA:\n" + "1 - Reprodutor\n" + "2 - Corte\n");
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (Date)formatter.parse(nascimento);
		MachoAdulto macho;
		switch (Integer.parseInt(categoria)) {
		case 1:
			macho = new MachoAdulto(Integer.parseInt(id), nome, Sexo.macho, raca, data, Double.parseDouble(peso), CategoriaMacho.reprodutor);
			break;
		case 2:
			macho = new MachoAdulto(Integer.parseInt(id), nome, Sexo.macho, raca, data, Double.parseDouble(peso), CategoriaMacho.corte);
			break;
		default:
			macho = new MachoAdulto(Integer.parseInt(id), nome, Sexo.macho, raca, data, Double.parseDouble(peso), CategoriaMacho.corte);
			break;
		}
		ovelhas.addOvelha(macho);
	}
	
	public static void telaCadastroFemea() throws ParseException {
		String id = JOptionPane.showInputDialog("Digite o ID do animal:\n");
		String nome = JOptionPane.showInputDialog("Digite o NOME:\n");
		String raca = JOptionPane.showInputDialog("Digite a RAÇA:\n");
		String nascimento = JOptionPane.showInputDialog("Digite a DATA DE NASCIMENTO(dd/mm/aaaa):\n");
		String peso = JOptionPane.showInputDialog("Digite o PESO:\n");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (Date)formatter.parse(nascimento);
		FemeaAdulta femea = new FemeaAdulta(Integer.parseInt(id), nome, Sexo.femea, raca, data, Double.parseDouble(peso));
		
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar filho(s) para esta fêmea?", null, JOptionPane.YES_NO_OPTION);
		if(opcao == 0) {
			int maisFilhos = 0;
			while(maisFilhos == 0) {
				femea.addFilho(JOptionPane.showInputDialog("Digite o nome do filho:\n"));
				maisFilhos = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais filhos para esta fêmea?", null, JOptionPane.YES_NO_OPTION);
			}
		}
		ovelhas.addOvelha(femea);
	}
	
	public static void telaCadastroBorrego() throws ParseException {
		String id = JOptionPane.showInputDialog("Digite o ID do animal:\n");
		String nome = JOptionPane.showInputDialog("Digite o NOME:\n");
		String sexo = JOptionPane.showInputDialog("Digite o SEXO:\n" + "1 - Macho\n" + "2 - FÊMEA\n");
		String raca = JOptionPane.showInputDialog("Digite a RAÇA:\n");
		String nascimento = JOptionPane.showInputDialog("Digite a DATA DE NASCIMENTO(dd/mm/aaaa):\n");
		String peso = JOptionPane.showInputDialog("Digite o PESO:\n");
		String mae = JOptionPane.showInputDialog("Digite o nome da MÃE:\n");
		String pai = JOptionPane.showInputDialog("Digite o nome do PAI:\n");
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (Date)formatter.parse(nascimento);
		Borrego borrego;
		
		switch (Integer.parseInt(sexo)) {
		case 1:
			borrego = new Borrego(Integer.parseInt(id), nome, Sexo.macho, raca, data, Double.parseDouble(peso), mae, pai);
			break;
		case 2:
			borrego = new Borrego(Integer.parseInt(id), nome, Sexo.femea, raca, data, Double.parseDouble(peso), mae, pai);
			break;
		default:
			borrego = new Borrego(Integer.parseInt(id), nome, Sexo.macho, raca, data, Double.parseDouble(peso), mae, pai);
			break;
		}
		ovelhas.addOvelha(borrego);
	}
	
	public static void telaRelatorioAnimais() {
		String entrada = JOptionPane.showInputDialog("Digite a opção desejada:\n" + "1 - Lista todos animais do rebanho\n" +
				"2 - Lista todos machos\n" + "3 - Lista todas fêmeas\n" + "4 - Lista machos reprodutores \n" + "5 - Lista machos de corte\n" +
				"6 - Lista todos borregos\n" + "7 - Busca Ovelha pelo ID\n" + "8 - Lista de filhos de uma fêmea");
		int opcao = Integer.parseInt(entrada);
		String relatorio = "";
		
		switch (opcao) {
		case 1:
			relatorio = "Lista de todo o rebanho:\n\n";
			LinkedList<Ovelha> listaRebanho = ovelhas.listaOvelhas();
			for (int i = 0; i < listaRebanho.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaRebanho.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
			
		case 2:
			relatorio = "Lista de todo os machos:\n\n";
			LinkedList<MachoAdulto> listaMachos = ovelhas.listaMachos();
			for (int i = 0; i < listaMachos.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaMachos.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
			
		case 3:
			relatorio = "Lista de todas as fêmeas:\n\n";
			LinkedList<FemeaAdulta> listaFemeas = ovelhas.listaFemeas();
			for (int i = 0; i < listaFemeas.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaFemeas.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
		
		case 4:
			relatorio = "Lista de todos machos reprodutores:\n\n";
			LinkedList<MachoAdulto> listaReprodutores = ovelhas.listaReprodutor();
			for (int i = 0; i < listaReprodutores.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaReprodutores.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
			
		case 5:
			relatorio = "Lista de todos machos reprodutores:\n\n";
			LinkedList<MachoAdulto> listaCorte = ovelhas.listaCorte();
			for (int i = 0; i < listaCorte.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaCorte.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
			
		case 6:
			relatorio = "Lista de todos borregos:\n\n";
			LinkedList<Borrego> listaBorregos = ovelhas.listaBorregos();
			for (int i = 0; i < listaBorregos.size(); i++) {
				relatorio = relatorio + (i+1) + " - \n" + listaBorregos.get(i).mostraDados();
			}
			JOptionPane.showMessageDialog(null, relatorio);
			break;
			
		case 7:
			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do animal:"));
			Ovelha ovelha = ovelhas.buscaPorId(id);
			JOptionPane.showMessageDialog(null, ovelha.mostraDados());
			break;
			
		case 8:
			int idFemea = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da fêmea:"));
			Ovelha ovelhaFemea = ovelhas.buscaPorId(idFemea);
			if(ovelhaFemea.getSexo() != Sexo.femea || ovelhaFemea instanceof Borrego) {
				JOptionPane.showMessageDialog(null, "ID inválido ou não corresponde a uma fêmea");
				break;
			}
			FemeaAdulta femea = (FemeaAdulta)ovelhaFemea;
			LinkedList<String> filhos = femea.listaFilhos();
			String relatorioFilhos = "Lista de filhos da ovelha (" + idFemea + "):\n";
			for (int i = 0; i < filhos.size(); i++) {
				relatorioFilhos = relatorioFilhos + filhos.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, relatorioFilhos);
			break;

		default:
						
			break;
		}
	}

}
