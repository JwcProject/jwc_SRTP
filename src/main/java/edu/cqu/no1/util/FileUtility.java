package edu.cqu.no1.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import javax.servlet.http.HttpServletResponse;

import java.io.DataInputStream;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.ServletOutputStream;

import javax.servlet.ServletContext;

public class FileUtility {

	private static final Logger log = LoggerFactory.getLogger(FileUtility.class);
	private static List<String> fileExtension = new ArrayList<String>();

	static {

		fileExtension.add("txt");
		fileExtension.add("text");
		fileExtension.add("html");
		fileExtension.add("doc");
		fileExtension.add("docx");
		fileExtension.add("pdf");
		fileExtension.add("xlsx");
		fileExtension.add("xls");
		fileExtension.add("jpeg");
		fileExtension.add("jpg");
		fileExtension.add("bmp");
		fileExtension.add("gif");

	}
	// Common Field
	private static final int BUFFER_SIZE = 16 * 1024;

	public static int getBUFFER_SIZE() {
		return BUFFER_SIZE;
	}

	private static final String FILE_PATH = "\\..\\..\\UserFile";
	private static final String REALFILE_PATH = "C:\\UserFile";

	public static String getFILE_PATH() {
		return FILE_PATH;
	}
	public static String getREALFILE_PATH()
	{
		return REALFILE_PATH;
	}

	// 保存单文件
	public static void SaveFile(File src, File dst) {

		try {

			InputStream in = null;

			OutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

				out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);

				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {

					out.write(buffer);

				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void SaveFiles(File[] srcs, File[] dsts) {
		try {

			if (srcs == null || dsts == null || srcs.length != dsts.length) {
				throw new NullPointerException("the source or dsts file is null or both are zero lengh ");
			}

			for (int i = 0; i < srcs.length; i++) {
				SaveFile(srcs[i], dsts[i]);
			}

		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static List<String> SaveFiles(File[] srcs, String[] fileNames, String[] fileContentTypes) {
		try {

			if (srcs == null || fileNames == null || fileContentTypes == null) {
				throw new NullPointerException("the srcs or fileNames or contenttype is null ,so we throw it out!");
			}

			/*
			String folder = ServletActionContext.getServletContext().getRealPath(getFILE_PATH());
			System.out.println("folder: \t" + folder);
			log.error("folder:\t "+folder);
			*/
			String folder = getREALFILE_PATH();
			//System.out.println("folder: \t" + folder);
			log.debug("files folder:\t "+folder);
			
			File rootDir = new File(folder);

			if (!rootDir.exists()) {
				rootDir.mkdir();
			}

			List<String> fileUris = new ArrayList<String>();

			for (int i = 0; i < srcs.length; i++) {

				String fileEx = fileNames[i].substring(fileNames[i].lastIndexOf("."), fileNames[i].length());

				String fileRealName = fileNames[i].substring(0, fileNames[i].lastIndexOf(".")) + String.valueOf(System.currentTimeMillis()) + fileEx;

				String filePath = folder + "\\" + fileRealName;

				SaveFile(srcs[i], new File(filePath));

				// 记录相对地址
				fileUris.add(FILE_PATH + "\\" + fileRealName);

			}

			return fileUris;

		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

	
	public static String GetFileExtention(String name) {
		try {
			if (name == null || name.equals("")) {
				throw new NullPointerException("the name for get file extention is null ");
			}
			if (name.lastIndexOf(".") == 0) {
				throw new StringIndexOutOfBoundsException("the name dot index is bad ");
			}

			return name.substring(name.lastIndexOf("."), name.length());

		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

	public static String GetFileBaseName(String name) {
		try {
			if (name == null || name.equals("")) {
				throw new NullPointerException("the file name for getting file name is null or empty, so...");
			}

			if (name.lastIndexOf(".") == 0) {
				return name.substring(0, name.length());
			} else {
				return name.substring(0, name.lastIndexOf("."));
			}

		} catch (RuntimeException re) {

			re.printStackTrace();

			throw re;
		}
	}

	// 匹配 文件后缀名是否和预定义的是否相同 如果不同返回 False 否则返回 True
	public static Boolean ValidateFileExtention(String name) throws Exception {
		try {
			if (name == null && name.equals("")) {
				throw new NullPointerException("name for validate extentsion is null or empty,so we populat it");
			}

			return FilenameUtils.isExtension(name, fileExtension);

		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

	// 返回文件列表的MIME 类型
	public static String GetFileContentType(File file) {

		try {
			return new MimetypesFileTypeMap().getContentType(file);

		} catch (RuntimeException re) {

			re.printStackTrace();

			throw re;

		}

	}

	public static void DeleteFile(File dfile) {
		try {

			if (dfile == null) {
				throw new NullPointerException("the file for deleting is not exist or is null ,so we populate it");
			}

			dfile.deleteOnExit();

		} catch (RuntimeException re) {

			re.printStackTrace();

			throw re;
		}
	}

	public static void DeleteFile(String relativepath) {
		try {

			if (relativepath == null || relativepath.equals("")) {
				throw new NullPointerException("the relative path  is null or empty, so we populate it  ");
			}

			relativepath = relativepath.replace('/', '\\');

			//String folder = ServletActionContext.getServletContext().getRealPath(getFILE_PATH());
			String folder = getREALFILE_PATH();
			String abstractPath = folder + "\\" + relativepath;

			DeleteFileAbstract(abstractPath);

		} catch (RuntimeException re) {

			re.printStackTrace();

			throw re;
		}
	}

	public static void DeleteFileAbstract(String abstractpath) {
		try {

			if (abstractpath == null || abstractpath.equals("")) {
				throw new NullPointerException("the abstract path is null or empty");
			}

			File file = new File(abstractpath);

			if (file.exists()) {
				file.deleteOnExit();
			}

		} catch (RuntimeException re) {

			re.printStackTrace();

			throw re;
		}
	}

	public static void doDownload(String filename, String original_filename) throws IOException {

		if (filename == null || filename.equals("")) {
			throw new NullPointerException("the file name for download is null or empty ,so we populate it");
		}

		File file = null;

		if (FilenameUtils.getPrefix(filename) == null || FilenameUtils.getPrefix(filename).equals("") || FilenameUtils.getPrefix(filename).equals("\\")) {

			
			file = new File(getREALFILE_PATH() + filename);
			//file = new File(ServletActionContext.getServletContext().getRealPath("") + filename);
		}

		if (file == null || !file.exists()) {
			return;
		}

		if (original_filename == null || original_filename.equals("")) {
			throw new NullPointerException("the oringnal file name is null or empty");
		}

		// HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();

		int length = 0;

		ServletOutputStream op = resp.getOutputStream();

		ServletContext context = ServletActionContext.getServletContext();

		String mimetype = context.getMimeType(filename);

		//
		// Set the response and go!
		//
		//
		resp.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
		resp.setContentLength((int) file.length());

		HttpServletRequest request = (HttpServletRequest) (ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST));
		String agent = request.getHeader("USER-AGENT");  
		
		String fileName = original_filename;
		 if (null != agent && -1 != agent.indexOf("MSIE")){  
			 fileName = java.net.URLEncoder.encode(fileName, "UTF-8");   
		}  
		 else if (null != agent && -1 != agent.indexOf("Mozilla")){      
			 fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
		}  
		
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		//
		// Stream to the requester.
		//
		byte[] bbuf = new byte[BUFFER_SIZE];

		DataInputStream in = new DataInputStream(new FileInputStream(file));

		while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			op.write(bbuf, 0, length);
		}

		in.close();
		op.flush();
		op.close();
	}

}
