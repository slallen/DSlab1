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
	private int local_time;
	private HashMap<String, Integer> local_map = new HashMap<String, Integer>(); //String = dest_name, int = that node's timestamp
	private int clock_size = 3;
	private String[] mapKeys = new String[]{"alice", "bob", "charlie"};
	private	int random = 0;

	public VectorTimeStamp() {
		super();
		this.local_time = 0;
		for (String key : mapKeys) //currently hard-coded, TODO: host_list List
        {
            this.local_map.put(key, local_time);
        }
	}
	
	public VectorTimeStamp(VectorTimeStamp t, int size){
		super();
		this.local_time++;
		for (String key : mapKeys) //currently hard-coded, TODO: host_list List
        {
            this.local_map.put(key, local_time);
        }
	}

	public void set_localtime(TimeStamp t) {		
		//this.local_time ++;
		if(t == null) return;
		else {
			VectorTimeStamp temp = (VectorTimeStamp)t;
			HashMap<String, Integer> other_time = temp.get_localmap();
			
	        for (Entry<String, Integer> entry : other_time.entrySet()) {
	            if (entry.getKey().equalsIgnoreCase("alice")) {
	                int other_value = entry.getValue();
	                random++;
	                local_map.put("bob", random);
	            }
	        }
			return;
			//if(local_time <= other_time) return 0;
			//else return 1;
		}
		
		/* TODO: old code, must update
		if(t == null) return;
		else {
			VectorTimeStamp temp = (VectorTimeStamp)t;
			int other_time = temp.get_localtime();
			local_time = (other_time + 1) > local_time ? (other_time + 1) : local_time;
			return;
		}
		*/
		

	}
	
	public void print_clock(){
		System.out.print("clock(vector) == (");
	    for (String key : local_map.keySet()) {
	        System.out.print(" " + key + "-" + local_map.get(key) + "; ");
	    }
	    System.out.print(")\t");
	    
	    /* another way to print HashMap...irrelevant
	    for (Map.Entry<String, Integer> entry : local_map.entrySet()) {
	        String key = entry.getKey().toString();;
	        Integer value = entry.getValue();
	        System.out.print("key, " + key + " value " + value );
	    }
	    */
	}
	
	public HashMap<String, Integer> get_localmap() {
		return this.local_map;
	}

	/* TODO: old code, must update */
	public int compare(TimeStamp t) {
		VectorTimeStamp temp = (VectorTimeStamp)t;
		HashMap<String, Integer> other_time = temp.get_localmap();
		
		return 1;
		//if(local_time <= other_time) return 0;
		//else return 1;
	}

}