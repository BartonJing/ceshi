package cn.com.jrr.common.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class FileHelper {
	public static final String root = "D:\\webWorkspace\\apache-tomcat-8.0.24\\webapps\\XSF_img";
	//public static final String filePath = "D:\\webWorkspace\\apache-tomcat-8.0.24\\webapps\\files";
	public static String getRealFileName(String fileName){
        int start = fileName.lastIndexOf("\\");  
        String value ="";
        if(start>0){
        	value = fileName.substring(start+1);
        }else{
        	value = fileName;
        }
		return value;
	}
	
	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "MB";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "GB";
		}
		return fileSizeString;
	}
	
	public static String upload(File file, String fileName, String root) {
		InputStream is = null;
		OutputStream os = null;
		try { 
			is = new FileInputStream(file);
			fileName = FileHelper.generateFileName(fileName);
	       os = new FileOutputStream(new File(root, fileName));
	        byte[] buffer = new byte[500];
	        int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        os.flush();
	        os.close();
	        is.close();
	        return fileName;
		} catch (Exception e) {
			System.out.println("涓婁紶澶辫触");
			return null;
		}
	       
	}
	/*删除文件*/
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	      
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
}
