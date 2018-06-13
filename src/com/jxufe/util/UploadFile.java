package com.jxufe.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadfile")
public class UploadFile extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	private static final int MAX_FILE_SIZE    = 1024 * 1024 * 40;
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
	private static String result;
	
	public UploadFile() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*****************************************************************************/

		String ip = request.getRemoteAddr();
		String logDirStr = getServletContext().getRealPath("/") + "logfile" ;
		
		File logDir = new File(logDirStr);
		if(!logDir.exists()){
			logDir.mkdir();
		}
		
		File logfile = new File(logDir.getAbsolutePath()+"/log.txt");
		
		FileWriter fw = null;
		BufferedWriter writer = null;
		
		if(!ServletFileUpload.isMultipartContent(request)){
			System.out.println("���ǰ���enctype = multipart/form-data�ı�����");
			System.out.println("����ipΪ:"+ip);

			try {
				fw = new FileWriter(logfile,true);
				writer = new BufferedWriter(fw);
				
				String ip_date = new Date().toString();
				
				String format_ip = String.format("%-10s", ip);
				String ip_format_date = String.format("%-20s", ip_date);
				
				writer.write("----------------------------------���ʵ�ip��ʱ��----------------------------------");
				writer.newLine();
				writer.write(format_ip);
				writer.newLine();
				writer.write(ip_format_date);
				writer.newLine();
				writer.write("----------------------------------���ʵ�ip��ʱ��----------------------------------");
				writer.newLine();
				writer.flush();
				
				PrintWriter out = response.getWriter();
				out.write(format_ip);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					writer.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return;
		}
		
		
		
		
		/*****************************************************************************/
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(MAX_REQUEST_SIZE);
		upload.setHeaderEncoding("UTF-8");
		
		String basePath = getServletContext().getRealPath("/") + "upload" ;
		
		File uploadDir = new File(basePath);
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		
		//��������
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			
			if(formItems != null && formItems.size() > 0){
				for(FileItem item: formItems){
					if(!item.isFormField()){
						//Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
						String fileName = new File(makeFileName(item.getName())).getName();
						
						//Ϊ��ֹһ��Ŀ¼������ֹ����ļ���Ҫʹ�� hash �㷨��ɢ�洢
						String filePath = basePath + File.separator + makeChildDirectory(uploadDir);
						filePath = makePath(fileName,filePath);
						
						String finalFilePath = filePath + File.separator + fileName;
						System.out.println("�ļ��洢����·��:" + finalFilePath);
						
						/**
						 * ��¼��־
						 */

						/*****************************************************************************/
						
						try {
							fw = new FileWriter(logfile,true);
							writer = new BufferedWriter(fw);
							
							String upload_date = new Date().toString();
							
							String format_img_url = String.format("%-200s", finalFilePath);
							String upload_format_date = String.format("%-20s", upload_date);
							
							writer.write("----------------------------------�ϴ��ļ���·����ʱ��----------------------------------");
							writer.newLine();
							writer.write(format_img_url);
							writer.newLine();
							writer.write(upload_format_date);
							writer.newLine();writer.write("----------------------------------�ϴ��ļ���·����ʱ��----------------------------------");
							writer.newLine();
							writer.newLine();
							writer.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}finally {
							try {
								writer.close();
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						/*****************************************************************************/
						
						
						File storeFile = new File(finalFilePath);
						
						try {
							item.write(storeFile);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					item.delete();
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// filename = "�ϴ����ļ���.jpg";
	private String makeFileName(String filename) {
		   return UUID.randomUUID().toString() + "_" + filename;
	}
	
	//Ϊ��ֹһ��Ŀ¼������ֹ����ļ���Ҫʹ�� hash �㷨��ɢ�洢
	//���ļ�����ɢ
	private String makePath(String filename, String basePath) {
	    int hashcode = filename.hashCode();
	    int dir1 = hashcode&0xf; // 0-15
	    int dir2 = hashcode&0xf>>4; // 0-15
	    String dir = basePath + "\\" + dir1 + "\\" + dir2;
	    File file = new File(dir);
	    if (!file.exists()) {
	        // file.mkdir()  ����һ��Ŀ¼
	        file.mkdirs();  //
	    }
	    return dir;
	}
	
	//�����ڴ�ɢ
	private String makeChildDirectory(File baseDirectory) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateDirectory = sdf.format(new Date());
		//ֻ�ܴ���Ŀ¼
		File file = new File(baseDirectory,dateDirectory);
		if(!file.exists()){
			file.mkdirs(); 
	    }
		return dateDirectory;
	}
}
