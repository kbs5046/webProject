package com.dao.query;

public interface SQLQuery {
	public static String UPDATE_USERS = "update Users set UserName = ?, Password = ? where Name=?";
	public static String DELETE_BY_NAME = "delete from USERS where Name = ?";
	
	public static String SELECT_SIGNUP_USERNAME_PASSWORD = "select uID,UserName,Password,Name,Email,Salutation,DateCreated,Role from Users where UserName=? and Password=? ";
	public static String ADD_USER = "insert into USERS(UserName,Password,Name,Email,Salutation) values(?,?,?,?,?)";
	public static String SELECT_ALL_USERS = "select * from Users";
	public static String SELECT_SIGNUPS="select uID,UserName,Password,Name,Email,Salutation,DateCreated,Role from Users";
	public static String DELETE_USER_BY_UID = "delete from Users where uID =?";
	//public static String SELECT_ALL_UID = "select uID from Users where uId >?";
	//public static String UPDATE_UID = "update Users set uId =? where uId=?";
	public static String UPDATE_UIDS_AFTER_DELETE = "UPDATE Users SET uID = uID - 1 WHERE uID > ?";
	public static String SELECT_MAX_ID = "SELECT MAX(uID) FROM Users";
	public static String UPDATE_UIDS_AFTER_SIGNUP = "UPDate Users SET uID = ?+1 Where uID = ?";
	public static String SELECT_USER_BY_UID = "select uId,UserName,Password,Name,Email,Salutation,DateCreated from Users where uID =?";
	public static String EDIT_USER = "update Users set UserName = ?,Password = ?,Name=?,Email=?,Salutation=? where uID = ?";
	
	public static String DELETE_UID_COL = "ALTER TABLE Users DROP uID";
	public static String ADD_UID_COL = "ALTER TABLE `Users` ADD `uID` INT(11) NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (`uID`)";
}
