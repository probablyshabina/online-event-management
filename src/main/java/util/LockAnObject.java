package util;

import java.lang.reflect.Method;
import java.util.TreeMap;

public class LockAnObject {

	private static LockAnObject thisObject;
    private static Object obj = null;
    private String perspective = null;
	 
    private LockAnObject() {
    }
 
    public static Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		LockAnObject.obj = obj;
	}

	public void setPOV(String pov) {
		this.perspective = pov;
	}

	public String getPOV() {
		return perspective;
	}


	public static synchronized LockAnObject getInstance()
    {
        if (thisObject == null)
        	thisObject = new LockAnObject();
        return thisObject;
    }
    /*
    public Map<String, String> setNgetObject() throws Exception{
    	if(ob.getClass().getName() == "eventAppointment") {
    		obj = (eventAppointment)ob;
    	}
    	else if(ob.getClass().getName() == "venueAppointment") {
    		obj = (venueAppointment) ob;
    	}
    	return ObjToMap();
    }
    */
    
    public TreeMap<String, String> ObjToMap() throws Exception{

    	Method[] methods = obj.getClass().getDeclaredMethods();
		String attribute;
		TreeMap<String, String> ObjToMap = new TreeMap<>(); 
    	
    	for(Method method : methods) 
		{
			if(method.getName().contains("get")) {
				attribute = method.getName().substring(3);
				try {
					ObjToMap.put(attribute, method.invoke(obj).toString());
				} catch(Exception ex) {
					continue;
				}
			}
		}
		
    	return ObjToMap;
    }
}
