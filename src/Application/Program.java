package Application;

import java.util.Scanner;

import Db.CustomersDAO;
import Entities.Customers;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customers ct = new Customers();
		CustomersDAO dao = new CustomersDAO();		
		int escolha = 0;
		
		
		while(escolha != 9) {
		System.out.println("\nEscolha uma opcao ou 9 para sair \n 1)Recuperar todos clientes \n 2)Procurar por ID \n 3)Procurar por nome \n 4) adicionar valores teste");
		escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			System.out.println("Recuperando Clientes da tabela \n");
			dao.select();
			break;
		
		case 2:
			System.out.println("Digite um ID para procura: ");
			int id = sc.nextInt();
			dao.selectById(id);
			break;
		case 3:
			System.out.println("Digite um nome para procura: ");
			String name = sc.next();
			dao.selectByFirstName(name);
			break;
		case 4:
			System.out.println("Inserindo valores de teste na tabela ");
			ct.setCompany("teste");
			ct.setLast_name("teste");
			ct.setFirst_name("teste");
			ct.setMobile_phone("0000-000");
			ct.setCity("teste");
			ct.setState_province("teste");
			ct.setZip_postal_code("teste");
			ct.setCountry_region("teste");
			
			dao.insert(ct);
			break;
		}
		}
																
		sc.close();
	}
}
