package struts.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;

public class PassengerControllerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final char DEFAULT_SEPARATOR = ',';
    
    
	/**
     * The execute function.
     * @return the answer.
     */
    public String execute() {

    	try {
			generateRandomCsv();
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
    }


	private void generateRandomCsv() throws IOException {
		String csvFile = new File(System.getProperty("user.dir")).getParentFile().getParent() + "\\src\\main\\webapp\\csv\\pieChart.csv";
        FileWriter writer = new FileWriter(csvFile);
        Random random = new Random();

        writeLine(writer, Arrays.asList("label", "count"), ' ', ' ');

        //custom separator + quote
        writeLine(writer, Arrays.asList("Flights earlier", String.valueOf(random.nextInt(2000))), ' ', '"');

        //custom separator + quote
        writeLine(writer, Arrays.asList("Flights in time", String.valueOf(random.nextInt(2000))), ' ', '"');

        //double-quotes
        writeLine(writer, Arrays.asList("Flights later", String.valueOf(random.nextInt(2000))), ' ', '"');


        writer.flush();
        writer.close();
	}
	
	public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
	
	private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

}
