import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class getFinal {
		
		static class  route  {
			int dis;
			int time;
			public route(int dis,int time){
				this.dis = dis; 
				this.time = time;
			}	
		}
	    public static void main(String[] args){
	    	for(int i=0;i<=39;i++){
	    		for(int j=i+1;j<=40;j++){
			        File file = new File("D:\\data\\"+i+"to"+j);
			        File filewalk = new File("D:\\data\\"+i+"to"+j+"walk");
			        txt2String(file,filewalk,i,j);
	    		}
	    	}
	    }
	    public static void txt2String(File file,File filewalk,int i,int j){
	        try{
	        	String woqu ="";
	        	double Timeless= 100000;
	        	String timelu="";
	        	double dataLess = 100000000;
	        	String datalu="";
	        	
	        	ArrayList<String> str = new ArrayList<String>();
	        	String encoding="utf-8";
	        	int count=0;
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    woqu = bufferedReader.readLine();
                    String strtmp="";
                    while((lineTxt = bufferedReader.readLine()) != null){
                    
                    	if(count%2==0){
                        	strtmp = lineTxt;
                        	System.out.println(strtmp);
                        }
                    	else{
                    		System.out.println(lineTxt);
                    		String sb[] = lineTxt.split(" ");
                
                    		double bis = Double.parseDouble(sb[0].trim());
                    		String danwei = sb[1].trim();
                    		if(danwei.equals("米")){
                    			bis/=1000;
                    		}
                    		
                    		if(bis<dataLess){
                    			dataLess = bis;
                    			datalu = strtmp;
                    	
                    		}
                    		
                    		double tt = Double.parseDouble(sb[3].trim());
                    		String sbtt = sb[4].trim();
                    		if(sbtt.indexOf("小时")!=-1){
                    			tt=tt*60;
                    			String sbsb[] = sbtt.split("小时");
                    			String ff;
                    			if(sbsb.length>=1){
                    			sbsb = sbsb[1].split("分钟");
                    			 ff = sbsb[0].trim();
                    			}
                    			else ff="0";
                    			tt = Double.parseDouble(ff)+tt;
                    		}
                    		if(tt<Timeless){
                    			Timeless = tt;
                    			timelu = strtmp;
                    		}
                    	}
                    	count++;
                    }
                    read.close();  
                }
                if(filewalk.isFile() && filewalk.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(filewalk),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    lineTxt = bufferedReader.readLine();
                    String strtmp="";
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	
                        
                        String sb[] = lineTxt.split("  |  ");
                        
                		double bis = Double.parseDouble(sb[0].trim().split(" ")[0]);
                		String danwei = sb[0].trim().split(" ")[1].trim();
                		if(danwei.equals("米")){
                			bis/=1000;
                		}
                		System.out.println(bis);
                		if(bis<dataLess){
                			dataLess = bis;
                			datalu = "步行";
                		}
                		
                		double tt = Double.parseDouble(sb[2].trim().split(" ")[0]);
                		String sbtt = sb[2].trim().split(" ")[1];
                		if(sbtt.indexOf("小时")!=-1){   			
                			tt=tt*60;
                			String sbsb[] = sbtt.split("小时");
                			String ff;
                			if(sbsb.length>=1){
                			sbsb = sbsb[1].split("分钟");
                			 ff = sbsb[0].trim();
                			}
                			else ff="0";
                			tt = Double.parseDouble(ff)+tt;
                		}
                		if(tt<Timeless){
                			Timeless = tt;
                			timelu = strtmp;
                		}
                    }
                    read.close();  
                }
                file = new File("D:\\data\\ans\\ans.txt");
                FileWriter fw = new FileWriter(file,true);
                        fw.write(woqu+" & "+"Timeless = & "+ Timeless +" & Way = & "+ timelu +" & "+ " & dataLess = & "+ dataLess +" & datalu = & "+ datalu+"\r\n");
                fw.flush();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
}
