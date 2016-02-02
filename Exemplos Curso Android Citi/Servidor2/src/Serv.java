import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.ietf.jgss.Oid;


public class Serv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double num1,num2,result = 0;
		int operacao;
		ServerSocket ss;
		
		try{
			
			
			
			ss = new ServerSocket(62);
			
			
			while(true){
			System.out.println("Aguardando conexão");
			Socket s = ss.accept();
			System.out.println("Conexão Aceita");
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out=  new DataOutputStream(s.getOutputStream());
			num1 = in.readDouble();
			num2 = in.readDouble();
			operacao = in.readInt();
			switch(operacao){
			case 0://soma
				result = num1+num2;
				break;
			case 1://sub
				result = num1-num2;
				break;
			case 2://mult
				result = num1*num2;
				break;
			case 3://div
				if(num2!=0){
				result = num1/num2;
				}
				else{
					result = -1;
				}
				break;
			
			}
			System.out.println("resultado="+result);
			out.writeDouble(result);
			in.close();
			out.close();
			s.close();
			}
			
			
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
		

	}

}