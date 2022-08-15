package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;



public class Main {

	public static void m1() {
		
		// File 클래스
		// 1. 파일 및 디렉터리 관리 (파일, 폴더 다 file클래스가 관리)
		// 2. 생성 방법
		// new File(경로, 파일명)
		// new File(파일명)
		// 윈도우 경로 구분은 백슬래시(\)
		
		// 폴더 만들기
		//File dir = new File("D:\\storage");
		File fold = new File("D:\\space");
		
		/*
		if(dir.exists() == false) {
			dir.mkdirs();
		} else {
			dir.delete();
		}
		*/
		
		if(!fold.exists()) {
			fold.mkdir();
		} else {
			fold.deleteOnExit();
		}
		
	}
	
	public static void m2() {
		
		File file = new File("D:\\space", "less.txt");
		File file2 = new File("d:\\space", "fear.txt");
		
		try {
			
			if(!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
			}
			if(!file2.exists()) {
				file2.createNewFile();
			} else {
				file2.delete();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void m3() {
		
		File file = new File("d:\\space", "less.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent());
		System.out.println("전체 경로 : " + file.getPath());
	
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();
		System.out.println("수정한 날짜 : " + lastModifiedDate);
		
		String lastModify = new SimpleDateFormat("a hh:mm yyyy-MM-dd").format(lastModifiedDate);
		System.out.println("마지막 수정 날짜 : " + lastModify);
		
		long size = file.length();
		System.out.println("파일 크기 : " + size + "byte"); 
	}
	
	public static void m4() {
	
		File dir = new File("d:\\HBtest"); // HBtest 안에 폴더 및 파일 하나하나가 다 File 객체. File[]
		File[] list = dir.listFiles();
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
	
	}
	
	public static void m5() {
		
		File file = new File("d:" + File.separator + "space" + File.separator + "less.txt");
		System.out.println(file.getName());	
	}
	
	public static void q1() {
		
		// 해당 디렉터리에 있는 파일이 폴더면 <DIR>을 적어주고 폴더의 갯수를 센다
		// 내용이 파일이면 아무것도 적지 않고 총 용량을 구하고 파일의 갯수를 센다
		
		File dir = new File("d:\\HBtest");
		File[] list = dir.listFiles();
		
		int dirCnt = 0;
		int fileCnt = 0;
		long totalsize = 0;
		
		for(File file : list) {
			if(file.isHidden()) {
				continue;
			}
			String lastModify = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
			String directory = "";
			String size = "";
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "     ";
				dirCnt++;
			} else if(file.isFile()) {
				directory = "      ";
				size = new DecimalFormat("#,###").format(file.length())+"";
				fileCnt++;
				totalsize += Long.parseLong(size.replace(",", ""));
			}
			String name = file.getName();
			System.out.println(lastModify + " " + name + " " + directory + " " + size);
			
		}
		System.out.println(dirCnt + "개 디렉터리");
		System.out.println(fileCnt + "개 파일" + "   " + new DecimalFormat("#,###").format(totalsize));
		
	}
	
	public static void q2() {
		// d:\space 삭제하기
		// 디렉터리가 비어있어야 삭제할 수 있으므로 내부 파일을 먼저 삭제해준다
		// 디렉터리 안에 파일이 여러 개일 경우, 배열로 내부파일을 삭제한다.
		
		File dir = new File("d:\\space");
		File[] fileList = dir.listFiles();
		
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].exists())
				fileList[i].delete();
		}
		
		if(dir.exists())
			dir.delete();
	}
	
	
	
	
	
	public static void main(String[] args) {
		q2();

	}

}
