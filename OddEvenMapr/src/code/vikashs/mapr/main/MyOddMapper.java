package code.vikashs.mapr.main;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyOddMapper extends Mapper<LongWritable , Text, Text, IntWritable>
{
	public void map(LongWritable key , Text text,Context con) throws IOException, InterruptedException
	{
		String[] data=text.toString().split(",");
		for(int i=0;i<data.length;i++)
		{
			int number=Integer.parseInt(data[i]);
			if((number % 2) == 1){
				con.write(new Text("ODD"), new IntWritable(number));
				
			}else{
				con.write(new Text("Even"), new IntWritable(number));
			}
		}
	}

}
