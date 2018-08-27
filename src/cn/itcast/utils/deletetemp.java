package cn.itcast.utils;

import java.io.File;

public class deletetemp {
	public static void dele(String path){
		File file = new File(path);
		File list[] = file.listFiles();
		long end = System.currentTimeMillis();
		for(File f :list){
			if(end-f.lastModified()>1000*60*60){
				f.delete();
			}
		}
	} 
}
