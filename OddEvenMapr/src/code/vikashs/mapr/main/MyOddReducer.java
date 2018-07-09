package code.vikashs.mapr.main;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyOddReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value, Context con) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.reduce(key, val, con);
		int sum=0;
		if(key.equals("ODD"))
		{
			for(IntWritable itr: value)
			{
				sum += itr.get();
			}
		}
		else
		{
			for(IntWritable itr: value)
			{
				sum += itr.get();
			}
		}
		con.write(key, new IntWritable(sum));
	}

}
