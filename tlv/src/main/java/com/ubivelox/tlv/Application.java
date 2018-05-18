package com.ubivelox.tlv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.ubivelox.tlv.util.HexUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(Application.class);
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
	String strHex = "6F1A840E315041592E5359532E4444463031A5088801025F2D02656E";
	System.out.println(strHex);

	byte[] bytes = HexUtil.convertHexStringToByte(strHex);
	System.out.println(bytes.length);

	for (int i = 0; i < bytes.length; i++) {
	    System.out.println("bytes[" + i + "] = " + bytes[i]);
	}

	System.out.println("HexUtil.convertByteToHexString(bytes) >>> " + HexUtil.convertByteToHexString(bytes));

    }
}
