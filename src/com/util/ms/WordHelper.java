/*********************************************
 * @author pan
 * time 2013-10-14
 *********************************************/
package com.util.ms;

import java.util.HashMap;
import java.util.Map;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordHelper {
	/**读取word文档中包含的内容*/
	public final static String[] content = new String[]{
			"研究内容",
			"立项意义",
			"研究路线",
			"创新点",
			"具备的研究条件",
			"进度安排",
			"预期研究目标",
			"预期提交成果"
			};
	
	/**word及文档对象*/
	private ActiveXComponent word;
	private Dispatch document;
	
	/**word路径*/
	private String filePath;
	
	/**
	 * 打开filePath下的word文档路径
	 * @param filePath
	 */
	public WordHelper(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * 获取第taberNum个表格的内容，返回申报表中第二个表格内容的键值对
	 * @param taberNum
	 * @return
	 */
	public Map<String, String> getDeclaContent() {
		Map<String, String> contentMap = new HashMap<String, String>();
		
		Dispatch tables = Dispatch.get(document, "Tables").toDispatch();
		//需要返回的文本内容在第二个表格
		Dispatch table;
		try {
			table = getTable(tables);
			for(int i=1; i<=content.length; ++i){
				//获取的数据默认在表格中的第二列
				contentMap.put(content[i-1], getTxtFromCell(table, i, 2));
			}
		} catch (WordFormatException e) {
			e.printStackTrace();
		} finally {
			tables = null;
			table = null;
			close();
		}
		return contentMap;
	}
	
	/**
	 * 简单判断word是否是一个申报表,第二个表格是否为8行2列,返回这个表格
	 * @param tables
	 * @return
	 */
	private Dispatch getTable(Dispatch tables) throws WordFormatException{
		Dispatch table = null;
		int tableCount = Dispatch.get(tables, "Count").getInt();
		if(tableCount < 2){
			throw new WordFormatException();
		}else {
			//获取第二个表格
			table = Dispatch.call(tables, "Item", new Variant(2)).toDispatch();
			return table;
			/*int rows = Dispatch.get(Dispatch.get(table, "Rows").toDispatch(), "Count").getInt();
			int columns = Dispatch.get(Dispatch.get(table, "Columns").toDispatch(), "Count").getInt();
			System.out.println("row="+rows+"::::cloumn="+columns);
			if(rows != 8 & columns !=2){
				throw new WordFormatException();
			}else {
				return table;
			}*/
		}
	}
	
	/**
	 * 获取指定table的指定行列的内容
	 * @param table
	 * @param cellRowIdx
	 * @param cellColIdx
	 * @return
	 */
	private String getTxtFromCell(Dispatch table, int cellRowIdx, int cellColIdx) {		  
		  Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx), new Variant(cellColIdx)).toDispatch();
		  Dispatch Range=Dispatch.call(cell, "Range").toDispatch();
		  
		  String result = Dispatch.get(Range,"Text").toString();
		  result = result.substring(0, result.length() - 2);
		  return result;
	 }
	
	/**
	 * 新建word及打开文档对象
	 */
	public void open(){
		word = new ActiveXComponent("Word.Application");
		word.setProperty("Visible", new Variant(false));
		word.setProperty("AutomationSecurity", new Variant(3));
		document = word.getProperty("Documents").toDispatch();
		document = Dispatch.invoke(document, 
        		"open", 
        		Dispatch.Method, 
        		new Object[]{filePath, new Variant(true), new Variant(true)},
        		new int[1]).toDispatch();
	}
	
	/**
	 * 关闭word及文档
	 */
	private void close(){
		if(document != null){
			Dispatch.call(document, "Close", new Variant(false));
			document = null; 
		}
		if(word != null){
			word.invoke("Quit", new Variant[0]);
			word = null;
		}
	}
}
