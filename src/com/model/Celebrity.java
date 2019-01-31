package com.model;

public class Celebrity {
	private static String Cid;
	private static String Cxingming;
	private static String Cnianhao;
	private static String Cminzu;
	private static String Cguanzhi;
	private static String Cchushengdi;
	private static String Cchengjiu;
	
	
	public static String getCid() {
		return Cid;
	}
	public static void setCid(String cid) {
		Cid = cid;
	}
	public static String getCxingming() {
		return Cxingming;
	}
	public static void setCxingming(String cxingming) {
		Cxingming = cxingming;
	}
	public static String getCnianhao() {
		return Cnianhao;
	}
	public static void setCnianhao(String cnianhao) {
		Cnianhao = cnianhao;
	}
	public static String getCminzu() {
		return Cminzu;
	}
	public static void setCminzu(String cminzu) {
		Cminzu = cminzu;
	}
	public static String getCguanzhi() {
		return Cguanzhi;
	}
	public static void setCguanzhi(String cguanzhi) {
		Cguanzhi = cguanzhi;
	}
	public static String getCchushengdi() {
		return Cchushengdi;
	}
	public static void setCchushengdi(String cchushengdi) {
		Cchushengdi = cchushengdi;
	}
	public static String getCchengjiu() {
		return Cchengjiu;
	}
	public static void setCchengjiu(String cchengjiu) {
		Cchengjiu = cchengjiu;
	}
	
	public Celebrity(String xingming, String minzu, String chushengdi, String nianhao, String guanzhi, String jianjie) {
		// TODO Auto-generated constructor stub
		Cxingming = xingming;
		Cnianhao = nianhao;
		Cminzu  = minzu;
		Cguanzhi = guanzhi;
		Cchushengdi = chushengdi; 
		Cchengjiu = jianjie;
	}
	public Celebrity() {
		
	}
	
	
	
	

}
