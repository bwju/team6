package src;

import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UploadFile1 {
	private List<String> filenames;
	public void upload(HttpServletRequest request,PageContext pageContext) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		filenames=new Vector();
		String dir=pageContext.getServletContext().getRealPath("/");
		//File filetmp =new File(dir+"img\\"+request.getParameter("id")+"\\");    
		//如果文件夹不存在则创建    
		//if  (!filetmp.exists()&&!filetmp.isDirectory())      
		//{       
		    //System.out.println("//不存在");  
		    //filetmp.mkdir();    
		//} else   
		//{  
		//    System.out.println("//目录存在");  
		//}
		//dir = dir+"img\\"+request.getParameter("id")+"\\";
		//System.out.println(dir+"1");
		//System.out.println("日了狗了"+request.getParameter("id"));
		MultipartRequest multi;
		try {
			//multi = new MultipartRequest(request,  "D:/course/upload/", 1024*1024*8, "gb2312");
			multi = new MultipartRequest(request, dir, 1024*1024*8, "utf-8");
			//System.out.println("2MultipartRequest="+multi.getParameter("abc"));
			//System.out.println(multi.getParameter("abc")+"5");
			Enumeration files = multi.getFileNames();
			//int i = 0;
			//String s = ".jpg";
			while (files.hasMoreElements()){
				String name = (String) files.nextElement();
				//System.out.println("???"+name);
				File file = multi.getFile(name);
				//System.out.println(multi.getFile(name).getName());
				//String newName = "";
				if (file != null) {
					//newName = i+s;
					//System.out.println(newName);
					//renameFile(dir,file.getName(),newName);
					String filename = file.getName();
					//String filename = "1.jpg";
					//System.out.println(file.getName()+"文件名");
					String ext=filename.substring(filename.lastIndexOf('.'));
					File rfile=new File(file.getCanonicalPath());
					//System.out.println(file.getCanonicalPath()+"这是啥");
					if(!ext.equals(".java")){
						//System.out.println("3"+ext);
						if(rfile.exists()){
							rfile.delete();
							return;
						}
					}
					filenames.add(file.getCanonicalPath());
					//System.out.println("4"+file.getCanonicalPath());
					  
					if(rfile.exists())
					{
					rfile.renameTo(new File("C:\\tomcat\\apache-tomcat-7.0.56\\wtpwebapps\\webFinal\\"+multi.getParameter("abc")+".jpg"));
					}
				}
				//i++;
			}
			//System.out.println("循环了"+i+"次");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	public String getFilenames(){
//		StringBuffer buf=new StringBuffer();
//		for(int i=0;i<filenames.size();i++){
//			buf.append((String)filenames.get(i)+" upload! <br/>");
//		}
//		return buf.toString();
		String n;
		if(filenames.isEmpty()){
			n=new String("没有上传");
		}
		else{
			n="您成功上传";
		}
		
		return n;
	}
	
	public void renameFile(String path,String oldname,String newname){ 
		//System.out.println("这里可以"); 
        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名 
        	//System.out.println("这里可以");
        	//System.out.println(path+"/"+oldname);
            File oldfile=new File(path+"/"+oldname); 
            File newfile=new File(path+"/"+newname); 
            if(!oldfile.exists()){
                return;//重命名文件不存在
            }
            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名 
            	newfile.delete();
                //System.out.println(newname+"已经存在！"); 
            //else{ 
                oldfile.renameTo(newfile); 
            //} 
        }else{
            System.out.println("新文件名和旧文件名相同...");
        }
    }
}

