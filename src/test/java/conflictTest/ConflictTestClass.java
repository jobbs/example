package conflictTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConflictTestClass {


	//Git Conflict Test
	public static void main(String[] args) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		Date stInDate;
		try {
			stInDate = transFormat.parse("20170731");
			Date stBaseDate = transFormat.parse("20170725");
			Date enBaseDate = transFormat.parse("20170801");
			Boolean dateDup = false;


			System.out.println("stBaseDate ::"+stBaseDate.getTime());
			System.out.println("enBaseDate ::"+enBaseDate.getTime());
			System.out.println("stInDate ::"+stInDate.getTime());
			if(stBaseDate.getTime() <= stInDate.getTime()  && stInDate.getTime() <= enBaseDate.getTime() ){
				System.out.println("come?");
				dateDup = true;
			}
			System.out.println(dateDup);
			if(!dateDup){
				System.out.println("dd?");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Date enInDate = transFormat.parse(rsrvSclngVo.getRsrvEndDt());

	}

	public static void upgradeMethod() {
		//
		System.out.println("This is upgrade method");
	}

}
