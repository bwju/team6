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
		//����ļ��в������򴴽�    
		//if  (!filetmp.exists()&&!filetmp.isDirectory())      
		//{       
		    //System.out.println("//������");  
		    //filetmp.mkdir();    
		//} else   
		//{  
		//    System.out.println("//Ŀ¼����");  
		//}
		//dir = dir+"img\\"+request.getParameter("id")+"\\";
		//System.out.println(dir+"1");
		//System.out.println("���˹���"+request.getParameter("id"));
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
					//System.out.println(file.getName()+"�ļ���");
					String ext=filename.substring(filename.lastIndexOf('.'));
					File rfile=new File(file.getCanonicalPath());
					//System.out.println(file.getCanonicalPath()+"����ɶ");
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
			//System.out.println("ѭ����"+i+"��");
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
			n=new String("û���ϴ�");
		}
		else{
			n="���ɹ��ϴ�";
		}
		
		return n;
	}
	
	public void renameFile(String path,String oldname,String newname){ 
		//System.out.println("�������"); 
        if(!oldname.equals(newname)){//�µ��ļ�������ǰ�ļ�����ͬʱ,���б�Ҫ���������� 
        	//System.out.println("�������");
        	//System.out.println(path+"/"+oldname);
            File oldfile=new File(path+"/"+oldname); 
            File newfile=new File(path+"/"+newname); 
            if(!oldfile.exists()){
                return;//�������ļ�������
            }
            if(newfile.exists())//���ڸ�Ŀ¼���Ѿ���һ���ļ������ļ�����ͬ�������������� 
            	newfile.delete();
                //System.out.println(newname+"�Ѿ����ڣ�"); 
            //else{ 
                oldfile.renameTo(newfile); 
            //} 
        }else{
            System.out.println("���ļ����;��ļ�����ͬ...");
        }
    }
}

