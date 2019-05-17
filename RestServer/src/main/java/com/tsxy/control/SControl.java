package com.tsxy.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.tsxy.service.Service;
import com.tsxy.service.Serviceimpl;


public class SControl {
	private ServerSocket server;
	public static final int PORT=6666;
	private Service service;
	private ExecutorService es;
	//private static Employee emp=new Employee();
	public SControl() {
		try {
			System.out.println("服务器正在开启中");
			this.server=new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已开启");
			this.service=new Serviceimpl();
			es=Executors.newCachedThreadPool();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start() {
		while(true){
			try {
				Socket client=this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				ControlThread ct=new ControlThread(client, service);
				es.submit(ct);
				int activeCount = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线用户"+activeCount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
