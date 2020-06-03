package com.example.android_helloworldpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView menu1;
    TextView menu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        menu1=(TextView)findViewById(R.id.menu1);
        menu2=(TextView)findViewById(R.id.menu2);
        this.registerForContextMenu(menu1);
        this.registerForContextMenu(menu2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 添加4个菜单项，分成2组
        int group1=1;
        int gourp2=2;
        int group3=3;
        int group4=4;
        SubMenu subMenu1=menu.addSubMenu(group1,1,Menu.NONE,"菜单1");
        MenuItem menu1_1=subMenu1.add(group3,101,1,"选项菜单1_1");
        MenuItem menu1_2=subMenu1.add(group3,102,2,"选项菜单1_2");
        MenuItem menu1_3=subMenu1.add(group3,103,3,"选项菜单1_3");

        SubMenu subMenu2=menu.addSubMenu(gourp2,2,Menu.NONE,"菜单2");
        MenuItem menu2_1=subMenu2.add(group4,201,1,"选项菜单2_1");
        MenuItem menu2_2=subMenu2.add(group4,202,2,"选项菜单2_2");
        MenuItem menu2_3=subMenu2.add(group4,203,3,"选项菜单2_3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 101:
                Toast.makeText(this, "选项菜单的第1个子菜单的菜单项1", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(this, "选项菜单的第1个子菜单的菜单项2", Toast.LENGTH_SHORT).show();
                break;
            case 103:
                Toast.makeText(this, "选项菜单的第1个子菜单的菜单项3", Toast.LENGTH_SHORT).show();
                break;
            case 201:
                Toast.makeText(this, "选项菜单的第2个子菜单的菜单项1", Toast.LENGTH_SHORT).show();
                break;
            case 202:
                Toast.makeText(this, "选项菜单的第2个子菜单的菜单项2", Toast.LENGTH_SHORT).show();
                break;
            case 203:
                Toast.makeText(this, "选项菜单的第2个子菜单的菜单项3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        switch (v.getId()){
            case R.id.menu1:
                menu.setHeaderTitle("上下文菜单1");
                menu.add(5,301,1,"选项菜单1_1");
                menu.add(5,302,2,"选项菜单1_2");
                menu.add(5,303,3,"选项菜单1_3");
                break;
            case R.id.menu2:
                menu.setHeaderTitle("上下文菜单2");
                getMenuInflater().inflate(R.menu.context_menu,menu);
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 301:
                Toast.makeText(this, "TextView1的菜单项1", Toast.LENGTH_SHORT).show();
                break;
            case 302:
                Toast.makeText(this, "TextView1的菜单项2", Toast.LENGTH_SHORT).show();
                break;
            case 303:
                Toast.makeText(this, "TextView1的菜单项3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m1:
                Toast.makeText(this, "TextView2的菜单项1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m2:
                Toast.makeText(this, "TextView2的菜单项2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Toast.makeText(this, "TextView2的菜单项3", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }





/*

    Button contextmenubtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        contextmenubtn=(Button)findViewById(R.id.contextMenuBtn);
        this.registerForContextMenu(contextmenubtn);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        Log.d("ContextMenuDemoActivity", "被创建...");
        menu.setHeaderTitle("文件操作");
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_send:
            Toast.makeText(this, "发送...", Toast.LENGTH_SHORT).show();
            break;
            case R.id.item_rename:
                Toast.makeText(this, "重命名...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_del:
                Toast.makeText(this, "删除...", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 添加4个菜单项，分成2组
        int group1 = 1;
        int gourp2 = 2;
        menu.add(group1, 1, 1, "菜单项1");
        menu.add(group1, 2, 2, "菜单项2");
        menu.add(gourp2, 3, 3, "菜单项3");
        menu.add(gourp2, 4, 4, "菜单项4");
        SubMenu subMenu=menu.addSubMenu(3,5,Menu.NONE,"基础操作");
        MenuItem rename=subMenu.add(3,201,1,"重命名");
        rename.setIcon(android.R.drawable.ic_menu_edit);
        MenuItem share=subMenu.add(3,202,2,"分享");
        share.setIcon(android.R.drawable.ic_menu_share);
        MenuItem del=subMenu.add(3,203,3,"删除");
        del.setIcon(android.R.drawable.ic_menu_delete);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "菜单项1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "菜单项2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "菜单项3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "菜单项4", Toast.LENGTH_SHORT).show();
                break;
            case 201:
                Toast.makeText(this, "重命名", Toast.LENGTH_SHORT).show();
                break;
            case 202:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case 203:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//	@Override
//	public final boolean onMenuItemSelected(int featureId, MenuItem item) {
//		switch (item.getItemId()) {
//			case 1:
//				Toast.makeText(this, "菜单项11", Toast.LENGTH_SHORT).show();
//				break;
//			case 2:
//				Toast.makeText(this, "菜单项22", Toast.LENGTH_SHORT).show();
//				break;
//			case 3:
//				Toast.makeText(this, "菜单项33", Toast.LENGTH_SHORT).show();
//				break;
//			case 4:
//				Toast.makeText(this, "菜单项44", Toast.LENGTH_SHORT).show();
//				break;
//		}
//		return super.onMenuItemSelected(featureId, item);
//	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		int base = Menu.FIRST;
//		// 一个menu可以包括多个子菜单
//		SubMenu subMenu = menu.addSubMenu(base, base+1, Menu.NONE, "系统设置");
//		// 子菜单可以包括多个菜单项
//		MenuItem menuitem1 = subMenu.add(base, base+1, base+1, "显示设置");
//		subMenu.add(base, base+2, base+2, "网络设置");
//		subMenu.add(base, base+3, base+3, "高级设置");
//		subMenu.add(base, base+4, base+4, "安全设置");
//
//
//		//但是子菜单本身是支持图标的
//		// subMenu.setIcon(R.drawable.settings);
//
//		// 显示菜单请返回true
//		return true;
//	}*/

}
