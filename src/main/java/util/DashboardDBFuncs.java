package util;

import java.util.List;

public class DashboardDBFuncs extends DBFunctions{

	public DashboardDBFuncs(){
		System.out.println("DashboardDBFuncs created");
	}

	public DashboardDBFuncs(Object ob) {
		super(ob);
	}

	public List<Object> setView(String view) throws Exception{
		super.tableName = "";
		switch(view) {
			case("events"):
				super.tableName = "cusDash_events";
				break;
			case("vApps"):
				super.tableName = "cusDash_vApp";
				break;
			case("eApps"):
				super.tableName = "cusDash_eApp";
				break;
		}
		return super.read();
	}
}
