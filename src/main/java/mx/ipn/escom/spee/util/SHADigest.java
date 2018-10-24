package mx.ipn.escom.spee.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHADigest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SHADigest.class);

	private SHADigest() {
		super();
	}

	public static String digest(String token) {
		String digestPassword = null;
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest mda = MessageDigest.getInstance("SHA-256", "BC");
			digestPassword = new String(Hex.encodeHex(mda.digest(token.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No existe el algoritmo", e);
		} catch (NoSuchProviderException e) {
			LOGGER.error("No existe el provedor", e);
		}
		return digestPassword;
	}
}
