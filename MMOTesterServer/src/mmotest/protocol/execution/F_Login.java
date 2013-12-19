/**
 * 
 */
package mmotest.protocol.execution;

import java.util.Vector;

import mmotest.protocol.ProtocolManager;

/**
 * @author noahwhiteis
 *
 */
public class F_Login extends ProtocolManager{
	@Override
	public void f_LOGIN(int packet[]){
		int usr_hash_size = packet[1];
		Vector<Character>CharacterMap = new Vector<Character>();
		for(int i=0; i<usr_hash_size; i++){
			CharacterMap.add((char)new Integer(packet[i+2]).intValue());
		}
		int passwd_hash_size;
		Vector
	}
}
