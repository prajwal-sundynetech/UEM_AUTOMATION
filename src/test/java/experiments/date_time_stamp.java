package experiments;

import java.util.Date;

public class date_time_stamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		String dateText = date.toString();
		String dateTextWithoutSpaces = dateText.replace(" ", "_");
		System.out.println(dateTextWithoutSpaces);

//		System.out.println(date.toString().replace(" ", "_"));
		
	}

}
