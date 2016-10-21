package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.service.Items;

/**
 * class utilisee pour gerer les donnees dans la base de donnee.
 * L'utilisateur qui qua instancie cette class aura alors access a 2 ArrayList d'item.
 * un ArrayList pour les message recus.
 * un ArrayList pour les messages brouillon (draft)
 * 
 * Cette class ne devra etre instancie qu'une seule fois.
 * 
 * create table mailbox(identity VARCHAR2(80), sender VARCHAR2(40), 
 * receiver VARCHAR2(40), subject VARCHAR2(144), 
 * messBody VARCHAR2(1500), timeStamp VARCHAR2(20), draft number);
 * 
 * @author Nicolas Tarral
 * @version 19-10-2016
 *
 */
public class messageDao {
	
	private static String TABLE_NAME = "mailbox";
	
	
	
	// TODO inserItem - public static boolean post(Item item) {
	
	public static void insertItem(Item item) throws SQLException  {
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
		connection = Database.getConnect();
		
			statement = connection.createStatement();

		
		String ident = null;
		String sender = null;
		String receiver =null;
		String object = null;
		String body = null;
		String date = null;
		int draft = 0; // 0 for draft
		
		ident = item.getId();
		sender = item.getSender();
		receiver = item.getReceiver();
		object = item.getObject();
		body = item.getBody();
		date = localDateToString(item.getTimeStamp());
		draft = booleanToInt(item.isDraftEmail());
		
		String createStatement = String
		        .format("insert into %s (%s  , %s ,%s , %s ,%s, %s , %s ) values ( " + "'" + ident + "' , '" + sender + "' , '" + receiver + "',  '" + object + "', '" + body + "', '" + date + "',  '" + draft + "' )", 	
		                TABLE_NAME, //
		                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft");

		System.out.println(createStatement);
		
		statement.executeUpdate(createStatement);
		
		connection.commit();

		
		} catch (SQLException e) {
			System.out.println("SQL Error In the insertMessage...");
			e.printStackTrace();
		} finally {
			if(resultSet != null ) {
				resultSet.close();
			}
			if(statement != null ) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
			
		}
//		if (item != null) {
//
//			mess.add(item);
//			items.put(item.getReceiver(), mess);
//			System.out.println("Message posted in "+ item.getReceiver() + "address " + item);
//			return true;
//
//		}
//
//		return false;
		
	}

	

	// TODO insertDraft - public static boolean postDraft(Item item)


	// TODO getMessages - public static Items getAllItems(String box, boolean draft) {
	/**
	 * This method is going to return the email for a particular user mailbox or a draft Mailbox.
	 * box will indicate the mailbox whether draft is false , or draft message if that is true
	 * @param rcv
	 * @param draft
	 * @return
	 * @throws SQLException
	 */
	public static Items getAllItems(String box, boolean draft) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Items items = new Items();
		
		connection = Database.getConnect();
		statement = connection.createStatement();
			
			String ident = null;
			String sender = null;
			String receiver =null;
			String object = null;
			String body = null;
			String date = null;
			int draftMess = 0;
			
			
			
			String createStatement = String
			        .format("select %s, %s  , %s ,%s , %s ,%s, %s from %s WHERE %s = '%s'", 	
		                 //
		                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft", TABLE_NAME,"RECEIVER", box);
			
//			        		select identity, sender, receiver, subject, messBody, timeStamp, draft from mailbox
	//		        		WHERE sender = 'claire';
			System.out.println(createStatement);
			resultSet = statement.executeQuery(createStatement);
			connection.commit();
			
			while(resultSet.next()) {
				
				
				ident = resultSet.getString("identity");
				sender = resultSet.getString("sender");
				receiver = resultSet.getString("receiver");
				object = resultSet.getString("subject");
				body = resultSet.getString("messBody");
				date = resultSet.getString("timeStamp");
				draftMess = resultSet.getInt("draft");
				
				
				Item item = new Item(ident, sender, receiver, object, body, StringToLocalDate(date), intToBoolean(draftMess));
				items.add(item);
				
				
			}
			return items;
			
	}
		
//	}
	
	// TODO deleteMessage - public static boolean removeMessage(String usr, String identifier, boolean draft) {

	 //public static boolean removeMessage(String usr, String identifier, boolean draft) {
		 
		 
		 
		 
	 //}

	// TODO popMessage - public static Item popMessage(String usr, String identifier, boolean draft) {
	
	
	
	// TODO updateMessage - public static Item updateMessage
	
	/**
	 * This static method is going to be used to convert LocalDateTime in a String format this way
	 * dd MM yyyy HH:MM:SS
	 * @param input the date to convert in LocalDateTime
	 * @return the output date in String format.
	 */
	public static String localDateToString(LocalDateTime input) {
		
		System.out.println(input.toString());
		
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm:ss");
		  String text = input.format(formatter);
		  
		  return text;

	}
	
	public static LocalDateTime StringToLocalDate( String input ) {
		
		System.out.println("before transform "+input);
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm:ss");
		  LocalDateTime localTime = LocalDateTime.parse(input, formatter);
		  return localTime;
	}
	
	/**
	 * This method is going to convert boolean true/false to its corresponding integer value
	 * 1/0.
	 * The given value is a primitive type int.
	 * @param input will be a boolean type
	 * @return is going to be its corresponding integer value
	 */
	public static int booleanToInt(boolean input) {
		int output = 0;
		if(input == true) {
			output = 1;
		}
		return output;
		
	}
	
	public static boolean intToBoolean(int input) {
		boolean output = false;
		if(input == 1) {
			output = true;
		}
		return output;
		
	}

}
