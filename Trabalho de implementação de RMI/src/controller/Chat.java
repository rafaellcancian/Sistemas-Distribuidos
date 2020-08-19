
package controller;

import model.IChat;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Rafael Cancian e Lucas Heinen
 */

public class Chat extends UnicastRemoteObject implements IChat {
    
    ArrayList<String> historicoMensagens;

    public Chat() throws RemoteException {
        historicoMensagens = new ArrayList<>();
    }
    
    @Override
    public void receberMensagem(String mensagem) throws RemoteException {
        historicoMensagens.add(mensagem);
    }

    @Override
    public ArrayList<String> getHistoricoMensagens() throws RemoteException {
        return historicoMensagens;
    }
}
