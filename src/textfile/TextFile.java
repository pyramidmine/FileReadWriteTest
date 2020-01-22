package textfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TextFile {
	static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {
		// 데이터 생성
		String sampleText = "To succeed in Life, you need two things: Ignorance and Confidence - Mark Twain.";
		byte[] encodedData = sampleText.getBytes(StandardCharsets.UTF_8);
		byte[] base64Data = Base64.getEncoder().encode(encodedData);
		String base64EncodedText = new String(base64Data, StandardCharsets.UTF_8);
		
		// 파일 패스
		String directory = System.getProperty("user.dir");
		String filename = "java.base64.dat";
		String path = directory + File.separator + filename;
		System.out.println("File Path: " + path);
		System.out.println("Encoded Base64 Text: " + base64EncodedText);
		
		// 파일 쓰기
		try (FileWriter fw = new FileWriter(path)) {
			fw.write(new String(base64Data));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		String base64DecodedText = null;
		
		// 파일 읽기
		try (
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr))
		{
			StringBuilder sb = new StringBuilder(BUFFER_SIZE);
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			base64DecodedText = sb.toString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Decoded Base64 Text: " + base64DecodedText);
		System.out.println("Compare Text: " + base64EncodedText.equals(base64DecodedText));
	}
}
