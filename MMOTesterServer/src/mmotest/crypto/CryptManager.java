package mmotest.crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import mmotest.constants.Constants;
import mmotest.exception.ExceptionHandler;

public class CryptManager {
	public PublicKey pkey;
	public PrivateKey prkey;
	private KeyPairGenerator kg;
	private KeyPair kkpair;
	private SecureRandom sr;
	private Cipher dcs;
	public KeyPair InitKey(){
		try {
			kg = KeyPairGenerator.getInstance(Constants.PACKET_ENC_TYPE, 
					Constants.PACKET_ENC_PROVIDER);
			sr = SecureRandom.getInstance(Constants.PACKET_RAN_PROVIDER, 
					Constants.PACKET_RAN_TYPE);
		} catch (NoSuchAlgorithmException e) {
			ExceptionHandler.HandleException(e);
		} catch (NoSuchProviderException e) {
			ExceptionHandler.HandleException(e);
		}
		kg.initialize(Constants.PACKET_KEY_SIZE, sr);
		kkpair = kg.generateKeyPair();
		return kkpair;
	}
	public byte[] Decrypt(byte data[]){ //Decrypt Using Stored KeyPair
		return MasterDecrypt(data);
	}
	public byte[] Decrypt(PrivateKey privkey, byte data[]){ // WARNING WILL OVERRIDE GENERATED KEY
		prkey = privkey;
		return MasterDecrypt(data);
	}
	public byte[] Decrypt(KeyPair kpair, byte data[]){
		prkey = kkpair.getPrivate();
		return MasterDecrypt(data);
	}
	private byte[] MasterDecrypt(byte data[]){
		try {
			dcs = Cipher.getInstance(Constants.PACKET_ENC_TYPE);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		} catch (NoSuchPaddingException e) {
			ExceptionHandler.HandleException(e);
		}
		try {
			dcs.init(Cipher.DECRYPT_MODE,kkpair.getPrivate());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
		try {
			return dcs.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
		byte err[] = {(byte) 0};
		dcs = null;
		return err;
	}
	public byte[] Encrypt(byte data[]){
		return MasterEncrypt(data);
	}
	public byte[] Encrypt(PublicKey pubkey, byte data[]){
		pkey = pubkey;
		return MasterEncrypt(data);
	}
	public byte[] Encrypt(KeyPair kpair, byte data[]){
		pkey = kpair.getPublic();
		return MasterEncrypt(data);
	}
	private byte[] MasterEncrypt(byte data[]){
		try {
			dcs = Cipher.getInstance(Constants.PACKET_ENC_TYPE);
			dcs.init(Cipher.ENCRYPT_MODE, kkpair.getPublic());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
		try {
			return dcs.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte err[] = {(byte) 0};
		dcs = null;
		return err;
	}
}

