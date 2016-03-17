class Notifications{
	/*
		@param emailList[] it will be an array containing all the email addresses the report must be sent to
		@param file this will be the generated report file that needs to be sent as an attachment with the email
	*/
	public void sendReport(String emailList[], String file){
		/*
			This function must take the list of emails and add each one to be sent to, ask buildMessage to generate the appropriate message
			and receive the email's body from buildMessage.

			We are in the process of making a telnet server to interface to the up mail server so just code as far as you can then be able to explain
			the work you have done thus far.
		*/
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the notification must be sent to
		other parameters still unsure
	*/
	public void sendNotification(String emailList[]){
		/*
			The email list must receive their notifications as per request, a sql request must be made to pull the notification message as the user speicifed
			when the notification was created.

			Thus each mail must be sent one by one so each user can get his/her personalised notfication.

			This will not use buildMessage as the user specified his own message.
		*/
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		other parameters still unsure
	*/
	public void sendChange(String emailList[], String publicationName){
		/*
			All authors must be notified if someone made changes to their publication of any kind. (Note the publication name must be specified as an author can belong to multiple groups) 
			Still to be figured out if it will tell the authors exactly what was changed. (to be discussed)
		*/
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		other parameters still unsure
	*/
	public void sendTextMail(String emailList[]){
		/*
			This will be used to email plain text emails no images/files etc. 
			will use buildMessage to assist the contruction of the message.
		*/
	}

	/*
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
	*/
	private String buildMessage(String typeOfRequest){ // Frederick
		/*
			This will generate a kind of "To whom it may concern" message when there are multiple clients in one email.
			The type of request will let the function know which template file to use.
		*/
		String message;
		
		message = "To whom it may concern, \n" + typeOfRequest;
            
		return message;
	}

	/*
		@param clientName this variable specifies the email receiptiant's name to make the mail look more professional
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
	*/
	private String buildMessage(String clientName, String typeOfRequest, String publicationName){ // Frederick
		/*
			This will take the client's name and add it to the message to give it a personal touch
			The type of request will let the function know which template file to use.
		*/
		String message;
		
<<<<<<< HEAD
		if(typeOfRequest.equals("Change"){
			message = publicationMessage(publicationName);
		}
		else if(typeOfRequest.equals("Notification")){
			message = notificationMessage(clientName);
		}
		else if(typeOfRequest.equals("Report")){
			message = reportMessage();
		}
		return message;
	}
	/*Functions to help mock */

	private String publicationMessage(String publicationName){
		String intro = "To whom it may concern \n";
		String body = "Please note that the following publication has been modified:";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + publicationName + "\n" + salutation;
		return completed;
	}

	private String notificationMessage(String clientName){
		String intro = "Dear " + clientName + "\n";				// sql request to sql database to get notification message
		String body = "This is the user's personal message";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + "\n" + salutation;
		return completed;
	}

	private String reportMessage(){
		String intro = "To whom it may concern \n";				// sql request to sql database to get the report file
		String body = "Plesae find attached the report file";
		String salutation = "Regards \n Bravo team"
		String completed = intro + body + publicationName + "\n" + salutation;
		return completed;
=======
		message = clientName + ", \n" + typeOfRequest;
		
		return message;
>>>>>>> 6ee0556292dedbb05c207185c342b93aade066af
	}
	

}