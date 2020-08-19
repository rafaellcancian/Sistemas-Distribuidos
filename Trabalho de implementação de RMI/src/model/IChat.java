
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Cancian e Lucas Heinen
 */

public interface IChat extends Remote {
    
    public void receberMensagem(String mensagem) throws RemoteException;

    public ArrayList getHistoricoMensagens() throws RemoteException;
}
