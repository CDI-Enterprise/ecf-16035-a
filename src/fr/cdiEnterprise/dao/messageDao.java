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
	
	
	
	
	
	public static void insertItem(Item item)   {
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnect();
			statement = connection.createStatement();
	
			
			int ident = 0;
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
			draft = booleanToInt(item.isDraftEmail());
			if(draft==0) {
				date = localDateToString(item.getTimeStamp());
			}
			
			
			
			String createStatement = String
			        .format("insert into %s (%s  , %s ,%s , %s ,%s, %s , %s ) values ( " + "'" + ident + "' , '" + sender + "' , '" + receiver + "',  '" + object + "', '" + body + "', '" + date + "',  '" + draft + "' )", 	
			                TABLE_NAME, //
			                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft");
	
			
			
			statement.executeUpdate(createStatement);
			
			connection.commit();

		
		} catch (SQLException e) {
			System.out.println("SQL Error In the insertMessage...");
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO (Nicolas) need to fix this
				e.printStackTrace();
			}
			
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
		
	

	

	// TODO (nicolas ) insertDraft - public static void postDraft(Item item) {
	
	public static void postDraft(Item item) {
		
	

	}



	/**
	 * This method is going to return the email for a particular user mailbox or a draft Mailbox.
	 * box will indicate the mailbox whether draft is false , or draft message if that is true
	 * @param rcv
	 * @param draft
	 * @return
	 * @throws SQLException
	 */
	public static Items getAllItems(String box, boolean draft)  {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Items items = new Items();
		
		connection = Database.getConnect();
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO (Nicolas) 
			e1.printStackTrace();
		}
			
			//String ident = null;
			int ident = 0;
			String sender = null;
			String receiver =null;
			String object = null;
			String body = null;
			String date = null;
			int draftMess = 0;
			
			String createStatement = null;
			if(draft) {
				createStatement= String
				        .format("select %s, %s  , %s ,%s , %s ,%s, %s from %s WHERE %s = '%s' AND %s = '%s'", 	
			                 //
			                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft", TABLE_NAME,"SENDER", box, "DRAFT", 1);
			}else {
				createStatement = String
				        .format("select %s, %s  , %s ,%s , %s ,%s, %s from %s WHERE %s = '%s' AND %s = '%s'", 	
			                 //
			                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft", TABLE_NAME,"RECEIVER", box, "DRAFT", 0);
			}
			
			
//			        		select identity, sender, receiver, subject, messBody, timeStamp, draft from mailbox
	//		        		WHERE sender = 'claire';
			
			try {
				resultSet = statement.executeQuery(createStatement);
				connection.commit();
				
				while(resultSet.next()) {
					
					
					ident = resultSet.getInt("identity");
					sender = resultSet.getString("sender");
					receiver = resultSet.getString("receiver");
					object = resultSet.getString("subject");
					body = resultSet.getString("messBody");

					draftMess = resultSet.getInt("draft");
					if(draftMess==0) {
						date = resultSet.getString("timeStamp");
					}
					
					
					Item item = new Item(ident, sender, receiver, object, body, StringToLocalDate(date), intToBoolean(draftMess));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO (Nicolas) need to fix this
				e.printStackTrace();
			}

				
				
			
			return items;
			
	}
	
	/**
	 * This method is going to return the email for a particular user mailbox or a draft Mailbox.
	 * box will indicate the mailbox whether draft is false , or draft message if that is true
	 * @param rcv
	 * @param draft
	 * @return
	 * @throws SQLException
	 */
	
	// TODO (nicolas) methode a revoir
	public static Items getAllItems(String box)  {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Items items = new Items();
		
		connection = Database.getConnect();
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO (nicolas) need to fix this excp
			e1.printStackTrace();
		}
			
			//String ident = null;
			int ident = 0;
			String sender = null;
			String receiver =null;
			String object = null;
			String body = null;
			String date = null;
			int draftMess = 0;
			
			String createStatement = null;

				createStatement= String
				        .format("select %s, %s  , %s ,%s , %s ,%s, %s from %s", 	
			                 //
			                "identity", "sender", "receiver", "subject", "messBody", "timeStamp", "draft", TABLE_NAME);

			

			try {
				resultSet = statement.executeQuery(createStatement);
				connection.commit();
				
				while(resultSet.next()) {
					
					
					ident = resultSet.getInt("identity");
					sender = resultSet.getString("sender");
					receiver = resultSet.getString("receiver");
					object = resultSet.getString("subject");
					body = resultSet.getString("messBody");

					draftMess = resultSet.getInt("draft");
					if(draftMess==0) {
						date = resultSet.getString("timeStamp");
					}
					
					
					Item item = new Item(ident, sender, receiver, object, body, StringToLocalDate(date), intToBoolean(draftMess));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO (nicolas) need to fix this
				e.printStackTrace();
			}

				
				
			
			return items;
			
	}
	
	
//	}
	
	// TODO (Nicolas) deleteMessage - public static boolean removeMessage(String usr, String identifier, boolean draft) {

	 public static boolean removeMessage(String usr, int identifier, boolean draft) {
		 
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		connection = Database.getConnect();
		try {
			statement = connection.createStatement();
			String query = "delete from mailbox where identity = '" + identifier + "'";
		
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			// TODO (Nicolas) need to fix this excp
			e.printStackTrace();
		}
		

		
		
		return true;
		
		
		
		
		
		 
		 
		 
	 }

	// TODO (Nicolas) popMessage - public static Item popMessage(String usr, String identifier, boolean draft) {
	
	
	
	// TODO (Nicolas) updateMessage - public static Item updateMessage
	
	/**
	 * This static method is going to be used to convert LocalDateTime in a String format this way
	 * dd MM yyyy HH:MM:SS
	 * @param input the date to convert in LocalDateTime
	 * @return the output date in String format.
	 */
	public static String localDateToString(LocalDateTime input) {
		

		
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm:ss");
		  String text = input.format(formatter);
		  
		  return text;

	}
	
	/**
	 * Cette methode statique va convertir une date de type String de format "dd MM uuuu HH:mm:ss"
	 * en type LocalDateTime
	 * @param input represente la date en String
	 * @return un objet de type LocalDateTime.
	 */
	public static LocalDateTime StringToLocalDate( String input ) {
		LocalDateTime localTime = null;
		if(input != null) {
			
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm:ss");
			  localTime = LocalDateTime.parse(input, formatter);
			  
		}
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
