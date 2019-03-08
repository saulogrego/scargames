package br.com.scargames.util;

import java.security.MessageDigest;

public class HashMaker {
    public static String stringHexa(byte bytes[])
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < bytes.length; i++)
        {
            int parteAlta = (bytes[i] >> 4 & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if(parteAlta == 0)
                s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }

        return s.toString();
    }
    
    public static byte[] gerarHash(String frase){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(frase.getBytes());
            return md.digest();
        }catch(Exception e){
            return null;
        }
    }
}
