package com.tsxy.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ControlThread implements Runnable{
		private Socket client;
		private Object object;

	public ControlThread(Socket client, Object object) {
		super();
		this.client = client;
		this.object = object;
	}

	public void run() {

		try {
			ObjectInputStream oi=new ObjectInputStream(client.getInputStream());
			String methodname=oi.readUTF();
			Class<?>[] methodtype=(Class<?>[])oi.readObject();
			Object[] methodparams=(Object[])oi.readObject();
			Method method=object.getClass().getMethod(methodname, methodtype);
			Object result = method.invoke(object, methodparams);
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(result);
			oos.flush();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	

}
