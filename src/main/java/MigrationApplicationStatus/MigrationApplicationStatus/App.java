package MigrationApplicationStatus.MigrationApplicationStatus;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	ApplicationStatus applicationStauts = ApplicationStatus.getApplicationStauts("Ansöka", "pågående");
    	
    	System.out.println(applicationStauts.getBeskrivning());
    	
    	
    	ApplicationStatus[] nastaStatus = applicationStauts.getNastaStatus();
	
    	for (ApplicationStatus nastaApplicationStatus : nastaStatus) {
			System.out.println(nastaApplicationStatus.getBeskrivning());
		}
    	
    	
    }
   
}
