package org.area515.resinprinter.server;


import java.io.IOException;
import java.util.Properties;

public class HostProperties {

	private static HostProperties m_instance = null;
	public static HostProperties Instance() throws IOException {
		if (m_instance == null) {
			m_instance = new HostProperties();
		}
		return m_instance;
	}
	
	public HostProperties() throws IOException{HostProperties.init();}
	
	static String sourceDir = "";
	public static String getSourceDir(){
		return sourceDir;
	}
	static String workingDir = "";
	public static String getWorkingDir(){
		return workingDir;
	}
	
	static boolean fakeSerial = false;
	public static boolean getFakeSerial(){return fakeSerial;}
	
	public static void init() throws IOException{
//		workingDir = HostProperties.getHostProperties().getProperty("printdir");		
//		sourceDir = HostProperties.getHostProperties().getProperty("sourcedir");
//		fakeSerial = Boolean.parseBoolean(HostProperties.getHostProperties().getProperty("fakeserial"));
		// Webapp war plugin doesn't cant find my config.properties - hardcoding for now
		workingDir = "/home/user/CreationWorkshop/Host/workingdir";
		sourceDir = "/home/user/CreationWorkshop/Host/sourcedir";
		fakeSerial = true;
		
		System.out.println("WorkingDir: " + workingDir);
		System.out.println("SourceDir: " + sourceDir);
		System.out.println("FakeSerial: " + fakeSerial);
	}
	
	public static Properties getHostProperties() throws IOException{
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		return properties;
	}
	
}