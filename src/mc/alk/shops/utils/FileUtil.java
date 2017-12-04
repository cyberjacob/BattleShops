package mc.alk.shops.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {


	public static File load(Class<?> clazz, String config_file, String default_file) {
		File file = new File(config_file);
		if (!file.exists()){ /// Create a new file from our default example
			try{
				InputStream inputStream = clazz.getResourceAsStream(default_file);
				if (inputStream == null) /// will this work to fix the problems in windows??
					inputStream = clazz.getClassLoader().getResourceAsStream(default_file);

				OutputStream out=new FileOutputStream(config_file);
				byte buf[]=new byte[1024];
				int len;
				while((len=inputStream.read(buf))>0){
					out.write(buf,0,len);}
				out.close();
				inputStream.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return file;
	}
}
