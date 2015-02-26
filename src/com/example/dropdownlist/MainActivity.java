package com.example.dropdownlist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvContent;
	
	private ArrayList<ListItem> alItems;
	private MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvContent = (ListView) this.findViewById(R.id.lv_content);
		
		initData();
	}
	
	/**
	 * 初始化内容
	 */
	private void initData()
	{
		alItems = new ArrayList<ListItem>();
		
		// 一共20个item
		for (int i = 0; i < 20; i++) {
			ListItem item = new ListItem();
			item.title = "Title - " + i;
			item.subTitle = "Subtitle - " + i;
			alItems.add(item);
		}
		
		adapter = new MyAdapter(this, alItems);
		lvContent.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
