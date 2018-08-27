package cn.itcast.utils;

import java.io.File;
import java.util.List;

import cn.itcast.domain.UpFile;
import cn.itcast.serciceimple.uploadserviceimple;

public class Delete {
	public static void delete(String dir){
		File file = new File(dir);
		uploadserviceimple s = new uploadserviceimple();
		List<UpFile> list = s.getAll();
		deletefile(file,list);
	}
	
	public static void deletefile(File file,List<UpFile> list){
		boolean flag=false;
		File[] f1 = file.listFiles();
		for(File f:f1){
			File[] f2 = f.listFiles();
			if(f2.length==0){
				f.delete();
			}
			for(File f3:f2){
				File[] f4 = f3.listFiles();
				if(f4.length==0){
					f3.delete();
				}
				for(File f5 : f4){
					File[] f6 = f5.listFiles();
						if(f6.length==0){
							f5.delete();
						}
					for(File f7:f6){
						String name = f7.getName();
						for(UpFile u:list){
							if(u.getUuidname().equals(name)){
								flag=true;
							}
						}
						if(flag==false){
							f7.delete();
							
						}
						flag=false;
						
					}
				}
			}
		}
	}
}
