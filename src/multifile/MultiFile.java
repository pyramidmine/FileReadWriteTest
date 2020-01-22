package multifile;

import java.io.File;
import java.io.FilenameFilter;

public class MultiFile {

	public static void main(String[] args) {
		// 현재 디렉토리
		File dir = new File(System.getProperty("user.dir"));
		
		String[] filenames = dir.list();
		System.out.println("---------- dir.list() ----------");
		for (var filename : filenames) {
			System.out.println(filename);
		}
		
		File[] files = dir.listFiles();
		System.out.println("---------- dir.listFiles() ----------");
		for (var file : files) {
			System.out.println(file);
		}
		
		System.out.println("---------- dir.listFiles(filter) ----------");
		String[] wantedFiles = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.matches("deflater\\.base64\\.(cs|cpp)\\.txt");
			}
		});
		for (var wantedFile : wantedFiles) {
			System.out.println(wantedFile);
		}
	}
}
