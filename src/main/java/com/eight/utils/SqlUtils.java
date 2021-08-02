package com.eight.utils;

public class SqlUtils {
    private StringBuffer sql=new StringBuffer("SELECT * FROM ");
    private int iniSqlLen;//不进行任何条件插入时sql语句的长度，方便后面进行条件的删除
    private int tmpLen;
    private int addLen;
    private String WHERE=" WHERE ";
    private String AND=" AND ";
    private String pageSize;

    public SqlUtils(String tb_name){//初始化sql语句
        sql.append(tb_name+";");
        iniSqlLen=sql.length()-1;
        addLen=iniSqlLen;
    }

    public SqlUtils(String tb_name, String pageSize){
        this.pageSize=pageSize;
        sql.append(tb_name+";");
        iniSqlLen=sql.length()-1;
        addLen=iniSqlLen;
    }

    public SqlUtils(String tb_name, String categoryId, String pageSize){
        this.pageSize=pageSize;
        sql.append(tb_name+" WHERE one_category_id="+categoryId+" ORDER BY product_id;");
        iniSqlLen=sql.length()-1;
        addLen=iniSqlLen;
    }

    public void Add(String newCon){//newCon:用户添加的新的筛选条件
        if(!sql.toString().contains(WHERE)){
            sql.insert(iniSqlLen,WHERE);
            tmpLen=WHERE.length();
        }
        else
        {
            sql.insert(addLen,AND);
            tmpLen=AND.length();
        }
        sql.insert(addLen+tmpLen,newCon);
        addLen=addLen+tmpLen+newCon.length();
        sql.trimToSize();
    }
    public void Del(String delCon){//delCon:用户不需要的筛选条件
        if(sql.length()-1==iniSqlLen+ delCon.length()+" WHERE ".length()){
            sql=new StringBuffer(sql.toString().replace(" WHERE "+delCon,""));
        }
        else{
            sql=new StringBuffer(sql.toString().replace(delCon+" AND ",""));
        }
        sql.trimToSize();
    }

    public void Limit(String curPage,String sortCon){
//        if((sql.length()-1)>iniSqlLen){
//            sql.delete(iniSqlLen,sql.length()-1);
//        }
        if(!sql.toString().contains("ORDER BY")){
            sql.insert(sql.length()-1," ORDER BY "+sortCon);
        }
        int m=(Integer.parseInt(curPage)-1)*Integer.parseInt(pageSize);
        sql.insert(sql.length()-1," limit "+m+","+pageSize);
    }

    public String getSql() {
        return sql.toString();
    }
}
