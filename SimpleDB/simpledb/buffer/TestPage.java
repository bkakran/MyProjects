package simpledb.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import simpledb.file.Block;
import simpledb.file.Page;
import simpledb.server.SimpleDB;

public class TestPage {
	public static void main(String[] args) {
	
		SimpleDB.initFileMgr("simpledb");
		Page p2 = new Page();
		p2.setString(0, "tim");
		p2.setInt(7, 2012);
		p2.setInt(11, 2013);
		p2.setBoolean(15, false);
		p2.setDate(23, new Date());
		Short s = 12;
		p2.setShort(44, s);
		String byteToSave = "Test";
		p2.setBytes(46, byteToSave.getBytes());
		
		Block b2 = p2.append("test.tbl");
		//System.out.println(b2.number());
		
		Block blk = new Block("test.tbl", 0);
		Page p1 = new Page();
		p1.read(blk);
		String sname = p1.getString(0);
		int age = p1.getInt(11);
		System.out.println(sname);
		System.out.println(age);
		System.out.println(p2.getBoolean(15));
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
	    Date getDate = p2.getDate(23);
	    String dateAsString = DATE_FORMAT.format(getDate);
		System.out.println(dateAsString);
		System.out.println(p2.getShort(44));
		byte[] bytes = p2.getBytes(46);
	    byteToSave = new String(bytes);
	    System.out.println(byteToSave);
	    
	}
}
