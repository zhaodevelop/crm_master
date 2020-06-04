package com.ruanyuan.crm_master.utils;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/**
 * 
 * Excel数据封装类
 * @author 
 *
 */
public class ExcelBean implements  java.io.Serializable{

		private static final long serialVersionUID = 1L;
		private String headTextName; //列头（标题）名
	    private String propertyName; //对应字段名
	    private Integer cols; //合并单元格数
	    private XSSFCellStyle cellStyle;
	    public ExcelBean(){
	    }
	    public ExcelBean(String headTextName, String propertyName){
	        this.headTextName = headTextName;
	        this.propertyName = propertyName;
	    }
	    public ExcelBean(String headTextName, String propertyName, Integer cols) {
	        super();
	        this.headTextName = headTextName;
	        this.propertyName = propertyName;
	        this.cols = cols;
	    }
	    public String getHeadTextName() {
	        return headTextName;
	    }

	    public void setHeadTextName(String headTextName) {
	        this.headTextName = headTextName;
	    }

	    public String getPropertyName() {
	        return propertyName;
	    }
}
