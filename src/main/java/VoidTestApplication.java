import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class VoidTestApplication {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date ayer = cal.getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ayerFormat = dateFormat.format(ayer);
		log.info("Ayer: "+ayerFormat);
	}

}
