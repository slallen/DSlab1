import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


	/*	I suggest you to define the array as a hashmap, like
	 * 		hashmap<String,int>
	 *  
	 *  
	 *  This is only what I think, I don't know if it is the best way to implement because I just
	 *  think about it roughly
	 */


public class VectorTimeStamp extends TimeStamp{
	private int local_time = 0;
	private HashMap<String, Integer> local_map = new HashMap<String, Integer>(); //String = dest_name, int = that node's timestamp
	private	int random = 0;

	public VectorTimeStamp() {
		super();
		//this.local_time = 0;
		for (Entry<String, Host> entry : MessagePasser.hosts.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase("logger")) {
            	this.local_map.put(entry.getKey(), local_time);
            }
        }
	}
	
	public VectorTimeStamp(VectorTimeStamp t){
		super();
		this.local_map = t.get_localtime();
	}

	public void set_localtime(TimeStamp t) {	
		this.local_time++;
		
		if(t == null) {
			local_map.put(MessagePasser.local_name, local_time);
			return;
		}
		else {
			VectorTimeStamp temp = (VectorTimeStamp)t;
			HashMap<String, Integer> other_time = temp.get_localtime();
			
			/* TODO: delete after testing */
//			for (Entry<String, Integer> entry : other_time.entrySet()) {
//	            this.local_map.put(entry.getKey(), local_time);
//	        }
            if (!MessagePasser.local_name.equalsIgnoreCase("logger"))
            	local_map.put(MessagePasser.local_name, local_time);
			
	        for (Entry<String, Integer> entry : other_time.entrySet()) {
            	if (entry.getValue() + 1 > local_map.get(entry.getKey()))
	        		local_map.put(entry.getKey(), entry.getValue());
	        
            	/*
	        	if (entry.getKey().equalsIgnoreCase("alice")) {
	            	int other_value = entry.getValue();
	                random++;
	                local_map.put("bob", random);
	            }
	            */
	        }
			return;
		}
		
	}
	
	public void print_clock(){
		System.out.print("clock(vector) == (");
	    for (String key : local_map.keySet()) {
	        System.out.print(" " + key + "-" + local_map.get(key) + "; ");
	    }
	    System.out.print(")\t");
	    
	}
	
	public HashMap<String, Integer> get_localtime() {
		return this.local_map;
	}

	/* TODO: old code, must update... UPDATE: when is this used? */
	public int compare(TimeStamp t) {
		//insert code
		return 0;
	}

}